package com.rockwellcollins.atc.resolute.analysis.execution;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;

import com.rockwellcollins.atc.resolute.analysis.values.NamedElementValue;
import com.rockwellcollins.atc.resolute.validation.BaseType;

public class EvaluationContext {
	private final ComponentInstance thisInst;
	private final Map<String, SortedSet<NamedElement>> sets;
	private final FeatureToConnectionsMap featToConnsMap;

	public EvaluationContext(ComponentInstance thisInst, Map<String, SortedSet<NamedElement>> sets,
			FeatureToConnectionsMap featToConnsMap) {
		this.thisInst = thisInst;
		this.sets = sets;
		this.featToConnsMap = featToConnsMap;
	}

	public EvaluationContext(SystemInstance si) {
		this.thisInst = si;
		this.sets = initializeSets(si);
		this.featToConnsMap = new FeatureToConnectionsMap(si);
	}

	public ComponentInstance getThisInstance() {
		return thisInst;
	}

	public ComponentImplementation getComponentImplementation() {
		final ComponentClassifier classifier = thisInst.getComponentClassifier();
		if (classifier instanceof ComponentImplementation) {
			return (ComponentImplementation) classifier;
		}
		return null;
	}

	public Set<NamedElement> getSet(String name) {
		Set<NamedElement> set = sets.get(name);
		if (set == null) {
			return Collections.emptySet();
		} else {
			return set;
		}
	}

	public List<NamedElementValue> getConnectionsForFeature(FeatureInstance feat) {
		return featToConnsMap.get(feat);
	}

	private Map<String, SortedSet<NamedElement>> initializeSets(SystemInstance si) {

		if (si == null) {
			return null;
		}

		final Map<String, SortedSet<NamedElement>> sets = new HashMap<>();

		addToSet(sets, si);
		for (InstanceObject io : EcoreUtil2.getAllContentsOfType(si, InstanceObject.class)) {
			addToSet(sets, io);
		}

		for (FlowSpecificationInstance flowSpec : si.getFlowSpecifications()) {
			addToSet(sets, "flow_specification", flowSpec);
		}

		for (EndToEndFlowInstance etef : si.getEndToEndFlows()) {
			addToSet(sets, "end_to_end_flow", etef);
		}
		return sets;
	}

	private static void addToSet(Map<String, SortedSet<NamedElement>> sets, InstanceObject io) {
		BaseType type = new BaseType(io);
		for (BaseType superType : type.getAllSuperTypes()) {
			addToSet(sets, superType.name, io);
		}

	}

	private static void addToSet(Map<String, SortedSet<NamedElement>> sets, String name, NamedElement ne) {
		SortedSet<NamedElement> set = sets.get(name);
		if (set == null) {
			set = new TreeSet<>(new NamedElementComparator());
			sets.put(name, set);
		}
		set.add(ne);
	}
}
