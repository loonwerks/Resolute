# Resolute Tests
This is the test regression suite for Resolute. There are currently two different types of tests defined in com.rockwellcollins.atc.resolute.tests: parsing and validation tests.

The [UtilityFunctions.java](https://github.com/loonwerks/Resolute/blob/master/com.rockwellcollins.atc.resolute.tests/src/com/rockwellcollins/atc/resolute/tests/UtilityFunctions.java) file has utility functions defined to aid in parsing the EMF model with java (compared to using Xtend). Detailed descriptions of each utility function are included in the comments of the file. When new tests are created, more utility functions can be added as necessary.

## Parsing Resolute Tests
The parsing tests are declared in [ResoluteParsingTest.java](https://github.com/loonwerks/Resolute/blob/master/com.rockwellcollins.atc.resolute.tests/src/com/rockwellcollins/atc/resolute/tests/ResoluteParsingTest.java). This file contains unit tests that test the grammar as defined in [Resolute.xtext](https://github.com/loonwerks/Resolute/blob/master/com.rockwellcollins.atc.resolute/src/com/rockwellcollins/atc/resolute/Resolute.xtext). 

### Adding a New Parsing Test
[ResoluteParsingTest.java](https://github.com/loonwerks/Resolute/blob/master/com.rockwellcollins.atc.resolute.tests/src/com/rockwellcollins/atc/resolute/tests/ResoluteParsingTest.java) is organized in the same order as [Resolute.xtext](https://github.com/loonwerks/Resolute/blob/master/com.rockwellcollins.atc.resolute/src/com/rockwellcollins/atc/resolute/Resolute.xtext) with one large example test at the end (i.e., BudgetCase); therefore, insert new tests where logically appropriate.

To insert a new test, insert `@Test` and then define the test as `public void test{GrammarElement}() throws Exception{...}` (e.g., `public void testImpliesExpr() throws Exception{...}`). Every test should like like this (or something very similar) with its own specific `String test` and testing functionality indicated by `...`:

```
@Test
public void test{GrammarElement}() throws Exception{
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
   ...
}
```
For parsing, these unit tests are checking if the correct instances/values are getting stuffed correctly in the EMF model. The goal is to keep these unit tests as simple as possible to test individual elements of the Resolute grammar. For the larger BudgetCase test, the goal was to test a realistic grammar usage example.

## Validation Resolute Tests
The validation tests are declared in [ResoluteValidationTest.java](https://github.com/loonwerks/Resolute/blob/master/com.rockwellcollins.atc.resolute.tests/src/com/rockwellcollins/atc/resolute/tests/ResoluteValidationTest.java). These file contains unit tests that test the validation checks as defined in [ResoluteValidator.java](https://github.com/loonwerks/Resolute/blob/master/com.rockwellcollins.atc.resolute/src/com/rockwellcollins/atc/resolute/validation/ResoluteValidator.java). 

### Adding a New Validation Test
[ResoluteValidationTest.java](https://github.com/loonwerks/Resolute/blob/master/com.rockwellcollins.atc.resolute.tests/src/com/rockwellcollins/atc/resolute/tests/ResoluteValidationTest.java) is organized in the same order as [ResoluteValidator.java](https://github.com/loonwerks/Resolute/blob/master/com.rockwellcollins.atc.resolute/src/com/rockwellcollins/atc/resolute/validation/ResoluteValidator.java); therefore, insert new tests where logically appropriate.

To insert a new test, insert `@Test` and then define the test as `public void test{GrammarElement}{ValidationCheckDescription}() throws Exception{...}` (e.g., `public void testProveStatementMustContainClaimError() throws Exception{...}`). Every test should like like this (or something very similar) with its own specific `String test` and testing functionality indicated by `...`:

```
@Test
public void test{GrammarElement}{ValidationCheckDescription}() throws Exception{
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
   ...
}
```

For each validation error check, there is exactly one accompanying `public void test{GrammarElement}NoErrors() throws Exception{...}` (e.g., `public void testProveStatementNoError() throws Exception{...}`) declared beforehand. Then, each validation error check has exactly one unit test (i.e., no more than one validation check can be tested per unit test). 

To check if no errors are to be thrown the `...` above in the example unit test will become the following:
```
assertTrue(issueCollection.getIssues().isEmpty());
```
If an error is supposed to be generated, `...` will look like the following:
```
List<Issue> issues = issueCollection.getIssues();
assertFalse(issues.isEmpty());
assertNotNull(UtilityFunctions.getError(issues, "Prove statements must contain a claim"));
```

## Add a New Test File
Adding a new test file is easy! Just create a new file in the [src/com.rockwellcollins.atc.resolute.tests](https://github.com/loonwerks/Resolute/tree/master/com.rockwellcollins.atc.resolute.tests/src/com/rockwellcollins/atc/resolute/tests) that following the naming convention Resolute{TestDescription}Test.java. Follow the parsing and validation tests for reference, and make sure to do the following in the new test file:
   - include `@RunWith(XtextRunner.class)` and `@InjectWith(ResoluteInjectorProvider.class)` before the class definition
   - the new class `extends XTextTest`
   - insert `@Inject TestHelper<ResolutePackage> testHelper;` in the class file

## Run Tests
Tests can be run in two ways:
   1. In Eclipse,
      - Open the Resolute project in Eclipse
      - Right click on com.rockwellcollins.atc.resolute.tests
      - Select `Run As` > `JUnit Plug-in Test`
   2. Using the tycho-surefire plugin
      - Run `mvn clean verify` on the entire Resolute project 
         * This is done automatically through the "Build and Test Project" GitHub Action, which is triggered whenever a push is made to master or a pull request is opened, reopened, or editted


