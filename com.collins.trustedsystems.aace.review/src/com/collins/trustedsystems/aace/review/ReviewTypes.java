package com.collins.trustedsystems.aace.review;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.external.ResoluteExternalFunctionLibraryType;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import com.rockwellcollins.atc.resolute.validation.ResoluteType;
import com.rockwellcollins.atc.resolute.validation.SetType;

public class ReviewTypes extends ResoluteExternalFunctionLibraryType {

	private static final BaseType REVIEW_LOG = new BaseType("review_log") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(ENTITY)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}
	};

	private static final BaseType REVIEW_STATE = new BaseType("review_state") {
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
			if (otherType.equals(REVIEW_STATE)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}

		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(REVIEW_STATE)) {
				return REVIEW_STATE;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType REVISED_WITHOUT_REVIEW = new BaseType("revised_without_review") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(REVIEW_STATE)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}

		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(REVIEW_STATE)) {
				return REVIEW_STATE;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType REVISED_WITH_REVIEW = new BaseType("revised_with_review") {
		@Override
		public boolean subtypeOf(ResoluteType otherType) {
			if (otherType.equals(REVIEW_STATE)) {
				return true;
			} else {
				return super.subtypeOf(otherType);
			}
		}

		@Override
		public ResoluteType join(ResoluteType otherType) {
			if (otherType.subtypeOf(REVIEW_STATE)) {
				return REVIEW_STATE;
			} else {
				return super.join(otherType);
			}
		}
	};

	private static final BaseType REVIEW = new BaseType("review") {
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

		if (name.equalsIgnoreCase(REVIEW_LOG.toString())) {
			return REVIEW_LOG;
		} else if (name.equalsIgnoreCase(REVIEW_STATE.toString())) {
			return REVIEW_STATE;
		} else if (name.equalsIgnoreCase(PASSED.toString())) {
			return PASSED;
		} else if (name.equalsIgnoreCase(REVISED_WITHOUT_REVIEW.toString())) {
			return REVISED_WITHOUT_REVIEW;
		} else if (name.equalsIgnoreCase(REVISED_WITH_REVIEW.toString())) {
			return REVISED_WITH_REVIEW;
		} else if (name.equalsIgnoreCase(REVIEW.toString())) {
			return REVIEW;
		}

		switch (name.toLowerCase()) {

		case "isreviews":
		case "isreviewresult":
		case "iscreatedby":
		case "isauthor":
		case "isreviewer":
		case "isreviewed":
		case "isgovernedby":
			return BaseType.BOOL;

		case "reviews":
			return new SetType(BaseType.ENTITY);
		case "reviewresult":
			return new SetType(REVIEW_STATE);
		case "createdby":
			return new SetType(BaseType.ACTIVITY);

		case "author":
		case "reviewer":
			return new SetType(BaseType.AGENT);
		case "reviewed":
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

		case "reviews":
		case "reviewresult":
		case "createdby":
			args.add(REVIEW_LOG);
			break;
		case "isreviews":
			args.add(REVIEW_LOG);
			args.add(BaseType.ENTITY);
			break;
		case "isreviewresult":
			args.add(REVIEW_LOG);
			args.add(REVIEW_STATE);
			break;
		case "iscreatedby":
			args.add(REVIEW_LOG);
			args.add(BaseType.ACTIVITY);
			break;

		case "author":
		case "reviewer":
		case "reviewed":
		case "governedby":
			args.add(REVIEW);
			break;
		case "isauthor":
		case "isreviewer":
			args.add(REVIEW);
			args.add(BaseType.AGENT);
			break;
		case "isreviewed":
		case "isgovernedby":
			args.add(REVIEW);
			args.add(BaseType.ENTITY);
			break;

		default:
			args = null;
		}

		return args;

	}

	@Override
	public boolean isTypeDefined(String type) {
		return type.equalsIgnoreCase(REVIEW_LOG.toString()) || type.equalsIgnoreCase(REVIEW_STATE.toString())
				|| type.equalsIgnoreCase(PASSED.toString()) || type.equalsIgnoreCase(REVISED_WITHOUT_REVIEW.toString())
				|| type.equalsIgnoreCase(REVISED_WITH_REVIEW.toString()) || type.equalsIgnoreCase(REVIEW.toString());
	}
}
