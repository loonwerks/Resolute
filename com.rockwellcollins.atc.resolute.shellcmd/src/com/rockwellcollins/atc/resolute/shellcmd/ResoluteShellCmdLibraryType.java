package com.rockwellcollins.atc.resolute.shellcmd;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;

public class ResoluteShellCmdLibraryType extends ResoluteExternalFunctionLibraryType {

	private static final BaseType SHELL_RETURN_TYPE = new BaseType("shell_return_type") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			// If SHELL_RETURN_TYPE is a subtype of some other type, that can be specified here
			// if (SOME_OTHER_TYPE.sybetypeOf(otherType)) {
			// return true;
			// } else {
			return super.subtypeOf(otherType);
			// }
		}
	};

	public static final String SHELL_RETURN_CODE_FIELD_NAME = "return_code";
	public static final String SHELL_OUTPUT_FIELD_NAME = "output";

	public static final String SHELL_EXEC_FUNCTION_NAME = "exec";
	public static final String SHELL_GET_RETURN_CODE_FUNCTION_NAME = "get_return_code";
	public static final String SHELL_GET_OUTPUT_FUNCTION_NAME = "get_output";

	@Override
	public ResoluteType getType(String name) {
		// Library-defined types
		if (name.equalsIgnoreCase(SHELL_RETURN_TYPE.name)) {
			return SHELL_RETURN_TYPE;
		}

		// Library-defined functions
		switch (name.toLowerCase()) {
		case SHELL_EXEC_FUNCTION_NAME:
			return SHELL_RETURN_TYPE;
		case SHELL_GET_RETURN_CODE_FUNCTION_NAME:
			return BaseType.INT;
		case SHELL_GET_OUTPUT_FUNCTION_NAME:
			return BaseType.STRING;
		}
		return BaseType.FAIL;
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {
		ArrayList<ResoluteType> args = new ArrayList<ResoluteType>();
		switch (function.toLowerCase()) {
		case SHELL_EXEC_FUNCTION_NAME:
			args.add(BaseType.STRING);
			break;
		case SHELL_GET_RETURN_CODE_FUNCTION_NAME:
			args.add(SHELL_RETURN_TYPE);
			break;
		case SHELL_GET_OUTPUT_FUNCTION_NAME:
			args.add(SHELL_RETURN_TYPE);
			break;
		default:
			args = null;
		}
		return args;
	}

	@Override
	public boolean isTypeDefined(String type) {
		if (type.equalsIgnoreCase(SHELL_RETURN_TYPE.name)) {
			return true;
		}
		return super.isTypeDefined(type);
	}

}
