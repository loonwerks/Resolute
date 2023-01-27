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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
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
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Injector;
import com.rockwellcollins.atc.resolute.ResoluteStandaloneSetup;
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap;
import com.rockwellcollins.atc.resolute.analysis.execution.Initializer;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter;
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.FailResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.cli.results.CommandLineOutput;
import com.rockwellcollins.atc.resolute.cli.results.ResoluteOutput;
import com.rockwellcollins.atc.resolute.cli.results.SyntaxValidationIssue;
import com.rockwellcollins.atc.resolute.cli.results.SyntaxValidationResults;
import com.rockwellcollins.atc.resolute.parsing.ResoluteAnnexLinkingService;
import com.rockwellcollins.atc.resolute.parsing.ResoluteAnnexParser;
import com.rockwellcollins.atc.resolute.resolute.AnalysisStatement;
import com.rockwellcollins.atc.resolute.resolute.ArgueStatement;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;
import com.rockwellcollins.atc.resolute.unparsing.ResoluteAnnexUnparser;

/** Adapted from sireum Phantom CLI and OSATE Using annex extensions in stand alone applications
 * https://github.com/sireum/osate-plugin/blob/master/org.sireum.aadl.osate.cli/src/org/sireum/aadl/osate/cli/Phantom.java
 * https://github.com/sireum/osate-plugin/blob/master/org.sireum.aadl.osate/src/main/java/org/sireum/aadl/osate/util/AadlProjectUtil.java
 * https://github.com/osate/osate2/wiki/Using-annex-extensions-in-stand-alone-applications
 * https://github.com/osate/osate2/tree/1388_stand_alone_property_sets/standalone_tests
 */

public class Main implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {

		System.out.println("Starting Resolute analysis");

		context.applicationRunning();

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
		final CommandLineOutput output = new CommandLineOutput();
		output.setDate((new Date()).toString());

		// Process command line options
		String projPath = null;
		String component = null;
		String outputPath = null;
		boolean exitOnValidationWarning = false;
		boolean validationOnly = false;
		boolean exit = false;

		final String[] args = (String[]) context.getArguments().get("application.args");
		System.out.println(Arrays.toString(args));

		for (int i = 0; i < args.length; i++) {
			final String arg = args[i];
			if (arg.equals("-h") || arg.equals("-help")) {
				exit = true;
				output.setStatus(CommandLineOutput.INTERRUPTED);
				output.setMessage(usage());
			}
			// specify project path, root for project aadl files and .project
			else if (arg.equals("-p") || arg.equals("-project")) {
				projPath = args[++i];
				output.setProject(projPath);
				System.out.println("Project = " + projPath);
				// Process .project file references
				final String filePath = String.join(File.separator, projPath, ".project");
				// TODO: handle referenced projects

			} else if (arg.equals("-compImpl")) {
				// expects qualified name
				component = args[++i];
				output.setComponent(component);
				System.out.println("Component implementation = " + component);
				if (!component.contains("::")) {
					output.setStatus(CommandLineOutput.INTERRUPTED);
					output.setMessage("Component implementation qualified name must be specified");
					exit = true;
				}
			} else if (arg.equals("-o") || arg.equals("-output")) {
				outputPath = args[++i];
				System.out.println("Output path = " + outputPath);
			} else if (arg.equals("-v") || arg.equals("-validationOnly")) {
				validationOnly = true;
			} else if (arg.equals("-w") || arg.equals("-exitOnValidationWarning")) {
				exitOnValidationWarning = true;
			} else {
				// invalid argument
				System.err.println("WARNING: unsupported option " + args[i]);
			}
		}

		if (exit) {
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		// Get the resource set from the Injector obtained from initializing the AADL meta model
		final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);

		// Add plug-in contributions to resource set
		if (resourceSet == null) {
			output.setStatus(CommandLineOutput.INTERRUPTED);
			output.setMessage("Unable to initialize resource set");
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		for (URI uri : PluginSupportUtil.getContributedAadl()) {
//			System.out.println(uri.toString());
			resourceSet.getResource(uri, true);
		}

		// Load project specific AADL files
		if (projPath == null) {
			output.setStatus(CommandLineOutput.INTERRUPTED);
			output.setMessage(usage());
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}
		try {
			loadProjectAadlFiles(projPath, resourceSet);
		} catch (Exception e) {
			output.setStatus(CommandLineOutput.INTERRUPTED);
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
			output.setStatus(CommandLineOutput.INTERRUPTED);
			output.setMessage("Syntax validation issues found");
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		} else if (validationOnly) {
			output.setStatus(CommandLineOutput.COMPLETED);
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
				final SystemInstance si = InstantiateModel.buildInstanceModelFile(compImpl);
				final List<ResoluteOutput> results = runResolute(si);
				output.setStatus(CommandLineOutput.COMPLETED);
				output.setResoluteOutput(results);
				writeOutput(output, outputPath);
			} catch (Exception e) {
				e.printStackTrace();
				output.setStatus(CommandLineOutput.INTERRUPTED);
				output.setMessage(e.getMessage());
				writeOutput(output, outputPath);
				return IApplication.EXIT_OK;
			}
		} else {
			output.setStatus(CommandLineOutput.INTERRUPTED);
			output.setMessage("Could not find component implementation in project");
			writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		return IApplication.EXIT_OK;
	}

