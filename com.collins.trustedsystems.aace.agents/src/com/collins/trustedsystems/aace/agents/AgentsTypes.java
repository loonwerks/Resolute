package com.collins.trustedsystems.aace.agents;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;

public class AgentsTypes extends ResoluteExternalFunctionLibraryType {

	private static final BaseType ORGANIZATION = new BaseType("organization") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(AGENT)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType PERSON = new BaseType("person") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(AGENT)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType TOOL = new BaseType("tool") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(AGENT)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType SOFTWAREAGENT = new BaseType("softwareagent") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(AGENT)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	@Override
	public ResoluteType getType(String name) {

		if (name.equalsIgnoreCase(ORGANIZATION.toString())) {
			return ORGANIZATION;
		} else if (name.equalsIgnoreCase(PERSON.toString())) {
			return PERSON;
		} else if (name.equalsIgnoreCase(TOOL.toString())) {
			return TOOL;
		} else if (name.equalsIgnoreCase(SOFTWAREAGENT.toString())) {
			return SOFTWAREAGENT;
		}

		switch (name.toLowerCase()) {

		case "isname":
		case "isemailaddress":
		case "isemployedby":
			return BaseType.BOOL;

		case "name":
		case "emailaddress":
			return BaseType.STRING;
		case "employedby":
			return BaseType.AGENT;

		default:
			return BaseType.FAIL;
		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {

		List<ResoluteType> args = new ArrayList<>();

		switch (function.toLowerCase()) {

		case "name":
			args.add(ORGANIZATION);
			break;
		case "isname":
			args.add(ORGANIZATION);
			args.add(BaseType.STRING);
			break;

//		case "name":
		case "emailaddress":
		case "employedby":
			args.add(PERSON);
			break;
//		case "isname":
		case "isemailaddress":
			args.add(PERSON);
			args.add(BaseType.STRING);
			break;
		case "isemployedby":
			args.add(PERSON);
			args.add(BaseType.AGENT);
			break;

		default:
			args = null;
		}

		return args;

	}

	@Override
	public boolean isTypeDefined(String type) {
		return type.equalsIgnoreCase(ORGANIZATION.toString()) || type.equalsIgnoreCase(PERSON.toString())
				|| type.equalsIgnoreCase(TOOL.toString()) || type.equalsIgnoreCase(SOFTWAREAGENT.toString());
	}

}
