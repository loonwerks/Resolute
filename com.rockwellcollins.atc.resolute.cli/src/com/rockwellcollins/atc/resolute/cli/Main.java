package com.rockwellcollins.atc.resolute.cli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.google.inject.Injector;
import com.rockwellcollins.atc.resolute.ResoluteStandaloneSetup;
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.cli.results.ResolintJsonResult;
import com.rockwellcollins.atc.resolute.cli.results.ResolintOutput;
import com.rockwellcollins.atc.resolute.cli.results.ResoluteJsonResult;
import com.rockwellcollins.atc.resolute.cli.results.ResoluteOutput;
import com.rockwellcollins.atc.resolute.cli.results.SyntaxValidationIssue;
import com.rockwellcollins.atc.resolute.cli.results.SyntaxValidationResults;
import com.rockwellcollins.atc.resolute.cli.results.ToolOutput;
import com.rockwellcollins.atc.resolute.parsing.ResoluteAnnexLinkingService;
import com.rockwellcollins.atc.resolute.parsing.ResoluteAnnexParser;
import com.rockwellcollins.atc.resolute.unparsing.ResoluteAnnexUnparser;

/** Adapted from sireum Phantom CLI and OSATE Using annex extensions in stand alone applications
 * https://github.com/sireum/osate-plugin/blob/master/org.sireum.aadl.osate.cli/src/org/sireum/aadl/osate/cli/Phantom.java
 * https://github.com/sireum/osate-plugin/blob/master/org.sireum.aadl.osate/src/main/java/org/sireum/aadl/osate/util/AadlProjectUtil.java
 * https://github.com/osate/osate2/wiki/Using-annex-extensions-in-stand-alone-applications
 * https://github.com/osate/osate2/tree/1388_stand_alone_property_sets/standalone_tests
 */

public class Main implements IApplication {

	private final static String HELP = "h";
	private final static String PROJECT = "p";
	private final static String COMP_IMPL = "c";
	private final static String OUTPUT = "o";
	private final static String ANALYSIS = "a";
	private final static String ONLY_RETURN_RULE_VIOLATIONS = "d";
	private final static String VALIDATION_ONLY = "v";
	private final static String EXIT_ON_VALIDATION_WARNING = "w";
	private final static String FILES = "f";
	private final static String RULESETS = "u";

