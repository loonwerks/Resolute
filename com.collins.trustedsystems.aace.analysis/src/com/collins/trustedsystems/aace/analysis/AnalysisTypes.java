package com.collins.trustedsystems.aace.analysis;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;
import com.rockwellcollins.atc.resolute.validation.SetType;

public class AnalysisTypes extends ResoluteExternalFunctionLibraryType {

	private static final BaseType ANALYSIS = new BaseType("analysis_activity") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ACTIVITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType ANALYSIS_REPORT = new BaseType("analysis_report") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType ANALYSIS_RESULT = new BaseType("analysis_result") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(ANALYSIS_RESULT)) {
				return ANALYSIS_RESULT;
			} else if (otherType.equals(PASSED) || otherType.equals(FAILED) || otherType.equals(INDETERMINATE)) {
				return ANALYSIS_RESULT;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType PASSED = new BaseType("passed") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ANALYSIS_RESULT)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(ANALYSIS_RESULT)) {
				return ANALYSIS_RESULT;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType FAILED = new BaseType("failed") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ANALYSIS_RESULT)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(ANALYSIS_RESULT)) {
				return ANALYSIS_RESULT;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType INDETERMINATE = new BaseType("indeterminate") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ANALYSIS_RESULT)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(ANALYSIS_RESULT)) {
				return ANALYSIS_RESULT;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType ANALYSIS_ANNOTATION_TYPE = new BaseType("analysis_annotation_type") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(THING)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(ANALYSIS_ANNOTATION_TYPE)) {
				return ANALYSIS_RESULT;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType PRECONDITION = new BaseType("precondition") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ANALYSIS_ANNOTATION_TYPE)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}

		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(ANALYSIS_ANNOTATION_TYPE)) {
				return ANALYSIS_ANNOTATION_TYPE;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType POSTCONDITION = new BaseType("postcondition") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ANALYSIS_ANNOTATION_TYPE)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}

		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(ANALYSIS_ANNOTATION_TYPE)) {
				return ANALYSIS_ANNOTATION_TYPE;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType INVARIANT = new BaseType("invariant") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ANALYSIS_ANNOTATION_TYPE)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}

		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(ANALYSIS_ANNOTATION_TYPE)) {
				return ANALYSIS_ANNOTATION_TYPE;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType ANALYSIS_ANNOTATION = new BaseType("analysis_annotation") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};


	@Override
	public ResoluteType getType(String name) {

		if (name.equalsIgnoreCase(ANALYSIS.toString())) {
			return ANALYSIS;
		} else if (name.equalsIgnoreCase(ANALYSIS_REPORT.toString())) {
			return ANALYSIS_REPORT;
		} else if (name.equalsIgnoreCase(ANALYSIS_RESULT.toString())) {
			return ANALYSIS_RESULT;
		} else if (name.equalsIgnoreCase(PASSED.toString())) {
			return PASSED;
		} else if (name.equalsIgnoreCase(FAILED.toString())) {
			return FAILED;
		} else if (name.equalsIgnoreCase(INDETERMINATE.toString())) {
			return INDETERMINATE;
		} else if (name.equalsIgnoreCase(ANALYSIS_ANNOTATION_TYPE.toString())) {
			return ANALYSIS_ANNOTATION_TYPE;
		} else if (name.equalsIgnoreCase(PRECONDITION.toString())) {
			return PRECONDITION;
		} else if (name.equalsIgnoreCase(POSTCONDITION.toString())) {
			return POSTCONDITION;
		} else if (name.equalsIgnoreCase(INVARIANT.toString())) {
			return INVARIANT;
		} else if (name.equalsIgnoreCase(ANALYSIS_ANNOTATION.toString())) {
			return ANALYSIS_ANNOTATION;
		}

		switch (name.toLowerCase()) {

		case "isperformedby":
		case "isresult":
		case "ismetric":
		case "isanalyzes":
		case "isproducedby":
		case "isfromreport":
		case "isannotationtype":
			return BaseType.BOOL;

		case "performedby":
			return new SetType(BaseType.AGENT);

		case "result":
			return new SetType(ANALYSIS_RESULT);

		case "metric":
			return new SetType(BaseType.REAL);

		case "analyzes":
			return new SetType(BaseType.ENTITY);

		case "producedby":
			return new SetType(BaseType.ACTIVITY);

		case "fromreport":
			return new SetType(BaseType.ENTITY);

		case "annotationtype":
			return new SetType(ANALYSIS_ANNOTATION_TYPE);

		default:
			return BaseType.FAIL;
		}
	}

	@Override
	public List<ResoluteType> getArgTypes(String function) {

		List<ResoluteType> args = new ArrayList<>();

		switch (function.toLowerCase()) {
		case "performedby":
			args.add(ANALYSIS);
			break;
		case "isperformedby":
			args.add(ANALYSIS);
			args.add(BaseType.AGENT);
			break;

		case "result":
		case "metric":
		case "analyzes":
		case "producedby":
			args.add(ANALYSIS_REPORT);
			break;

		case "isresult":
			args.add(ANALYSIS_REPORT);
			args.add(ANALYSIS_RESULT);
			break;
		case "ismetric":
			args.add(ANALYSIS_REPORT);
			args.add(BaseType.REAL);
			break;
		case "isanalyzes":
			args.add(ANALYSIS_REPORT);
			args.add(BaseType.ENTITY);
			break;
		case "isproducedby":
			args.add(ANALYSIS_REPORT);
			args.add(BaseType.ACTIVITY);
			break;

		case "fromreport":
		case "annotationtype":
			args.add(ANALYSIS_ANNOTATION);
			break;

		case "isfromreport":
			args.add(ANALYSIS_ANNOTATION);
			args.add(BaseType.ENTITY);
			break;
		case "isannotationtype":
			args.add(ANALYSIS_ANNOTATION);
			args.add(ANALYSIS_ANNOTATION_TYPE);
			break;

		default:
			args = null;
		}

		return args;
	}

	@Override
	public boolean isTypeDefined(String type) {
		return type.equalsIgnoreCase(ANALYSIS.toString()) || type.equalsIgnoreCase(ANALYSIS_REPORT.toString())
				|| type.equalsIgnoreCase(ANALYSIS_RESULT.toString()) || type.equalsIgnoreCase(PASSED.toString())
				|| type.equalsIgnoreCase(FAILED.toString()) || type.equalsIgnoreCase(INDETERMINATE.toString())
				|| type.equalsIgnoreCase(ANALYSIS_ANNOTATION_TYPE.toString())
				|| type.equalsIgnoreCase(PRECONDITION.toString()) || type.equalsIgnoreCase(POSTCONDITION.toString())
				|| type.equalsIgnoreCase(INVARIANT.toString()) || type.equalsIgnoreCase(ANALYSIS_ANNOTATION.toString());
	}

}
