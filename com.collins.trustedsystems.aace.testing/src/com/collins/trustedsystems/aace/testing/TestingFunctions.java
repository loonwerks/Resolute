package com.collins.trustedsystems.aace.testing;

import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteExternalFunctionLibrary;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteFailException;
import com.rockwellcollins.atc.resolute.analysis.values.ResoluteValue;

public class TestingFunctions extends ResoluteExternalFunctionLibrary {

	@Override
	public ResoluteValue run(EvaluationContext context, String function, List<ResoluteValue> args) {

		// These data properties are evaluated by RACK, not Resolute

		throw new ResoluteFailException("Resolute cannot evaluate AACE evidence methods.",
				context.getThisInstance().getSubcomponent());

	}
	
}
