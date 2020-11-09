package com.collins.trustedsystems.aace.testing;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;
import com.rockwellcollins.atc.resolute.validation.SetType;

public class TestingTypes extends ResoluteExternalFunctionLibraryType {

	private static final BaseType TEST = new BaseType("test") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType TEST_STATUS = new BaseType("test_status") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(THING)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType PASSED = new BaseType("passed") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(TEST_STATUS)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}

		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(TEST_STATUS)) {
				return TEST_STATUS;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType FAILED = new BaseType("failed") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(TEST_STATUS)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}

		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(TEST_STATUS)) {
				return TEST_STATUS;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType INDETERMINATE = new BaseType("indeterminate") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(TEST_STATUS)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}

		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(TEST_STATUS)) {
				return TEST_STATUS;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType TEST_RESULT = new BaseType("test_result") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType TEST_DEVELOPMENT = new BaseType("test_development") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ACTIVITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType TEST_EXECUTION = new BaseType("test_execution") {
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

		if (name.equalsIgnoreCase(TEST.toString())) {
			return TEST;
		} else if (name.equalsIgnoreCase(TEST_STATUS.toString())) {
			return TEST_STATUS;
		} else if (name.equalsIgnoreCase(PASSED.toString())) {
			return PASSED;
		} else if (name.equalsIgnoreCase(FAILED.toString())) {
			return FAILED;
		} else if (name.equalsIgnoreCase(INDETERMINATE.toString())) {
			return INDETERMINATE;
		} else if (name.equalsIgnoreCase(TEST_RESULT.toString())) {
			return TEST_RESULT;
		} else if (name.equalsIgnoreCase(TEST_DEVELOPMENT.toString())) {
			return TEST_DEVELOPMENT;
		} else if (name.equalsIgnoreCase(TEST_EXECUTION.toString())) {
			return TEST_EXECUTION;
		}


		switch (name.toLowerCase()) {

		case "isverifies":
		case "isproducedby":
		case "isresult":
		case "isconfirms":
		case "isexecutedby":
		case "isdevelopedby":
		case "isexecutedon":
			return BaseType.BOOL;

		case "verifies":
			return new SetType(BaseType.ENTITY);

		case "producedby":
			return new SetType(BaseType.ACTIVITY);

		case "result":
			return new SetType(TEST_STATUS);

		case "confirms":
			return new SetType(BaseType.ENTITY);

		case "executedby":
			return new SetType(BaseType.ACTIVITY);

		case "developedby":
			return new SetType(BaseType.AGENT);

		case "executedon":
			return new SetType(BaseType.AGENT);

		default:
			return BaseType.FAIL;
		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {

		List<ResoluteType> args = new ArrayList<>();

		switch (function.toLowerCase()) {
		case "verifies":
		case "producedby":
			args.add(TEST);
			break;
		case "isverifies":
			args.add(TEST);
			args.add(BaseType.ENTITY);
		case "isproducedby":
			args.add(TEST);
			args.add(BaseType.ACTIVITY);
			break;

		case "result":
		case "confirms":
		case "executedby":
			args.add(TEST_RESULT);
			break;
		case "isresult":
			args.add(TEST_RESULT);
			args.add(TEST_STATUS);
			break;
		case "isconfirms":
			args.add(TEST_RESULT);
			args.add(BaseType.ENTITY);
			break;
		case "isexecutedby":
			args.add(TEST_RESULT);
			args.add(BaseType.ACTIVITY);
			break;

		case "developedby":
			args.add(TEST_DEVELOPMENT);
			break;
		case "isdevelopedby":
			args.add(TEST_DEVELOPMENT);
			args.add(BaseType.AGENT);
			break;

		case "executedon":
			args.add(TEST_EXECUTION);
			break;
		case "isexecutedon":
			args.add(TEST_EXECUTION);
			args.add(BaseType.AGENT);
			break;

		default:
			args = null;
		}

		return args;
	}

	@Override
	public boolean isTypeDefined(String type) {
		return type.equalsIgnoreCase(TEST.toString()) || type.equalsIgnoreCase(TEST_STATUS.toString())
				|| type.equalsIgnoreCase(PASSED.toString()) || type.equalsIgnoreCase(FAILED.toString())
				|| type.equalsIgnoreCase(INDETERMINATE.toString()) || type.equalsIgnoreCase(TEST_RESULT.toString())
				|| type.equalsIgnoreCase(TEST_DEVELOPMENT.toString())
				|| type.equalsIgnoreCase(TEST_EXECUTION.toString());
	}

}
