package com.rockwellcollins.atc.resolute.cli;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.aadl2.parsesupport.LocationReference;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.annexsupport.AnnexUtil;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;

import com.google.inject.Injector;
import com.rockwellcollins.atc.resolute.ResoluteStandaloneSetup;
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter;
import com.rockwellcollins.atc.resolute.analysis.results.ResolintResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.cli.results.ResolintJsonResult;
import com.rockwellcollins.atc.resolute.cli.results.ResolintOutput;
import com.rockwellcollins.atc.resolute.cli.results.SyntaxValidationResults;
import com.rockwellcollins.atc.resolute.cli.results.ToolOutput;
import com.rockwellcollins.atc.resolute.resolute.AnalysisStatement;
import com.rockwellcollins.atc.resolute.resolute.CheckStatement;
import com.rockwellcollins.atc.resolute.resolute.Definition;
import com.rockwellcollins.atc.resolute.resolute.IdExpr;
import com.rockwellcollins.atc.resolute.resolute.LintStatement;
import com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;
import com.rockwellcollins.atc.resolute.resolute.Ruleset;

/** Adapted from sireum Phantom CLI and OSATE Using annex extensions in stand alone applications
 * https://github.com/sireum/osate-plugin/blob/master/org.sireum.aadl.osate.cli/src/org/sireum/aadl/osate/cli/Phantom.java
 * https://github.com/sireum/osate-plugin/blob/master/org.sireum.aadl.osate/src/main/java/org/sireum/aadl/osate/util/AadlProjectUtil.java
 * https://github.com/osate/osate2/wiki/Using-annex-extensions-in-stand-alone-applications
 * https://github.com/osate/osate2/tree/1388_stand_alone_property_sets/standalone_tests
 */

public class Resolint implements IApplication {

	private final static String HELP = "h";
	private final static String DATA = "data";
	private final static String APPLICATION = "application";
	private final static String NO_SPLASH = "noSplash";
	private final static String PROJECT_PATH = "p";
	private final static String COMP_IMPL = "c";
	private final static String OUTPUT = "o";
	private final static String RETURN_PASSING_RESULTS = "a";
	private final static String VALIDATION_ONLY = "v";
	private final static String EXIT_ON_VALIDATION_WARNING = "w";
	private final static String FILES = "f";
	private final static String RULESETS = "u";

