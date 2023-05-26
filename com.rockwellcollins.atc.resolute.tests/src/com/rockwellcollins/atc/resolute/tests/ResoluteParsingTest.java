package com.rockwellcollins.atc.resolute.tests;

import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.emf.ecore.EObject;

import org.osate.testsupport.TestHelper;
import org.osate.aadl2.*;
import com.itemis.xtext.testing.FluentIssueCollection;

import com.google.inject.Inject;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ResoluteInjectorProvider.class)
public class ResoluteParsingTest {

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
		EObject sys_impl = UtilityFunctions.getSubClass(
								UtilityFunctions.getSubClass(aadl_package_impl, "PublicPackageSectionImpl"),
						   "SystemImplementationImpl");
		assertNotNull(sys_impl);
		assertTrue(UtilityFunctions.getName(sys_impl).equals("sys.impl"));
		EObject annex = UtilityFunctions.getSubClass(sys_impl, "DefaultAnnexSubclauseImpl");
		assertNotNull(annex);
		assertTrue(UtilityFunctions.getName(annex).equals("Resolute"));
		EObject parsed_annex = UtilityFunctions.getSubClass(annex, "ResoluteSubclauseImpl");
		//assertNotNull(parsed_annex);
		EObject parsed_annex2 = UtilityFunctions.getSubClass(parsed_annex, "ResoluteSubclauseImpl");
		assertNotNull(parsed_annex);
	}

}
