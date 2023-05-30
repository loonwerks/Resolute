package com.rockwellcollins.atc.resolute.tests;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
	 * Takes an EMF EObject and returns the ownedPublicSection if it exists
	 *
	 * @param eObject the EObject to find the ownedPublicSection in
	 * @return the ownedPublicSection
	 */
	public static EObject getownedPublicSection(EObject eObject){
		EStructuralFeature pub_sec_feature = eObject.eClass().getEStructuralFeature("ownedPublicSection");
		if(pub_sec_feature instanceof EReference && !pub_sec_feature.isMany()) {
			return (EObject)eObject.eGet(pub_sec_feature);
		}		
		return null;
	}
	
	/**
	 * Takes an EMF EObject and a classifier name and returns the 
	 * class object if it exists
	 *
	 * @param eObject the EObject to find the ownedClassifier in
	 * @param name the name of the classifier
	 * @return the ownedClassifier titled "name"
	 */
	public static EObject getownedClassifier(EObject eObject, String name){
		EList<EObject> contents = eObject.eContents();
		for(EObject e : contents) {
			if(getName(e).equals(name)) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * Takes an EMF EObject and a classifier name and returns the 
	 * class object if it exists
	 *
	 * @param eObject the EObject to find the ownedClassifier in
	 * @param name the name of the classifier
	 * @return the ownedClassifier titled "name"
	 */
	public static EObject getAnnex(EObject eObject, String name){
		EList<EObject> contents = eObject.eContents();
		for(EObject e : contents) {
			if(getName(e).equals(name)) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * Takes an EMF EObject and returns the parsedAnnexSubclause
	 *
	 * @param eObject the EObject to find the parsedAnnexSubclause in
	 * @return the parsedAnnexSubclause
	 */
	public static EObject getParsedAnnex(EObject eObject){
		EStructuralFeature parsed_annex_feature = eObject.eClass().getEStructuralFeature("parsedAnnexSubclause");
		if(parsed_annex_feature instanceof EReference && !parsed_annex_feature.isMany()) {
			return (EObject)eObject.eGet(parsed_annex_feature);
		}		
		return null;
	}
}
