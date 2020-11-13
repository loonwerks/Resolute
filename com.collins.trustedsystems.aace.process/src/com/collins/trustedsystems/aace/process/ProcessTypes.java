package com.collins.trustedsystems.aace.process;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;
import com.rockwellcollins.atc.resolute.validation.SetType;

public class ProcessTypes extends ResoluteExternalFunctionLibraryType {

	private static final BaseType OBJECTIVE = new BaseType("objective") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	@Override
	public ResoluteType getType(String name) {

		if (name.equalsIgnoreCase(OBJECTIVE.toString())) {
			return OBJECTIVE;
		}

		switch (name.toLowerCase()) {

		case "issatisfiedby":
			return BaseType.BOOL;
		case "satisfiedby":
			return new SetType(BaseType.ACTIVITY);

		default:
			return BaseType.FAIL;
		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {

		List<ResoluteType> args = new ArrayList<>();

		switch (function.toLowerCase()) {

		case "satisfiedby":
			args.add(OBJECTIVE);
			break;
		case "issatisfiedby":
			args.add(OBJECTIVE);
			args.add(BaseType.ACTIVITY);
			break;
		default:
			args = null;
		}

		return args;

	}

	@Override
	public boolean isTypeDefined(String type) {
		return type.equalsIgnoreCase(OBJECTIVE.toString());
	}

}
