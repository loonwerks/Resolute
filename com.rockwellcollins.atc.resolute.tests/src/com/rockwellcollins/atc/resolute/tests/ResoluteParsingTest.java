package com.rockwellcollins.atc.resolute.tests;

import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;

import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.emf.ecore.EObject;

import org.osate.testsupport.TestHelper;
import org.osate.aadl2.*;

import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

import com.google.inject.Inject;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ResoluteInjectorProvider.class)
public class ResoluteParsingTest extends XtextTest{

	@Inject
	TestHelper<AadlPackage> testHelper;
	
	@Test
	public void testAnnexSubclause() throws Exception{
		String assurance_case = "package TestPackage\r\n"
				+ "public\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection= testHelper.testString(assurance_case);
		assertNotNull(issueCollection);
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		assertNotNull(aadl_package_impl);
		assertTrue(aadl_package_impl.getClass().toString().contains("AadlPackageImpl"));
		assertTrue(UtilityFunctions.getName(aadl_package_impl).equals("TestPackage"));
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		assertNotNull(pub_sec);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		assertNotNull(owned_classifiers);
		EObject annex = UtilityFunctions.getAnnex(owned_classifiers, "Resolute");
		assertNotNull(annex);
		EObject parsed_annex = UtilityFunctions.getParsedAnnex(annex);
		assertNotNull(parsed_annex);
		assertTrue(parsed_annex instanceof ResoluteSubclause);
	}

}
