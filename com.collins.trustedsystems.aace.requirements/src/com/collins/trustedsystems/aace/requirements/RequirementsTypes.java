package com.collins.trustedsystems.aace.requirements;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;
import com.rockwellcollins.atc.resolute.validation.SetType;

public class RequirementsTypes extends ResoluteExternalFunctionLibraryType {

	private static final BaseType REQUIREMENT = new BaseType("requirement") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType DATA_DICTIONARY_TERM = new BaseType("data_dictionary_term") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType REQUIREMENT_DEVELOPMENT = new BaseType("requirement_development") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ACTIVITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	// Special type to handle polymorphism
	private static final BaseType REQUIREMENT_DATA_DICTIONARY_TERM = new BaseType("requirement_data_dictionary_term") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(REQUIREMENT) || otherType.equals(DATA_DICTIONARY_TERM)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	@Override
	public ResoluteType getType(String name) {

		if (name.equalsIgnoreCase(REQUIREMENT.toString())) {
			return REQUIREMENT;
		} else if (name.equalsIgnoreCase(DATA_DICTIONARY_TERM.toString())) {
			return DATA_DICTIONARY_TERM;
		} else if (name.equalsIgnoreCase(REQUIREMENT_DEVELOPMENT.toString())) {
			return REQUIREMENT_DEVELOPMENT;
		}

		switch (name.toLowerCase()) {

		case "istext":
		case "isgiventext":
		case "isiftext":
		case "isthentext":
		case "isgoverns":
		case "issatisfies":
		case "ismitigates":
		case "iscreatedby":
		case "isprovidedby":
		case "isconsumedby":
		case "isauthor":
		case "isreferenced":
		case "isgovernedby":
			return BaseType.BOOL;

		case "text":
		case "giventext":
		case "iftext":
		case "thentext":
			return new SetType(BaseType.STRING);
		case "governs":
		case "satisfies":
		case "mitigates":
			return new SetType(BaseType.ENTITY);
		case "createdby":
			return new SetType(BaseType.ACTIVITY);
		case "providedby":
		case "consumedby":
			return new SetType(BaseType.ENTITY);
		case "author":
			return new SetType(BaseType.AGENT);
		case "referenced":
		case "governedby":
			return new SetType(BaseType.ENTITY);

		default:
			return BaseType.FAIL;
		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {

		List<ResoluteType> args = new ArrayList<>();

		switch (function.toLowerCase()) {

		case "text":
			args.add(REQUIREMENT_DATA_DICTIONARY_TERM);
			break;
		case "giventext":
		case "iftext":
		case "thentext":
		case "governs":
		case "satisfies":
		case "mitigates":
			args.add(REQUIREMENT);
			break;
		case "createdby":
			args.add(REQUIREMENT_DATA_DICTIONARY_TERM);
			break;
		case "istext":
			args.add(REQUIREMENT_DATA_DICTIONARY_TERM);
			args.add(BaseType.STRING);
			break;
		case "isgiventext":
		case "isiftext":
		case "isthentext":
			args.add(REQUIREMENT);
			args.add(BaseType.STRING);
			break;
		case "isgoverns":
		case "issatisfies":
		case "ismitigates":
			args.add(REQUIREMENT);
			args.add(BaseType.ENTITY);
			break;
		case "iscreatedby":
			args.add(REQUIREMENT_DATA_DICTIONARY_TERM);
			args.add(BaseType.ACTIVITY);
			break;

		case "providedby":
		case "consumedby":
			args.add(DATA_DICTIONARY_TERM);
			break;

		case "isprovidedby":
		case "isconsumedby":
			args.add(DATA_DICTIONARY_TERM);
			args.add(BaseType.ENTITY);
			break;

		case "author":
		case "referenced":
		case "governedby":
			args.add(REQUIREMENT_DEVELOPMENT);
			break;
		case "isauthor":
			args.add(REQUIREMENT_DEVELOPMENT);
			args.add(BaseType.AGENT);
			break;
		case "isreferenced":
		case "isgovernedby":
			args.add(REQUIREMENT_DEVELOPMENT);
			args.add(BaseType.ENTITY);

		default:
			args = null;
		}

		return args;

	}

	@Override
	public boolean isTypeDefined(String type) {
		return type.equalsIgnoreCase(REQUIREMENT.toString()) || type.equalsIgnoreCase(DATA_DICTIONARY_TERM.toString())
				|| type.equalsIgnoreCase(REQUIREMENT_DEVELOPMENT.toString());
	}

}
