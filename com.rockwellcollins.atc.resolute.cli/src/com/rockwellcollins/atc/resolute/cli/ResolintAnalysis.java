package com.rockwellcollins.atc.resolute.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.aadl2.parsesupport.LocationReference;
import org.osate.annexsupport.AnnexUtil;

import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter;
import com.rockwellcollins.atc.resolute.analysis.results.ResolintResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.cli.results.ResolintJsonResult;
import com.rockwellcollins.atc.resolute.resolute.AnalysisStatement;
import com.rockwellcollins.atc.resolute.resolute.CheckStatement;
import com.rockwellcollins.atc.resolute.resolute.Definition;
import com.rockwellcollins.atc.resolute.resolute.IdExpr;
import com.rockwellcollins.atc.resolute.resolute.LintStatement;
import com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;
import com.rockwellcollins.atc.resolute.resolute.Ruleset;

public class ResolintAnalysis {

	private static List<Ruleset> getResolintRuleSetDefs(XtextResourceSet resourceSet) throws Exception {
		final List<Ruleset> rulesets = new ArrayList<>();

		for (Resource resource : resourceSet.getResources()) {
			if (!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof AadlPackage) {
				final AadlPackage pkg = (AadlPackage) resource.getContents().get(0);
				final EClass resoluteLibEClass = ResolutePackage.eINSTANCE.getResoluteLibrary();
				for (AnnexLibrary lib : AnnexUtil.getAllActualAnnexLibraries(pkg, resoluteLibEClass)) {
					if (lib instanceof ResoluteLibrary) {
						final ResoluteLibrary resoluteLib = (ResoluteLibrary) lib;
						for (Definition def : resoluteLib.getDefinitions()) {
							if (def instanceof Ruleset) {
								final Ruleset ruleset = (Ruleset) def;
								rulesets.add(ruleset);
							}
						}
					}
				}
			}

		}
		return rulesets;
	}

	public static List<ResolintJsonResult> runResolintUserRule(XtextResourceSet resourceSet, EvaluationContext context,
			String[] ruleSetsToCheck, boolean onlyReturnRuleViolations) throws Exception {

		final List<ResoluteResult> checkTrees = new ArrayList<>();

		for (NamedElement el : context.getSet("component")) {
			// Avoid multiple subcomponents causing duplicated lint statements
			if (el == el.getElementRoot()) {
				final ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
				for (String ruleSet : ruleSetsToCheck) {
					boolean match = false;
					for (Ruleset ruleset : getResolintRuleSetDefs(resourceSet)) {
						if (ruleSet.equalsIgnoreCase(ruleset.getName())) {
							match = true;
							for (LintStatement lint : ruleset.getBody().getLintStatements()) {
								checkTrees.add(interpreter.evaluateLintStatement(lint));
							}
						}
						break;
					}
					if (!match) {
						System.err.println("Warning undefined rule set: " + ruleSet);
					}

				}
			}
		}
		// Return output in json format
		return getResolintResults(checkTrees, context.getComponentImplementation(), onlyReturnRuleViolations);
	}

	public static List<ResolintJsonResult> runResolint(EvaluationContext context, boolean onlyReturnRuleViolations)
			throws Exception {

		final List<ResoluteResult> checkTrees = new ArrayList<>();

		// Get the resolute subclause for the selected component implementation
		for (AnnexSubclause annexSubclause : context.getComponentImplementation().getOwnedAnnexSubclauses()) {
			if (annexSubclause instanceof ResoluteSubclause) {
				final ResoluteSubclause resoluteSubclause = (ResoluteSubclause) annexSubclause;
				final ResoluteInterpreter interpreter = new ResoluteInterpreter(context);

				// Evaluate each check statement in selected implementation
				for (AnalysisStatement as : resoluteSubclause.getAnalyses()) {
					if (as instanceof CheckStatement) {
						final CheckStatement cs = (CheckStatement) as;
						// Only evaluate rulesets
						if (cs.getExpr() instanceof IdExpr) {
							final IdExpr idExpr = (IdExpr) cs.getExpr();
							if (idExpr.getId() instanceof Ruleset) {
								final Ruleset ruleset = (Ruleset) idExpr.getId();
								for (LintStatement lint : ruleset.getBody().getLintStatements()) {
									checkTrees.add(interpreter.evaluateLintStatement(lint));
								}
							}
						}
					}
				}
				break;
			}
		}

		// Return output in json format
		return getResolintResults(checkTrees, context.getComponentImplementation(), onlyReturnRuleViolations);
	}

	private static List<ResolintJsonResult> getResolintResults(List<ResoluteResult> results, ComponentImplementation ci,
			boolean onlyReturnRuleViolations) {

		final List<ResolintJsonResult> resolintJsonResults = new ArrayList<>();

		for (ResoluteResult resoluteResult : results) {

			if (resoluteResult != null && !resoluteResult.isValid()) {
				final ResolintResult result = (ResolintResult) resoluteResult;
				try {
					final Set<EObject> locations = result.getLocations();
					if (locations.isEmpty()) {

						final ResolintJsonResult resolintJsonResult = new ResolintJsonResult();
						resolintJsonResult.setStatus(resoluteResult.isValid());
						resolintJsonResult.setRule(result.getText());

						final int severity = result.getSeverity();
						if (severity == IMarker.SEVERITY_ERROR) {
							resolintJsonResult.setSeverity(ResolintJsonResult.ERROR);
						} else if (severity == IMarker.SEVERITY_WARNING) {
							resolintJsonResult.setSeverity(ResolintJsonResult.WARNING);
						}
						resolintJsonResult.setLine(getLineNumberFor(ci));
						resolintJsonResults.add(resolintJsonResult);
					} else {
						for (EObject ref : locations) {
							final ResolintJsonResult resolintJsonResult = new ResolintJsonResult();
							resolintJsonResult.setStatus(resoluteResult.isValid());
							resolintJsonResult.setRule(result.getText());
							final int severity = result.getSeverity();
							if (severity == IMarker.SEVERITY_ERROR) {
								resolintJsonResult.setSeverity(ResolintJsonResult.ERROR);
							} else if (severity == IMarker.SEVERITY_WARNING) {
								resolintJsonResult.setSeverity(ResolintJsonResult.WARNING);
							}
							if (ref == null) {
								resolintJsonResult.setLine(getLineNumberFor(ci));
							} else {
								resolintJsonResult.setLine(getLineNumberFor(ref));
							}
							resolintJsonResults.add(resolintJsonResult);
						}
					}
				} catch (Exception e) {
					continue;
				}
			} else if (!onlyReturnRuleViolations && resoluteResult != null && resoluteResult.isValid()) {
				final ResolintResult result = (ResolintResult) resoluteResult;
				final ResolintJsonResult resolintJsonResult = new ResolintJsonResult();
				resolintJsonResult.setStatus(true);
				resolintJsonResult.setRule(result.getText());
				resolintJsonResults.add(resolintJsonResult);
			}
		}

		return resolintJsonResults;
	}

	private static int getLineNumberFor(EObject obj) {
		if (obj == null) {
			return 0;
		}
		if (obj instanceof AObject) {
			final LocationReference locref = ((AObject) obj).getLocationReference();
			if (locref != null) {
				return locref.getLine();
			}
		}
		INode node = null;
		int lineNum = 0;
		final EObject defaultannex = AadlUtil.getContainingDefaultAnnex(obj);
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

}
