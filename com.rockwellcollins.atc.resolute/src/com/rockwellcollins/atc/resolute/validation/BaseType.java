package com.rockwellcollins.atc.resolute.validation;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import org.osate.aadl2.Access;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;

import com.rockwellcollins.atc.resolute.resolute.Type;

public class BaseType extends ResoluteType {
	public static final BaseType ANY = new BaseType("any");
	public static final BaseType INT = new BaseType("int");
	public static final BaseType REAL = new BaseType("real");
	public static final BaseType STRING = new BaseType("string");
	public static final BaseType BOOL = new BaseType("bool");
	public static final BaseType FAIL = new BaseType("fail");
	public static final BaseType RANGE = new BaseType("range");
	public static final BaseType RECORD = new BaseType("record");

	public static final BaseType AADL = new BaseType("aadl");

	public static final BaseType COMPONENT = new BaseType("component");
	public static final BaseType ABSTRACT = new BaseType("abstract");
	public static final BaseType BUS = new BaseType("bus");
	public static final BaseType DATA = new BaseType("data");
	public static final BaseType DEVICE = new BaseType("device");
	public static final BaseType MEMORY = new BaseType("memory");
	public static final BaseType PROCESSOR = new BaseType("processor");
	public static final BaseType PROCESS = new BaseType("process");
	public static final BaseType SUBPROGRAM_GROUP = new BaseType("subprogram_group");
	public static final BaseType SUBPROGRAM = new BaseType("subprogram");
	public static final BaseType SYSTEM = new BaseType("system");
	public static final BaseType THREAD_GROUP = new BaseType("thread_group");
	public static final BaseType THREAD = new BaseType("thread");
	public static final BaseType VIRTUAL_BUS = new BaseType("virtual_bus");
	public static final BaseType VIRTUAL_PROCESSOR = new BaseType("virtual_processor");

	public static final BaseType CONNECTION = new BaseType("connection");

	public static final BaseType PROPERTY = new BaseType("property");

	public static final BaseType FEATURE = new BaseType("feature");
	public static final BaseType PORT = new BaseType("port");
	public static final BaseType DATA_PORT = new BaseType("data_port");
	public static final BaseType EVENT_PORT = new BaseType("event_port");
	public static final BaseType EVENT_DATA_PORT = new BaseType("event_data_port");
	public static final BaseType FEATURE_GROUP = new BaseType("feature_group");
	public static final BaseType ACCESS = new BaseType("access");
	public static final BaseType BUS_ACCESS = new BaseType("bus_access");
	public static final BaseType PROVIDES_BUS_ACCESS = new BaseType("provides_bus_access");
	public static final BaseType REQUIRES_BUS_ACCESS = new BaseType("requires_bus_access");
	public static final BaseType DATA_ACCESS = new BaseType("data_access");
	public static final BaseType PROVIDES_DATA_ACCESS = new BaseType("provides_data_access");
	public static final BaseType REQUIRES_DATA_ACCESS = new BaseType("requires_data_access");
	public static final BaseType SUBPROGRAM_ACCESS = new BaseType("subprogram_access");
	public static final BaseType PROVIDES_SUBPROGRAM_ACCESS = new BaseType("provides_subprogram_access");
	public static final BaseType REQUIRES_SUBPROGRAM_ACCESS = new BaseType("requires_subprogram_access");
	public static final BaseType SUBPROGRAM_GROUP_ACCESS = new BaseType("subprogram_group_access");
	public static final BaseType PROVIDES_SUBPROGRAM_GROUP_ACCESS = new BaseType("provides_subprogram_group_access");
	public static final BaseType REQUIRES_SUBPROGRAM_GROUP_ACCESS = new BaseType("requires_subprogram_group_access");

	public static final BaseType FLOW_SPECIFICATION = new BaseType("flow_specification");
	public static final BaseType END_TO_END_FLOW = new BaseType("end_to_end_flow");

