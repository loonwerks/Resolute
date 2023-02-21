package com.rockwellcollins.atc.resolute.cli;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.annexsupport.AnnexUtil;

import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter;
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.FailResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.cli.results.ResoluteJsonResult;
import com.rockwellcollins.atc.resolute.resolute.AnalysisStatement;
import com.rockwellcollins.atc.resolute.resolute.ArgueStatement;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;

public class ResoluteAnalysis {

	public static List<ResoluteJsonResult> runResolute(EvaluationContext context) throws Exception {

		final List<ResoluteResult> argumentTrees = new ArrayList<>();

		for (NamedElement el : context.getSet("component")) {
			final ComponentInstance compInst = (ComponentInstance) el;
			final EClass resoluteSubclauseEClass = ResolutePackage.eINSTANCE.getResoluteSubclause();
			for (AnnexSubclause subclause : AnnexUtil.getAllAnnexSubclauses(compInst.getComponentClassifier(),
					resoluteSubclauseEClass)) {
				if (subclause instanceof ResoluteSubclause) {
					final ResoluteSubclause resoluteSubclause = (ResoluteSubclause) subclause;
					final ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
					for (AnalysisStatement as : resoluteSubclause.getAnalyses()) {
						if (as instanceof ArgueStatement) {
							final ArgueStatement stmt = (ArgueStatement) as;
							argumentTrees.add(interpreter.evaluateArgueStatement(stmt));
						}
					}
					break;
				}
			}
		}

		// Return output in json format
		return getResoluteResults(argumentTrees);
	}

	private static List<ResoluteJsonResult> getResoluteResults(List<ResoluteResult> results) {

		final List<ResoluteJsonResult> resoluteOutputs = new ArrayList<>();

		for (ResoluteResult result : results) {
			final ResoluteJsonResult resoluteResult = new ResoluteJsonResult();
			if (result instanceof ClaimResult) {
				final ClaimResult claimResult = (ClaimResult) result;
				resoluteResult.setClaim(claimResult.getText());
				resoluteResult.setStatus(claimResult.isValid());
				final List<ResoluteJsonResult> childrenResult = getResoluteResults(claimResult.getChildren());
				resoluteResult.setSubclaims(childrenResult);
			} else if (result instanceof FailResult) {
				final FailResult failResult = (FailResult) result;
				resoluteResult.setClaim(failResult.getText());
				resoluteResult.setStatus(failResult.isValid());
				final List<ResoluteJsonResult> childrenResult = getResoluteResults(failResult.getChildren());
				resoluteResult.setSubclaims(childrenResult);
			} else {
				continue;
			}
			resoluteOutputs.add(resoluteResult);
		}

		return resoluteOutputs;
	}

}
