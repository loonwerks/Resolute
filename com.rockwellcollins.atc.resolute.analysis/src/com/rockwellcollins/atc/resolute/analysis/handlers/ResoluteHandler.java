package com.rockwellcollins.atc.resolute.analysis.handlers;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ui.dialogs.Dialog;

import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.analysis.views.AssuranceCaseView;
import com.rockwellcollins.atc.resolute.resolute.AnalysisStatement;
import com.rockwellcollins.atc.resolute.resolute.ArgueStatement;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.IdExpr;
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;
import com.rockwellcollins.atc.resolute.resolute.ThisExpr;

public class ResoluteHandler extends AadlHandler {
	private static final String RERUN_ID = "com.rockwellcollins.atc.resolute.analysis.commands.rerunResolute";
	private IHandlerActivation rerunActivation;

	@Override
	protected String getJobName() {
		return "Resolute Analysis";
	}

	private static FunctionDefinition resolveResoluteFunction(EObject context, String resoluteFunctionName) {

		// psNode.setText(resoluteFunctionName);
		// val List<EObject> boundList =
		// resoluteLinkingService.getLinkedObjects(context,
		// ResolutePackage.eINSTANCE.getFnCallExpr_Fn(), psNode);
		// if (boundList.size() > 0) {
		// return boundList.get(0) as FunctionDefinition;
		// }
		EObject res = getNamedElementByType(context, resoluteFunctionName,
				ResolutePackage.eINSTANCE.getFunctionDefinition());

		return ((FunctionDefinition) res);
	}

	private static EObject getNamedElementByType(EObject context, String name, EClass eclass) {

		// This code will only link to objects in the projects visible from the
		// current project
		Iterable<IEObjectDescription> allObjectTypes = Aadl2GlobalScopeUtil.getAllEObjectDescriptions(context,
				eclass);
		String contextProject = context.eResource().getURI().segment(1);
		List<String> visibleProjects = getVisibleProjects(contextProject);

		for (IEObjectDescription eod : allObjectTypes) {
			if (eod.getName().getLastSegment().equalsIgnoreCase(name)) {
				EObject res = eod.getEObjectOrProxy();
				res = EcoreUtil.resolve(res, context.eResource().getResourceSet());
				if (!Aadl2Util.isNull(res)) {
					URI linkUri = res.eResource().getURI();
					String linkProject = linkUri.segment(1);
					if (visibleProjects.contains(linkProject)) {
						return res;
					}
				}
			}
		}

		return null;
	}

	private static List<String> getVisibleProjects(String contextProjectName) {
		List<String> result = new ArrayList<String>();
		result.add(contextProjectName);

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject contextProject = root.getProject(URI.decode(contextProjectName));
		if (!contextProject.exists() || !contextProject.isAccessible() || !contextProject.isOpen()) {
			return result;
		}
		try {
			IProjectDescription description = contextProject.getDescription();
			for (IProject referencedProject : description.getReferencedProjects()) {
				result.add(URI.encodeSegment(referencedProject.getName(), false));
			}
		} catch (CoreException ex) {
			System.out.println("CORE EXCEPTION");
			ex.printStackTrace();
		}

		return result;
	}