	public static final BaseType ENTITY = new BaseType("entity");
	public static final BaseType ACTIVITY = new BaseType("activity");
	public static final BaseType AGENT = new BaseType("agent");
	public static final BaseType THING = new BaseType("thing");
	public static final BaseType ANALYSIS_ACTIVITY = new BaseType("analysis_activity");
	public static final BaseType ANALYSIS_REPORT = new BaseType("analysis_report");
	public static final BaseType ANALYSIS_RESULT = new BaseType("analysis_result");
	public static final BaseType PASSED = new BaseType("passed");
	public static final BaseType FAILED = new BaseType("failed");
	public static final BaseType INDETERMINATE = new BaseType("indeterminate");
	public static final BaseType ANALYSIS_ANNOTATION_TYPE = new BaseType("analysis_annotation_type");
	public static final BaseType PRECONDITION = new BaseType("precondition");
	public static final BaseType POSTCONDITION = new BaseType("postcondition");
	public static final BaseType INVARIANT = new BaseType("invariant");
	public static final BaseType ANALYSIS_ANNOTATION = new BaseType("analysis_annotation");
	public static final BaseType HAZARD = new BaseType("hazard");
	public static final BaseType HAZARD_IDENTIFICATION = new BaseType("hazard_identification");
	public static final BaseType REQUIREMENT = new BaseType("requirement");
	public static final BaseType DATA_DICTIONARY_TERM = new BaseType("data_dictionary_term");
	public static final BaseType REQUIREMENT_DEVELOPMENT = new BaseType("requirement_development");
	public static final BaseType REVIEW = new BaseType("review");
	public static final BaseType REVIEW_LOG = new BaseType("review_log");
	public static final BaseType REVIEW_STATE = new BaseType("review_state");
	public static final BaseType REVISED_WITHOUT_REVIEW = new BaseType("revised_without_review");
	public static final BaseType REVISED_WITH_REVIEW = new BaseType("revised_with_review");
	public static final BaseType FILE = new BaseType("file");
	public static final BaseType FORMAT = new BaseType("format");
	public static final BaseType CODE_DEVELOPMENT = new BaseType("code_development");
	public static final BaseType BUILD = new BaseType("build");
	public static final BaseType CODE_GEN = new BaseType("code_gen");
	public static final BaseType COMPILE = new BaseType("compile");
	public static final BaseType PACKAGE_FILE = new BaseType("package_file");
	public static final BaseType COMPONENT_TYPE = new BaseType("component_type");
	public static final BaseType SOURCE_FUNCTION = new BaseType("source_function");
	public static final BaseType BINARY_FUNCTION = new BaseType("binary_function");
	public static final BaseType SOURCE_GLOBAL_VARIABLE = new BaseType("source_global_variable");
	public static final BaseType BINARY_GLOBAL_VARIABLE = new BaseType("binary_global_variable");
	public static final BaseType BINARY_BASIC_BLOCK = new BaseType("binary_basic_block");
	public static final BaseType CLASS_DEFINITION = new BaseType("class_definition");
	public static final BaseType CLASS_METHOD = new BaseType("class_method");
	public static final BaseType CLASS_MEMBER_VARIABLE = new BaseType("class_member_variable");
	public static final BaseType CLASS_CONSTRUCTOR = new BaseType("class_constructor");
	public static final BaseType MODULE = new BaseType("module");
	public static final BaseType NAMESPACE = new BaseType("namespace");
	public static final BaseType INTERFACE = new BaseType("interface");
	public static final BaseType SYSTEM_DEVELOPMENT = new BaseType("system_development");
	public static final BaseType TEST = new BaseType("test");
	public static final BaseType TEST_RESULT = new BaseType("test_result");
	public static final BaseType TEST_DEVELOPMENT = new BaseType("test_developmemt");
	public static final BaseType TEST_EXECUTION = new BaseType("test_execution");
	public static final BaseType TEST_STATUS = new BaseType("test_status");

	final public String name;

	public BaseType(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}

