package com.rockwellcollins.atc.resolute.analysis.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.aadl2.parsesupport.LocationReference;
import org.osate.ui.dialogs.Dialog;

import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter;
import com.rockwellcollins.atc.resolute.analysis.results.ResolintResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.resolute.AnalysisStatement;
import com.rockwellcollins.atc.resolute.resolute.CheckStatement;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.IdExpr;
import com.rockwellcollins.atc.resolute.resolute.LintExpr;
import com.rockwellcollins.atc.resolute.resolute.LintStatement;
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;
import com.rockwellcollins.atc.resolute.resolute.Ruleset;
import com.rockwellcollins.atc.resolute.resolute.ThisExpr;

public class ResolintHandler extends AadlHandler {

	private static final String MARKER_TYPE = "com.rockwellcollins.atc.resolute.linter.marker";

	@Override
	protected String getJobName() {
		return "Resolint Analysis";
	}

	@Override
	protected IStatus runJob(Element root, IProgressMonitor monitor) {

		long start = System.currentTimeMillis();
		SystemInstance si;
		ComponentImplementation compImpl = getComponentImplementation(root);
		if (compImpl == null) {
			return Status.CANCEL_STATUS;
		} else {
			try {
				si = InstantiateModel.buildInstanceModelFile(compImpl);
			} catch (Exception e) {
				Dialog.showError("Resolint", "Error while instantiating the model: " + e.getMessage());
				return Status.CANCEL_STATUS;
			}
		}
		long stop = System.currentTimeMillis();
		System.out.println("Instantiation time: " + (stop - start) / 1000.0 + "s");

		// Clear the problems pane
		clearMarkers(si.getComponentImplementation());

		start = System.currentTimeMillis();

		List<ResoluteResult> checkTrees = new ArrayList<>();
		try {
			checkTrees = run(si);
		} catch (Exception e) {
			Dialog.showError("Resolint", e.getMessage());
			return Status.CANCEL_STATUS;
		}
		displayResults(checkTrees, compImpl);

		stop = System.currentTimeMillis();
		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");

		return Status.OK_STATUS;
	}

	public static List<ResoluteResult> run(SystemInstance si) throws Exception {

		EvaluationContext context = new EvaluationContext(si);
		List<ResoluteResult> checkTrees = new ArrayList<>();

		// Get the resolute subclause for the selected component implementation
		for (AnnexSubclause annexSubclause : si.getComponentImplementation().getOwnedAnnexSubclauses()) {
			DefaultAnnexSubclause defaultSubclause = (DefaultAnnexSubclause) annexSubclause;
			if (defaultSubclause.getParsedAnnexSubclause() instanceof ResoluteSubclause) {
				ResoluteSubclause resoluteSubclause = (ResoluteSubclause) defaultSubclause.getParsedAnnexSubclause();
				ResoluteInterpreter interpreter = new ResoluteInterpreter(context);

				// Evaluate each check statement in selected implementation
				for (AnalysisStatement as : resoluteSubclause.getAnalyses()) {
					if (as instanceof CheckStatement) {
						CheckStatement cs = (CheckStatement) as;
						if (cs.getExpr() instanceof IdExpr) {
							IdExpr idExpr = (IdExpr) cs.getExpr();
							if (idExpr.getId() instanceof Ruleset) {
								Ruleset ruleset = (Ruleset) idExpr.getId();
								for (LintStatement lint : ruleset.getBody().getLintStatements()) {
									try {
										checkTrees.add(interpreter.evaluateLintStatement(lint));
									} catch (Exception e) {
										handleCheckStatementException(cs, e);
									}
								}
							}
						} else if (cs.getExpr() instanceof LintExpr) {
							LintStatement lint = ((LintExpr) cs.getExpr()).getLintStmt();
							try {
								checkTrees.add(interpreter.evaluateLintStatement(lint));
							} catch (Exception e) {
								handleCheckStatementException(cs, e);
							}
						}
					}
				}
				break;
			}
		}

		return checkTrees;
	}

	public static void clearMarkers(ComponentImplementation ci) {

		for (Resource r : ci.eResource().getResourceSet().getResources()) {
			try {
				IResource resource = getIResource(r);
				resource.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			} catch (Exception e) {
				continue;
			}
		}

	}

