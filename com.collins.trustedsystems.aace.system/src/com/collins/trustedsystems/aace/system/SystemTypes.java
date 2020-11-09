package com.collins.trustedsystems.aace.system;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;

public class SystemTypes extends ResoluteExternalFunctionLibraryType {

	private static final BaseType INTERFACE = new BaseType("interface") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType SYSTEM_DEVELOPMENT = new BaseType("system_development") {
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

		if (name.equalsIgnoreCase(INTERFACE.toString())) {
			return INTERFACE;
		} else if (name.equalsIgnoreCase(SYSTEM_DEVELOPMENT.toString())) {
			return SYSTEM_DEVELOPMENT;
		}

		switch (name.toLowerCase()) {

		case "ispartof":
		case "isproducedby":
		case "isprovides":
		case "isrequires":
		case "issource":
		case "isdestination":
		case "isidentifiedby":
		case "isdevelopedby":
			return BaseType.BOOL;

		case "partof":
			return BaseType.ENTITY;
		case "producedby":
			return BaseType.ACTIVITY;
		case "provides":
		case "requires":
			return BaseType.ENTITY;

		case "source":
		case "destination":
			return BaseType.ENTITY;
		case "identifiedby":
			return BaseType.ACTIVITY;

		case "developedby":
			return BaseType.AGENT;

		default:
			return BaseType.FAIL;

		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {

		List<ResoluteType> args = new ArrayList<>();

		switch (function.toLowerCase()) {

		case "partof":
		case "producedby":
		case "provides":
		case "requires":
			args.add(BaseType.SYSTEM);
			break;
		case "ispartof":
			args.add(BaseType.SYSTEM);
			args.add(BaseType.ENTITY);
			break;
		case "isproducedby":
			args.add(BaseType.SYSTEM);
			args.add(BaseType.ACTIVITY);
			break;
		case "isprovides":
		case "isrequires":
			args.add(BaseType.SYSTEM);
			args.add(BaseType.ENTITY);
			break;

		case "source":
		case "destination":
		case "identifiedby":
			args.add(INTERFACE);
			break;
		case "issource":
		case "isdestination":
			args.add(INTERFACE);
			args.add(BaseType.ENTITY);
			break;
		case "isidentifiedby":
			args.add(INTERFACE);
			args.add(BaseType.ACTIVITY);
			break;

		case "developedby":
			args.add(SYSTEM_DEVELOPMENT);
			break;
		case "isdevelopedby":
			args.add(SYSTEM_DEVELOPMENT);
			args.add(BaseType.AGENT);
			break;

		default:
			args = null;
		}

		return args;
	}

	@Override
	public boolean isTypeDefined(String type) {
		return type.equalsIgnoreCase(INTERFACE.toString()) || type.equalsIgnoreCase(SYSTEM_DEVELOPMENT.toString());
	}

}
