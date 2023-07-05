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
	public void testProveStatementNoErrors() throws Exception{
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
	}
	
	@Test
	public void testProveStatementMustContainClaimError() throws Exception{
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
				+ "			argue;\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Prove statements must contain a claim"));
	}
	
	@Test
	public void testProveStatementCouldNotClaimFunctionError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Could not find claim function"));
	}
	
	@Test
	public void testIdExprNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let test : bool = true;\r\n"
				+ "			test and AnotherSimpleTest()\r\n"
				+ "			\r\n"
				+ "		AnotherSimpleTest() <=\r\n"
				+ "			** \"This is another simple test\" **\r\n"
				+ "			let another_test : bool = true;\r\n"
				+ "			another_test\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "	features\r\n"
				+ "		in_val : in data port;\r\n"
				+ "		out_val : out data port;\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection= testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testIdExprCouldNotResolveRefError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			true and AnotherSimpleTest\r\n"
				+ "			\r\n"
				+ "		AnotherSimpleTest() <=\r\n"
				+ "			** \"This is another simple test\" **\r\n"
				+ "			let another_test : bool = true;\r\n"
				+ "			another_test\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "The reference 'AnotherSimpleTest' could not be resolved."));
	}
	
	@Test
	public void testClaimContextNoErrors() throws Exception{
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
	}
	
	@Test
	public void testClaimContextDuplicateAttributeError() throws Exception{
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Context element 'test' has already been declared"));
	}
	
	@Test
	public void testClaimJustificationNoErrors() throws Exception{
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
	}
	
	@Test
	public void testClaimJustificationDuplicateAttributeError() throws Exception{
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Justification element 'test' has already been declared"));
	}
	
	@Test
	public void testClaimAssumptionNoErrors() throws Exception{
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
	}
	
	@Test
	public void testClaimAssumptionDuplicateAttributeError() throws Exception{
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Assumption element 'test' has already been declared"));
	}
	
	@Test
	public void testClaimStrategyNoErrors() throws Exception{
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
	}
	
	@Test
	public void testClaimStrategyDuplicateAttributeError() throws Exception{
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Strategy element 'test' has already been declared"));
	}
	
	@Test
	public void testThisExprNoErrors() throws Exception{
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
	}
	
	@Test
	public void testThisExprOnlyUsedInSubclauseError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "A 'this' expression can only be used in a " +
								"resolute subclause (inside of a component or component implementation)"));
	}
	
	@Test
	public void testThisExprNotSubcomponentConnectionFeatureError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "ID 'null' is not a subcomponent, connection or feature"));
	}
	
	@Test
	public void testIfThenElseExprNoErrors() throws Exception{
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
	}
	
	@Test
	public void testIfThenElseExprExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type bool but found type string"));
	}
	
	@Test
	public void testIfThenElseExprInconsistentBranchTypesError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Inconsistent branch types string, bool"));
	}
	
	@Test
	public void testUnaryExprNoErrors() throws Exception{
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
	}
	
	@Test
	public void testUnaryExprNotTypeError() throws Exception {
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Operator 'not' not defined on type int"));
	}
	
	@Test
	public void testUnaryExprHyphenTypeError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Operator '-' not defined on type bool"));
	}
	
	@Test
	public void testUndevelopedExprNoErrors() throws Exception {
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
	}
	
	@Test
	public void testUndevelopedExprCanOnlyBeDefinedInsideClaimOrStrategyError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Undeveloped element can only be defined inside a Claim or a Strategy"));
	}
	
	@Test
	public void testSolutionExprNoErrors() throws Exception{
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
	}
	
	@Test
	public void testSolutionExprCanOnlyBeDefinedInsideClaimError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Solution element can only be defined inside a Claim"));
	}
	
	@Test
	public void testConstDefNoErrors() throws Exception {
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
	}
	
	@Test
	public void testConstDefExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Definition expects type bool but has type int"));
	}
	
	@Test
	public void testFuncDefNoErrors() throws Exception{
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
	}
	
	@Test
	public void testFuncDefCanOnlyBeDeclairedForClaimsError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Keyword strategy can only be declared for claims"));
	}
	
	@Test
	public void testFuncDefExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Function expects type bool but has type int"));
	}
	
	@Test
	public void testFuncDefMustHaveTypeBoolError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Claim must have type bool, but has type int"));
	}
	
	@Test
	public void testFuncDefStrategyCannotContainStrategyAttributeError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "A strategy cannot contain a strategy attribute"));
		
	}
	
	@Test
	public void testFuncDefInvalidStrategyExprError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Invalid strategy expression"));
	}
	
	@Test
	public void testFuncDefCanOnlyBeDeclaredOnceError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Strategy claim attribute can only be declared once inside a claim"));
	}
	
	@Test
	public void testFuncDefInlineStrategyCanOnlyBeUsedWithGoalClaimError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "An inline startegy can only be used with a goal claim call expression"));
	}
	
	@Test
	public void testQuantifiedExprNoErrors() throws Exception{
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
	}
	
	@Test
	public void testQuantifiedExprExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type bool but found type string"));
	}
	
	@Test
	public void testQuantifiedExprArgumentTypeError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues,  "Arguments to quantifier is of type 'component' but must be of a set type"));
	}
	
	@Test
	public void testQuantifiedExprCanOnlyQualifyOverAADLError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues,  "Can only quantify over AADL types"));
	}
	
	@Test
	public void testLetExprNoErrors() throws Exception{
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
	}
	
	@Test
	public void testLetExprTypeMismatchError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "types mismatch in let expression for variable 'test'. "
				+ "The binding is of type 'bool' but the expression is of type 'int'"));
	}
	
	@Test
	public void testLetExprNeverUsedWarning() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getWarning(issues, "Let expression is never used"));
	}
	
	@Test
	public void testBinExprCallNoErrors() throws Exception{
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
	}
	
	@Test
	public void testBinExprCallOperatorType1Error() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Operator 'and' not defined on types int, int"));

	}
	
	@Test
	public void testBinExprCallOperatorType2Error() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Operator '*' not defined on types bool, bool"));
	}
	
	@Test
	public void testBinExprCallOperatorType3Error() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Operator '=' not defined on types int, real"));
	}
	
	@Test
	public void testFnCallExprNoErrors() throws Exception{
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
	}
	
	@Test
	public void testFnCallExprClaimCannotAppearInThisContextError() throws Exception{
		
	}
	
	@Test
	public void testFnCallExprArgumentNumError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Function expects 0 arguments but found 1 arguments"));
	}
	
	@Test
	public void testFnCallExprExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type bool but found type int"));
	}
	
	@Test
	public void testLibraryFnCallExprNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
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
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testLibraryFnCallExprCouldNotFindLibraryError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
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
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Could not find external library 'StringLibrary'"));
	}
	
	@Test
	public void testLibraryFnCallExprFunctionNotFoundInLibraryError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
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
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "External function 'add()' not found in library 'StringLib'."));
	}
	
	@Test
	public void testLibraryFnCallExprArgumentNumError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
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
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "External library function 'StringLib.concat()' "
														+ "expects 2 arguments but found 3 arguments"));
	}
	
	@Test
	public void testLibraryFnCallExprExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest() <=\r\n"
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
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "	\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type string but found type int"));
	}
	
	@Test
	public void testBuiltInFnAnalysisCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			analysis(\"schedule\")\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnAnalysisCallExpectsOneArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			analysis()\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Function 'analysis' expects at least one argument"));
	}
	
	@Test
	public void testBuiltInFnAnalysisCallFirstArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			analysis(true)\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "The first argument of 'analysis' must be a literal string"));
	}
	
	@Test
	public void testBuiltInFnAnalysisCallCouldNotFindExternalAnalysisError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			analysis(\"concat\", \"Hel\", \"lo\")\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Could not find external analysis 'concat'"));
	}
	
	@Test
	public void testBuiltInFnAnalysisCallArgumentNumError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			analysis(\"schedule\", 1)\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "External analysis 'schedule' expects "
												+ "0 additional arguments but found 1 additional arguments"));
	}
	
	@Test
	public void testBuiltInFnAnalysisCallExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			analysis(\"ngrep\", \"test\", \"file\", true)\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type int but found type bool"));
	}
	
	@Test
	public void testBuiltInFnMemberCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			member(2, [1,2,3])\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());		
	}
	
	@Test
	public void testBuiltInFnMemberCallExpectsTwoArgumentsError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			member(2)\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'member' expects two arguments"));
	}
	
	@Test
	public void testBuiltInFnMemberCallExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			member(1, 1)\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected list or set type but found type int"));
	}
	
	@Test
	public void testBuiltInFnMemberCallFunctionMemberNotDefinedOnTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			member(1, ['a', 'b', 'c'])\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'member' not defined on arguments of type int, string"));
	}
	
	@Test
	public void testBuiltInFnLengthCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_size : int = length([1,2,3]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());	
	}
	
	@Test
	public void testBuiltInFnLengthCallExpectsOneArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_size : int = size([1,2,3],[4,5,6]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'size' expects one argument"));
	}
	
	@Test
	public void testBuiltInFnLengthCallExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_size : int = length(1);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected list or set type but found type int"));
	}
	
	@Test
	public void testBuiltInFnSumCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_sum : int = sum([1,2,3]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnSumCallExpectsOneArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_sum : int = sum();\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'sum' expects one argument"));
	}
	
	@Test
	public void testBuiltInFnSumCallNotDefinedOnTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_sum : bool = sum([true, false]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'sum' not defined on type [bool]"));
	}
	
	@Test
	public void testBuiltInFnMinCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_min : int = min([1,2,3]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnMinCallExpectsOneArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_min : int = min();\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'min' expects one argument"));
	}
	
	@Test
	public void testBuiltInFnMinCallNotDefinedOnTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_min : string = min(['a','b','c']);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'min' not defined on type [string]"));
	}
	
	@Test
	public void testBuiltInFnMaxCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_max : int = max([1,2,3]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnMaxCallExpectsOneArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_max : int = max();\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'max' expects one argument"));
	}
	
	@Test
	public void testBuiltInFnMaxCallNotDefinedOnTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_max : string = max(['a','b','c']);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'max' not defined on type [string]"));
	}
	
	@Test
	public void testBuiltInFnAppendCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_append : [string] = append([\"H\",\"e\",\"l\"],[\"l\",\"o\"]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnAppendCallExpectsTwoArgumentsError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_append : [string] = append([\"H\",\"e\",\"l\"]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'append' expects two arguments"));
	}
	
	@Test
	public void testBuiltInFnAppendCallFirstArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_append : [string] = append(\"Hel\",[\"l\",\"o\"]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "first argument to function 'append' must be a list"));
	}
	
	@Test
	public void testBuiltInFnAppendCallSecondArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_append : [string] = append([\"H\",\"e\",\"l\"],\"lo\");\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "second argument to function 'append' must be a list"));
	}
	
	@Test
	public void testBuiltInFnAppendCallNotDefinedOnTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_append : [string] = append([\"H\",\"e\",\"l\",\"l\",\"o\"],[1,2,3]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'append' not defined on types [string] and [int]"));
	}
	
	@Test
	public void testBuiltInFnHeadCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			head([true,false,true])\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnHeadCallExpectsOneArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			head()\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'head' expects one argument"));
	}
	
	@Test
	public void testBuiltInFnHeadCallArgumentMustBeListError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			head(123)\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "argument to function 'head' must be a list"));
	}
	
	@Test
	public void testBuiltInFnTailCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_tail : [bool] = tail([true,false,true]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnTailCallExpectsOneArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_tail : [bool] = tail();\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'tail' expects one argument"));
	}
	
	@Test
	public void testBuiltInFnTailCallArgumentMustBeListError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let list_tail : [int] = tail(123);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "argument to function 'tail' must be a list"));
	}
	
	@Test
	public void testBuiltInFnAsSetCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : {int} = as_set([1,2,3]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnAsSetCallExpectsOneArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : {int} = as_set();\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'as_set' expects one argument"));
	}
	
	@Test
	public void testBuiltInFnAsSetCallArgumentMustBeListError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : {int} = as_set(123);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "argument to function 'as_set' must be a list"));
	}
	
	@Test
	public void testBuiltInFnBinarySetOpCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : {int} = union({1,2,3},{4,5,6});\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnBinarySetOpCallExpectsTwoArgumentsError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : {int} = intersect({1,2,3});\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'intersect' expects two arguments"));
	}
	
	@Test
	public void testBuiltInFnBinarySetOpCallExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : [int] = union([1,2,3], [4,5,6]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected set type but found type [int]"));
	}
	
	@Test
	public void testBuiltInFnBinarySetOpCallNoDefinedOnTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : {int} = intersect({1,2,3}, {4.0,5.0,6.0});\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'intersect' not defined on arguments of type {int}, {real}"));
	}
	
	@Test
	public void testBuiltInFnAsListCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : [int] = as_list({1,2,3});\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnAsListCallExpectsOneArgumentError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : [int] = as_list();\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "function 'as_list' expects one argument"));
	}
	
	@Test
	public void testBuiltInFnAsListArgumentMustBeSetError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : [int] = as_list([1,2,3]);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "argument to function 'as_list' must be a set"));
	}
	
	@Test
	public void testBuiltInFnPropertyCallNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	with SEI;\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : real = property(self, SEI::Price, 20.0);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	properties\r\n"
				+ "		SEI::Price => 10.0;\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnPropertyCallExpectedPropertyConstantRefError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	with SEI;\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : real = property(self);\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	properties\r\n"
				+ "		SEI::Price => 10.0;\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Only parameter expected to be a property constant reference."));
	}
	
	@Test
	public void testBuiltInFnPropertyCallArgumentMismatchError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	with SEI;\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let x : string = property(self, SEI::Price, \"$10.00\");\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	properties\r\n"
				+ "		SEI::Price => 10.0;\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "The second argument is of type 'property<real>' and the third argument is of type 'string'"));
	}
	
	@Test
	public void testBuiltInFnCallExprNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			is_system(self)\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testBuiltInFnCallExprArgumentNumError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			is_system()\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Function expects 1 argument but found 0 arguments"));
	}
	
	@Test
	public void testBuiltInCallExprExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			is_system(1)\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type aadl but found type int"));
	}
	
	@Test
	public void testListFilterMapExprNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let test : [component] = [sub for (sub : subcomponents(self)) | is_system(sub)];\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
		
	@Test
	public void testListFilterMapExprExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let test : [component] = [sub for (sub : subcomponents(self)) | instances(sub)];\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type bool but found type {component}"));
	}
	
	@Test
	public void testSetFilterMapExprNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let test : {component} = {sub for (sub : subcomponents(self)) | is_processor(sub)};\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
		
	@Test
	public void testSetFilterMapExprExpectedTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let test : {component} = {sub for (sub : subcomponents(self)) | subcomponents(sub)};\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Expected type bool but found type {component}"));
	}
	
	@Test
	public void testListNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let test : [component] = [self, self];\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testListExprUnableToAddTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let test : [component] = [self, 1];\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Unable to add type int to list of type [component]"));	
	}
	
	@Test
	public void testSetNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let test : {component} = {self, self};\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testSetExprUnableToAddTypeError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest(self : component) <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "			let test : {bool} = {true, self};\r\n"
				+ "			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest(this)\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Unable to add type component to set of type {bool}"));	
	}
	
	@Test
	public void testInstanceOfExprNoErrors() throws Exception{
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
	}
	
	
	@Test
	public void testInstanceOfExprCannotCompareError() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Cannot compare from component to bool"));
	}
	
	@Test
	public void testCastExprNoErrors() throws Exception{
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
	}
	
	@Test
	public void testCastExpr() throws Exception{
		String test = "package TestPackage\r\n"
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
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Cannot cast from int to bool"));
	}
	
	@Test
	public void testLibraryFnTypeNoErrors() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "  			let s : ShellCmd.shell_return_type = ShellCmd.exec(\"cmd.exe\");\r\n"
				+ "  			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		assertTrue(issueCollection.getIssues().isEmpty());
	}
	
	@Test
	public void testLibraryFnTypeCouldNotFindExternalLibraryError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "  			let s : shellcmd.shell_return_type = ShellCmd.exec(\"cmd.exe\");\r\n"
				+ "  			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "Could not find external library 'shellcmd'"));
	}
	
	@Test
	public void testLibraryFnTypeNotDefinedError() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "		SimpleTest() <=\r\n"
				+ "			** \"This is a simple unit test\" **\r\n"
				+ "  			let s : ShellCmd.return_type = ShellCmd.exec(\"cmd.exe\");\r\n"
				+ "  			true\r\n"
				+ "	**};\r\n"
				+ "\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "			argue SimpleTest()\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection = testHelper.testString(test);
		List<Issue> issues = issueCollection.getIssues();
		assertFalse(issues.isEmpty());
		assertNotNull(UtilityFunctions.getError(issues, "User-defined type 'return_type' not defined in ShellCmd"));		
	}
}

