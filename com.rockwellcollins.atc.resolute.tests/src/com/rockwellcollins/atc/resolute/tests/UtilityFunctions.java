package com.rockwellcollins.atc.resolute.tests;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class UtilityFunctions {
	
	/**
	 * Takes an EMF EObject and finds its names by locating the string of the name property
	 *
	 * @param eObject the EObject to find the name of
	 * @return the name of the eObject
	 */
	public static String getName(EObject eObject) {
		EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
		if(nameFeature instanceof EAttribute && !nameFeature.isMany()) {
			EAttribute nameAttribute = (EAttribute)nameFeature;
			Object nameValue = eObject.eGet(nameFeature);
			return EcoreUtil.convertToString(nameAttribute.getEAttributeType(), nameValue);
		}
		return "";
	}
	
	/**
	 * Takes an EMF EObject and a string and returns the subclass that matches that name
	 *
	 * @param eObject the EObject to find the subclass in
	 * @param sub_name the name of the sub class
	 * @return the subclass
	 */
	public static EObject getSubClass(EObject eObject, String sub_name){
		EList<EObject> contents = eObject.eContents();
		System.out.printf("The subclass names: ");
		for(EObject e : contents) {
			System.out.printf("%s\n", e.getClass().toString());
		}
		for(EObject e : contents) {
			if(e.getClass().toString().contains(sub_name)) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * Takes an EMF EObject and a string and returns the subclass that matches that name
	 *
	 * @param eObject the EObject to find the subclass in
	 * @param sub_name the name of the sub class
	 * @return the subclass
	 */
	public static EObject getAadlPackage(EObject eObject, String sub_name){
		EList<EObject> contents = eObject.eContents();
		System.out.printf("The subclass names: ");
		for(EObject e : contents) {
			System.out.printf("%s\n", e.getClass().toString());
		}
		for(EObject e : contents) {
			if(e.getClass().toString().contains(sub_name)) {
				return e;
			}
		}
		return null;
	}
}
