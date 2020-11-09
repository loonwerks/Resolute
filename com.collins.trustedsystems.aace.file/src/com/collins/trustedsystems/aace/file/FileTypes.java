package com.collins.trustedsystems.aace.file;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;
import com.rockwellcollins.atc.resolute.validation.SetType;

public class FileTypes extends ResoluteExternalFunctionLibraryType {

	public static final BaseType FILE = new BaseType("file") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType FORMAT = new BaseType("format") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(THING)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	public static final BaseType FILE_CREATION = new BaseType("file_creation") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ACTIVITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType FILE_HASH = new BaseType("file_hash") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(THING)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType HASH_TYPE = new BaseType("hash_type") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(THING)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	@Override
	public ResoluteType getType(String name) {

		if (name.equalsIgnoreCase(FILE.toString())) {
			return FILE;
		} else if (name.equalsIgnoreCase(FORMAT.toString())) {
			return FORMAT;
		} else if (name.equalsIgnoreCase(FILE_CREATION.toString())) {
			return FILE_CREATION;
		} else if (name.equalsIgnoreCase(FILE_HASH.toString())) {
			return FILE_HASH;
		} else if (name.equalsIgnoreCase(HASH_TYPE.toString())) {
			return HASH_TYPE;
		}

		switch (name.toLowerCase()) {

		case "isfileparent":
		case "isfilename":
		case "isfileformat":
		case "issatisfies":
		case "iscreatedby":
		case "isfilehash":
		case "ishashtype":
		case "ishashvalue":
			return BaseType.BOOL;

		case "fileparent":
			return new SetType(FILE);
		case "filename":
			return new SetType(BaseType.STRING);
		case "fileformat":
			return new SetType(FORMAT);
		case "satisfies":
			return new SetType(BaseType.ENTITY);
		case "createdby":
			return new SetType(FILE_CREATION);
		case "filehash":
			return new SetType(FILE_HASH);
		case "hashtype":
			return HASH_TYPE;
		case "hashvalue":
			return BaseType.STRING;

		default:
			return BaseType.FAIL;
		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {

		List<ResoluteType> args = new ArrayList<>();

		switch (function.toLowerCase()) {

		case "fileparent":
			args.add(BaseType.ENTITY);
			break;
		case "isfileparent":
			args.add(BaseType.ENTITY);
			args.add(FILE);
			break;

		case "filename":
		case "fileformat":
		case "satisfies":
		case "createdby":
		case "filehash":
			args.add(FILE);
			break;
		case "isfilename":
			args.add(FILE);
			args.add(BaseType.STRING);
			break;
		case "isfileformat":
			args.add(FILE);
			args.add(FORMAT);
			break;
		case "issatisfies":
			args.add(FILE);
			args.add(BaseType.ENTITY);
			break;
		case "iscreatedby":
			args.add(FILE);
			args.add(FILE_CREATION);
			break;
		case "isfilehash":
			args.add(FILE);
			args.add(FILE_HASH);
			break;

		case "hashtype":
		case "hashvalue":
			args.add(FILE_HASH);
			break;
		case "ishashtype":
			args.add(FILE_HASH);
			args.add(HASH_TYPE);
			break;
		case "ishashvalue":
			args.add(FILE_HASH);
			args.add(BaseType.STRING);
			break;

		default:
			args = null;
		}

		return args;

	}

	@Override
	public boolean isTypeDefined(String type) {
		return type.equalsIgnoreCase(FILE.toString()) || type.equalsIgnoreCase(FORMAT.toString())
				|| type.equalsIgnoreCase(FILE_CREATION.toString()) || type.equalsIgnoreCase(FILE_HASH.toString())
				|| type.equalsIgnoreCase(HASH_TYPE.toString());
	}

}
