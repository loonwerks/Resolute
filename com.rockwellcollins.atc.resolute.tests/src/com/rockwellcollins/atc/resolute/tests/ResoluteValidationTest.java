package com.rockwellcollins.atc.resolute.tests;

import com.rockwellcollins.atc.resolute.resolute.*;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.osate.testsupport.TestHelper;

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
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection= testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
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
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
			issueCollection = testHelper.testString(test);
			issues = issueCollection.getIssues();
			assertFalse(issues.isEmpty());
			assertNotNull(UtilityFunctions.getError(issues, "Could not find claim function"));
	}
	
	@Test
	public void testIdExpr() throws Exception{
		
	}
	
	@Test
	public void testClaimContext() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		context test : true;\r\n"
				+ "		true\r\n"
				+ "		\r\n"
				+ "	AnotherSimpleTest() <=\r\n"
				+ "		** \"This is another simple unit test\" ** \r\n"
				+ "		context another_test : false;\r\n"
				+ "		true\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "			argue AnotherSimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection= testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		context test : true;\r\n"
				+ "		true\r\n"
				+ "		\r\n"
				+ "	AnotherSimpleTest() <=\r\n"
				+ "		** \"This is another simple unit test\" ** \r\n"
				+ "		context test : false;\r\n"
				+ "		true\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "			argue AnotherSimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Context element 'test' has already been declared"));
	}
	
	@Test
	public void testClaimJustification() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		justification test : \"SimpleTest\";\r\n"
				+ "		true\r\n"
				+ "	\r\n"
				+ "	AnotherSimpleTest() <=\r\n"
				+ "		** \"This is another simple unit test\" **\r\n"
				+ "		justification another_test: \"AnotherSimpleTest\";\r\n"
				+ "		true\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "			argue AnotherSimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection= testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		justification test : \"SimpleTest\";\r\n"
				+ "		true\r\n"
				+ "	\r\n"
				+ "	AnotherSimpleTest() <=\r\n"
				+ "		** \"This is another simple unit test\" **\r\n"
				+ "		justification test: \"AnotherSimpleTest\";\r\n"
				+ "		true\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "			argue AnotherSimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Justification element 'test' has already been declared"));
	}
	
	@Test
	public void testClaimAssumption() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		assumption test : true;\r\n"
				+ "		true\r\n"
				+ "	\r\n"
				+ "	AnotherSimpleTest() <=\r\n"
				+ "		** \"This is another simple unit test\" **\r\n"
				+ "		assumption another_test: false;\r\n"
				+ "		true\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "			argue AnotherSimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection= testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		assumption test : true;\r\n"
				+ "		true\r\n"
				+ "	\r\n"
				+ "	AnotherSimpleTest() <=\r\n"
				+ "		** \"This is another simple unit test\" **\r\n"
				+ "		assumption test: false;\r\n"
				+ "		true\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "			argue AnotherSimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Assumption element 'test' has already been declared"));
	}
	
	@Test
	public void testClaimStrategy() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		strategy test : \"SimpleTest\";\r\n"
				+ "		true\r\n"
				+ "		\r\n"
				+ "	AnotherSimpleTest() <=\r\n"
				+ "		** \"This is another simple unit test\" ** \r\n"
				+ "		strategy another_test : \"AnotherSimpleTest\";\r\n"
				+ "		true\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "			argue AnotherSimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection= testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		strategy test : \"SimpleTest\";\r\n"
				+ "		true\r\n"
				+ "		\r\n"
				+ "	AnotherSimpleTest() <=\r\n"
				+ "		** \"This is another simple unit test\" ** \r\n"
				+ "		strategy test : \"AnotherSimpleTest\";\r\n"
				+ "		true\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "			argue AnotherSimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Strategy element 'test' has already been declared"));
	}
	
	@Test
	public void testThisExpr() throws Exception{
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
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		is_system(this)\r\n"
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
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "A 'this' expression can only be used in a " +
								"resolute subclause (inside of a component or component implementation)"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	with Test_Properties;\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : system) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	prototypes\r\n"
				+ "		test : data;\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this.nothing)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "ID 'null' is not a subcomponent, connection or feature"));
	}
	
	@Test
	public void testIfThenElseExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "	if true then\r\n"
				+ "		false\r\n"
				+ "	else\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "	if \"Simple\" then\r\n"
				+ "		false\r\n"
				+ "	else\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type bool but found type string"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "	if true then\r\n"
				+ "		\"Hello\"\r\n"
				+ "	else\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Inconsistent branch types string, bool"));
	}
	
	@Test
	public void testUnaryExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		let test1 : int = -5;\r\n"
				+ "		let test2 : bool = not(true);\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		let test : int = not(1);\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Operator 'not' not defined on type int"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		let test : bool = -(true);\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Operator '-' not defined on type bool"));
	}
	
	@Test
	public void testUndevelopedExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		undeveloped\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		let temp : int = undeveloped;\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Undeveloped element can only be defined inside a Claim or a Strategy"));
	}
	
	@Test
	public void testSolutionExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		solution temp : \"Test\"\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		SimpleFn()\r\n"
				+ "		\r\n"
				+ "	SimpleFn() : bool = \r\n"
				+ "		solution temp: \"Test\"\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Solution element can only be defined inside a Claim"));
	}
	
	@Test
	public void testConstDef() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	test : bool = true\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	test : bool = 1\r\n"
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
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Definition expects type bool but has type int"));
	}
	
	@Test
	public void testFuncDef() throws Exception{
		String test ="package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		true\r\n"
				+ "		\r\n"
				+ "	SimpleFn() : bool = true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		true\r\n"
				+ "		\r\n"
				+ "	strategy SimpleFn() : bool = true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Keyword strategy can only be declared for claims"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		true\r\n"
				+ "		\r\n"
				+ "	SimpleFn() : bool = 1\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Function expects type bool but has type int"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		SimpleFn()\r\n"
				+ "		\r\n"
				+ "	SimpleFn() : int = 1\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Claim must have type bool, but has type int"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	strategy SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		strategy test_strategy : \"Simple Test\";\r\n"
				+ "		SimpleFn()\r\n"
				+ "		\r\n"
				+ "	SimpleFn() : bool = true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "A strategy cannot contain a strategy attribute"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	strategy SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		SimpleFn()\r\n"
				+ "		\r\n"
				+ "	SimpleFn() : bool = true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Invalid strategy expression"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		strategy test_strategy : \"Simple Test\";\r\n"
				+ "		strategy another_strategy : \"Simple Test\";\r\n"
				+ "		SimpleFn()\r\n"
				+ "		\r\n"
				+ "	SimpleFn() : bool = true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Strategy claim attribute can only be declared once inside a claim"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	goal SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		strategy test_strategy : \"Simple Test\";\r\n"
				+ "		SimpleFn()\r\n"
				+ "		\r\n"
				+ "	SimpleFn() : bool = true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "An inline startegy can only be used with a goal claim call expression"));
	}
	
	@Test
	public void testQuantArg() throws Exception{
		
	}
	
	@Test
	public void testQuantifiedExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		forall (sub : subcomponents(self)). true\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		forall (sub : subcomponents(self)). \"Hello\"\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type bool but found type string"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		forall (sub : self). true\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues,  "Arguments to quantifier is of type 'component' but must be of a set type"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		forall (sub : {component}). true\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues,  "Can only quantify over AADL types"));
	}
	
	@Test
	public void testLetExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		let test : bool = true;\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		let test : bool = 1;\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "types mismatch in let expression for variable 'test'. "
				+ "The binding is of type 'bool' but the expression is of type 'int'"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		let test : bool = true;\r\n"
				+ "		undeveloped\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getWarning(issues, "Let expression is never used"));
	}
	
	@Test
	public void testBinExprCall() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		1 = 1\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		1 and 1\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Operator 'and' not defined on types int, int"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		true * true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Operator '*' not defined on types bool, bool"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		1 = 1.0\r\n"
				+ "**};\r\n"
				+ "	\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Operator '=' not defined on types int, real"));
	}
	
	@Test
	public void testFnCallExpr() throws Exception{
		String test ="package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		SimpleFn()\r\n"
				+ "		\r\n"
				+ "	SimpleFn() : bool = true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		SimpleFn(1)\r\n"
				+ "		\r\n"
				+ "	SimpleFn() : bool = true\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Function expects 0 arguments but found 1 arguments"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		SimpleFn(1)\r\n"
				+ "		\r\n"
				+ "	SimpleFn(b : bool) : bool = b\r\n"
				+ "**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type bool but found type int"));
	}
	
	@Test
	public void testLibraryFnCallExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		let s : string = StringLib.concat(\"hel\", \"lo\");\r\n"
				+ "		s = \"Hello\"\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		let s : string = StringLibrary.concat(\"hel\", \"lo\");\r\n"
				+ "		s = \"Hello\"\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Could not find external library 'StringLibrary'"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		let s : string = StringLib.add(\"hel\", \"lo\");\r\n"
				+ "		s = \"Hello\"\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "External function 'add()' not found in library 'StringLib'."));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		let s : string = StringLib.concat(\"he\", \"ll\", \"o\");\r\n"
				+ "		s = \"Hello\"\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "External library function 'StringLib.concat()' "
														+ "expects 2 arguments but found 3 arguments"));
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		let s : string = StringLib.concat(\"hello\", 2);\r\n"
				+ "		s = \"Hello\"\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type string but found type int"));
	}
	
	@Test
	public void testBuiltInFnCallExpr() throws Exception{
		
		//analysis()
		String test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "     		\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "           analysis(SimpleTest, self):component\r\n"
				+ "             true\r\n"
				+ "             \r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    \r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "The first argument of 'analysis' must be a literal string"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "     		\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"         
				+ "             --let addition : int = sum(list1);\r\n"
				+ "           analysis():component\r\n"
				+ "             true\r\n"
				+ "             \r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    \r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Function 'analysis' expects at least one argument"));
		
		//ToDo - test for error message "Could not find external analysis \"SimpleTest\"" 
		
		//member()
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "       \r\n"
				+ "             member(2, [1,2,3])\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "       \r\n"
				+ "             member()\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'member' expects two arguments"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "       \r\n"
				+ "       		let x : int = 1;\r\n"
				+ "             member(1, x)\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected list or set type but found type int"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "       \r\n"
				+ "       		\r\n"
				+ "             member(1, ['a'])\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'member' not defined on arguments of type int, string"));
		
		//length()/size()
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "             let list_size : int = length([1,2,3]);\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		//"Expected list or set type but found type " - the function accepts any argument
		
		//sum()
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ " \r\n"
				+ "             let list : [int] = [1,2,3];\r\n"
				+ "             let addition : int = sum(list);\r\n"
				+ "             \r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ " \r\n"
				+ "             let list : [int] = [1,2,3];\r\n"
				+ "             let addition : int = sum();\r\n"
				+ "             \r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'sum' expects one argument"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "             let list_size : int = sum({});\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'sum' not defined on type {}"));
		
		
		//min()
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ " \r\n"
				+ "             let minimum : int = min([1,2]);\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ " \r\n"
				+ "             let minimum : int = min();\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'min' expects one argument"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ " \r\n"
				+ "             let minimum : int = min({});\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'min' not defined on type {}"));
		
		//max()
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ " \r\n"
				+ "             let maximum : int = max([1,2]);\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ " \r\n"
				+ "             let maximum : int = max();\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'max' expects one argument"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ " \r\n"
				+ "             let maximum : int = max({});\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'max' not defined on type {}"));
		
		//append()
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "             let maximum : [int] = append([1,2,3],[234]);\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "             let maximum : [int] = append([1,2,3]);\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'append' expects two arguments"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "             let maximum : [int] = append({},[1,2,3]);\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "first argument to function 'append' must be a list"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "             let maximum : [int] = append([1,2,4], self);\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "second argument to function 'append' must be a list"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "             let maximum : [int] = append([], {});\r\n"
				+ "             true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'append' not defined on types [] and {}"));
		
		//head()
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :int =  head([1,2,3]);\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :int =  head();\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'head' expects one argument"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :int =  head(1+1);\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "argument to function 'head' must be a list"));
		
		//tail()
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :[int] =  tail([1,2,3]);\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :[int] =  tail();\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'tail' expects one argument"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :[int] =  tail(1+1);\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "argument to function 'tail' must be a list"));
		
		//as_set()
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  as_set([1,2,3]);\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  as_set();\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'as_set' expects one argument"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  as_set(1);\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";	
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "argument to function 'as_set' must be a list"));
		
		// union()
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  union({1,2,3},{1,2,3});\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";	
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  union();\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";	
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'union' expects two arguments"));
		
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  union([],[]);\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected set type but found type []"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  union({1,2,3,4},{false});\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'union' not defined on arguments of type {int}, {bool}"));
		
		
		// intersect()
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  intersect({1,2,3,4},{1,2,3});\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  intersect();\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";	
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'intersect' expects two arguments"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  intersect([],[]);\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected set type but found type []"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :{int} =  intersect({1,2,3,4},{false});\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";	
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'intersect' not defined on arguments of type {int}, {bool}"));
		
		// as_list()
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :[int] =  as_list({1,2,3});\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :[int] =  as_list();\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'as_list' expects one argument"));
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "   \r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ "           let x :[int] =  as_list(2);\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "argument to function 'as_list' must be a set"));
		
		
		// property() ToDo - test for a model with no validation errors
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ " \r\n"
				+ "           let ref :int = 2; \r\n"
				+ "           let x :int = property(self, ref:int);\r\n"
				+ "           true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl    		\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";	
		issueCollection = testHelper.testString(test);
		issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Only parameter expected to be a property constant reference."));
		
		// ToDo - test for error message: "The second argument is of type '" + type1 + "' and the third argument is of type '" + type2 + "'"
		
		// debug()
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "            \r\n"
				+ " \r\n"
				+ "           debug(true)\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl    		\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
		
	@Test
	public void testListFilterMapExpr() throws Exception{
		
		String test = "package Test\r\n"
				+ "public\r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "           \r\n"
				+ "           let x: [bool] = [true,false];\r\n"
				+ "    		true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl    		\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		// ToDo - test for error message - "Expected type bool but found type " + validType
	}
	
	@Test
	public void testSetFilterMapExpr() throws Exception{
		
		String test = "package Test\r\n"
				+ "public\r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "           \r\n"
				+ "           let x: {bool} = {true};\r\n"
				+ "    	    true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl    		\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		// ToDo - test for error message - "Expected type bool but found type " + validType
	}
	
	@Test
	public void testListExpr() throws Exception{
		String test = "package Test\r\n"
				+ "public\r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "           \r\n"
				+ "           let x: [bool] = [true];\r\n"
				+ "    	    true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl    		\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "           \r\n"
				+ "           let x: [bool] = [true,1];\r\n"
				+ "    	    true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl    		\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Unable to add type int to list of type [bool]"));	
	}
	
	@Test
	public void testSetExpr() throws Exception{
		
		String test = "package Test\r\n"
				+ "public\r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "           \r\n"
				+ "           let x: {bool} = {true};\r\n"
				+ "    	    true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl    		\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";		
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		
		test = "package Test\r\n"
				+ "public\r\n"
				+ "     annex Resolute{**\r\n"
				+ "          goal SimpleTest(self : component) <=\r\n"
				+ "            ** \"This is a simple unit test\" **\r\n"
				+ "           \r\n"
				+ "           let x: {bool} = {true,1};\r\n"
				+ "    	    true\r\n"
				+ "          **};\r\n"
				+ "            \r\n"
				+ "      system sys\r\n"
				+ "      end sys;\r\n"
				+ "           \r\n"
				+ "      system implementation sys.impl    		\r\n"
				+ "      annex Resolute{**\r\n"
				+ "                prove SimpleTest(this)\r\n"
				+ "    			\r\n"
				+ "              **};\r\n"
				+ "      end sys.impl;\r\n"
				+ "      \r\n"
				+ "end Test;";	
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Unable to add type int to set of type {bool}"));
	}
	
	@Test
	public void testInstanceOfExpr() throws Exception{
		String test ="package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		self instanceof System\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		self instanceof bool\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Cannot compare from component to bool"));
	}
	
	@Test
	public void testCastExpr() throws Exception{
		String test ="package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		let temp : int = 1;\r\n"
				+ "		let test : real = (real)temp;\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
		test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" ** \r\n"
				+ "		let temp : int = 1;\r\n"
				+ "		let test : bool = (bool)temp;\r\n"
				+ "		true\r\n"
				+ "**};\r\n"
				+ "\r\n"
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
		issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Cannot cast from int to bool"));
	}
	
	@Test
	public void testLibraryFnType() throws Exception{
		
	}
}