	@Override
	public Object start(IApplicationContext context) throws Exception {

		System.out.println("Starting analysis");

		context.applicationRunning();

		System.out.println("Branding application: " + context.getBrandingApplication());
		System.out.println("Branding name: " + context.getBrandingName());
		System.out.println("Branding description: " + context.getBrandingDescription());
		System.out.println("Branding id: " + context.getBrandingId());
		String launcher = "";
		for (int i = 0; i < Platform.getCommandLineArgs().length; ++i) {
			final String arg = Platform.getCommandLineArgs()[i];
			if ("-launcher".equals(arg.toLowerCase()) && i < Platform.getCommandLineArgs().length - 1) {
				launcher = Platform.getCommandLineArgs()[i + 1];
				break;
			}
		}
		System.out.println("Launcher: " + launcher);

		// Read the meta information about the plug-ins to get the annex information.
		EcorePlugin.ExtensionProcessor.process(null);

		// Register Resolute annex, otherwise get exception when add Resolute annex to resource set
		AnnexRegistry.registerAnnex("Resolute", new ResoluteAnnexParser(), new ResoluteAnnexUnparser(),
				new ResoluteAnnexLinkingService(), null, null, null, null, null);

		// Initialize the AADL meta model
		final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();

		ResoluteStandaloneSetup.doSetup();

		// Initialize the meta model for instance models -- need both lines
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("aaxl2", new Aadl2ResourceFactoryImpl());
		InstancePackage.eINSTANCE.eClass();

		// Output Json object
		final ToolOutput output = new ToolOutput();
		output.setDate((new Date()).toString());

		// Process command line options
		String projPath = null;
		String component = null;
		String outputPath = null;
		String[] fileArray = null;
		String[] resolintRuleList = null;
		boolean exitOnValidationWarning = false;
		boolean validationOnly = false;
		boolean resolute = false;
		boolean resolint = false;
		boolean onlyReturnRuleViolations = true;
		boolean exit = false;

		final String[] args = (String[]) context.getArguments().get("application.args");
		System.out.println(Arrays.toString(args));

		// create Options
		final Options options = new Options();
		options.addOption(HELP, "help", false, "print this message");
		options.addOption(ANALYSIS, "analysis", true, "required, analysis to run [resolute | resolint]");
		options.addOption(PROJECT, "project", true, "required, project root path");
		options.addOption(COMP_IMPL, "compImpl", true, "qualified component implementation name");
		options.addOption(OUTPUT, "output", true, "output JSON file name");
		options.addOption(ONLY_RETURN_RULE_VIOLATIONS, "onlyReturnRuleViolations", false,
				"do not return passing Resolint results, default true");
		options.addOption(VALIDATION_ONLY, "validationOnly", false, "validation only, default false");
		options.addOption(EXIT_ON_VALIDATION_WARNING, "exitOnValidtionWarning", false,
				"exit on validation warning, default false");

		Option option = new Option(FILES, "files", true, "AADL file list");
		option.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(option);

		option = new Option(RULESETS, "rulesets", true, "Resolint ruleset list");
		option.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(option);

		CommandLine commandLine;
		final CommandLineParser parser = new DefaultParser();
		String[] testArgs =
//			{"--project", "D:\\Resolute_Test\\Test", "--compImpl", "test_model::Aircraft.Impl", "--resolute",
//					"-o", "D:\\Resolute_Test\\Test\\HeadlessResoluteResults.json", "-l",
//			"D:\\Phase-2-UAV-Experimental-Platform-Transformed\\CASEAgree2.aadl"};
//				{ "-" + PROJECT, "C:\\Apps\\osate2_2022-06\\runtime-osate2\\Resolute_Test\\Test", "-" + COMP_IMPL,
//						"test_model::Aircraft.Impl", "-" + ANALYSIS + " resolint", "-" + RULESETS, "HAMR_Guidelines", "xyz", "-" + OUTPUT,
//						"C:\\Apps\\osate2_2022-06\\runtime-osate2\\Resolute_Test\\Test\\HeadlessResoluteResults.json" };
				{ "-" + PROJECT, "C:\\Apps\\osate2_2022-06\\runtime-osate2\\Resolute_Test\\Test", "-" + COMP_IMPL,
						"test_model::Aircraft.Impl", "-" + ANALYSIS + " resolute", "-" + OUTPUT,
						"C:\\Apps\\osate2_2022-06\\runtime-osate2\\Resolute_Test\\Test\\HeadlessResoluteResults.json" };

		// parse options
		try {
			commandLine = parser.parse(options, testArgs);
//			commandLine = parser.parse(options, args);

			if (commandLine.hasOption(HELP)) {
				final HelpFormatter formatter = new HelpFormatter();
				// TODO: Get app name (it could be something other than OSATE)
				formatter.printHelp("OSATE", options);
				exit = true;
				output.setStatus(ToolOutput.INTERRUPTED);
			}
			if (commandLine.hasOption(ANALYSIS)) {
				final String analysis = commandLine.getOptionValue(ANALYSIS);
				resolute = "resolute".equals(analysis.toLowerCase());
				resolint = "resolint".equals(analysis.toLowerCase());
			}
			if (commandLine.hasOption(COMP_IMPL)) {
				component = commandLine.getOptionValue(COMP_IMPL);
				output.setComponent(component);
				// expects qualified name
				if (!component.contains("::")) {
					output.setStatus(ToolOutput.INTERRUPTED);
					output.setMessage("Component implementation qualified name must be specified");
					exit = true;
				}
			}
			if (commandLine.hasOption(PROJECT)) {
				projPath = commandLine.getOptionValue(PROJECT);
				output.setProject(projPath);
			}
			if (commandLine.hasOption(OUTPUT)) {
				outputPath = commandLine.getOptionValue(OUTPUT);
			}
			if (commandLine.hasOption(FILES)) {
				fileArray = commandLine.getOptionValues(FILES);
			}
			if (resolint) {
				if (commandLine.hasOption(RULESETS)) {
					resolintRuleList = commandLine.getOptionValues(RULESETS);
				}
				if (commandLine.hasOption(ONLY_RETURN_RULE_VIOLATIONS)) {
					onlyReturnRuleViolations = true;
				}
			}
			if (commandLine.hasOption(VALIDATION_ONLY)) {
				validationOnly = true;
			}
			if (commandLine.hasOption(EXIT_ON_VALIDATION_WARNING)) {
				exitOnValidationWarning = true;
			}
			final String[] remainder = commandLine.getArgs();
			for (String argument : remainder) {
				// TODO Get app name (it could be something other than OSATE)
				System.err.println("WARNING: remainder option " + argument + ". See 'OSATE --help'");
			}
		} catch (ParseException exception) {
			System.out.print("Parse error: ");
			System.out.println(exception.getMessage());
		}

		if (exit) {
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		// Get the resource set from the Injector obtained from initializing the AADL meta model
		final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);

		// Add plug-in contributions to resource set
		if (resourceSet == null) {
			output.setStatus(ToolOutput.INTERRUPTED);
			output.setMessage("Unable to initialize resource set");
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		for (URI uri : PluginSupportUtil.getContributedAadl()) {
			resourceSet.getResource(uri, true);
		}
		// May be redundant, option parser handles it already
		if (projPath == null) {
			output.setStatus(ToolOutput.INTERRUPTED);
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}
		// Load project AADL files
		try {
			loadProjectAadlFiles(projPath, fileArray, resourceSet);
		} catch (Exception e) {
			output.setStatus(ToolOutput.INTERRUPTED);
			output.setMessage(e.getMessage());
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		// Validate resource set
		final SyntaxValidationResults validationResults = validateResourceSet(resourceSet);
		// Add validation results to output
		output.setSyntaxValidationResults(validationResults);

		// If there are any errors, do not continue
		// Don't continue if user doesn't want any warnings
		// Don't continue if user only wants to validate model
		if (validationResults.getErrors() > 0 || (exitOnValidationWarning && validationResults.getWarnings() > 0)) {
			output.setStatus(ToolOutput.INTERRUPTED);
			output.setMessage("Syntax validation issues found");
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		} else if (validationOnly) {
			output.setStatus(ToolOutput.COMPLETED);
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		ComponentImplementation compImpl = null;
		for (Resource resource : resourceSet.getResources()) {

			if (!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof AadlPackage) {
				final AadlPackage pkg = (AadlPackage) resource.getContents().get(0);
				if (pkg.getName().equalsIgnoreCase(Aadl2Util.getPackageName(component))) {

					compImpl = (ComponentImplementation) AadlUtil.findNamedElementInList(
							AadlUtil.getAllComponentImpl(pkg), Aadl2Util.getItemNameWithoutQualification(component));
					break;
				}
			}
		}
		if (compImpl != null) {
			try {
				final SystemInstance si = InstantiateModel.instantiate(compImpl);
				final EvaluationContext evalContext = new EvaluationContext(si);
				if (resolute) {
					final ResoluteOutput resoluteOutput = new ResoluteOutput(output);
					final List<ResoluteJsonResult> results = ResoluteAnalysis.runResolute(evalContext);
					resoluteOutput.setStatus(ToolOutput.COMPLETED);
					resoluteOutput.setResults(results);
					writeOutput(resoluteOutput, outputPath);
				} else if (resolint) {

					final ResolintOutput resolintOutput = new ResolintOutput(output);
					final List<ResolintJsonResult> results = ResolintAnalysis.runResolint(evalContext,
							onlyReturnRuleViolations);

					if (resolintRuleList != null) {
						final List<ResolintJsonResult> resultsUserRule = ResolintAnalysis.runResolintUserRule(
								resourceSet, evalContext, resolintRuleList, onlyReturnRuleViolations);
						final List<ResolintJsonResult> resultsFinal = Stream
								.concat(results.stream(), resultsUserRule.stream())
								.toList();
						resolintOutput.setResults(resultsFinal);
					} else {
						resolintOutput.setResults(results);
					}
					resolintOutput.setStatus(ToolOutput.COMPLETED);
					writeOutput(resolintOutput, outputPath);
				}
			} catch (Exception e) {
				e.printStackTrace();
				output.setStatus(ToolOutput.INTERRUPTED);
				output.setMessage(e.getMessage());
				writeOutput(output, outputPath);
				return IApplication.EXIT_OK;
			}
		} else {
			output.setStatus(ToolOutput.INTERRUPTED);
			output.setMessage("Could not find component implementation in project");
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		return IApplication.EXIT_OK;
	}


	// Load project specific AADL files
	public void loadProjectAadlFiles(String projPath, String[] libArray, XtextResourceSet resourceSet) throws Exception {

		final List<String> projectFiles = findFiles(Paths.get(projPath), "aadl");
		final File projectRootDirectory = new File(projPath);
		final File projectFile = new File(projectRootDirectory, ".project");
		final String projName = getProjectName(projectFile);

		for (String pFile : projectFiles) {
			final File projFile = new File(pFile);
			loadFile(projectRootDirectory, projName, projFile, resourceSet);
		}

		// load user specified AADL libs
		if (libArray != null) {
			for (String libName : libArray) {
				loadLibFile(libName, resourceSet);
			}
		}

		// load referenced project AADL files
		final String projParentPath = projectRootDirectory.getParent();
		final List<String> refProjNames = new ArrayList<>();
		getRefProjName(refProjNames, projName, projParentPath);
		for (String refProjName : refProjNames) {
			// assuming reference project is at the same level of main project
			final File refProj = new File(projParentPath, refProjName);
			final List<String> refProjFileNames = findFiles(refProj.toPath(), "aadl");
			for (String refProjFileName : refProjFileNames) {
				final File refProjFile = new File(refProjFileName);
				loadFile(projectRootDirectory, projName, refProjFile, resourceSet);
			}
		}
	}

	// Validation resource set
	private SyntaxValidationResults validateResourceSet(XtextResourceSet resourceSet) {

		final List<SyntaxValidationIssue> syntaxValidationIssues = new ArrayList<>();
		int numErrors = 0;
		int numWarnings = 0;
		for (Resource resource : resourceSet.getResources()) {
			if (resource.getURI().isPlatformResource()) {
//				System.out.println("Validating " + resource.getURI().toString());
				final IResourceValidator validator = ((XtextResource) resource).getResourceServiceProvider()
						.getResourceValidator();
				final List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
				for (Issue issue : issues) {
					final SyntaxValidationIssue valIssue = new SyntaxValidationIssue();
					if (issue.getSeverity().equals(Severity.ERROR)) {
						++numErrors;
						valIssue.setSeverity("error");
					} else if (issue.getSeverity().equals(Severity.WARNING)) {
						++numWarnings;
						valIssue.setSeverity("warning");
					}
					valIssue.setIssue(issue.getMessage());
					valIssue.setFile(resource.getURI().toPlatformString(true));
					valIssue.setLine(issue.getLineNumber());
					syntaxValidationIssues.add(valIssue);
//					System.out.println(issue.getMessage());
				}
			}
		}

		return new SyntaxValidationResults(numWarnings, numErrors, syntaxValidationIssues);
	}

	private List<String> findFiles(Path path, String fileExtension) throws Exception {

		if (!Files.isDirectory(path)) {
			throw new IllegalArgumentException("Path must be a directory!");
		}

		final List<String> result;

		try (Stream<Path> walk = Files.walk(path)) {
			result = walk
					.filter(p -> !Files.isDirectory(p))
					.map(p -> p.toString().toLowerCase())
					.filter(f -> f.endsWith(fileExtension))
					.collect(Collectors.toList());
		}
		return result;
	}

	/** Adapted from
	 * <a href="https://github.com/osate/osate2/blob/44af9ff8d6309410aeb134a0ae825aa7c916fabf/core/org.osate.testsupport/src/org/osate/testsupport/TestHelper.java#L147">here</a>.
	 *
	 * load file as Xtext resource into resource set
	 * @param filePath String
	 * @param rs ResourceSet
	 * @return
	 */
	//https://github.com/sireum/osate-plugin/blob/master/org.sireum.aadl.osate/src/main/java/org/sireum/aadl/osate/util/AadlProjectUtil.java

	private Resource loadFile(File projectRootDirectory, String projectName, File file, ResourceSet rs)
			throws Exception {

		final URL url = new URL("file:" + file.getAbsolutePath());
		InputStream stream = null;
		try {
			stream = url.openConnection().getInputStream();
		} catch (Exception ex) {
			throw new Exception("Error loading file " + file.toString());
		}

		final String normalizedRelPath = relativize(projectRootDirectory, file).replace("\\", "/");

		// came up with this uri by comparing what OSATE IDE serialized AIR produces
		final URI resourceUri = URI.createPlatformResourceURI(projectName + "/" + normalizedRelPath, true);
		final Resource res = rs.createResource(resourceUri);
		if (res == null) {
			throw new Exception("Error loading file " + projectName + "/" + normalizedRelPath);
		}
		try {
//			System.out.println("Loading " + file.getAbsolutePath());
			res.load(stream, Collections.EMPTY_MAP);
			return res;
		} catch (IOException e) {
			throw new Exception("Error loading file " + projectName + "/" + normalizedRelPath);
		}
	}

	// User specified AADL file path may be outside workspace, cannot use relative path from main project
	private Resource loadLibFile(String filePath, ResourceSet rs) {
		try {
			final URL url = new URL("file:" + filePath);
			final InputStream stream = url.openConnection().getInputStream();

			final Path path = Paths.get(filePath);
			final URI resourceUri = URI.createPlatformResourceURI("Lib/" + path.getFileName().toString(), true);
			final Resource res = rs.createResource(resourceUri);

//			System.out.println("Loading " + filePath);
			res.load(stream, Collections.EMPTY_MAP);
			return res;
		} catch (IOException e) {
//			System.err.println("Error loading file " + filePath);
			return null;
		}
	}

	private String relativize(File root, File other) {
		return Paths.get(root.toURI()).relativize(Paths.get(other.toURI())).toString();
	}

	private String getProjectName(File projectFile) throws Exception {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = factory.newDocumentBuilder();
		final Document doc = builder.parse(projectFile);
		doc.getDocumentElement().normalize();
		final org.w3c.dom.Element root = doc.getDocumentElement();
		final NodeList list = doc.getElementsByTagName("name");

		for (int i = 0; i < list.getLength(); i++) {
			final Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
				final org.w3c.dom.Element element = (org.w3c.dom.Element) node;
            	// "name" tag could be used at lower level e.g. "<buildCommand>"
            	if (element.getParentNode().isEqualNode(root)) {
					return element.getTextContent();
            	}
            }
		}
		throw new Exception("Error getting project name from file " + projectFile.toString());
	}

	// A reference project could depend on another reference project
	private void getRefProjName(List<String> list, String project, String parent) throws Exception {

		final File refProj = new File(parent, project);
		final File projectFile = new File(refProj, ".project");
		final List<String> refProjList = getReferenceProjectName(projectFile);
		if (!refProjList.isEmpty()) {
			for (String refProjName : refProjList) {
				// avoid duplicate and break circular reference
				if (!list.contains(refProjName)) {
					list.add(refProjName);
					getRefProjName(list, refProjName, parent);
				}
            }
		}
	}

	private List<String> getReferenceProjectName(File projectFile) throws Exception {
		final List<String> refProjNameList = new ArrayList<>();
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = factory.newDocumentBuilder();
		final Document doc = builder.parse(projectFile);
		doc.getDocumentElement().normalize();
		final NodeList list = doc.getElementsByTagName("projects");

		for (int i = 0; i < list.getLength(); i++) {
			final Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
				final org.w3c.dom.Element element = (org.w3c.dom.Element) node;
				final Node projNode = element.getElementsByTagName("project").item(0);
            	// Handle empty reference project list
            	if (projNode != null) {
					refProjNameList.add(projNode.getTextContent());
            	}
            }
		}
		return refProjNameList;
	}

	private void writeOutput(ToolOutput output, String outputPath) {

		// Convert to json
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			if (outputPath != null) {
				final File outputFile = new File(outputPath);
				final JsonWriter jsonWriter = new JsonWriter(new FileWriter(outputFile));
				jsonWriter.setIndent("    ");
				gson.toJson(output, output.getClass(), jsonWriter);
				jsonWriter.close();
			}
		} catch (Exception e) {
			System.out.println("Error writing to " + outputPath);
		}

		// Write to std out
		System.out.println(gson.toJson(output));
	}

	@Override
	public void stop() {

	}

}