	private List<ResoluteOutput> runResolute(SystemInstance si) throws Exception {

		final Map<String, SortedSet<NamedElement>> sets = new HashMap<>();
		Initializer.initializeSets(si, sets);
		final FeatureToConnectionsMap featToConnsMap = new FeatureToConnectionsMap(si);

		final List<ResoluteResult> argumentTrees = new ArrayList<>();

		for (NamedElement el : sets.get("component")) {
			final ComponentInstance compInst = (ComponentInstance) el;
			final EClass resoluteSubclauseEClass = ResolutePackage.eINSTANCE.getResoluteSubclause();
			for (AnnexSubclause subclause : AnnexUtil.getAllAnnexSubclauses(compInst.getComponentClassifier(),
					resoluteSubclauseEClass)) {

				if (subclause instanceof ResoluteSubclause) {
					final ResoluteSubclause resoluteSubclause = (ResoluteSubclause) subclause;
					final EvaluationContext context = new EvaluationContext(compInst, sets, featToConnsMap);
					final ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
					for (AnalysisStatement as : resoluteSubclause.getAnalyses()) {
						if (as instanceof ArgueStatement) {
							final ArgueStatement stmt = (ArgueStatement) as;
//							try {
								argumentTrees.add(interpreter.evaluateArgueStatement(stmt));
//							} catch (Exception e) {
//
//							}
						}
					}
				}
			}
		}

		// Return output in json format
		return getResoluteResults(argumentTrees);

	}

	private List<ResoluteOutput> getResoluteResults(List<ResoluteResult> results) {

		final List<ResoluteOutput> resoluteOutputs = new ArrayList<>();

		for (ResoluteResult result : results) {
			final ResoluteOutput resoluteOutput = new ResoluteOutput();
			if (result instanceof ClaimResult) {
				final ClaimResult claimResult = (ClaimResult) result;
				resoluteOutput.setClaim(claimResult.getText());
				resoluteOutput.setStatus(claimResult.isValid());
				final List<ResoluteOutput> childrenResult = getResoluteResults(claimResult.getChildren());
				resoluteOutput.setSubclaims(childrenResult);
			} else if (result instanceof FailResult) {
				final FailResult failResult = (FailResult) result;
				resoluteOutput.setClaim(failResult.getText());
				resoluteOutput.setStatus(failResult.isValid());
				final List<ResoluteOutput> childrenResult = getResoluteResults(failResult.getChildren());
				resoluteOutput.setSubclaims(childrenResult);
			} else {
				continue;
			}
			resoluteOutputs.add(resoluteOutput);
		}

		return resoluteOutputs;
	}

	// Load project specific AADL files
	public void loadProjectAadlFiles(String projPath, XtextResourceSet resourceSet) throws Exception {

		final List<String> projectFiles = findFiles(Paths.get(projPath), "aadl");
		projectFiles.forEach(x -> System.out.println(x));
		final File projectRootDirectory = new File(projPath);
		final File projectFile = new File(projectRootDirectory, ".project");
		final String projName = getProjectName(projectFile);

		for (String pFile : projectFiles) {
			final File projFile = new File(pFile);
			loadFile(projectRootDirectory, projName, projFile, resourceSet);
		}
	}

	// Validation resource set
	private SyntaxValidationResults validateResourceSet(XtextResourceSet resourceSet) {

		final List<SyntaxValidationIssue> syntaxValidationIssues = new ArrayList<>();
		int numErrors = 0;
		int numWarnings = 0;
		for (Resource resource : resourceSet.getResources()) {
			if (resource.getURI().isPlatformResource()) {
				System.out.println("Validating " + resource.getURI().toString());
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
					System.out.println(issue.getMessage());
				}
			}
		}

		return new SyntaxValidationResults(numWarnings, numErrors, syntaxValidationIssues);
	}

	private List<String> findFiles(Path path, String fileExtension) throws Exception {

		if (!Files.isDirectory(path)) {
			throw new IllegalArgumentException("Path must be a directory!");
		}

		List<String> result;

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
		final InputStream stream = url.openConnection().getInputStream();

		final String prefix = "platform:/resource/";
		final String normalizedRelPath = relativize(projectRootDirectory, file).replace("\\", "/");
//		System.out.println(normalizedRelPath);
		// came up with this uri by comparing what OSATE IDE serialized AIR produces
		final URI resourceUri = URI.createURI(prefix + projectName + "/" + normalizedRelPath);
		final Resource res = rs.createResource(resourceUri);
		if (res == null) {
			throw new Exception("Error loading file " + projectName + "/" + normalizedRelPath);
		}
		try {
			res.load(stream, Collections.EMPTY_MAP);
			return res;
		} catch (IOException e) {
//			System.err.println("ERROR LOADING RESOURCE: " + e.getMessage());
			throw new Exception("Error loading file " + projectName + "/" + normalizedRelPath);
		}
	}

	private String relativize(File root, File other) {
		return Paths.get(root.toURI()).relativize(Paths.get(other.toURI())).toString();
	}

	private String getProjectName(File projectFile) throws Exception {
		String marker = "<name>";
		String line = readFile(projectFile).split("\n")[2];
		return line.substring(line.indexOf(marker) + marker.length(), line.indexOf("</name>"));
	}

	private String readFile(File f) throws Exception {
		return new String(Files.readAllBytes(Paths.get(f.toURI())));
	}

	private String usage() {
		// TODO: print usage information
		final StringBuilder usage = new StringBuilder();

		return usage.toString();
	}

	private void writeOutput(CommandLineOutput output, String outputPath) {

		// Convert to json
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			if (outputPath != null) {
				final File outputFile = new File(outputPath);
				final FileWriter jsonWriter = new FileWriter(outputFile);
				gson.toJson(output, new FileWriter(outputFile));
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
