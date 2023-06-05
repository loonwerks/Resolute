package com.rockwellcollins.atc.resolute.tests;

import com.rockwellcollins.atc.resolute.resolute.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;

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
	TestHelper<ResolutePackage> testHelper;
	
	@Test
	public void testAnnexLibrary() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	annex Resolute{**\r\n"
				+ "	**};\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection= testHelper.testString(test);
		assertNotNull(issueCollection);
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		assertNotNull(aadl_package_impl);
		assertTrue(aadl_package_impl.getClass().toString().contains("AadlPackageImpl"));
		assertTrue(UtilityFunctions.getStringProperty(aadl_package_impl, "name").equals("TestPackage"));
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		assertNotNull(pub_sec);
		EObject annex_lib = UtilityFunctions.getAnnexLibrary(pub_sec, "Resolute");
		assertNotNull(annex_lib);
		EObject parsed_annex_lib = UtilityFunctions.getParsedAnnexLibrary(annex_lib);
		assertNotNull(parsed_annex_lib);
		assertTrue(parsed_annex_lib instanceof ResoluteLibrary);
	}
	
	@Test
	public void testAnnexSubclause() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "system sys\r\n"
				+ "end sys;\r\n"
				+ "system implementation sys.impl\r\n"
				+ "	annex Resolute{**\r\n"
				+ "	**};\r\n"
				+ "end sys.impl;\r\n"
				+ "end TestPackage;";
		FluentIssueCollection issueCollection= testHelper.testString(test);
		assertNotNull(issueCollection);
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		assertNotNull(aadl_package_impl);
		assertTrue(aadl_package_impl.getClass().toString().contains("AadlPackageImpl"));
		assertTrue(UtilityFunctions.getStringProperty(aadl_package_impl, "name").equals("TestPackage"));
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		assertNotNull(pub_sec);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		assertNotNull(owned_classifiers);
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		assertNotNull(annex_subclause);
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		assertNotNull(parsed_annex_subclause);
		assertTrue(parsed_annex_subclause instanceof ResoluteSubclause);
	}
	
	@Test
	public void testClaimSubclauseArgsAndBody() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		true\r\n"
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
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		EObject analysis = UtilityFunctions.getAnalysis(parsed_annex_subclause, "argue SimpleTest(this)");
		assertNotNull(analysis);
		assertTrue(analysis instanceof ArgueStatement);
		EObject expr = UtilityFunctions.getExpr(analysis);
		assertNotNull(expr);
		assertTrue(expr instanceof FnCallExpr);
		EObject fn = UtilityFunctions.getFn(expr);
		assertNotNull(fn);
		assertTrue(fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(fn, "name").equals("SimpleTest"));
		EObject arg = UtilityFunctions.getArg(fn, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("self"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(fn);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		assertTrue(UtilityFunctions.getExpr(body) instanceof BoolExpr);
		EObject claim = UtilityFunctions.getClaim(body);
		assertNotNull(claim);
		assertTrue(claim instanceof ClaimString);
		assertTrue(UtilityFunctions.getStringProperty(claim, "str").equals("This is a simple unit test"));
	}
	
	@Test
	public void testImpliesExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		false => true\r\n"
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
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		EObject fn = UtilityFunctions.getFn(parsed_annex_subclause, "argue SimpleTest(this)");
		EObject body = UtilityFunctions.getClaimBody(fn);
		assertNotNull(body);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "op").equals("=>"));
		EObject left = UtilityFunctions.getLeft(expr);
		assertNotNull(left);
		assertTrue(left instanceof BoolExpr);
		EObject val_left = UtilityFunctions.getVal(left);
		assertNotNull(val_left);
		assertTrue(val_left instanceof BooleanLiteral);
		assertFalse(Boolean.parseBoolean(UtilityFunctions.getStringProperty(val_left, "value")));
		EObject right = UtilityFunctions.getRight(expr);
		assertNotNull(right);
		assertTrue(right instanceof BoolExpr);
		EObject val_right = UtilityFunctions.getVal(right);
		assertNotNull(val_right);
		assertTrue(val_right instanceof BooleanLiteral);
		assertTrue(Boolean.parseBoolean(UtilityFunctions.getStringProperty(val_right, "value")));
	}
	
	@Test
	public void testOrExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		true or false\r\n"
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
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		EObject fn = UtilityFunctions.getFn(parsed_annex_subclause, "argue SimpleTest(this)");
		EObject body = UtilityFunctions.getClaimBody(fn);
		assertNotNull(body);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "op").equals("or"));
		EObject left = UtilityFunctions.getLeft(expr);
		assertNotNull(left);
		assertTrue(left instanceof BoolExpr);
		EObject val_left = UtilityFunctions.getVal(left);
		assertNotNull(val_left);
		assertTrue(val_left instanceof BooleanLiteral);
		assertTrue(Boolean.parseBoolean(UtilityFunctions.getStringProperty(val_left, "value")));
		EObject right = UtilityFunctions.getRight(expr);
		assertNotNull(right);
		assertTrue(right instanceof BoolExpr);
		EObject val_right = UtilityFunctions.getVal(right);
		assertNotNull(val_right);
		assertTrue(val_right instanceof BooleanLiteral);
		assertFalse(Boolean.parseBoolean(UtilityFunctions.getStringProperty(val_right, "value")));
	}
	
	@Test
	public void testAndExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		true and true\r\n"
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
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		EObject fn = UtilityFunctions.getFn(parsed_annex_subclause, "argue SimpleTest(this)");
		EObject body = UtilityFunctions.getClaimBody(fn);
		assertNotNull(body);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "op").equals("and"));
		EObject left = UtilityFunctions.getLeft(expr);
		assertNotNull(left);
		assertTrue(left instanceof BoolExpr);
		EObject val_left = UtilityFunctions.getVal(left);
		assertNotNull(val_left);
		assertTrue(val_left instanceof BooleanLiteral);
		assertTrue(Boolean.parseBoolean(UtilityFunctions.getStringProperty(val_left, "value")));
		EObject right = UtilityFunctions.getRight(expr);
		assertNotNull(right);
		assertTrue(right instanceof BoolExpr);
		EObject val_right = UtilityFunctions.getVal(right);
		assertNotNull(val_right);
		assertTrue(val_right instanceof BooleanLiteral);
		assertTrue(Boolean.parseBoolean(UtilityFunctions.getStringProperty(val_right, "value")));
	}
	
	@Test
	public void testInstanceOfExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		self instanceof system\r\n"
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
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		EObject fn = UtilityFunctions.getFn(parsed_annex_subclause, "argue SimpleTest(this)");
		EObject body = UtilityFunctions.getClaimBody(fn);
		assertNotNull(body);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof InstanceOfExpr);
		EObject expr_argument = UtilityFunctions.getExpr(expr);
		assertNotNull(expr_argument);
		assertTrue(expr_argument instanceof IdExpr);
		EObject expr_argument_id = UtilityFunctions.getID(expr_argument);
		assertNotNull(expr_argument_id);
		assertTrue(expr_argument_id instanceof Arg);
		assertTrue(UtilityFunctions.getStringProperty(expr_argument_id, "name").equals("self"));
		EObject id_type = UtilityFunctions.getType(expr_argument_id);
		assertTrue(UtilityFunctions.getStringProperty(id_type, "type").equals("component"));
		assertNotNull(id_type);
		assertTrue(id_type instanceof BaseType);
		EObject type = UtilityFunctions.getType(expr);
		assertNotNull(type);
		assertTrue(type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(type, "type").equals("system"));
	}
	
	@Test
	public void testRelationalExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		1 < 5\r\n"
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
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		EObject fn = UtilityFunctions.getFn(parsed_annex_subclause, "argue SimpleTest(this)");
		EObject body = UtilityFunctions.getClaimBody(fn);
		assertNotNull(body);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "op").equals("<"));
		EObject left = UtilityFunctions.getLeft(expr);
		assertNotNull(left);
		assertTrue(left instanceof IntExpr);
		EObject val_left = UtilityFunctions.getVal(left);
		assertNotNull(val_left);
		assertTrue(val_left instanceof IntegerLiteral);
		assertTrue(Integer.parseInt(UtilityFunctions.getStringProperty(val_left, "value")) == 1);
		EObject right = UtilityFunctions.getRight(expr);
		assertNotNull(right);
		assertTrue(right instanceof IntExpr);
		EObject val_right = UtilityFunctions.getVal(right);
		assertNotNull(val_right);
		assertTrue(val_right instanceof IntegerLiteral);
		assertTrue(Integer.parseInt(UtilityFunctions.getStringProperty(val_right, "value")) == 5);
	}
	
	@Test
	public void testPlusExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		5-4.2 < 1\r\n"
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
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		EObject fn = UtilityFunctions.getFn(parsed_annex_subclause, "argue SimpleTest(this)");
		EObject body = UtilityFunctions.getClaimBody(fn);
		assertNotNull(body);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		EObject left = UtilityFunctions.getLeft(expr);
		assertNotNull(left);
		assertTrue(UtilityFunctions.getStringProperty(left, "op").equals("-"));
		EObject sub_left = UtilityFunctions.getLeft(left);
		assertNotNull(sub_left);
		assertTrue(sub_left instanceof IntExpr);
		EObject val_left = UtilityFunctions.getVal(sub_left);
		assertNotNull(val_left);
		assertTrue(val_left instanceof IntegerLiteral);
		assertTrue(Integer.parseInt(UtilityFunctions.getStringProperty(val_left, "value")) == 5);
		EObject sub_right = UtilityFunctions.getRight(left);
		assertNotNull(sub_right);
		assertTrue(sub_right instanceof RealExpr);
		EObject val_right = UtilityFunctions.getVal(sub_right);
		assertNotNull(val_right);
		assertTrue(val_right instanceof RealLiteral);
		assertTrue(Double.parseDouble(UtilityFunctions.getStringProperty(val_right, "value")) == 4.2);
	}
	
	@Test
	public void testTimesExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		1*5 <= 5\r\n"
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
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		EObject fn = UtilityFunctions.getFn(parsed_annex_subclause, "argue SimpleTest(this)");
		EObject body = UtilityFunctions.getClaimBody(fn);
		assertNotNull(body);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "op").equals("<="));
		EObject expr_left = UtilityFunctions.getLeft(expr);
		assertNotNull(expr_left);
		assertTrue(expr_left instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr_left, "op").equals("*"));
		EObject expr_left_left = UtilityFunctions.getLeft(expr_left);
		assertNotNull(expr_left_left);
		assertTrue(expr_left_left instanceof IntExpr);
		EObject expr_left_left_val = UtilityFunctions.getVal(expr_left_left);
		assertNotNull(expr_left_left_val);
		assertTrue(expr_left_left_val instanceof IntegerLiteral);
		assertTrue(Integer.parseInt(UtilityFunctions.getStringProperty(expr_left_left_val, "value"))==1);
		// And so on
	}
	
	@Test
	public void testExpExpr() throws Exception{
		
	}
	
	@Test
	public void testPrefixExpr() throws Exception{
		
	}
	
	@Test
	public void testFailExpr() throws Exception{
		
	}
	
	@Test
	public void testIfThenElseExpr() throws Exception{
		
	}
	
	@Test
	public void testQuantifiedExpr() throws Exception{
		
	}
	
	@Test
	public void testBuiltInFnCallExpr() throws Exception{
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
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		EObject fn = UtilityFunctions.getFn(parsed_annex_subclause, "argue SimpleTest(this)");
		EObject body = UtilityFunctions.getClaimBody(fn);
		assertNotNull(body);
		assertTrue(UtilityFunctions.getExpr(body) instanceof BuiltInFnCallExpr);
	}

	@Test
	public void testLetExpr() throws Exception{
		String test = "package TestPackage\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute{**\r\n"
				+ "	SimpleTest(self : component) <=\r\n"
				+ "		** \"This is a simple unit test\" **\r\n"
				+ "		let test : string = 'Hello';\r\n"
				+ "		true\r\n"
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
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject owned_classifiers = UtilityFunctions.getownedClassifier(pub_sec, "sys.impl");
		EObject annex_subclause = UtilityFunctions.getAnnexSubclause(owned_classifiers, "Resolute");
		EObject parsed_annex_subclause = UtilityFunctions.getParsedAnnexSubclause(annex_subclause);
		EObject fn = UtilityFunctions.getFn(parsed_annex_subclause, "argue SimpleTest(this)");
		EObject body = UtilityFunctions.getClaimBody(fn);
		assertNotNull(body);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof LetExpr);
		EObject binding = UtilityFunctions.getBinding(expr);
		assertNotNull(binding);
		assertTrue(binding instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(binding, "name").equals("test"));
		EObject binding_expr = UtilityFunctions.getExpr(binding);
		assertNotNull(binding_expr);
		assertTrue(binding_expr instanceof StringExpr);
		EObject val = UtilityFunctions.getVal(binding_expr);
		assertNotNull(val);
		assertTrue(val instanceof StringLiteral);
		assertTrue(UtilityFunctions.getStringProperty(val, "value").equals("'Hello'"));
	}
	
	@Test
	public void testClaimType() throws Exception{
		
	}
	
	@Test
	public void testBudgetCase() throws Exception{
		// BudgetCase adapted from https:github.com/osate/examples/blob/master/core-examples/resolute/BudgetCase.aadl
		String budget_case = "package BudgetCase\r\n"
				+ "public\r\n"
				+ "	\r\n"
				+ "annex Resolute {**\r\n"
				+ "	MaximumWeight : real = 1.2kg\r\n"
				+ "	\r\n"
				+ "	-- requirement expressed in terms of the Maximum weight constant\r\n"
				+ "	SCSReq1(self : component) <=\r\n"
				+ "	**  \"R1: SCS shall be no heaver than \" MaximumWeight%kg  **\r\n"
				+ "	 SCSReq1AssureSubcomponentTotals(self, MaximumWeight) \r\n"
				+ "	 and SCSReq1AssureRecursivetotals(self, MaximumWeight)\r\n"
				+ "\r\n"
				+ "	-- requirement with the maximum passed into the claim function as parameter\r\n"
				+ "	-- the prove statement will refer to the constant Maximumweight\r\n"
				+ "	SCSReq1_1(self : component, max_weight : real) <=\r\n"
				+ "	**  \"R1: SCS shall be no heaver than \" max_weight%kg **\r\n"
				+ "	 SCSReq1VA1_1(self, max_weight) and SCSReq1AssureRecursivetotals(self, max_weight) \r\n"
				+ "	\r\n"
				+ "	-- verification action for requirement 1\r\n"
				+ "	-- VA1 does it by assuring thet the direct subcomponent budget totals do not exceed the limit\r\n"
				+ "	SCSReq1AssureSubcomponentTotals(self : component, max_weight :real) <=\r\n"
				+ "	** \"AVA1: assured sum of subcomponent budgets within budget\" **\r\n"
				+ "	-- we only evaluate the weight total if subcomponents have weight budget\r\n"
				+ "	SCSReq1VA1SubcomponentsHaveWeight(self) and SCSReq1VA1VerifySubcomponentTotals(self, max_weight)  \r\n"
				+ "\r\n"
				+ "	SCSReq1VA1VerifySubcomponentTotals(self : component, max_weight :real) <=\r\n"
				+ "	** \"VA1: sum of direct subcomponent weights \" actuals%kg \" within budget \"  max_weight%kg **\r\n"
				+ "	let actuals : real = AddSubcomponentWeightBudgets(self); \r\n"
				+ "	-- checking for over budget results in a fail exception. Otherwise return true\r\n"
				+ "	(actuals > max_weight) => fail ** self \" weight sum \" actuals%kg \" over budget \" max_weight%kg **  \r\n"
				+ "	\r\n"
				+ "	-- Also it specifies the assumption for the verification as a predicate function\r\n"
				+ "	SCSReq1VA1_1(self : component, max_weight :real) <=\r\n"
				+ "	** \"VA1: sum of direct subcomponent weights \" actuals%kg \" within budget \"  max_weight%kg **\r\n"
				+ "	let actuals : real = AddSubcomponentWeightBudgets(self); \r\n"
				+ "	SubcomponentsHaveWeightBudgetFail(self) => \r\n"
				+ "	-- in this case we will not evaluate the budget if the assumption does not hold\r\n"
				+ "	not (actuals <= max_weight) => fail ** self \"weight sum \" actuals%kg \" over budget \" max_weight%kg **\r\n"
				+ "	\r\n"
				+ "	-- this verification action recursively adds all budgets\r\n"
				+ "	SCSReq1AssureRecursivetotals(self : component, max_weight :real) <=\r\n"
				+ "	** \"VA2: sum of all subcomponent weights \" actuals%kg \" within budget \" max_weight%kg **\r\n"
				+ "	let actuals : real = AddAllBudgets(self); \r\n"
				+ "	(actuals > max_weight) => fail ** self \"All weight sum \" actuals%kg \" over budget \" max_weight%kg **  \r\n"
				+ "	\r\n"
				+ "	SCSReq1VA1SubcomponentsHaveWeight(self : component) <=\r\n"
				+ "	** \"Ass1: All subcomponents have gross weight\" **\r\n"
				+ "	let ratio : int = SubcomponentWeightBudgetCoveragePercent(self);\r\n"
				+ " 	not(forall (sub: subcomponents(self)). has_property(sub,SEI::GrossWeight)) \r\n"
				+ "   	=> fail ** \"Percentage of subcomponents with weight \" ratio \"%\" **\r\n"
				+ "	\r\n"
				+ "	\r\n"
				+ "	-- c omputational function to calculate total of weight budget from subcomponents\r\n"
				+ "	AddSubcomponentWeightBudgets(self: component) : real = \r\n"
				+ "		sum([WeightBudget(t) for (t: subcomponents(self))])\r\n"
				+ "\r\n"
				+ "	-- total of weight budgets of all components\r\n"
				+ "	AddAllBudgets(self : component) : real = \r\n"
				+ "	let subs :{component} = subcomponents(self);\r\n"
				+ "	if (length(subs) = 0) then\r\n"
				+ "		WeightBudget(self)\r\n"
				+ "	else\r\n"
				+ "		sum([WeightBudget(t) for (t: subs)])\r\n"
				+ "\r\n"
				+ "-- retrieves weight budget or 0.0 if no budget was assigned\r\n"
				+ "WeightBudget(self:component): real =\r\n"
				+ " property(self,SEI::GrossWeight,0.0 kg)\r\n"
				+ "\r\n"
				+ "-- assure all direct subcomponents have a weight budget\r\n"
				+ "SubcomponentsHaveWeightBudgetFail(self:component): bool =\r\n"
				+ "	let ratio : int = SubcomponentWeightBudgetCoveragePercent(self);\r\n"
				+ " not(forall (sub: subcomponents(self)). has_property(sub,SEI::GrossWeight)) \r\n"
				+ "   => fail ** \"Percentage of subcomponents with weight \" ratio \"%\" **\r\n"
				+ "\r\n"
				+ "-- assure all direct subcomponents have a weight budget\r\n"
				+ "SubcomponentsHaveWeightBudget(self:component): bool =\r\n"
				+ "    forall (sub: subcomponents(self)). has_property(sub,SEI::GrossWeight) \r\n"
				+ "\r\n"
				+ "-- calcuate the ratio of components with budget vs. all subcomponents\r\n"
				+ "SubcomponentWeightBudgetCoveragePercent(self:component): int = let subs: {component} = subcomponents(self); \r\n"
				+ " sum([ 100 for (sub : subs) | has_property(sub,SEI::GrossWeight)])/ (length(subs))\r\n"
				+ " \r\n"
				+ " \r\n"
				+ " AllHaveBudgets(self : component) <= ** \"Component \" self \" shall have a weight budget\" ** \r\n"
				+ " 	HasWeightBudget(self) and forall (c: subcomponents(self)). AllHaveBudgets(c) \r\n"
				+ "		\r\n"
				+ " \r\n"
				+ " HasWeightBudget(t : component) : bool =  \r\n"
				+ " not(has_property(t,SEI::GrossWeight)) => fail ** t \" has no weight\" ** \r\n"
				+ " \r\n"
				+ " SystemWideReq1() <= ** \"All threads have a period\" ** \r\n"
				+ " forall (t: thread). HasPeriod(t)\r\n"
				+ " \r\n"
				+ " HasPeriod(t : thread) <= ** \"Thread \" t \" has a period\" ** \r\n"
				+ " has_property(t,Timing_Properties::Period)\r\n"
				+ "	\r\n"
				+ "**};\r\n"
				+ "end BudgetCase;";
		FluentIssueCollection issueCollection= testHelper.testString(budget_case);
		EObject aadl_package_impl = issueCollection.getResource().getContents().get(0);
		EObject pub_sec = UtilityFunctions.getownedPublicSection(aadl_package_impl);
		EObject annex_lib = UtilityFunctions.getAnnexLibrary(pub_sec, "Resolute");
		EObject parsed_annex_lib = UtilityFunctions.getParsedAnnexLibrary(annex_lib);
		testBudgetCaseMaximumWeightDefinition(parsed_annex_lib);
		testBudgetCaseSCSReq1Definition(parsed_annex_lib);
		testBudgetCaseSCSReq1_1Definition(parsed_annex_lib);
		testBudgetCaseSCSReq1AssureSubcomponentTotalsDefinition(parsed_annex_lib);
		testBudgetCaseSCSReq1VA1VerifySubcomponentTotalDefinition(parsed_annex_lib);
		testBudgetCaseSCSReq1VA1_1Definition(parsed_annex_lib);
		testBudgetCaseSCSReq1AssureRecursiveTotalsDefinition(parsed_annex_lib);
		testBudgetCaseSCSReq1VA1SubcomponentsHaveWeightDefinition(parsed_annex_lib);
		testBudgetCaseAddSubcomponentWeightBudgetsDefinition(parsed_annex_lib);
		testBudgetCaseAddAllBudgetsDefinition(parsed_annex_lib);
		testBudgetCaseWeightBudgetDefinition(parsed_annex_lib);
		testBudgetCaseSubcomponentsHaveWeightBudgetFailDefinition(parsed_annex_lib);
		testBudgetCaseSubcomponentsHaveWeightBudgetDefinition(parsed_annex_lib);
		testBudgetCaseSubcomponentWeightBudgetCoveragePercentDefinition(parsed_annex_lib);
		testBudgetCaseAllHaveBudgetsDefinition(parsed_annex_lib);
		testBudgetCaseHasWeightBudgetDefinition(parsed_annex_lib);
		testBudgetCaseSystemWideReq1Definition(parsed_annex_lib);
		testBudgetCaseHasPeriodDefinition(parsed_annex_lib);
	}
	
	public void testBudgetCaseMaximumWeightDefinition(EObject parsed_annex_lib){
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "MaximumWeight");
		assertNotNull(definition);
		assertTrue(definition instanceof ConstantDefinition);
		assertTrue(UtilityFunctions.getType(definition) instanceof BaseType);
		EObject expr = UtilityFunctions.getExpr(definition);
		assertNotNull(expr);
		assertTrue(expr instanceof RealExpr);
		EObject val = UtilityFunctions.getVal(expr);
		assertNotNull(val);
		assertTrue(val instanceof RealLiteral);
		assertTrue(Double.parseDouble(UtilityFunctions.getStringProperty(val, "value")) == 1.2);
		EObject unit = UtilityFunctions.getUnit(val);
		assertNotNull(unit);
		assertTrue(unit instanceof UnitLiteral);
		assertTrue(UtilityFunctions.getStringProperty(unit, "name").equals("kg"));
	}
	 
	public void testBudgetCaseSCSReq1Definition(EObject parsed_annex_lib){
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SCSReq1");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("self"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "op").equals("and"));
		EObject left = UtilityFunctions.getLeft(expr);
		assertNotNull(left);
		assertTrue(left instanceof FnCallExpr);
		EObject left_arg0 = UtilityFunctions.getArg(left, 0);
		assertNotNull(left_arg0);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(left_arg0), "name").equals("self"));
		assertTrue(left_arg0 instanceof IdExpr);
		EObject left_arg0_type = UtilityFunctions.getType(UtilityFunctions.getID(left_arg0));
		assertNotNull(left_arg0_type);
		assertTrue(left_arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(left_arg0_type, "type").equals("component"));
		EObject left_arg1 = UtilityFunctions.getArg(left, 1);
		assertNotNull(left_arg1);
		assertTrue(left_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(left_arg1), "name").equals("MaximumWeight"));
		EObject left_arg1_type = UtilityFunctions.getType(UtilityFunctions.getID(left_arg1));
		assertNotNull(left_arg1_type);
		assertTrue(left_arg1_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(left_arg1_type, "type").equals("real"));
		EObject fn_left = UtilityFunctions.getFn(left);
		assertNotNull(fn_left);
		assertTrue(fn_left instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(fn_left, "name").equals("SCSReq1AssureSubcomponentTotals"));
		EObject right = UtilityFunctions.getRight(expr);
		assertNotNull(right);
		assertTrue(right instanceof FnCallExpr);
		EObject right_arg0 = UtilityFunctions.getArg(right, 0);
		assertNotNull(right_arg0);
		assertTrue(right_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(right_arg0), "name").equals("self"));
		EObject right_arg0_type = UtilityFunctions.getType(UtilityFunctions.getID(right_arg0));
		assertNotNull(right_arg0_type);
		assertTrue(right_arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(right_arg0_type, "type").equals("component"));
		EObject right_arg1 = UtilityFunctions.getArg(right, 1);
		assertNotNull(right_arg1);
		assertTrue(right_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(right_arg1), "name").equals("MaximumWeight"));
		EObject right_arg1_type = UtilityFunctions.getType(UtilityFunctions.getID(right_arg1));
		assertNotNull(right_arg1_type);
		assertTrue(right_arg1_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(right_arg1_type, "type").equals("real"));
		EObject fn_right = UtilityFunctions.getFn(right);
		assertNotNull(fn_right);
		assertTrue(fn_right instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(fn_right, "name").equals("SCSReq1AssureRecursivetotals"));
	}
	
	public void testBudgetCaseSCSReq1_1Definition(EObject parsed_annex_lib){;
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SCSReq1_1");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg0 = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg0);
		assertTrue(UtilityFunctions.getStringProperty(arg0, "name").equals("self"));
		EObject arg0_type = UtilityFunctions.getType(arg0);
		assertNotNull(arg0_type);
		assertTrue(arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg0_type, "type").equals("component"));
		EObject arg1 = UtilityFunctions.getArg(definition, 1);
		assertNotNull(arg1);
		assertTrue(UtilityFunctions.getStringProperty(arg1, "name").equals("max_weight"));
		EObject arg1_type = UtilityFunctions.getType(arg1);
		assertNotNull(arg1_type);
		assertTrue(arg1_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg1_type, "type").equals("real"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "op").equals("and"));
		EObject left = UtilityFunctions.getLeft(expr);
		assertNotNull(left);
		assertTrue(left instanceof FnCallExpr);
		EObject left_arg0 = UtilityFunctions.getArg(left, 0);
		assertNotNull(left_arg0);
		assertTrue(left_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(left_arg0), "name").equals("self"));
		EObject left_arg0_type = UtilityFunctions.getType(UtilityFunctions.getID(left_arg0));
		assertNotNull(left_arg0_type);
		assertTrue(left_arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(left_arg0_type, "type").equals("component"));
		EObject left_arg1 = UtilityFunctions.getArg(left, 1);
		assertNotNull(left_arg1);
		assertTrue(left_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(left_arg1), "name").equals("max_weight"));
		EObject left_arg1_type = UtilityFunctions.getType(UtilityFunctions.getID(left_arg1));
		assertNotNull(left_arg1_type);
		assertTrue(left_arg1_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(left_arg1_type, "type").equals("real"));
		EObject fn_left = UtilityFunctions.getFn(left);
		assertNotNull(fn_left);
		assertTrue(fn_left instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(fn_left, "name").equals("SCSReq1VA1_1"));
		EObject right = UtilityFunctions.getRight(expr);
		assertNotNull(right);
		assertTrue(right instanceof FnCallExpr);
		EObject right_arg0 = UtilityFunctions.getArg(right, 0);
		assertNotNull(right_arg0);
		assertTrue(right_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(right_arg0), "name").equals("self"));
		EObject right_arg0_type = UtilityFunctions.getType(UtilityFunctions.getID(right_arg0));
		assertNotNull(right_arg0_type);
		assertTrue(right_arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(right_arg0_type, "type").equals("component"));
		EObject right_arg1 = UtilityFunctions.getArg(right, 1);
		assertNotNull(right_arg1);
		assertTrue(right_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(right_arg1), "name").equals("max_weight"));
		EObject right_arg1_type = UtilityFunctions.getType(UtilityFunctions.getID(right_arg1));
		assertNotNull(right_arg1_type);
		assertTrue(right_arg1_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(right_arg1_type, "type").equals("real"));
		EObject fn_right = UtilityFunctions.getFn(right);
		assertNotNull(fn_right);
		assertTrue(fn_right instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(fn_right, "name").equals("SCSReq1AssureRecursivetotals"));
	}

	public void testBudgetCaseSCSReq1AssureSubcomponentTotalsDefinition(EObject parsed_annex_lib){
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SCSReq1AssureSubcomponentTotals");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg0 = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg0);
		assertTrue(UtilityFunctions.getStringProperty(arg0, "name").equals("self"));
		EObject arg0_type = UtilityFunctions.getType(arg0);
		assertNotNull(arg0_type);
		assertTrue(arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg0_type, "type").equals("component"));
		EObject arg1 = UtilityFunctions.getArg(definition, 1);
		assertNotNull(arg1);
		assertTrue(UtilityFunctions.getStringProperty(arg1, "name").equals("max_weight"));
		EObject arg1_type = UtilityFunctions.getType(arg1);
		assertNotNull(arg1_type);
		assertTrue(arg1_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg1_type, "type").equals("real"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "op").equals("and"));
		EObject left = UtilityFunctions.getLeft(expr);
		assertNotNull(left);
		assertTrue(left instanceof FnCallExpr);
		EObject left_arg = UtilityFunctions.getArg(left, 0);
		assertNotNull(left_arg);
		assertTrue(left_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(left_arg), "name").equals("self"));
		EObject left_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(left_arg));
		assertNotNull(left_arg_type);
		assertTrue(left_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(left_arg_type, "type").equals("component"));
		EObject fn_left = UtilityFunctions.getFn(left);
		assertNotNull(fn_left);
		assertTrue(fn_left instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(fn_left, "name").equals("SCSReq1VA1SubcomponentsHaveWeight"));
		EObject right = UtilityFunctions.getRight(expr);
		assertNotNull(right);
		assertTrue(right instanceof FnCallExpr);
		EObject right_arg0 = UtilityFunctions.getArg(right, 0);
		assertNotNull(right_arg0);
		assertTrue(right_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(right_arg0), "name").equals("self"));
		EObject right_arg0_type = UtilityFunctions.getType(UtilityFunctions.getID(right_arg0));
		assertNotNull(right_arg0_type);
		assertTrue(right_arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(right_arg0_type, "type").equals("component"));
		EObject right_arg1 = UtilityFunctions.getArg(right, 1);
		assertNotNull(right_arg1);
		assertTrue(right_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(right_arg1), "name").equals("max_weight"));
		EObject right_arg1_type = UtilityFunctions.getType(UtilityFunctions.getID(right_arg1));
		assertNotNull(right_arg1_type);
		assertTrue(right_arg1_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(right_arg1_type, "type").equals("real"));
		EObject fn_right = UtilityFunctions.getFn(right);
		assertNotNull(fn_right);
		assertTrue(fn_right instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(fn_right, "name").equals("SCSReq1VA1VerifySubcomponentTotals"));
	}
	
	public void testBudgetCaseSCSReq1VA1VerifySubcomponentTotalDefinition(EObject parsed_annex_lib){		
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SCSReq1VA1VerifySubcomponentTotals");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg0 = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg0);
		assertTrue(UtilityFunctions.getStringProperty(arg0, "name").equals("self"));
		EObject arg0_type = UtilityFunctions.getType(arg0);
		assertNotNull(arg0_type);
		assertTrue(arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg0_type, "type").equals("component"));
		EObject arg1 = UtilityFunctions.getArg(definition, 1);
		assertNotNull(arg1);
		assertTrue(UtilityFunctions.getStringProperty(arg1, "name").equals("max_weight"));
		EObject arg1_type = UtilityFunctions.getType(arg1);
		assertNotNull(arg1_type);
		assertTrue(arg1_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg1_type, "type").equals("real"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		
		EObject expr0 = UtilityFunctions.getExpr(body);
		assertNotNull(expr0);
		assertTrue(expr0 instanceof LetExpr);
		EObject binding = UtilityFunctions.getBinding(expr0);
		assertNotNull(binding);
		assertTrue(binding instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(binding, "name").equals("actuals"));
		EObject binding_type = UtilityFunctions.getType(binding);
		assertNotNull(binding_type);
		assertTrue(binding_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_type, "type").equals("real"));
		EObject binding_expr = UtilityFunctions.getExpr(binding);
		assertNotNull(binding_expr);
		assertTrue(binding_expr instanceof FnCallExpr);
		EObject binding_fn = UtilityFunctions.getFn(binding_expr);
		assertNotNull(binding_fn);
		assertTrue(binding_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn, "name").equals("AddSubcomponentWeightBudgets"));
		EObject binding_fn_arg = UtilityFunctions.getArg(binding_fn, 0);
		assertNotNull(binding_fn_arg);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn_arg, "name").equals("self"));
		EObject binding_fn_arg_type = UtilityFunctions.getType(binding_fn_arg);
		assertNotNull(binding_fn_arg_type);
		assertTrue(binding_fn_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn_arg_type, "type").equals("component"));
		
		EObject expr1 = UtilityFunctions.getExpr(expr0);
		assertNotNull(expr1);
		assertTrue(expr1 instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1, "op").equals("=>"));	
		EObject expr1_left = UtilityFunctions.getLeft(expr1);
		assertNotNull(expr1_left);
		assertTrue(expr1_left instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left, "op").equals(">"));
		EObject expr1_left_left = UtilityFunctions.getLeft(expr1_left);
		assertNotNull(expr1_left_left);
		assertTrue(expr1_left_left instanceof IdExpr);
		EObject expr1_left_left_id = UtilityFunctions.getID(expr1_left_left);
		assertNotNull(expr1_left_left_id);
		assertTrue(expr1_left_left_id instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_left_id,"name").equals("actuals"));
		EObject expr1_left_right = UtilityFunctions.getRight(expr1_left);
		assertNotNull(expr1_left_right);
		assertTrue(expr1_left_right instanceof IdExpr);
		EObject expr1_left_right_id = UtilityFunctions.getID(expr1_left_right);
		assertNotNull(expr1_left_right_id);
		assertTrue(expr1_left_right_id instanceof Arg);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_right_id,"name").equals("max_weight"));
		EObject expr1_right = UtilityFunctions.getRight(expr1);
		assertNotNull(expr1_right);
		assertTrue(expr1_right instanceof FailExpr);
	}
	
	public void testBudgetCaseSCSReq1VA1_1Definition(EObject parsed_annex_lib){
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SCSReq1VA1_1");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg0 = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg0);
		assertTrue(UtilityFunctions.getStringProperty(arg0, "name").equals("self"));
		EObject arg0_type = UtilityFunctions.getType(arg0);
		assertNotNull(arg0_type);
		assertTrue(arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg0_type, "type").equals("component"));
		EObject arg1 = UtilityFunctions.getArg(definition, 1);
		assertNotNull(arg1);
		assertTrue(UtilityFunctions.getStringProperty(arg1, "name").equals("max_weight"));
		EObject arg1_type = UtilityFunctions.getType(arg1);
		assertNotNull(arg1_type);
		assertTrue(arg1_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg1_type, "type").equals("real"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		
		EObject expr0 = UtilityFunctions.getExpr(body);
		assertNotNull(expr0);
		assertTrue(expr0 instanceof LetExpr);
		EObject binding = UtilityFunctions.getBinding(expr0);
		assertNotNull(binding);
		assertTrue(binding instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(binding, "name").equals("actuals"));
		EObject binding_type = UtilityFunctions.getType(binding);
		assertNotNull(binding_type);
		assertTrue(binding_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_type, "type").equals("real"));
		EObject binding_expr = UtilityFunctions.getExpr(binding);
		assertNotNull(binding_expr);
		assertTrue(binding_expr instanceof FnCallExpr);
		EObject binding_fn = UtilityFunctions.getFn(binding_expr);
		assertNotNull(binding_fn);
		assertTrue(binding_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn, "name").equals("AddSubcomponentWeightBudgets"));
		EObject binding_fn_arg = UtilityFunctions.getArg(binding_fn, 0);
		assertNotNull(binding_fn_arg);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn_arg, "name").equals("self"));
		EObject binding_fn_arg_type = UtilityFunctions.getType(binding_fn_arg);
		assertNotNull(binding_fn_arg_type);
		assertTrue(binding_fn_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn_arg_type, "type").equals("component"));

		
		EObject expr1 = UtilityFunctions.getExpr(expr0);
		assertNotNull(expr1);
		assertTrue(expr1 instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1, "op").equals("=>"));	
		EObject expr1_left = UtilityFunctions.getLeft(expr1);
		assertNotNull(expr1_left);
		assertTrue(expr1_left instanceof FnCallExpr);
		EObject expr1_left_arg = UtilityFunctions.getArg(expr1_left, 0);
		assertNotNull(expr1_left_arg);
		assertTrue(expr1_left_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_arg), "name").equals("self"));
		EObject expr1_left_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(expr1_left_arg));
		assertNotNull(expr1_left_arg_type);
		assertTrue(expr1_left_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_arg_type, "type").equals("component"));
		EObject expr1_left_fn = UtilityFunctions.getFn(expr1_left);
		assertNotNull(expr1_left_fn);
		assertTrue(expr1_left_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_fn, "name").equals("SubcomponentsHaveWeightBudgetFail"));
		
		EObject expr1_right = UtilityFunctions.getRight(expr1);
		assertNotNull(expr1_right);
		assertTrue(expr1_right instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_right,"op").equals("=>"));
		EObject expr1_right_left = UtilityFunctions.getLeft(expr1_right);
		assertNotNull(expr1_right_left);
		assertTrue(expr1_right_left instanceof UnaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_right_left, "op").equals("not"));
		EObject expr1_right_left_expr = UtilityFunctions.getExpr(expr1_right_left);
		assertNotNull(expr1_right_left_expr);
		assertTrue(expr1_right_left_expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_right_left_expr, "op").equals("<="));
		EObject expr1_right_left_expr_left = UtilityFunctions.getLeft(expr1_right_left_expr);
		assertNotNull(expr1_right_left_expr_left);
		assertTrue(expr1_right_left_expr_left instanceof IdExpr);
		EObject expr1_right_left_expr_left_id = UtilityFunctions.getID(expr1_right_left_expr_left);
		assertNotNull(expr1_right_left_expr_left_id);
		assertTrue(expr1_right_left_expr_left_id instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(expr1_right_left_expr_left_id, "name").equals("actuals"));
		EObject expr1_right_left_expr_right = UtilityFunctions.getRight(expr1_right_left_expr);
		assertNotNull(expr1_right_left_expr_right);
		assertTrue(expr1_right_left_expr_right instanceof IdExpr);
		EObject expr1_right_left_expr_right_id = UtilityFunctions.getID(expr1_right_left_expr_right);
		assertNotNull(expr1_right_left_expr_right_id);
		assertTrue(expr1_right_left_expr_right_id instanceof Arg);
		assertTrue(UtilityFunctions.getStringProperty(expr1_right_left_expr_right_id, "name").equals("max_weight"));
		EObject expr1_right_right = UtilityFunctions.getRight(expr1_right);
		assertNotNull(expr1_right_right);
		assertTrue(expr1_right_right instanceof FailExpr);
	}
	
	public void testBudgetCaseSCSReq1AssureRecursiveTotalsDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SCSReq1AssureRecursivetotals");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg0 = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg0);
		assertTrue(UtilityFunctions.getStringProperty(arg0, "name").equals("self"));
		EObject arg0_type = UtilityFunctions.getType(arg0);
		assertNotNull(arg0_type);
		assertTrue(arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg0_type, "type").equals("component"));
		EObject arg1 = UtilityFunctions.getArg(definition, 1);
		assertNotNull(arg1);
		assertTrue(UtilityFunctions.getStringProperty(arg1, "name").equals("max_weight"));
		EObject arg1_type = UtilityFunctions.getType(arg1);
		assertNotNull(arg1_type);
		assertTrue(arg1_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg1_type, "type").equals("real"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		
		EObject expr0 = UtilityFunctions.getExpr(body);
		assertNotNull(expr0);
		assertTrue(expr0 instanceof LetExpr);
		EObject binding = UtilityFunctions.getBinding(expr0);
		assertNotNull(binding);
		assertTrue(binding instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(binding, "name").equals("actuals"));
		EObject binding_type = UtilityFunctions.getType(binding);
		assertNotNull(binding_type);
		assertTrue(binding_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_type, "type").equals("real"));
		EObject binding_expr = UtilityFunctions.getExpr(binding);
		assertNotNull(binding_expr);
		assertTrue(binding_expr instanceof FnCallExpr);
		EObject binding_fn = UtilityFunctions.getFn(binding_expr);
		assertNotNull(binding_fn);
		assertTrue(binding_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn, "name").equals("AddAllBudgets"));
		EObject binding_fn_arg = UtilityFunctions.getArg(binding_fn, 0);
		assertNotNull(binding_fn_arg);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn_arg, "name").equals("self"));
		EObject binding_fn_arg_type = UtilityFunctions.getType(binding_fn_arg);
		assertNotNull(binding_fn_arg_type);
		assertTrue(binding_fn_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn_arg_type, "type").equals("component"));

		EObject expr1 = UtilityFunctions.getExpr(expr0);
		assertNotNull(expr1);
		assertTrue(expr1 instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1, "op").equals("=>"));	
		EObject expr1_left = UtilityFunctions.getLeft(expr1);
		assertNotNull(expr1_left);
		assertTrue(expr1_left instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left, "op").equals(">"));
		EObject expr1_left_left = UtilityFunctions.getLeft(expr1_left);
		assertNotNull(expr1_left_left);
		assertTrue(expr1_left_left instanceof IdExpr);
		EObject expr1_left_left_id = UtilityFunctions.getID(expr1_left_left);
		assertNotNull(expr1_left_left_id);
		assertTrue(expr1_left_left_id instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_left_id, "name").equals("actuals"));
		EObject expr1_left_right = UtilityFunctions.getRight(expr1_left);
		assertNotNull(expr1_left_right);
		assertTrue(expr1_left_right instanceof IdExpr);
		EObject expr1_left_right_id = UtilityFunctions.getID(expr1_left_right);
		assertNotNull(expr1_left_right_id);
		assertTrue(expr1_left_right_id instanceof Arg);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_right_id, "name").equals("max_weight"));
		EObject expr1_right = UtilityFunctions.getRight(expr1);
		assertNotNull(expr1_right);
		assertTrue(expr1_right instanceof FailExpr);
	}
	
	public void testBudgetCaseSCSReq1VA1SubcomponentsHaveWeightDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SCSReq1VA1SubcomponentsHaveWeight");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("self"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		
		EObject expr0 = UtilityFunctions.getExpr(body);
		assertNotNull(expr0);
		assertTrue(expr0 instanceof LetExpr);
		EObject binding = UtilityFunctions.getBinding(expr0);
		assertNotNull(binding);
		assertTrue(binding instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(binding, "name").equals("ratio"));
		EObject binding_type = UtilityFunctions.getType(binding);
		assertNotNull(binding_type);
		assertTrue(binding_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_type, "type").equals("int"));
		EObject binding_expr = UtilityFunctions.getExpr(binding);
		assertNotNull(binding_expr);
		assertTrue(binding_expr instanceof FnCallExpr);
		EObject binding_fn = UtilityFunctions.getFn(binding_expr);
		assertNotNull(binding_fn);
		assertTrue(binding_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn, "name").equals("SubcomponentWeightBudgetCoveragePercent"));
		EObject binding_fn_arg = UtilityFunctions.getArg(binding_fn, 0);
		assertNotNull(binding_fn_arg);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn_arg, "name").equals("self"));
		EObject binding_fn_arg_type = UtilityFunctions.getType(binding_fn_arg);
		assertNotNull(binding_fn_arg_type);
		assertTrue(binding_fn_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn_arg_type, "type").equals("component"));

		EObject expr1 = UtilityFunctions.getExpr(expr0);
		assertNotNull(expr1);
		assertTrue(expr1 instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1, "op").equals("=>"));	
		EObject expr1_left = UtilityFunctions.getLeft(expr1);
		assertNotNull(expr1_left);
		assertTrue(expr1_left instanceof UnaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left, "op").equals("not"));
		EObject expr1_left_expr = UtilityFunctions.getExpr(expr1_left);
		assertNotNull(expr1_left_expr);
		assertTrue(expr1_left_expr instanceof QuantifiedExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_expr, "quant").equals("forall"));
		EObject expr1_left_expr_expr = UtilityFunctions.getExpr(expr1_left_expr);
		assertNotNull(expr1_left_expr_expr);
		assertTrue(expr1_left_expr_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_expr_expr, "fn").equals("has_property"));
		EObject expr1_left_expr_expr_arg0 = UtilityFunctions.getArg(expr1_left_expr_expr, 0);
		assertNotNull(expr1_left_expr_expr_arg0);
		assertTrue(expr1_left_expr_expr_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_expr_expr_arg0), "name").equals("sub"));
		EObject expr1_left_expr_expr_arg0_expr = UtilityFunctions.getExpr(UtilityFunctions.getID(expr1_left_expr_expr_arg0));
		assertNotNull(expr1_left_expr_expr_arg0_expr);
		assertTrue(expr1_left_expr_expr_arg0_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_expr_expr_arg0_expr, "fn").equals("subcomponents"));
		EObject expr1_left_expr_expr_arg0_expr_arg = UtilityFunctions.getArg(expr1_left_expr_expr_arg0_expr, 0);
		assertNotNull(expr1_left_expr_expr_arg0_expr_arg);
		assertTrue(expr1_left_expr_expr_arg0_expr_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_expr_expr_arg0_expr_arg), "name").equals("self"));
		EObject expr1_left_expr_expr_arg0_expr_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(expr1_left_expr_expr_arg0_expr_arg));
		assertNotNull(expr1_left_expr_expr_arg0_expr_arg_type);
		assertTrue(expr1_left_expr_expr_arg0_expr_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_expr_expr_arg0_expr_arg_type, "type").equals("component"));
		EObject expr1_left_expr_expr_arg1 = UtilityFunctions.getArg(expr1_left_expr_expr, 1);
		assertNotNull(expr1_left_expr_expr_arg1);
		assertTrue(expr1_left_expr_expr_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_expr_expr_arg1), "name").equals("GrossWeight"));
		assertTrue(UtilityFunctions.getID(expr1_left_expr_expr_arg1) instanceof Property);
		EObject expr1_right = UtilityFunctions.getRight(expr1);
		assertNotNull(expr1_right);
		assertTrue(expr1_right instanceof FailExpr);
	}
	
	public void testBudgetCaseAddSubcomponentWeightBudgetsDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "AddSubcomponentWeightBudgets");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("self"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof FunctionBody);
		
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "fn").equals("sum"));
		EObject expr_arg = UtilityFunctions.getArg(expr, 0);
		assertNotNull(expr_arg);
		assertTrue(expr_arg instanceof ListFilterMapExpr);
		EObject expr_arg_arg = UtilityFunctions.getArg(expr_arg, 0);
		assertNotNull(expr_arg_arg);
		assertTrue(expr_arg_arg instanceof QuantArg);
		assertTrue(UtilityFunctions.getStringProperty(expr_arg_arg, "name").equals("t"));
		EObject expr_arg_arg_expr = UtilityFunctions.getExpr(expr_arg_arg);
		assertNotNull(expr_arg_arg_expr);
		assertTrue(expr_arg_arg_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr_arg_arg_expr, "fn").equals("subcomponents"));
		EObject expr_arg_arg_expr_arg = UtilityFunctions.getArg(expr_arg_arg_expr, 0);
		assertNotNull(expr_arg_arg_expr_arg);
		assertTrue(expr_arg_arg_expr_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_arg_arg_expr_arg), "name").equals("self"));
		EObject expr_arg_arg_expr_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(expr_arg_arg_expr_arg));
		assertNotNull(expr_arg_arg_expr_arg_type);
		assertTrue(expr_arg_arg_expr_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_arg_arg_expr_arg_type, "type").equals("component"));

		EObject map = UtilityFunctions.getMap(expr_arg);
		assertNotNull(map);
		assertTrue(map instanceof FnCallExpr);
		EObject map_arg = UtilityFunctions.getArg(map, 0);
		assertNotNull(map_arg);
		assertTrue(map_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(map_arg), "name").equals("t"));
		EObject map_arg_expr = UtilityFunctions.getExpr(UtilityFunctions.getID(map_arg));
		assertNotNull(map_arg_expr);
		assertTrue(map_arg_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(map_arg_expr, "fn").equals("subcomponents"));
		EObject map_arg_expr_arg = UtilityFunctions.getArg(map_arg_expr, 0);
		assertNotNull(map_arg_expr_arg);
		assertTrue(map_arg_expr_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(map_arg_expr_arg), "name").equals("self"));
		EObject map_fn = UtilityFunctions.getFn(map);
		assertNotNull(map_fn);
		assertTrue(map_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(map_fn, "name").equals("WeightBudget"));
	}
	
	public void testBudgetCaseAddAllBudgetsDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "AddAllBudgets");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("self"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof FunctionBody);
		
		EObject expr0 = UtilityFunctions.getExpr(body);
		assertNotNull(expr0);
		assertTrue(expr0 instanceof LetExpr);
		EObject binding = UtilityFunctions.getBinding(expr0);
		assertNotNull(binding);
		assertTrue(binding instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(binding, "name").equals("subs"));
		EObject binding_type = UtilityFunctions.getType(binding);
		assertNotNull(binding_type);
		assertTrue(binding_type instanceof SetType);
		EObject binding_type_type = UtilityFunctions.getType(binding_type);
		assertNotNull(binding_type_type);
		assertTrue(binding_type_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_type_type, "type").equals("component"));
		EObject binding_expr = UtilityFunctions.getExpr(binding);
		assertNotNull(binding_expr);
		assertTrue(binding_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(binding_expr, "fn").equals("subcomponents"));

		EObject expr1 = UtilityFunctions.getExpr(expr0);
		assertNotNull(expr1);
		assertTrue(expr1 instanceof IfThenElseExpr);
		
		EObject expr1_cond = UtilityFunctions.getCond(expr1);
		assertNotNull(expr1_cond);
		assertTrue(expr1_cond instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_cond, "op").equals("="));
		EObject expr1_cond_left = UtilityFunctions.getLeft(expr1_cond);
		assertNotNull(expr1_cond_left);
		assertTrue(expr1_cond_left instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_cond_left, "fn").equals("length"));
		EObject expr1_cond_left_arg = UtilityFunctions.getArg(expr1_cond_left, 0);
		assertNotNull(expr1_cond_left_arg);
		assertTrue(expr1_cond_left_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_cond_left_arg), "name").equals("subs"));
		EObject expr1_cond_right = UtilityFunctions.getRight(expr1_cond);
		assertNotNull(expr1_cond_right);
		assertTrue(expr1_cond_right instanceof IntExpr);
		EObject val = UtilityFunctions.getVal(expr1_cond_right);
		assertNotNull(val);
		assertTrue(val instanceof IntegerLiteral);
		assertTrue(Integer.parseInt(UtilityFunctions.getStringProperty(val, "value")) == 0);
		
		EObject expr1_then = UtilityFunctions.getThen(expr1);
		assertNotNull(expr1_then);
		assertTrue(expr1_then instanceof FnCallExpr);
		EObject expr1_then_arg = UtilityFunctions.getArg(expr1_then, 0);
		assertNotNull(expr1_then_arg);
		assertTrue(expr1_then_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_then_arg), "name").equals("self"));
		EObject expr1_then_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(expr1_then_arg));
		assertNotNull(expr1_then_arg_type);
		assertTrue(expr1_then_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr1_then_arg_type, "type").equals("component"));
		EObject expr1_then_fn = UtilityFunctions.getFn(expr1_then);
		assertNotNull(expr1_then_fn);
		assertTrue(expr1_then_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(expr1_then_fn, "name").equals("WeightBudget"));
		EObject expr1_then_fn_arg = UtilityFunctions.getArg(expr1_then_fn, 0);
		assertNotNull(expr1_then_fn_arg);
		assertTrue(UtilityFunctions.getStringProperty(expr1_then_fn_arg, "name").equals("self"));
		EObject expr1_then_fn_arg_type = UtilityFunctions.getType(expr1_then_fn_arg);
		assertNotNull(expr1_then_fn_arg_type);
		assertTrue(expr1_then_fn_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr1_then_fn_arg_type, "type").equals("component"));

		EObject expr1_else = UtilityFunctions.getElse(expr1);
		assertNotNull(expr1_else);
		assertTrue(expr1_else instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_else, "fn").equals("sum"));
		
		EObject expr1_else_arg = UtilityFunctions.getArg(expr1_else, 0);
		assertNotNull(expr1_else_arg);
		assertTrue(expr1_else_arg instanceof ListFilterMapExpr);
		EObject expr1_else_arg_arg = UtilityFunctions.getArg(expr1_else_arg, 0);
		assertNotNull(expr1_else_arg_arg);
		assertTrue(expr1_else_arg_arg instanceof QuantArg);
		assertTrue(UtilityFunctions.getStringProperty(expr1_else_arg_arg, "name").equals("t"));
		EObject expr1_else_arg_arg_expr = UtilityFunctions.getExpr(expr1_else_arg_arg);
		assertNotNull(expr1_else_arg_arg_expr);
		assertTrue(expr1_else_arg_arg_expr instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_else_arg_arg_expr), "name").equals("subs"));

		EObject expr1_else_map = UtilityFunctions.getMap(expr1_else_arg);
		assertNotNull(expr1_else_map);
		assertTrue(expr1_else_map instanceof FnCallExpr);
		EObject expr1_else_map_arg = UtilityFunctions.getArg(expr1_else_map, 0);
		assertNotNull(expr1_else_map_arg);
		assertTrue(expr1_else_map_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_else_map_arg), "name").equals("t"));
		EObject expr1_else_map_arg_expr = UtilityFunctions.getExpr(UtilityFunctions.getID(expr1_else_map_arg));
		assertNotNull(expr1_else_map_arg_expr);
		assertTrue(expr1_else_map_arg_expr instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_else_map_arg_expr), "name").equals("subs"));
		EObject expr1_else_map_fn = UtilityFunctions.getFn(expr1_else_map);
		assertNotNull(expr1_else_map_fn);
		assertTrue(expr1_else_map_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(expr1_else_map_fn, "name").equals("WeightBudget"));
	}
	
	public void testBudgetCaseWeightBudgetDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "WeightBudget");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("self"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof FunctionBody);
		EObject body_type = UtilityFunctions.getType(body);
		assertNotNull(body_type);
		assertTrue(body_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(body_type, "type").equals("real"));
		
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "fn").equals("property"));
		EObject expr_arg0 = UtilityFunctions.getArg(expr, 0);
		assertNotNull(expr_arg0);
		assertTrue(expr_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_arg0), "name").equals("self"));
		EObject expr_arg0_type = UtilityFunctions.getType(UtilityFunctions.getID(expr_arg0));
		assertNotNull(expr_arg0_type);
		assertTrue(expr_arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_arg0_type, "type").equals("component"));
		EObject expr_arg1 = UtilityFunctions.getArg(expr, 1);
		assertNotNull(expr_arg1);
		assertTrue(expr_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_arg1), "name").equals("GrossWeight"));
		assertTrue(UtilityFunctions.getID(expr_arg1) instanceof Property);
		EObject expr_arg2 = UtilityFunctions.getArg(expr, 2);
		assertNotNull(expr_arg2);
		assertTrue(expr_arg2 instanceof RealExpr);
		EObject expr_arg2_val = UtilityFunctions.getVal(expr_arg2);
		assertNotNull(expr_arg2_val);
		assertTrue(expr_arg2_val instanceof RealLiteral);
		assertTrue(Double.parseDouble(UtilityFunctions.getStringProperty(expr_arg2_val, "value"))==0.0);
		EObject expr_arg2_val_unit = UtilityFunctions.getUnit(expr_arg2_val);
		assertNotNull(expr_arg2_val_unit);
		assertTrue(expr_arg2_val_unit instanceof UnitLiteral);
		assertTrue(UtilityFunctions.getStringProperty(expr_arg2_val_unit, "name").equals("kg"));

	}
	
	public void testBudgetCaseSubcomponentsHaveWeightBudgetFailDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SubcomponentsHaveWeightBudgetFail");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("self"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof FunctionBody);
		EObject body_type = UtilityFunctions.getType(body);
		assertNotNull(body_type);
		assertTrue(body_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(body_type, "type").equals("bool"));
		
		EObject expr0 = UtilityFunctions.getExpr(body);
		assertNotNull(expr0);
		assertTrue(expr0 instanceof LetExpr);
		EObject binding = UtilityFunctions.getBinding(expr0);
		assertNotNull(binding);
		assertTrue(binding instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(binding, "name").equals("ratio"));
		EObject binding_type = UtilityFunctions.getType(binding);
		assertNotNull(binding_type);
		assertTrue(binding_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_type, "type").equals("int"));
		EObject binding_expr = UtilityFunctions.getExpr(binding);
		assertNotNull(binding_expr);
		assertTrue(binding_expr instanceof FnCallExpr);
		EObject binding_fn = UtilityFunctions.getFn(binding_expr);
		assertNotNull(binding_fn);
		assertTrue(binding_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn, "name").equals("SubcomponentWeightBudgetCoveragePercent"));
		EObject binding_fn_arg = UtilityFunctions.getArg(binding_fn, 0);
		assertNotNull(binding_fn_arg);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn_arg, "name").equals("self"));
		EObject binding_fn_arg_type = UtilityFunctions.getType(binding_fn_arg);
		assertNotNull(binding_fn_arg_type);
		assertTrue(binding_fn_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_fn_arg_type, "type").equals("component"));

		EObject expr1 = UtilityFunctions.getExpr(expr0);
		assertNotNull(expr1);
		assertTrue(expr1 instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1, "op").equals("=>"));	
		EObject expr1_left = UtilityFunctions.getLeft(expr1);
		assertNotNull(expr1_left);
		assertTrue(expr1_left instanceof UnaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left, "op").equals("not"));
		EObject expr1_left_expr = UtilityFunctions.getExpr(expr1_left);
		assertNotNull(expr1_left_expr);
		assertTrue(expr1_left_expr instanceof QuantifiedExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_expr, "quant").equals("forall"));
		EObject expr1_left_expr_expr = UtilityFunctions.getExpr(expr1_left_expr);
		assertNotNull(expr1_left_expr_expr);
		assertTrue(expr1_left_expr_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_expr_expr, "fn").equals("has_property"));
		EObject expr1_left_expr_expr_arg0 = UtilityFunctions.getArg(expr1_left_expr_expr, 0);
		assertNotNull(expr1_left_expr_expr_arg0);
		assertTrue(expr1_left_expr_expr_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_expr_expr_arg0), "name").equals("sub"));
		EObject expr1_left_expr_expr_arg0_expr = UtilityFunctions.getExpr(UtilityFunctions.getID(expr1_left_expr_expr_arg0));
		assertNotNull(expr1_left_expr_expr_arg0_expr);
		assertTrue(expr1_left_expr_expr_arg0_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_expr_expr_arg0_expr, "fn").equals("subcomponents"));
		EObject expr1_left_expr_expr_arg0_expr_arg = UtilityFunctions.getArg(expr1_left_expr_expr_arg0_expr, 0);
		assertNotNull(expr1_left_expr_expr_arg0_expr_arg);
		assertTrue(expr1_left_expr_expr_arg0_expr_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_expr_expr_arg0_expr_arg), "name").equals("self"));
		EObject expr1_left_expr_expr_arg0_expr_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(expr1_left_expr_expr_arg0_expr_arg));
		assertNotNull(expr1_left_expr_expr_arg0_expr_arg_type);
		assertTrue(expr1_left_expr_expr_arg0_expr_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_expr_expr_arg0_expr_arg_type, "type").equals("component"));
		EObject expr1_left_expr_expr_arg1 = UtilityFunctions.getArg(expr1_left_expr_expr, 1);
		assertNotNull(expr1_left_expr_expr_arg1);
		assertTrue(expr1_left_expr_expr_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_expr_expr_arg1), "name").equals("GrossWeight"));
		assertTrue(UtilityFunctions.getID(expr1_left_expr_expr_arg1) instanceof Property);
		EObject expr1_right = UtilityFunctions.getRight(expr1);
		assertNotNull(expr1_right);
		assertTrue(expr1_right instanceof FailExpr);
	}
	
	public void testBudgetCaseSubcomponentsHaveWeightBudgetDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SubcomponentsHaveWeightBudget");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("self"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof FunctionBody);
		EObject body_type = UtilityFunctions.getType(body);
		assertNotNull(body_type);
		assertTrue(body_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(body_type, "type").equals("bool"));

		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof QuantifiedExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "quant").equals("forall"));
		EObject expr_arg = UtilityFunctions.getArg(expr, 0);
		assertNotNull(expr_arg);
		assertTrue(expr_arg instanceof QuantArg);
		assertTrue(UtilityFunctions.getStringProperty(expr_arg,"name").equals("sub"));
		EObject expr_arg_expr = UtilityFunctions.getExpr(expr_arg);
		assertNotNull(expr_arg_expr);
		assertTrue(expr_arg_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr_arg_expr, "fn").equals("subcomponents"));
		EObject expr_expr = UtilityFunctions.getExpr(expr);
		assertNotNull(expr_expr);
		assertTrue(expr_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr_expr, "fn").equals("has_property"));
		EObject expr_expr_arg0 = UtilityFunctions.getArg(expr_expr, 0);
		assertNotNull(expr_expr_arg0);
		assertTrue(expr_expr_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_expr_arg0), "name").equals("sub"));
		EObject expr_expr_arg0_expr = UtilityFunctions.getExpr(UtilityFunctions.getID(expr_expr_arg0));
		assertNotNull(expr_expr_arg0_expr);
		assertTrue(expr_expr_arg0_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr_expr_arg0_expr, "fn").equals("subcomponents"));
		EObject expr_expr_arg0_expr_arg = UtilityFunctions.getArg(expr_expr_arg0_expr, 0);
		assertNotNull(expr_expr_arg0_expr_arg);
		assertTrue(expr_expr_arg0_expr_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_expr_arg0_expr_arg), "name").equals("self"));
		EObject expr_expr_arg0_expr_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(expr_expr_arg0_expr_arg));
		assertNotNull(expr_expr_arg0_expr_arg_type);
		assertTrue(expr_expr_arg0_expr_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_expr_arg0_expr_arg_type, "type").equals("component"));
		EObject expr_expr_arg1 = UtilityFunctions.getArg(expr_expr, 1);
		assertNotNull(expr_expr_arg1);
		assertTrue(expr_expr_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_expr_arg1), "name").equals("GrossWeight"));
		assertTrue(UtilityFunctions.getID(expr_expr_arg1) instanceof Property);
	}
	
	public void testBudgetCaseSubcomponentWeightBudgetCoveragePercentDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SubcomponentWeightBudgetCoveragePercent");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("self"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof FunctionBody);
		EObject body_type = UtilityFunctions.getType(body);
		assertNotNull(body_type);
		assertTrue(body_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(body_type, "type").equals("int"));

		EObject expr0 = UtilityFunctions.getExpr(body);
		assertNotNull(expr0);
		assertTrue(expr0 instanceof LetExpr);
		EObject binding = UtilityFunctions.getBinding(expr0);
		assertNotNull(binding);
		assertTrue(binding instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(binding, "name").equals("subs"));
		EObject binding_type = UtilityFunctions.getType(binding);
		assertNotNull(binding_type);
		assertTrue(binding_type instanceof SetType);
		EObject binding_set_type = UtilityFunctions.getType(binding_type);
		assertNotNull(binding_set_type);
		assertTrue(binding_set_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_set_type, "type").equals("component"));
		EObject binding_expr = UtilityFunctions.getExpr(binding);
		assertNotNull(binding_expr);
		assertTrue(binding_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(binding_expr, "fn").equals("subcomponents"));
		EObject binding_expr_arg = UtilityFunctions.getArg(binding_expr, 0);
		assertNotNull(binding_expr_arg);
		assertTrue(binding_expr_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(binding_expr_arg), "name").equals("self"));
		EObject binding_expr_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(binding_expr_arg));
		assertNotNull(binding_expr_arg_type);
		assertTrue(binding_expr_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(binding_expr_arg_type, "type").equals("component"));
		
		EObject expr1 = UtilityFunctions.getExpr(expr0);
		assertNotNull(expr1);
		assertTrue(expr1 instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1, "op").equals("/"));
		
		EObject expr1_left = UtilityFunctions.getLeft(expr1);
		assertNotNull(expr1_left);
		assertTrue(expr1_left instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left, "fn").equals("sum"));
		
		EObject expr1_left_arg = UtilityFunctions.getArg(expr1_left, 0);
		assertNotNull(expr1_left_arg);
		assertTrue(expr1_left_arg instanceof ListFilterMapExpr);
		EObject expr1_left_arg_arg = UtilityFunctions.getArg(expr1_left_arg, 0);
		assertNotNull(expr1_left_arg_arg);
		assertTrue(expr1_left_arg_arg instanceof QuantArg);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_arg_arg, "name").equals("sub"));
		EObject expr1_left_arg_arg_expr = UtilityFunctions.getExpr(expr1_left_arg_arg);
		assertNotNull(expr1_left_arg_arg_expr);
		assertTrue(expr1_left_arg_arg_expr instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_arg_arg_expr), "name").equals("subs"));
		EObject expr1_left_arg_arg_expr_type = UtilityFunctions.getType(UtilityFunctions.getID(expr1_left_arg_arg_expr));
		assertNotNull(expr1_left_arg_arg_expr_type);
		assertTrue(expr1_left_arg_arg_expr_type instanceof SetType);
		EObject expr1_left_arg_arg_expr_set_type = UtilityFunctions.getType(expr1_left_arg_arg_expr_type);
		assertNotNull(expr1_left_arg_arg_expr_set_type);
		assertTrue(expr1_left_arg_arg_expr_set_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_arg_arg_expr_set_type, "type").equals("component"));
		
		EObject expr1_left_filter = UtilityFunctions.getFilter(expr1_left_arg);
		assertNotNull(expr1_left_filter);
		assertTrue(expr1_left_filter instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_left_filter, "fn").equals("has_property"));
		EObject expr1_left_filter_arg0 = UtilityFunctions.getArg(expr1_left_filter, 0);
		assertNotNull(expr1_left_filter_arg0);
		assertTrue(expr1_left_filter_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_filter_arg0), "name").equals("sub"));
		EObject expr1_left_filter_arg0_expr = UtilityFunctions.getExpr(UtilityFunctions.getID(expr1_left_filter_arg0));
		assertNotNull(expr1_left_filter_arg0_expr);
		assertTrue(expr1_left_filter_arg0_expr instanceof IdExpr);
		assertTrue(UtilityFunctions.getID(expr1_left_filter_arg0_expr) instanceof LetBinding);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_filter_arg0_expr), "name").equals("subs"));
		EObject expr1_left_filter_arg1 = UtilityFunctions.getArg(expr1_left_filter, 1);
		assertNotNull(expr1_left_filter_arg1);
		assertTrue(expr1_left_filter_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_left_filter_arg1), "name").equals("GrossWeight"));
		assertTrue(UtilityFunctions.getID(expr1_left_filter_arg1) instanceof Property);

		EObject expr1_left_map = UtilityFunctions.getMap(expr1_left_arg);
		assertNotNull(expr1_left_map);
		assertTrue(expr1_left_map instanceof IntExpr);
		EObject expr1_left_map_val = UtilityFunctions.getVal(expr1_left_map);
		assertNotNull(expr1_left_map_val);
		assertTrue(expr1_left_map_val instanceof IntegerLiteral);
		assertTrue(Integer.parseInt(UtilityFunctions.getStringProperty(expr1_left_map_val, "value")) == 100);
		
		EObject expr1_right = UtilityFunctions.getRight(expr1);
		assertNotNull(expr1_right);
		assertTrue(expr1_right instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr1_right, "fn").equals("length"));
		EObject expr1_right_arg = UtilityFunctions.getArg(expr1_right, 0);
		assertNotNull(expr1_right_arg);
		assertTrue(expr1_right_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr1_right_arg), "name").equals("subs"));
		EObject expr1_right_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(expr1_right_arg));
		assertNotNull(expr1_right_arg_type);
		assertTrue(expr1_right_arg_type instanceof SetType);
		EObject expr1_right_arg_set_type = UtilityFunctions.getType(expr1_right_arg_type);
		assertNotNull(expr1_right_arg_set_type);
		assertTrue(expr1_right_arg_set_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr1_right_arg_set_type, "type").equals("component"));
	}

	
	public void testBudgetCaseAllHaveBudgetsDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "AllHaveBudgets");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("self"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "op").equals("and"));
		EObject expr_left = UtilityFunctions.getLeft(expr);
		
		assertNotNull(expr_left);
		assertTrue(expr_left instanceof FnCallExpr);
		EObject expr_left_arg = UtilityFunctions.getArg(expr_left, 0);
		assertNotNull(expr_left_arg);
		assertTrue(expr_left_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_left_arg), "name").equals("self"));
		EObject expr_left_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(expr_left_arg));
		assertNotNull(expr_left_arg_type);
		assertTrue(expr_left_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_left_arg_type, "type").equals("component"));
		EObject expr_left_fn = UtilityFunctions.getFn(expr_left);
		assertNotNull(expr_left_fn);
		assertTrue(expr_left_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(expr_left_fn, "name").equals("HasWeightBudget"));
		EObject expr_left_fn_arg = UtilityFunctions.getArg(expr_left_fn, 0);
		assertNotNull(expr_left_fn_arg);
		assertTrue(expr_left_fn_arg instanceof Arg);
		assertTrue(UtilityFunctions.getStringProperty(expr_left_fn_arg,"name").equals("t"));
		EObject expr_left_fn_arg_type = UtilityFunctions.getType(expr_left_fn_arg);
		assertNotNull(expr_left_fn_arg_type);
		assertTrue(expr_left_fn_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_left_fn_arg_type, "type").equals("component"));
		
		EObject expr_right = UtilityFunctions.getRight(expr);
		assertNotNull(expr_right);
		assertTrue(expr_right instanceof QuantifiedExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr_right, "quant").equals("forall"));
		EObject expr_right_arg = UtilityFunctions.getArg(expr_right, 0);
		assertNotNull(expr_right_arg);
		assertTrue(expr_right_arg instanceof QuantArg);
		assertTrue(UtilityFunctions.getStringProperty(expr_right_arg, "name").equals("c"));
		EObject expr_right_arg_expr = UtilityFunctions.getExpr(expr_right_arg);
		assertNotNull(expr_right_arg_expr);
		assertTrue(expr_right_arg_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr_right_arg_expr, "fn").equals("subcomponents"));
		EObject expr_right_arg_expr_arg = UtilityFunctions.getArg(expr_right_arg_expr, 0);
		assertNotNull(expr_right_arg_expr_arg);
		assertTrue(expr_right_arg_expr_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_right_arg_expr_arg), "name").equals("self"));
		EObject expr_right_arg_expr_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(expr_right_arg_expr_arg));
		assertNotNull(expr_right_arg_expr_arg_type);
		assertTrue(expr_right_arg_expr_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_right_arg_expr_arg_type, "type").equals("component"));
		
		EObject expr_right_expr = UtilityFunctions.getExpr(expr_right);
		assertNotNull(expr_right_expr);
		assertTrue(expr_right_expr instanceof FnCallExpr);
		EObject expr_right_expr_fn = UtilityFunctions.getFn(expr_right_expr);
		assertNotNull(expr_right_expr_fn);
		assertTrue(expr_right_expr_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(expr_right_expr_fn, "name").equals("AllHaveBudgets"));
		EObject expr_right_expr_fn_arg = UtilityFunctions.getArg(expr_right_expr_fn, 0);
		assertNotNull(expr_right_expr_fn_arg);
		assertTrue(expr_right_expr_fn_arg instanceof Arg);
		assertTrue(UtilityFunctions.getStringProperty(expr_right_expr_fn_arg, "name").equals("self"));
		EObject expr_right_expr_fn_arg_type = UtilityFunctions.getType(expr_right_expr_fn_arg);
		assertNotNull(expr_right_expr_fn_arg_type);
		assertTrue(expr_right_expr_fn_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_right_expr_fn_arg_type, "type").equals("component"));
	}
	
	public void testBudgetCaseHasWeightBudgetDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "HasWeightBudget");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("t"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("component"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof FunctionBody);
		EObject body_type = UtilityFunctions.getType(body);
		assertNotNull(body_type);
		assertTrue(body_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(body_type, "type").equals("bool"));
		
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BinaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "op").equals("=>"));	
		EObject expr_left = UtilityFunctions.getLeft(expr);
		assertNotNull(expr_left);
		assertTrue(expr_left instanceof UnaryExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr_left, "op").equals("not"));
		EObject expr_left_expr = UtilityFunctions.getExpr(expr_left);
		assertNotNull(expr_left_expr);
		assertTrue(expr_left_expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr_left_expr, "fn").equals("has_property"));
		EObject expr_left_expr_arg0 = UtilityFunctions.getArg(expr_left_expr, 0);
		assertNotNull(expr_left_expr_arg0);
		assertTrue(expr_left_expr_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_left_expr_arg0), "name").equals("t"));
		EObject expr_left_expr_arg0_type = UtilityFunctions.getType(UtilityFunctions.getID(expr_left_expr_arg0));
		assertNotNull(expr_left_expr_arg0_type);
		assertTrue(expr_left_expr_arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_left_expr_arg0_type, "type").equals("component"));
		EObject expr_left_expr_arg1 = UtilityFunctions.getArg(expr_left_expr, 1);
		assertNotNull(expr_left_expr_arg1);
		assertTrue(expr_left_expr_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getID(expr_left_expr_arg1) instanceof Property);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_left_expr_arg1), "name").equals("GrossWeight"));
		EObject expr_right = UtilityFunctions.getRight(expr);
		assertNotNull(expr_right);
		assertTrue(expr_right instanceof FailExpr);
	}
	
	public void testBudgetCaseSystemWideReq1Definition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "SystemWideReq1");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof QuantifiedExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "quant").equals("forall"));
		EObject expr_arg = UtilityFunctions.getArg(expr, 0);
		assertNotNull(expr_arg);
		assertTrue(expr_arg instanceof Arg);
		assertTrue(UtilityFunctions.getStringProperty(expr_arg,"name").equals("t"));
		EObject expr_arg_type = UtilityFunctions.getType(expr_arg);
		assertNotNull(expr_arg_type);
		assertTrue(expr_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_arg_type, "type").equals("thread"));
		EObject expr_expr = UtilityFunctions.getExpr(expr);
		assertNotNull(expr_expr);
		assertTrue(expr_expr instanceof FnCallExpr);
		
		
		EObject expr_expr_arg = UtilityFunctions.getArg(expr_expr, 0);
		assertNotNull(expr_expr_arg);
		assertTrue(expr_expr_arg instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_expr_arg), "name").equals("t"));
		EObject expr_expr_arg_type = UtilityFunctions.getType(UtilityFunctions.getID(expr_expr_arg));
		assertNotNull(expr_expr_arg_type);
		assertTrue(expr_expr_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_expr_arg_type, "type").equals("thread"));
		EObject expr_expr_fn = UtilityFunctions.getFn(expr_expr);
		assertNotNull(expr_expr_fn);
		assertTrue(expr_expr_fn instanceof FunctionDefinition);
		assertTrue(UtilityFunctions.getStringProperty(expr_expr_fn, "name").equals("HasPeriod"));
		EObject expr_expr_fn_arg = UtilityFunctions.getArg(expr_expr_fn, 0);
		assertNotNull(expr_expr_fn_arg);
		assertTrue(expr_expr_fn_arg instanceof Arg);
		assertTrue(UtilityFunctions.getStringProperty(expr_expr_fn_arg,"name").equals("t"));
		EObject expr_expr_fn_arg_type = UtilityFunctions.getType(expr_expr_fn_arg);
		assertNotNull(expr_expr_fn_arg_type);
		assertTrue(expr_expr_fn_arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_expr_fn_arg_type, "type").equals("thread"));
	}
	
	public void testBudgetCaseHasPeriodDefinition(EObject parsed_annex_lib) {
		EObject definition = UtilityFunctions.getDefinition(parsed_annex_lib, "HasPeriod");
		assertNotNull(definition);
		assertTrue(definition instanceof FunctionDefinition);
		EObject arg = UtilityFunctions.getArg(definition, 0);
		assertNotNull(arg);
		assertTrue(UtilityFunctions.getStringProperty(arg, "name").equals("t"));
		EObject arg_type = UtilityFunctions.getType(arg);
		assertNotNull(arg_type);
		assertTrue(arg_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(arg_type, "type").equals("thread"));
		EObject body = UtilityFunctions.getClaimBody(definition);
		assertNotNull(body);
		assertTrue(body instanceof ClaimBody);
		EObject expr = UtilityFunctions.getExpr(body);
		assertNotNull(expr);
		assertTrue(expr instanceof BuiltInFnCallExpr);
		assertTrue(UtilityFunctions.getStringProperty(expr, "fn").equals("has_property"));
		EObject expr_arg0 = UtilityFunctions.getArg(expr, 0);
		assertNotNull(expr_arg0);
		assertTrue(expr_arg0 instanceof IdExpr);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_arg0), "name").equals("t"));
		EObject expr_arg0_type = UtilityFunctions.getType(UtilityFunctions.getID(expr_arg0));
		assertNotNull(expr_arg0_type);
		assertTrue(expr_arg0_type instanceof BaseType);
		assertTrue(UtilityFunctions.getStringProperty(expr_arg0_type, "type").equals("thread"));
		EObject expr_arg1 = UtilityFunctions.getArg(expr, 1);
		assertNotNull(expr_arg1);
		assertTrue(expr_arg1 instanceof IdExpr);
		assertTrue(UtilityFunctions.getID(expr_arg1) instanceof Property);
		assertTrue(UtilityFunctions.getStringProperty(UtilityFunctions.getID(expr_arg1), "name").equals("Period"));
	}
}
