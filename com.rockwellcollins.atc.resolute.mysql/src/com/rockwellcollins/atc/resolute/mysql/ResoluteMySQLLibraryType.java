package com.rockwellcollins.atc.resolute.mysql;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ListType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;

public class ResoluteMySQLLibraryType extends ResoluteExternalFunctionLibraryType {

	private static final BaseType TABLE_ROW_TYPE = new BaseType("table_row_type") {
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

	public static final String SELECT_FUNCTION_NAME = "select";
	public static final String GET_BOOL_FIELD_FUNCTION_NAME = "get_bool_field";
	public static final String GET_INT_FIELD_FUNCTION_NAME = "get_int_field";
	public static final String GET_REAL_FIELD_FUNCTION_NAME = "get_real_field";
	public static final String GET_STRING_FIELD_FUNCTION_NAME = "get_string_field";

	@Override
	public ResoluteType getType(String function) {
		switch (function.toLowerCase()) {
		case SELECT_FUNCTION_NAME:
			return new ListType(TABLE_ROW_TYPE);
		case GET_BOOL_FIELD_FUNCTION_NAME:
			return BaseType.BOOL;
		case GET_INT_FIELD_FUNCTION_NAME:
			return BaseType.INT;
		case GET_REAL_FIELD_FUNCTION_NAME:
			return BaseType.REAL;
		case GET_STRING_FIELD_FUNCTION_NAME:
			return BaseType.STRING;
		default:
			return BaseType.FAIL;
		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {
		List<ResoluteType> args = new ArrayList<>();
		switch (function.toLowerCase()) {
		case SELECT_FUNCTION_NAME:
			// Database Name
			args.add(BaseType.STRING);
			// Table Name
			args.add(BaseType.STRING);
			// List of Field Names
			args.add(new ListType(BaseType.STRING));
			break;
		case GET_BOOL_FIELD_FUNCTION_NAME:
		case GET_INT_FIELD_FUNCTION_NAME:
		case GET_REAL_FIELD_FUNCTION_NAME:
		case GET_STRING_FIELD_FUNCTION_NAME:
			// Row from which to extract field
			args.add(TABLE_ROW_TYPE);
			// Field name to be extracted
			args.add(BaseType.STRING);
		default:
			args = null;
		}
		return args;
	}

	@Override
	public boolean isTypeDefined(String type) {
		if (type.equalsIgnoreCase(TABLE_ROW_TYPE.name)) {
			return true;
		}
		return super.isTypeDefined(type);
	}

}