	@Override
	public Object start(IApplicationContext context) throws Exception {

		System.out.println("Starting analysis");

		context.applicationRunning();

		// Output Json object
		final ResolintOutput output = new ResolintOutput();
		output.setDate((new Date()).toString());

		// Process command line options
		final Path workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toPath();
		Path projPath = null;
		String component = null;
		Path outputPath = null;
		String[] fileArray = null;
		String[] resolintRulesetList = null;
		boolean exitOnValidationWarning = false;
		boolean validationOnly = false;
		boolean returnPassingResults = false;
		boolean exit = false;

		final String[] args = (String[]) context.getArguments().get("application.args");
		System.out.println("Application args: " + Arrays.toString(args));
		System.out.println("Workspace: " + workspace);

		// create Options
		final Options options = new Options();
		options.addOption(HELP, "help", false, "print this message");
		options.addOption(NO_SPLASH, false, "optional, hide the splash screen, default false");
		options.addOption(DATA, true, "required, path of workspace");
		options.addOption(APPLICATION, true,
				"required, the name of this analysis (com.rockwellcollins.atc.resolute.cli.Resolint)");
		options.addOption(PROJECT_PATH, "project", true, "optional, project path relative to workspace");
		options.addOption(COMP_IMPL, "compImpl", true, "qualified component implementation name");
		options.addOption(OUTPUT, "output", true, "output JSON file absolute path");
		options.addOption(RETURN_PASSING_RESULTS, "returnPassingResults", false,
				"Return passing Resolint results, default false");
		options.addOption(VALIDATION_ONLY, "validationOnly", false, "validation only, default false");
		options.addOption(EXIT_ON_VALIDATION_WARNING, "exitOnValidtionWarning", false,
				"exit on validation warning, default false");
		Option option = new Option(FILES, "files", true, "Supplementary AADL files (absolute paths)");
		option.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(option);
		option = new Option(RULESETS, "rulesets", true, "Resolint ruleset name list");
		option.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(option);

		// parse options
		try {
			final CommandLineParser parser = new DefaultParser();
			final CommandLine commandLine = parser.parse(options, args);

			if (commandLine.hasOption(HELP)) {
				exit = true;
				output.setStatus(ToolOutput.INTERRUPTED);
			}
			if (workspace == null) {
				exit = true;
				output.setStatus(ToolOutput.INTERRUPTED);
				output.addStatusMessage("A workspace must be specified.");
			}
			if (commandLine.hasOption(COMP_IMPL)) {
				component = commandLine.getOptionValue(COMP_IMPL);
				output.setComponent(component);
				// expects qualified name
				if (!component.contains("::")) {
					output.setStatus(ToolOutput.INTERRUPTED);
					output.addStatusMessage("Component implementation qualified name must be specified.");
					exit = true;
				}
			}
			if (commandLine.hasOption(PROJECT_PATH)) {
				projPath = workspace.resolve(commandLine.getOptionValue(PROJECT_PATH));
			} else {
				projPath = workspace;
			}
			output.setProject(projPath.toString());
			if (commandLine.hasOption(OUTPUT)) {
				outputPath = Paths.get(commandLine.getOptionValue(OUTPUT));
				// Make sure output directory exists and is valid
				try {
					outputPath.getParent().toFile().mkdirs();
				} catch (InvalidPathException e1) {
					exit = true;
					outputPath = null;
					output.addStatusMessage("Invalid output path: " + outputPath + ".");
				} catch (NullPointerException e2) {
					// Do nothing, this is the root directory (which exists)
				} catch (UnsupportedOperationException e3) {
					exit = true;
					outputPath = null;
					output.addStatusMessage("No file system access to output path " + outputPath + ".");
				} catch (SecurityException e4) {
					exit = true;
					outputPath = null;
					output.addStatusMessage("Security settings prohibit writing to output path " + outputPath + ".");
				}
			}
			if (commandLine.hasOption(FILES)) {
				fileArray = commandLine.getOptionValues(FILES);
			}
			if (commandLine.hasOption(RULESETS)) {
				resolintRulesetList = commandLine.getOptionValues(RULESETS);
			}
			if (commandLine.hasOption(RETURN_PASSING_RESULTS)) {
				returnPassingResults = true;
			}
			if (commandLine.hasOption(VALIDATION_ONLY)) {
				validationOnly = true;
			}
			if (commandLine.hasOption(EXIT_ON_VALIDATION_WARNING)) {
				exitOnValidationWarning = true;
			}
			final String[] remainder = commandLine.getArgs();
			for (String argument : remainder) {
				final String message = "WARNING: unknown arguement " + argument
						+ ". See --help for command line options.";
				output.addStatusMessage(message);
				System.err.println(message);
			}
		} catch (ParseException exception) {
			final String message = "Parse error: " + exception.getMessage();
			System.err.println(message);
			output.addStatusMessage(message);
			exit = true;
		}

		if (exit) {
			final HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("osate", options);
			Util.writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		// Initialize the AADL meta model
		final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();

		ResoluteStandaloneSetup.doSetup();

		// Initialize the meta model for instance models -- need both lines
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("aaxl2", new Aadl2ResourceFactoryImpl());
		InstancePackage.eINSTANCE.eClass();

		// Get the resource set from the Injector obtained from initializing the AADL meta model
		final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);

		if (resourceSet == null) {
			output.setStatus(ToolOutput.INTERRUPTED);
			output.addStatusMessage("Unable to initialize resource set");
			Util.writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		// Add plug-in contributions to resource set
		for (URI uri : PluginSupportUtil.getContributedAadl()) {
			resourceSet.getResource(uri, true);
		}

		// Load project AADL files
		try {
			Util.loadProjectAadlFiles(workspace, projPath, fileArray, resourceSet);
		} catch (Exception e) {
			output.setStatus(ToolOutput.INTERRUPTED);
			output.addStatusMessage(e.getMessage());
			Util.writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		// Validate resource set
		final SyntaxValidationResults validationResults = Util.validateResourceSet(resourceSet);
		// Add validation results to output
		output.setSyntaxValidationResults(validationResults);

		// If there are any errors, do not continue
		// Don't continue if user doesn't want any warnings
		// Don't continue if user only wants to validate model
		if (validationResults.getErrors() > 0 || (exitOnValidationWarning && validationResults.getWarnings() > 0)) {
			output.setStatus(ToolOutput.INTERRUPTED);
			output.addStatusMessage("Syntax validation issues found.");
			Util.writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		} else if (validationOnly) {
			output.setStatus(ToolOutput.COMPLETED);
			Util.writeOutput(output, outputPath);
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
				final List<ResolintJsonResult> results = runResolint(evalContext,
						returnPassingResults);

				if (resolintRulesetList != null) {
					final List<ResolintJsonResult> resultsUserRulesets = runResolintUserRule(
							resourceSet, evalContext, resolintRulesetList, returnPassingResults);
					results.addAll(resultsUserRulesets);
				}

				output.setResults(results);
				output.setStatus(ToolOutput.COMPLETED);
				Util.writeOutput(output, outputPath);

			} catch (Exception e) {
				e.printStackTrace();
				output.setStatus(ToolOutput.INTERRUPTED);
				output.addStatusMessage(e.getMessage());
				Util.writeOutput(output, outputPath);
				return IApplication.EXIT_OK;
			}
		} else {
			output.setStatus(ToolOutput.INTERRUPTED);
			output.addStatusMessage("Could not find component implementation in project.");
			Util.writeOutput(output, outputPath);
			return IApplication.EXIT_OK;
		}

		return IApplication.EXIT_OK;
	}

	private List<Ruleset> getResolintRuleSetDefs(XtextResourceSet resourceSet) throws Exception {
		final List<Ruleset> rulesets = new ArrayList<>();

		for (Resource resource : resourceSet.getResources()) {
			if (!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof AadlPackage) {
				final AadlPackage pkg = (AadlPackage) resource.getContents().get(0);
				final EClass resoluteLibEClass = ResolutePackage.eINSTANCE.getResoluteLibrary();
				for (AnnexLibrary lib : AnnexUtil.getAllActualAnnexLibraries(pkg, resoluteLibEClass)) {
					if (lib instanceof ResoluteLibrary) {
						final ResoluteLibrary resoluteLib = (ResoluteLibrary) lib;
						for (Definition def : resoluteLib.getDefinitions()) {
							if (def instanceof Ruleset) {
								final Ruleset ruleset = (Ruleset) def;
								rulesets.add(ruleset);
							}
						}
					}
				}
			}

		}
		return rulesets;
	}

	private List<ResolintJsonResult> runResolintUserRule(XtextResourceSet resourceSet, EvaluationContext context,
			String[] ruleSetsToCheck, boolean returnPassingResults) throws Exception {

		final List<ResoluteResult> checkTrees = new ArrayList<>();

		for (NamedElement el : context.getSet("component")) {
			// Avoid multiple subcomponents causing duplicated lint statements
			if (el == el.getElementRoot()) {
				final ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
				for (String ruleSet : ruleSetsToCheck) {
					boolean match = false;
					for (Ruleset ruleset : getResolintRuleSetDefs(resourceSet)) {
						if (ruleSet.equalsIgnoreCase(ruleset.getName())) {
							match = true;
							for (LintStatement lint : ruleset.getBody().getLintStatements()) {
								checkTrees.add(interpreter.evaluateLintStatement(lint));
							}
						}
						break;
					}
					if (!match) {
						System.err.println("Warning undefined rule set: " + ruleSet);
					}

				}
			}
		}
		// Return output in json format
		return getResolintResults(checkTrees, context.getComponentImplementation(), returnPassingResults);
	}

	private List<ResolintJsonResult> runResolint(EvaluationContext context, boolean returnPassingResults)
			throws Exception {

		final List<ResoluteResult> checkTrees = new ArrayList<>();

		// Get the resolute subclause for the selected component implementation
		for (AnnexSubclause annexSubclause : AnnexUtil.getAllAnnexSubclauses(context.getComponentImplementation(),
				ResolutePackage.eINSTANCE.getResoluteSubclause())) {
			if (annexSubclause instanceof ResoluteSubclause) {
				final ResoluteSubclause resoluteSubclause = (ResoluteSubclause) annexSubclause;
				final ResoluteInterpreter interpreter = new ResoluteInterpreter(context);

				// Evaluate each check statement in selected implementation
				for (AnalysisStatement as : resoluteSubclause.getAnalyses()) {
					if (as instanceof CheckStatement) {
						final CheckStatement cs = (CheckStatement) as;
						// Only evaluate rulesets
						if (cs.getExpr() instanceof IdExpr) {
							final IdExpr idExpr = (IdExpr) cs.getExpr();
							if (idExpr.getId() instanceof Ruleset) {
								final Ruleset ruleset = (Ruleset) idExpr.getId();
								for (LintStatement lint : ruleset.getBody().getLintStatements()) {
									checkTrees.add(interpreter.evaluateLintStatement(lint));
								}
							}
						}
					}
				}
				break;
			}
		}

		// Return output in json format
		return getResolintResults(checkTrees, context.getComponentImplementation(), returnPassingResults);
	}

	private List<ResolintJsonResult> getResolintResults(List<ResoluteResult> results, ComponentImplementation ci,
			boolean returnPassingResults) {

		final List<ResolintJsonResult> resolintJsonResults = new ArrayList<>();

		for (ResoluteResult resoluteResult : results) {

			if (resoluteResult != null && !resoluteResult.isValid()) {
				final ResolintResult result = (ResolintResult) resoluteResult;
				try {
					final Set<EObject> locations = result.getLocations();
					if (locations.isEmpty()) {

						final ResolintJsonResult resolintJsonResult = new ResolintJsonResult();
						resolintJsonResult.setStatus(resoluteResult.isValid());
						resolintJsonResult.setRule(result.getText());

						final int severity = result.getSeverity();
						if (severity == IMarker.SEVERITY_ERROR) {
							resolintJsonResult.setSeverity(ResolintJsonResult.ERROR);
						} else if (severity == IMarker.SEVERITY_WARNING) {
							resolintJsonResult.setSeverity(ResolintJsonResult.WARNING);
						}
						resolintJsonResult.setFile(Util.trimProjectName(ci.eResource().getURI()));
						resolintJsonResult.setLine(getLineNumberFor(ci));
						resolintJsonResults.add(resolintJsonResult);
					} else {
						for (EObject ref : locations) {
							final ResolintJsonResult resolintJsonResult = new ResolintJsonResult();
							resolintJsonResult.setStatus(resoluteResult.isValid());
							resolintJsonResult.setRule(result.getText());
							final int severity = result.getSeverity();
							if (severity == IMarker.SEVERITY_ERROR) {
								resolintJsonResult.setSeverity(ResolintJsonResult.ERROR);
							} else if (severity == IMarker.SEVERITY_WARNING) {
								resolintJsonResult.setSeverity(ResolintJsonResult.WARNING);
							}
							if (ref == null || !(ref instanceof NamedElement)) {
								resolintJsonResult.setElement(ci.getQualifiedName());
								resolintJsonResult.setFile(Util.trimProjectName(ci.eResource().getURI()));
								resolintJsonResult.setLine(getLineNumberFor(ci));
							} else {
								resolintJsonResult.setElement(((NamedElement) ref).getQualifiedName());
								resolintJsonResult.setFile(Util.trimProjectName(ref.eResource().getURI()));
								resolintJsonResult.setLine(getLineNumberFor(ref));
							}
							resolintJsonResults.add(resolintJsonResult);
						}
					}
				} catch (Exception e) {
					continue;
				}
			} else if (returnPassingResults && resoluteResult != null && resoluteResult.isValid()) {
				final ResolintResult result = (ResolintResult) resoluteResult;
				final ResolintJsonResult resolintJsonResult = new ResolintJsonResult();
				resolintJsonResult.setStatus(true);
				resolintJsonResult.setRule(result.getText());
				resolintJsonResults.add(resolintJsonResult);
			}
		}

		return resolintJsonResults;
	}

	private int getLineNumberFor(EObject obj) {
		if (obj == null) {
			return 0;
		}
		if (obj instanceof AObject) {
			final LocationReference locref = ((AObject) obj).getLocationReference();
			if (locref != null) {
				return locref.getLine();
			}
		}
		INode node = null;
		int lineNum = 0;
		final EObject defaultannex = AadlUtil.getContainingDefaultAnnex(obj);
		if (defaultannex != null) {
			node = NodeModelUtils.findActualNodeFor(defaultannex);
			if (node != null) {
				lineNum = node.getStartLine() - 1;
			}
		}

		node = NodeModelUtils.findActualNodeFor(obj);

		if (node != null) {
			return lineNum + node.getStartLine();
		}

		return 0;
	}

	@Override
	public void stop() {

	}

}
