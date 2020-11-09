package com.collins.trustedsystems.aace.software;

import java.util.ArrayList;
import java.util.List;

import com.collins.trustedsystems.aace.file.FileTypes;
import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;
import com.rockwellcollins.atc.resolute.validation.SetType;

public class SoftwareTypes extends ResoluteExternalFunctionLibraryType {

	private static final BaseType CODE_DEVELOPMENT = new BaseType("code_development") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(FileTypes.FILE_CREATION)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType BUILD = new BaseType("build") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(FileTypes.FILE_CREATION)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType CODE_GEN = new BaseType("code_gen") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(FileTypes.FILE_CREATION)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType COMPILE = new BaseType("compile") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(FileTypes.FILE_CREATION)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType PACKAGE = new BaseType("package") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(FileTypes.FILE_CREATION)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType COMPONENT_TYPE = new BaseType("component_type") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(THING)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	// Special type to handle polymorphism
	private static final BaseType PERFORMED_BY = new BaseType("performed_by") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(CODE_GEN) || otherType.equals(COMPILE) || otherType.equals(PACKAGE)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	@Override
	public ResoluteType getType(String name) {

		if (name.equalsIgnoreCase(CODE_DEVELOPMENT.toString())) {
			return CODE_DEVELOPMENT;
		} else if (name.equalsIgnoreCase(BUILD.toString())) {
			return BUILD;
		} else if (name.equalsIgnoreCase(CODE_GEN.toString())) {
			return CODE_GEN;
		} else if (name.equalsIgnoreCase(COMPILE.toString())) {
			return COMPILE;
		} else if (name.equalsIgnoreCase(PACKAGE.toString())) {
			return PACKAGE;
		} else if (name.equalsIgnoreCase(COMPONENT_TYPE.toString())) {
			return COMPONENT_TYPE;
		}

		switch (name.toLowerCase()) {

		case "isauthor":
		case "isreferenced":
		case "isgovernedby":
		case "isstep":
		case "isperformedby":
		case "iscompiledby":
		case "iscompileinput":
		case "ispackagedby":
		case "ispackageinput":
		case "isname":
		case "iscomponenttype":
		case "isvaluetype":
		case "isinstantiates":
		case "isdefinedin":
		case "ismentions":
		case "issubcomponentof":
		case "isrequirements":
		case "isannotations":
		case "iscontrolflowstounconditionally":
		case "iscontrolflowstoconditionally":
			return BaseType.BOOL;

		case "author":
			return new SetType(BaseType.AGENT);
		case "referenced":
		case "governedby":
			return new SetType(BaseType.ENTITY);

		case "step":
			return new SetType(BaseType.ACTIVITY);

		case "performedby":
			return new SetType(BaseType.AGENT);

		case "compiledby":
		case "compileinput":
			return new SetType(FileTypes.FILE);

		case "packagedby":
		case "packageinput":
			return new SetType(FileTypes.FILE);

		case "name":
			return new SetType(BaseType.STRING);

		case "componenttype":
			return new SetType(COMPONENT_TYPE);

		case "valuetype":
			return new SetType(BaseType.STRING);

		case "instantiates":
		case "definedin":
		case "mentions":
		case "subcomponentof":
		case "requirements":
		case "annotations":
			return new SetType(BaseType.ENTITY);

		case "controlflowstounconditionally":
		case "controlflowstoconditionally":
			return new SetType(BaseType.COMPONENT);

		default:
			return BaseType.FAIL;
		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {

		List<ResoluteType> args = new ArrayList<>();

		switch (function.toLowerCase()) {

		case "author":
		case "referenced":
		case "governedby":
			args.add(CODE_DEVELOPMENT);
			break;
		case "isauthor":
			args.add(CODE_DEVELOPMENT);
			args.add(BaseType.AGENT);
			break;
		case "isreferenced":
		case "isgovernedby":
			args.add(CODE_DEVELOPMENT);
			args.add(BaseType.ENTITY);
			break;

		case "step":
			args.add(BUILD);
			break;
		case "isstep":
			args.add(BUILD);
			args.add(BaseType.ACTIVITY);
			break;

		case "performedby":
			args.add(PERFORMED_BY);
			break;
		case "isperformedby":
			args.add(PERFORMED_BY);
			args.add(BaseType.AGENT);
			break;

		case "compiledby":
		case "compileinput":
			args.add(COMPILE);
			break;

		case "iscompiledby":
		case "iscompileinput":
			args.add(COMPILE);
			args.add(FileTypes.FILE);
			break;

		case "packagedby":
		case "packageinput":
			args.add(PACKAGE);
			break;
		case "ispackagedby":
		case "ispackageinput":
			args.add(PACKAGE);
			args.add(FileTypes.FILE);
			break;

		case "name":
		case "componenttype":
		case "valuetype":
		case "instantiates":
		case "definedin":
		case "mentions":
		case "subcomponentof":
		case "requirements":
		case "annotations":
		case "controlflowstounconditionally":
		case "controlflowstoconditionally":
			args.add(BaseType.COMPONENT);
			break;
		case "isname":
			args.add(BaseType.COMPONENT);
			args.add(BaseType.STRING);
			break;
		case "iscomponenttype":
			args.add(BaseType.COMPONENT);
			args.add(COMPONENT_TYPE);
			break;
		case "isvaluetype":
			args.add(BaseType.COMPONENT);
			args.add(BaseType.STRING);
			break;
		case "isinstantiates":
		case "isdefinedin":
		case "ismentions":
		case "issubcomponentof":
		case "isrequirements":
		case "isannotations":
			args.add(BaseType.COMPONENT);
			args.add(BaseType.ENTITY);
			break;
		case "iscontrolflowstounconditionally":
		case "iscontrolflowstoconditionally":
			args.add(BaseType.COMPONENT);
			args.add(BaseType.COMPONENT);
			break;

		default:
			args = null;
		}

		return args;

	}

	@Override
	public boolean isTypeDefined(String type) {
		return type.equalsIgnoreCase(CODE_DEVELOPMENT.toString()) || type.equalsIgnoreCase(BUILD.toString())
				|| type.equalsIgnoreCase(CODE_GEN.toString()) || type.equalsIgnoreCase(COMPILE.toString())
				|| type.equalsIgnoreCase(PACKAGE.toString()) || type.equalsIgnoreCase(COMPONENT_TYPE.toString());
	}

}