		this.name = name;
	}

	public BaseType(InstanceObject io) {
		if (io instanceof FeatureInstance) {
			FeatureInstance fi = (FeatureInstance) io;
			String prefix = "";
			if (fi.getFeature() instanceof Access) {
				Access acc = (Access) fi.getFeature();
				prefix = acc.getKind().toString() + "_";
			}
			this.name = prefix + convertCamelCase(fi.getCategory().toString());
		} else if (io instanceof ComponentInstance) {
			ComponentInstance ci = (ComponentInstance) io;
			this.name = ci.getCategory().getName().replace(" ", "_");
		} else if (io instanceof ConnectionInstance) {
			this.name = "connection";
		} else {
			this.name = "aadl";
		}
	}

	public BaseType(ComponentCategory cc) {
		this.name = cc.getName().replace(" ", "_");
	}

	private String convertCamelCase(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isUpperCase(c)) {
				result.append('_');
				result.append(Character.toLowerCase(c));
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}

	private final BaseType[] INSTANCE_TYPES = { AADL, COMPONENT, ABSTRACT, BUS, DATA, DEVICE, MEMORY, PROCESSOR,
			PROCESS, SUBPROGRAM_GROUP, SUBPROGRAM, SYSTEM, THREAD_GROUP, THREAD, VIRTUAL_BUS, VIRTUAL_PROCESSOR,
			CONNECTION, PROPERTY, FEATURE, PORT, DATA_PORT, EVENT_PORT, EVENT_DATA_PORT, FEATURE_GROUP, ACCESS,
			BUS_ACCESS, PROVIDES_BUS_ACCESS, REQUIRES_BUS_ACCESS, DATA_ACCESS, PROVIDES_DATA_ACCESS,
			REQUIRES_DATA_ACCESS, SUBPROGRAM_ACCESS, PROVIDES_SUBPROGRAM_ACCESS, REQUIRES_SUBPROGRAM_ACCESS,
			SUBPROGRAM_GROUP_ACCESS, PROVIDES_SUBPROGRAM_GROUP_ACCESS, REQUIRES_SUBPROGRAM_GROUP_ACCESS };

	public List<BaseType> getAllSuperTypes() {
		return Arrays.stream(INSTANCE_TYPES).filter(this::subtypeOf).collect(toList());
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean subtypeOf(ResoluteType otherType) {
		if (this.equals(FAIL) || otherType.equals(FAIL)) {
			return true;
		}

		if (this.equals(ANY) || otherType.equals(ANY)) {
			return true;
		}

		if (this.equals(otherType)) {
			return true;
		}

		if ((name.equalsIgnoreCase("real")) && (otherType.toString().equalsIgnoreCase("int"))) {
			// System.out.println("case from int to real");
			return true;
		}

		if (otherType instanceof BaseType) {
			BaseType bt = (BaseType) otherType;
			switch (bt.name) {
			case "aadl":
				return subtypeOf(COMPONENT) || subtypeOf(CONNECTION) || subtypeOf(PROPERTY) || subtypeOf(FEATURE)
						|| subtypeOf(FLOW_SPECIFICATION) || subtypeOf(END_TO_END_FLOW);

			case "component":
				return subtypeOf(ABSTRACT) || subtypeOf(BUS) || subtypeOf(DATA) || subtypeOf(DEVICE)
						|| subtypeOf(MEMORY) || subtypeOf(PROCESSOR) || subtypeOf(PROCESS)
						|| subtypeOf(SUBPROGRAM_GROUP) || subtypeOf(SUBPROGRAM) || subtypeOf(SYSTEM)
						|| subtypeOf(THREAD_GROUP) || subtypeOf(THREAD) || subtypeOf(VIRTUAL_BUS)
						|| subtypeOf(VIRTUAL_PROCESSOR);

			case "feature":
				return subtypeOf(PORT) || subtypeOf(ACCESS) || subtypeOf(FEATURE_GROUP);

			case "port":
				return subtypeOf(DATA_PORT) || subtypeOf(EVENT_PORT) || subtypeOf(EVENT_DATA_PORT);

			case "access":
				return subtypeOf(BUS_ACCESS) || subtypeOf(DATA_ACCESS) || subtypeOf(SUBPROGRAM_ACCESS)
						|| subtypeOf(SUBPROGRAM_GROUP_ACCESS);

			case "bus_access":
				return subtypeOf(PROVIDES_BUS_ACCESS) || subtypeOf(REQUIRES_BUS_ACCESS);

			case "data_access":
				return subtypeOf(PROVIDES_DATA_ACCESS) || subtypeOf(REQUIRES_DATA_ACCESS);

			case "subprogram_access":
				return subtypeOf(PROVIDES_SUBPROGRAM_ACCESS) || subtypeOf(REQUIRES_SUBPROGRAM_ACCESS);

			case "subprogram_group_access":
				return subtypeOf(PROVIDES_SUBPROGRAM_GROUP_ACCESS) || subtypeOf(REQUIRES_SUBPROGRAM_GROUP_ACCESS);

			case "entity":
				return subtypeOf(ANALYSIS_REPORT) || subtypeOf(ANALYSIS_ANNOTATION) || subtypeOf(HAZARD)
						|| subtypeOf(REQUIREMENT) || subtypeOf(DATA_DICTIONARY_TERM) || subtypeOf(REVIEW_LOG)
						|| subtypeOf(FILE) || subtypeOf(INTERFACE) || subtypeOf(TEST) || subtypeOf(TEST_RESULT)
						|| subtypeOf(COMPONENT) || subtypeOf(SYSTEM);

			case "activity":
				return subtypeOf(ANALYSIS_ACTIVITY) || subtypeOf(HAZARD_IDENTIFICATION)
						|| subtypeOf(REQUIREMENT_DEVELOPMENT) || subtypeOf(REVIEW) || subtypeOf(CODE_DEVELOPMENT)
						|| subtypeOf(BUILD) || subtypeOf(CODE_GEN) || subtypeOf(COMPILE) || subtypeOf(PACKAGE_FILE)
						|| subtypeOf(SYSTEM_DEVELOPMENT) || subtypeOf(TEST_DEVELOPMENT) || subtypeOf(TEST_EXECUTION);

			case "thing":
				return subtypeOf(FORMAT) || subtypeOf(COMPONENT_TYPE);

			case "analysis_result":
			case "test_status":
				return subtypeOf(PASSED) || subtypeOf(FAILED) || subtypeOf(INDETERMINATE);

			case "analysis_annotation_type":
				return subtypeOf(PRECONDITION) || subtypeOf(POSTCONDITION) || subtypeOf(INVARIANT);

			case "review_state":
				return subtypeOf(PASSED) || subtypeOf(REVISED_WITHOUT_REVIEW) || subtypeOf(REVISED_WITH_REVIEW);

			case "component_type":
				return subtypeOf(SOURCE_FUNCTION) || subtypeOf(BINARY_FUNCTION) || subtypeOf(SOURCE_GLOBAL_VARIABLE)
						|| subtypeOf(BINARY_GLOBAL_VARIABLE) || subtypeOf(BINARY_BASIC_BLOCK)
						|| subtypeOf(CLASS_DEFINITION) || subtypeOf(CLASS_METHOD) || subtypeOf(CLASS_MEMBER_VARIABLE)
						|| subtypeOf(CLASS_CONSTRUCTOR) || subtypeOf(MODULE) || subtypeOf(NAMESPACE);

			case "agent":
				return false;

			default: {
				// System.out.println("this=" + this.name);
				// System.out.println("other=" + otherType.toString());
				return false;
			}
			}
		}

		return false;
	}

	@Override
	public ResoluteType join(ResoluteType otherType) {
		if (this.equals(FAIL) || otherType.equals(FAIL)) {
			return FAIL;
		}

		if (this.equals(otherType)) {
			return this;
		}

		if (subtypeOf(COMPONENT) && otherType.subtypeOf(COMPONENT)) {
			return COMPONENT;
		}

		if (subtypeOf(AADL) && otherType.subtypeOf(AADL)) {
			return AADL;
		}

		if (subtypeOf(TEST_STATUS) && otherType.subtypeOf(TEST_STATUS)) {
			return TEST_STATUS;
		}

		return null;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BaseType) {
			BaseType bt = (BaseType) obj;
			return bt.name.equals(name);
		}

		return false;
	}

	@Override
	public boolean similar(Type otherType) {
		if (otherType instanceof com.rockwellcollins.atc.resolute.resolute.BaseType) {
			com.rockwellcollins.atc.resolute.resolute.BaseType bt = (com.rockwellcollins.atc.resolute.resolute.BaseType) otherType;
			String otherTypeName = bt.getType();

			// System.out.println("other type=" + otherTypeName);
			// System.out.println("this type=" + name);
			return otherTypeName.equalsIgnoreCase(name);
		}
		return false;
	}
}
