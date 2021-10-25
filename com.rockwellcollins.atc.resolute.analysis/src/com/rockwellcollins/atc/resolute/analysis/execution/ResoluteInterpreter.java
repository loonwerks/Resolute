package com.rockwellcollins.atc.resolute.analysis.execution;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResolintResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.resolute.ArgueStatement;
import com.rockwellcollins.atc.resolute.resolute.ErrorStatement;
import com.rockwellcollins.atc.resolute.resolute.InfoStatement;
import com.rockwellcollins.atc.resolute.resolute.LintStatement;
import com.rockwellcollins.atc.resolute.resolute.WarningStatement;

public class ResoluteInterpreter {
    final private EvaluationContext globalContext;

    public ResoluteInterpreter(EvaluationContext globalContext) {
        this.globalContext = globalContext;
    }

	public ResoluteResult evaluateArgueStatement(ArgueStatement argueStatement) {
		String argueText = ResoluteProver.argueStatementToString(argueStatement,
                globalContext.getThisInstance());
		ResoluteResult subResult = evaluateArgueStatementBody(argueStatement);
        Map<String, EObject> references = Collections.emptyMap();
		return new ClaimResult(argueText, subResult, references, argueStatement);
    }

	private ResoluteResult evaluateArgueStatementBody(ArgueStatement argueStatement) {
        ResoluteProver prover = new ResoluteProver(globalContext);
		return prover.doSwitch(argueStatement.getExpr());
    }

	public ResoluteResult evaluateLintStatement(LintStatement lintStatement) {
		int severity = 0;
		if (lintStatement instanceof ErrorStatement) {
			severity = IMarker.SEVERITY_ERROR;
		} else if (lintStatement instanceof WarningStatement) {
			severity = IMarker.SEVERITY_WARNING;
		} else if (lintStatement instanceof InfoStatement) {
			severity = IMarker.SEVERITY_INFO;
		}

		ResoluteResult result = evaluateLintStatementBody(lintStatement);
		if (result instanceof ClaimResult) {
			return new ResolintResult(severity, (ClaimResult) result);
		}
		return null;
	}

	private ResoluteResult evaluateLintStatementBody(LintStatement lintStatement) {
		ResoluteProver prover = new ResoluteProver(globalContext);
		return prover.doSwitch(lintStatement.getExpr());
	}
}
