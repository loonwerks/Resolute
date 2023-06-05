package com.rockwellcollins.atc.resolute.tests;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;

import com.rockwellcollins.atc.resolute.resolute.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class UtilityFunctions {
	
	/**
	 * Takes an EMF EObject, finds its property, and returns the property's string value if it exists
	 *
	 * @param eObject the EObject to find the property of
	 * @parm property the property's name
	 * @return the name of the property
	 */
	public static String getStringProperty(EObject eObject, String property) {
		EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature(property);
		if(nameFeature instanceof EAttribute && !nameFeature.isMany()) {
			EAttribute nameAttribute = (EAttribute)nameFeature;
			Object nameValue = eObject.eGet(nameFeature);
			return EcoreUtil.convertToString(nameAttribute.getEAttributeType(), nameValue);
		}
		return "";
	}
	
	/**
	 * Takes an EMF EObject and returns the subclass given by class_name if it exists
	 *
	 * @param eObject the EObject to find the subclass in
	 * @param class_name the name of the subclass
	 * @return the subclass
	 */
	private static EObject getSubclassBasedOnClassName(EObject eObject, String class_name){
		EStructuralFeature feature = eObject.eClass().getEStructuralFeature(class_name);
		if(feature instanceof EReference && !feature.isMany()) {
			return (EObject)eObject.eGet(feature);
		}		
		return null;
	}
	
	/**
	 * Takes an EMF EObject and a property name and returns the 
	 * class object if it exists
	 *
	 * @param eObject the EObject to find the property in
	 * @param name the name of the property
	 * @return the property titled "property_name"
	 */
	private static EObject getSubclassBasedOnPropertyName(EObject eObject, String property_name){
		EList<EObject> contents = eObject.eContents();
		for(EObject e : contents) {
			if(getStringProperty(e, "name").equals(property_name)) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * Takes an EMF EObject and returns the ownedPublicSection if it exists
	 *
	 * @param eObject the EObject to find the ownedPublicSection in
	 * @return the ownedPublicSection
	 */
	public static EObject getownedPublicSection(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "ownedPublicSection");
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
		return getSubclassBasedOnPropertyName(eObject, name);
	}
	
	/**
	 * Takes an EMF EObject and a classifier name and returns the 
	 * class object if it exists
	 *
	 * @param eObject the EObject to find the ownedClassifier in
	 * @param name the name of the classifier
	 * @return the ownedClassifier titled "name"
	 */
	public static EObject getAnnexLibrary(EObject eObject, String name){
		return getSubclassBasedOnPropertyName(eObject, name);
	}
	
	/**
	 * Takes an EMF EObject and an annex name and returns the 
	 * class object if it exists
	 *
	 * @param eObject the EObject to find the annex in
	 * @param name the name of the annex
	 * @return the annex subclause titled "name"
	 */
	public static EObject getAnnexSubclause(EObject eObject, String name){
		return getSubclassBasedOnPropertyName(eObject, name);
	}
	
	/**
	 * Takes an EMF EObject and returns the parsedAnnexLibrary if it exists
	 *
	 * @param eObject the EObject to find the parsedAnnexLibrary in
	 * @return the parsedAnnexLibrary
	 */
	public static EObject getParsedAnnexLibrary(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "parsedAnnexLibrary");
	}
	
	/**
	 * Takes an EMF EObject and returns the parsedAnnexSubclause if it exists
	 *
	 * @param eObject the EObject to find the parsedAnnexSubclause in
	 * @return the parsedAnnexSubclause
	 */
	public static EObject getParsedAnnexSubclause(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "parsedAnnexSubclause");
	}
	
	/**
	 * Takes an EMF EObject and a definition name and returns the 
	 * class object if it exists
	 *
	 * @param eObject the EObject to find the annex in
	 * @param name the name of the definition
	 * @return the definition titled "name"
	 */
	public static EObject getDefinition(EObject eObject, String name){
		return getSubclassBasedOnPropertyName(eObject, name);
	}
	
	/**
	 * Takes an EMF EObject and a analysis name and returns the 
	 * class object if it exists
	 *
	 * @param eObject the EObject to find the analysis in
	 * @param name the argument of the analysis (e.g., "argue", or "prove Req1(this))")
	 * @return the analysis with the argument "name"
	 */
	public static EObject getAnalysis(EObject eObject, String name){
		name = name.substring(0,5);
		EList<EObject> contents = eObject.eContents();
		for(EObject e : contents) {
			if(getStringProperty(e, "tag").equals(name)) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * Takes an EMF EObject and returns the expr if it exists
	 *
	 * @param eObject the EObject to find the expr in
	 * @return the expr
	 */
	public static EObject getExpr(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "expr");
	}
	
	/**
	 * Takes an EMF EObject and returns the fn if it exists
	 *
	 * @param eObject the EObject to find the fn in
	 * @return the fn
	 */
	public static EObject getFn(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "fn");
	}
	
	/**
	 * Takes an EMF EObject(parsed annex) and returns the fn based on the claim if it exists
	 *
	 * @param parsed_annex the EObject(parsed annex) to find the fn in
	 * @param claim the string of the argument claim (e.g., "argue Req1(this)" or "prove Req2(this))")
	 * @return the fn
	 */
	public static EObject getFn(EObject parsed_annex, String claim){
		String[] str = claim.split(" ");
		if(str.length != 2)
			return null;
		String argue_statement = str[0];
		String argument_name = str[1];
		argument_name = argument_name.substring(0, argument_name.indexOf("("));
		EList<EObject> contents = parsed_annex.eContents();
		for(EObject e : contents) {
			if(getStringProperty(e, "tag").equals(argue_statement)) {
				EObject temp_fn = getFn(getExpr(e));
				if(getStringProperty(temp_fn, "name").equals(argument_name))
					return temp_fn;
			}
		}
		return null;
	}
	
	/**
	 * Takes an EMF EObject and an argument index and returns the 
	 * class object if it exists
	 *
	 * @param eObject the EObject to find the arg in
	 * @param index the index of the arg
	 * @return the arg at index
	 */
	public static EObject getArg(EObject eObject, int index){
		List<EObject> objects = eObject.eContents();
		List<EObject> args = new ArrayList<EObject>();
		for(EObject e : objects) {
			EStructuralFeature container_feature = e.eContainingFeature();
			if(getStringProperty((EObject)container_feature, "name").equals("args")){
				args.add(e);
			}
		}
		if(index < args.size())
			return args.get(index);
		else
			return null;
	}
	
	/**
	 * Takes an EMF Object and returns the type if it exists
	 *
	 * @param eObject the argument to find the type in
	 * @return the type
	 */
	public static EObject getType(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "type");
	}
	
	/**
	 * Takes an EMF EObject and returns the body if it exists
	 *
	 * @param eObject the EObject to find the body in
	 * @return the body
	 */
	public static EObject getClaimBody(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "body");
	}
	
	/**
	 * Takes an EMF EObject and returns the claim if it exists
	 *
	 * @param eObject the EObject to find the claim in
	 * @return the claim
	 */
	public static EObject getClaim(EObject eObject){
		List<EObject> objects = eObject.eContents();
		for(EObject e : objects) {
			EStructuralFeature container_feature = e.eContainingFeature();
			if(getStringProperty((EObject)container_feature, "name").equals("claim")){
				return e;
			}
		}
		return null;
	}
	
	/**
	 * Takes an EMF EObject and returns the binding if it exists
	 *
	 * @param eObject the EObject to find the binding in
	 * @return the binding
	 */
	public static EObject getBinding(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "binding");
	}
	
	/**
	 * Takes an EMF EObject and returns the val if it exists
	 *
	 * @param eObject the EObject to find the val in
	 * @return the val
	 */
	public static EObject getVal(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "val");
	}
	
	/**
	 * Takes an EMF EObject and returns the left property if it exists
	 *
	 * @param eObject the EObject to find the left property in
	 * @return the left property
	 */
	public static EObject getLeft(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "left");
	}
	
	/**
	 * Takes an EMF EObject and returns the right property if it exists
	 *
	 * @param eObject the EObject to find the right property in
	 * @return the right property
	 */
	public static EObject getRight(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "right");
	}
	
	/**
	 * Takes an EMF EObject and returns the id property if it exists
	 *
	 * @param eObject the EObject to find the id property in
	 * @return the id property
	 */
	public static EObject getID(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "id");
	}
	
	/**
	 * Takes an EMF EObject and returns the unit if it exists
	 *
	 * @param eObject the EObject to find the unit in
	 * @return the unit
	 */
	public static EObject getUnit(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "unit");
	}
	
	/**
	 * Takes an EMF EObject and returns the map if it exists
	 *
	 * @param eObject the EObject to find the map in
	 * @return the map
	 */
	public static EObject getMap(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "map");
	}
	
	/**
	 * Takes an EMF EObject and returns the cond property if it exists
	 *
	 * @param eObject the EObject to find the cond property in
	 * @return the cond property
	 */
	public static EObject getCond(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "cond");
	}
	
	/**
	 * Takes an EMF EObject and returns the then property if it exists
	 *
	 * @param eObject the EObject to find the then property in
	 * @return the then property
	 */
	public static EObject getThen(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "then");
	}
	
	/**
	 * Takes an EMF EObject and returns the else property if it exists
	 *
	 * @param eObject the EObject to find the else property in
	 * @return the else property
	 */
	public static EObject getElse(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "else");
	}
	
	/**
	 * Takes an EMF EObject and returns the else property if it exists
	 *
	 * @param eObject the EObject to find the else property in
	 * @return the else property
	 */
	public static EObject getFilter(EObject eObject){
		return getSubclassBasedOnClassName(eObject, "filter");
	}
	
	/**
	 * Takes an list of issues and returns the error with the matching message
	 *
	 * @param issues the list of issues
	 * @param message the message of the error
	 * @return the error with the matching message
	 */
	public static Issue getError(List<Issue> issues, String message) {
		for(Issue i : issues) {
			if(i.getMessage().equals(message) && i.getSeverity()==Severity.ERROR)
				return i;
		}
		return null;
	}
}
