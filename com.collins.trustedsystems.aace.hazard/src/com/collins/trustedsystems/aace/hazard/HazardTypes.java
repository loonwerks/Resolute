package com.collins.trustedsystems.aace.hazard;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;
import com.rockwellcollins.atc.resolute.validation.SetType;

public class HazardTypes extends ResoluteExternalFunctionLibraryType {

	private static final BaseType HAZARD = new BaseType("hazard") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType HAZARD_IDENTIFICATION = new BaseType("hazard_identification") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ACTIVITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	@Override
	public ResoluteType getType(String name) {

		if (name.equalsIgnoreCase(HAZARD.toString())) {
			return HAZARD;
		} else if (name.equalsIgnoreCase(HAZARD_IDENTIFICATION.toString())) {
			return HAZARD_IDENTIFICATION;
		}

		switch (name.toLowerCase()) {

		case "isdefinition":
		case "issource":
		case "isidentified":
		case "isauthor":
			return BaseType.BOOL;

		case "definition":
			return new SetType(BaseType.STRING);
		case "source":
			return new SetType(BaseType.ENTITY);
		case "identified":
			return new SetType(HAZARD_IDENTIFICATION);
		case "author":
			return new SetType(BaseType.AGENT);

		default:
			return BaseType.FAIL;
		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {

		List<ResoluteType> args = new ArrayList<>();

		switch (function.toLowerCase()) {

		case "definition":
		case "source":
		case "identified":
			args.add(HAZARD);
			break;
		case "isdefinition":
			args.add(HAZARD);
			args.add(BaseType.STRING);
			break;
		case "issource":
			args.add(HAZARD);
			args.add(BaseType.ENTITY);
			break;
		case "isidentified":
			args.add(HAZARD);
			args.add(HAZARD_IDENTIFICATION);
			break;

		case "author":
			args.add(HAZARD_IDENTIFICATION);
			break;
		case "isauthor":
			args.add(HAZARD_IDENTIFICATION);
			args.add(BaseType.AGENT);

		default:
			args = null;
		}

		return args;

	}

	@Override
	public boolean isTypeDefined(String type) {
		return type.equalsIgnoreCase(HAZARD.toString()) || type.equalsIgnoreCase(HAZARD_IDENTIFICATION.toString());
	}

}