	@Override
	protected IStatus runJob(Element root, IProgressMonitor monitor) {
		clearArguments();
		disableRerunHandler();
		String theorem;

		theorem = this.getExecutionEvent().getParameter("com.rockwellcollins.atc.resolute.analysis.theorem");

		long start = System.currentTimeMillis();
		SystemInstance si;
		ComponentImplementation compImpl = getComponentImplementation(root);
		if (compImpl == null) {
			return Status.CANCEL_STATUS;
		} else {
			try {
				si = InstantiateModel.buildInstanceModelFile(compImpl);
			} catch (Exception e) {
				Dialog.showError("Resolute", "Error while instantiating the model: " + e.getMessage());
				return Status.CANCEL_STATUS;
			}
		}
		long stop = System.currentTimeMillis();
		System.out.println("Instantiation time: " + (stop - start) / 1000.0 + "s");

		start = System.currentTimeMillis();

		EvaluationContext context = new EvaluationContext(si);

		List<ResoluteResult> argumentTrees = new ArrayList<>();

		if (theorem != null) {

			FunctionDefinition functionDefinition = resolveResoluteFunction(si, theorem);

			ResoluteSubclause resoluteSubclause = ResoluteFactory.eINSTANCE.createResoluteSubclause();
			ArgueStatement argueStatement = ResoluteFactory.eINSTANCE.createArgueStatement();
			FnCallExpr fnCallExpr = ResoluteFactory.eINSTANCE.createFnCallExpr();

			fnCallExpr.getArgs().add(ResoluteFactory.eINSTANCE.createThisExpr());
			fnCallExpr.setFn(functionDefinition);

			argueStatement.setTag("argue");
			argueStatement.setExpr(fnCallExpr);
			resoluteSubclause.getAnalyses().add(argueStatement);
			si.getComponentClassifier().getOwnedAnnexSubclauses().add(resoluteSubclause);

			ResoluteInterpreter interpreter = new ResoluteInterpreter(context);

			for (AnalysisStatement as : resoluteSubclause.getAnalyses()) {
				if (as instanceof ArgueStatement) {
					ArgueStatement stmt = (ArgueStatement) as;
					try {
						argumentTrees.add(interpreter.evaluateArgueStatement(stmt));
					} catch (Exception e) {
						handleArgueStatementException(stmt, e);
					}
					drawArguments(argumentTrees);
				}
			}

		} else {
			for (NamedElement el : context.getSet("component")) {
				ComponentInstance compInst = (ComponentInstance) el;
				EClass resoluteSubclauseEClass = ResolutePackage.eINSTANCE.getResoluteSubclause();
				for (AnnexSubclause subclause : AnnexUtil.getAllAnnexSubclauses(compInst.getComponentClassifier(),
						resoluteSubclauseEClass)) {

					if (subclause instanceof ResoluteSubclause) {
						ResoluteSubclause resoluteSubclause = (ResoluteSubclause) subclause;
						ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
						for (AnalysisStatement as : resoluteSubclause.getAnalyses()) {
							if (as instanceof ArgueStatement) {
								ArgueStatement stmt = (ArgueStatement) as;
								try {
									argumentTrees.add(interpreter.evaluateArgueStatement(stmt));
								} catch (Exception e) {
									handleArgueStatementException(stmt, e);
								}
								drawArguments(argumentTrees);
							}
						}
					}
				}
			}
		}

		stop = System.currentTimeMillis();
		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");

		enableRerunHandler(root);
		System.out.println(EcoreUtil.getURI(root));

		return Status.OK_STATUS;
	}

	private void handleArgueStatementException(ArgueStatement as, Exception e) {
		String bodyText = simpleSerializer(as.getExpr());
		getWindow().getShell().getDisplay().syncExec(() -> {
			MessageDialog.openError(getWindow().getShell(), "Error in " + as.getTag() + " statement: " + bodyText,
					e.getMessage());
		});
		e.printStackTrace();
	}

	private String simpleSerializer(EObject e) {
		if (e instanceof FnCallExpr) {
			FnCallExpr fce = (FnCallExpr) e;
			String args = fce.getArgs().stream().map(this::simpleSerializer).collect(joining(", "));
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

	private void enableRerunHandler(final Element root) {
		getWindow().getShell().getDisplay().syncExec(() -> {
			IHandlerService handlerService = getHandlerService();
			rerunActivation = handlerService.activateHandler(RERUN_ID,
					new RerunHandler(root, ResoluteHandler.this));
		});
	}

	private void disableRerunHandler() {
		if (rerunActivation != null) {
			getWindow().getShell().getDisplay().syncExec(() -> {
				IHandlerService handlerService = getHandlerService();
				handlerService.deactivateHandler(rerunActivation);
				rerunActivation = null;
			});
		}
	}

	private IHandlerService getHandlerService() {
		return getWindow().getService(IHandlerService.class);
	}

	private void drawArguments(final List<ResoluteResult> argumentTrees) {
		final IWorkbenchPage page = getWindow().getActivePage();

		Display.getDefault().asyncExec(() -> displayView(argumentTrees, page));
	}

	private void displayView(final List<ResoluteResult> argumentTrees, final IWorkbenchPage page) {
		try {
			AssuranceCaseView view = (AssuranceCaseView) page.showView(AssuranceCaseView.ID);
			view.setProofs(argumentTrees);
			view.setFocus();
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	protected void clearArguments() {
		drawArguments(Collections.<ResoluteResult> emptyList());
	}
}
