package com.rockwellcollins.atc.resolute.json;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ListType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;

public class JsonType extends ResoluteExternalFunctionLibraryType {

	public static final BaseType JSON_ELEMENT = new BaseType("json_element");

	public static final BaseType JSON_ARRAY = new BaseType("json_array") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
//			if (this.equals(FAIL) || otherType.equals(FAIL)) {
//				return true;
//			}

			if (this.equals(ANY) || otherType.equals(ANY)) {
				return true;
			}

			if (this.equals(otherType)) {
				return true;
			}
//			if (otherType instanceof ListType || otherType.equals(BaseType.COLLECTION)) {
//				return true;
//			}
			if (otherType instanceof BaseType) {
				final BaseType bt = (BaseType) otherType;
				return (bt.name.equalsIgnoreCase(JSON_ELEMENT.name));
			}
			return false;
		}
	};

	public static final BaseType JSON_OBJECT = new BaseType("json_object") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
//			if (this.equals(FAIL) || otherType.equals(FAIL)) {
//				return true;
//			}

			if (this.equals(ANY) || otherType.equals(ANY)) {
				return true;
			}

			if (this.equals(otherType)) {
				return true;
			}
			if (otherType instanceof BaseType) {
				final BaseType bt = (BaseType) otherType;
				return (bt.name.equalsIgnoreCase(JSON_ELEMENT.name));
			}
			return false;
		}
	};

	public static final BaseType JSON_PRIMITIVE = new BaseType("json_primitive") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
//			if (this.equals(FAIL) || otherType.equals(FAIL)) {
//				return true;
//			}

			if (this.equals(ANY) || otherType.equals(ANY)) {
				return true;
			}

			if (this.equals(otherType)) {
				return true;
			}
			if (otherType instanceof BaseType) {
				final BaseType bt = (BaseType) otherType;
				return (bt.name.equalsIgnoreCase(JSON_ELEMENT.name));
			}
			return false;
		}
	};


	@Override
	public ResoluteType getType(String function) {
		switch (function.toLowerCase()) {
		// Functions
		case "parse":
			return JSON_ELEMENT;
		case "isarray":
		case "isobject":
		case "isprimitive":
		case "isboolean":
		case "isinteger":
		case "isnull":
		case "isreal":
		case "isstring":
			return com.rockwellcollins.atc.resolute.validation.BaseType.BOOL;
		case "toarray":
			return new ListType(JSON_ELEMENT);
		case "toobject":
//			return com.rockwellcollins.atc.resolute.validation.BaseType.RECORD;
			return JSON_OBJECT;
		case "toprimitive":
			return JSON_PRIMITIVE;
		case "toboolean":
			return com.rockwellcollins.atc.resolute.validation.BaseType.BOOL;
		case "tointeger":
			return com.rockwellcollins.atc.resolute.validation.BaseType.INT;
		case "toreal":
			return com.rockwellcollins.atc.resolute.validation.BaseType.REAL;
		case "tostring":
			return com.rockwellcollins.atc.resolute.validation.BaseType.STRING;
		case "get":
			return JSON_ELEMENT;
		case "getarray":
			return JSON_ARRAY;
		case "getobject":
			return JSON_OBJECT;
		case "getprimitive":
			return JSON_PRIMITIVE;
		case "getboolean":
			return com.rockwellcollins.atc.resolute.validation.BaseType.BOOL;
		case "getinteger":
			return com.rockwellcollins.atc.resolute.validation.BaseType.INT;
		case "getreal":
			return com.rockwellcollins.atc.resolute.validation.BaseType.REAL;
		case "getstring":
			return com.rockwellcollins.atc.resolute.validation.BaseType.STRING;
		case "hasmember":
			return com.rockwellcollins.atc.resolute.validation.BaseType.BOOL;
		// Types
		case "json_element":
			return JSON_ELEMENT;
		case "json_array":
			return JSON_ARRAY;
		case "json_object":
			return JSON_OBJECT;
		case "json_primitive":
			return JSON_PRIMITIVE;
		default:
			return com.rockwellcollins.atc.resolute.validation.BaseType.FAIL;
		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {

		List<ResoluteType> args = new ArrayList<>();

		switch (function.toLowerCase()) {
		case "parse":
			args.add(com.rockwellcollins.atc.resolute.validation.BaseType.STRING);
			break;
		case "isarray":
		case "isobject":
		case "isprimitive":
		case "isboolean":
		case "isinteger":
		case "isnull":
		case "isreal":
		case "isstring":
		case "toarray":
		case "toobject":
		case "toprimitive":
		case "toboolean":
		case "tointeger":
		case "toreal":
		case "tostring":
			args.add(JSON_ELEMENT);
			break;
		case "get":
		case "getarray":
		case "getobject":
		case "getprimitive":
		case "getboolean":
		case "getinteger":
		case "getreal":
		case "getstring":
		case "hasmember":
			args.add(JSON_ELEMENT);
			args.add(com.rockwellcollins.atc.resolute.validation.BaseType.STRING);
			break;
		default:
			args = null;
		}
		return args;
	}

	@Override
	public boolean isTypeDefined(String type) {
		if (type.equalsIgnoreCase(JSON_ELEMENT.name) || type.equalsIgnoreCase(JSON_ARRAY.name)
				|| type.equalsIgnoreCase(JSON_OBJECT.name) || type.equalsIgnoreCase(JSON_PRIMITIVE.name)) {
			return true;
		}
		return super.isTypeDefined(type);
	}

}
