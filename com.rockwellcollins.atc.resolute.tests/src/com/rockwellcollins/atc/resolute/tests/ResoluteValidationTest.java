package com.rockwellcollins.atc.resolute.tests;

import com.rockwellcollins.atc.resolute.resolute.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.osate.testsupport.TestHelper;
import org.osate.aadl2.*;

import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

import com.google.inject.Inject;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ResoluteInjectorProvider.class)
public class ResoluteValidationTest extends XtextTest{
	
	@Inject TestHelper<ResolutePackage> testHelper;
	
	@Test
	public void testValidArgueStatement() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		is_system(self)\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection= testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue;\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Prove statements must contain a claim"));
	}
}