	private void displayResults(List<ResoluteResult> checkTrees, ComponentImplementation ci) {
		// Print the errors to standard 'Problems' pane.
		int errors = 0;
		int warnings = 0;

		for (ResoluteResult resoluteResult : checkTrees) {
			if (resoluteResult != null && !resoluteResult.isValid()) {
				ResolintResult result = (ResolintResult) resoluteResult;
				try {
					Set<EObject> locations = result.getLocations();
					if (locations.isEmpty()) {
						IMarker marker = getIResource(ci.eResource()).createMarker(MARKER_TYPE);
						marker.setAttribute(IMarker.MESSAGE, result.getText());
						int severity = result.getSeverity();
						marker.setAttribute(IMarker.SEVERITY, severity);
						if (severity == IMarker.SEVERITY_ERROR) {
							errors++;
						} else if (severity == IMarker.SEVERITY_WARNING) {
							warnings++;
						}
						marker.setAttribute(IMarker.LINE_NUMBER, getLineNumberFor(ci));
					} else {
						for (EObject ref : locations) {
							if (ref == null) {
								IMarker marker = getIResource(ci.eResource()).createMarker(MARKER_TYPE);
								marker.setAttribute(IMarker.MESSAGE, result.getText());
								int severity = result.getSeverity();
								marker.setAttribute(IMarker.SEVERITY, severity);
								if (severity == IMarker.SEVERITY_ERROR) {
									errors++;
								} else if (severity == IMarker.SEVERITY_WARNING) {
									warnings++;
								}
								marker.setAttribute(IMarker.LINE_NUMBER, getLineNumberFor(ci));
							} else {
								IMarker marker = getIResource(ref.eResource()).createMarker(MARKER_TYPE);
								marker.setAttribute(IMarker.MESSAGE, result.getText());
								int severity = result.getSeverity();
								marker.setAttribute(IMarker.SEVERITY, severity);
								if (severity == IMarker.SEVERITY_ERROR) {
									errors++;
								} else if (severity == IMarker.SEVERITY_WARNING) {
									warnings++;
								}
								marker.setAttribute(IMarker.LINE_NUMBER, getLineNumberFor(ref));
							}
						}
					}
				} catch (Exception e) {
					continue;
				}
			}
		}

		if ((errors + warnings) == 0) {
			Dialog.showInfo("Resolint", "No problems found");
		} else {
			String message = "";
			if (errors > 0) {
				message += errors + " error" + (errors > 1 ? "s" : "") + " found.";
			}
			if (warnings > 0) {
				if (!message.isEmpty()) {
					message += "\n";
				}
				message += warnings + " warning" + (warnings > 1 ? "s" : "") + " found.";
			}
			Dialog.showInfo("Resolint", message);
		}

	}

	public static int getLineNumberFor(EObject obj) {
		if (obj == null) {
			return 0;
		}
		if (obj instanceof AObject) {
			LocationReference locref = ((AObject) obj).getLocationReference();
			if (locref != null) {
				return locref.getLine();
			}
		}
		INode node = null;
		int lineNum = 0;
		EObject defaultannex = AadlUtil.getContainingDefaultAnnex(obj);
		if (defaultannex != null) {
			node = NodeModelUtils.findActualNodeFor(defaultannex);
			if (node != null) {
				lineNum = node.getStartLine() - 1;
			}
		}

		node = NodeModelUtils.findActualNodeFor(obj);

		if (node != null) {
			return lineNum + node.getStartLine();
		}

		return 0;
	}

	protected static IResource getIResource(Resource r) {
		final URI uri = r.getURI();
		final IPath path = new Path(uri.toPlatformString(true));
		final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
		if (resource == null) {
			throw new RuntimeException("Unable to get IResource for Resource: " + r);
		}
		return resource;
	}

	private static void handleCheckStatementException(CheckStatement cs, Exception e) throws Exception {
		final String bodyText = "Error in check statement: " + simpleSerializer(cs.getExpr()) + "\n" + e.getMessage();
		throw new Exception(bodyText);
	}

	public static String simpleSerializer(EObject e) {
		if (e instanceof FnCallExpr) {
			FnCallExpr fce = (FnCallExpr) e;
			String args = "";
			for (int i = 0; i < fce.getArgs().size(); ++i) {
				args += fce.getArgs().get(i);
				if (i < fce.getArgs().size() - 1) {
					args += ", ";
				}
			}
			return fce.getFn().getName() + "(" + args + ")";
		} else if (e instanceof ThisExpr) {
			return "this";
		} else if (e instanceof IdExpr) {
			IdExpr ide = (IdExpr) e;
			return ide.getId().getFullName();
		} else {
			return e.toString();
		}
	}

}
