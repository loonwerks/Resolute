package com.rockwellcollins.atc.resolute.analysis.execution;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;

import com.rockwellcollins.atc.resolute.validation.BaseType;

public class ModelMap {

	private final SystemInstance si;
	private final Map<String, SortedSet<NamedElement>> sets = new HashMap<>();
	private final FeatureToConnectionsMap featToConnsMap;

	public ModelMap(SystemInstance si) {
		this.si = si;
		this.featToConnsMap = new FeatureToConnectionsMap(si);
		initializeSets(si, this.sets);
	}

	public SystemInstance getSystemInstance() {
		return this.si;
	}

	public SortedSet<NamedElement> getElements(String element) {
		return this.sets.get(element);
	}

	public Map<String, SortedSet<NamedElement>> getElementSets() {
		return this.sets;
	}

	public FeatureToConnectionsMap getFeatureToConnectionsMap() {
		return this.featToConnsMap;
	}

	public static void initializeSets(ComponentInstance ci, Map<String, SortedSet<NamedElement>> sets) {
		if (ci == null) {
			return;
		}

		addToSet(sets, ci);
		for (InstanceObject io : EcoreUtil2.getAllContentsOfType(ci, InstanceObject.class)) {
			addToSet(sets, io);
		}

		for (FlowSpecificationInstance flowSpec : ci.getFlowSpecifications()) {
			addToSet(sets, "flow_specification", flowSpec);
		}

		for (EndToEndFlowInstance etef : ci.getEndToEndFlows()) {
			addToSet(sets, "end_to_end_flow", etef);
		}
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
