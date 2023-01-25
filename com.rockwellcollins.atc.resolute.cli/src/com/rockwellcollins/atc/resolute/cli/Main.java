package com.rockwellcollins.atc.resolute.cli;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;

import com.google.inject.Injector;
import com.rockwellcollins.atc.resolute.ResoluteStandaloneSetup;
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

	@Override
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Hello World!");

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

		// Get the resource set from the Injector obtained from initializing the AADL meta model
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);

		// Add plug-in contributions to resource set
		if (resourceSet != null) {
			List<URI> contributed = PluginSupportUtil.getContributedAadl();
			for (URI uri : contributed) {
				System.out.println(uri.toString());
				resourceSet.getResource(uri, true);
			}

			// Validate resource set
			//	        validateResourceSet(resourceSet);

			String projPath = null;
			String component = null;
			// Process command line options
			final Map<?, ?> args = context.getArguments();
			final String[] appArgs = (String[]) args.get("application.args");
			System.out.println(Arrays.toString(appArgs));

			for (int i = 0; i < appArgs.length; i++) {
				String arg = appArgs[i];
				if (arg.equals("-h")) {
					printUsage();
				}
				// specify project path, root for project aadl files and .project
				else if (arg.equals("-project")) {
					projPath = appArgs[++i];
					System.out.println(projPath);
					// process .project file references
					String projectFileName = new String(".project");
					String filePath = String.join("\\",projPath, projectFileName);
					System.out.println(filePath);
					// TODO: handle reference

					// Load project specific AADL files
					loadProjectAadlFiles(projPath, resourceSet);

				} else if (arg.equals("-compImpl")) {
					// expects qualified name e.g. MC::MissionComputer.Impl
					component = appArgs[++i];
					System.out.println(component);
					// TODO: process component
				} else {
					// invalid argument
					System.err.println("WARNING: unsupported option " + appArgs[i]);
				}
			}

			// Validate resource set
			//	        validateResourceSet(resourceSet);


			//	        Resource res = resourceSet.getResources().get(0);
			//	        if (res == null) {
			//	        	System.out.println("resource = null");
			//	        }
			//
			//	        if (res.getContents() == null) {
			//	        	System.out.println("resource.getContents() = null");
			//	        }
			//
			//	        if (res.getContents().get(0) == null) {
			//	        	System.out.println("resource.getContents().get(0) = null");
			//	        }

			ComponentImplementation compImpl = null;

			// debug
			// java.lang.NullPointerException: Cannot invoke "org.eclipse.xtext.resource.IResourceServiceProvider.get(java.lang.Class)" because "provider" is null
			// at org.osate.annexsupport.AnnexUtil.getInjector(AnnexUtil.java:395)
			// https://github.com/osate/osate2/blob/master/core/org.osate.annexsupport/src/org/osate/annexsupport/AnnexUtil.java

//			Registry registry = IResourceServiceProvider.Registry.INSTANCE;
//			for (String extension : registry.getExtensionToFactoryMap().keySet()) {
//				System.out.println("extension: " + extension);
//				if (!extension.equals("xtend")) {
//					IResourceServiceProvider provider = registry
//						.getResourceServiceProvider(URI.createURI("dummy." + extension));
//				}
//			}

			//	        for (Resource resource : resourceSet.getResources()) {
			for (int k = 0; k < resourceSet.getResources().size(); k++) {
				//        		if (k == 0 || k == 1 || k == 27 || k == 31 || k == 32) continue;
				// if (k == 0 || k == 1) continue;
				System.out.println(k);
				Resource resource = resourceSet.getResources().get(k);
				//        		Resource resource = resourceSet.getResources().get(31);

//				EList<EObject> contents = resource.getContents();

				if (!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof AadlPackage) {
					AadlPackage candidate = (AadlPackage) resource.getContents().get(0);
					if (candidate.getName().equalsIgnoreCase(Aadl2Util.getPackageName(component))
							&& candidate.getOwnedPublicSection() != null
							&& candidate.getOwnedPublicSection().getOwnedClassifiers() != null) {
						Classifier classCand = getResourceByName(component,
								candidate.getOwnedPublicSection().getOwnedClassifiers());

						if (classCand != null) {
							if (classCand instanceof ComponentImplementation) {
								compImpl = (ComponentImplementation) classCand;
								System.out.println("found " + component);
								break;
							} else {
								System.err.println(component + " is a "
										+ classCand.getClass().getSimpleName()
										+ " rather than a system implementation");
								return null;
							}
						}
						break;
					}
				}
			}
			if (compImpl != null) {
				SystemInstance si = null;
				try {
					si = InstantiateModel.buildInstanceModelFile(compImpl);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Goodbye World!");
		return IApplication.EXIT_OK;
	}

	// Load project specific AADL files
	public static void loadProjectAadlFiles (String projPath, XtextResourceSet resourceSet) {
		try {
			List<String> projectFiles = findFiles(Paths.get(projPath), "aadl");
			projectFiles.forEach(x -> System.out.println(x));
			File projectRootDirectory = new File(projPath);
			File projectFile = new File(projectRootDirectory, ".project");
			String projName = getProjectName(projectFile);

			for (String pFile : projectFiles) {
				File projFile = new File(pFile);
				loadFile(projectRootDirectory, projName, projFile, resourceSet);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Validation resource set
	public static void validateResourceSet (XtextResourceSet resourceSet) {
		for (Resource resource : resourceSet.getResources()) {
			System.out.println("*** validating " + resource.getURI().toString() + " ***");
			IResourceValidator validator = ((XtextResource) resource).getResourceServiceProvider()
					.getResourceValidator();
			List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			for (Issue issue : issues) {
				System.out.println(issue.getMessage());
			}
		}
	}

	public static Classifier getResourceByName(String name, EList<Classifier> l) {
		boolean isQualified = name.contains("::");
		for (Classifier oc : l) {
			if (isQualified && oc.getQualifiedName().equals(name)) {
				return oc;
			} else if (oc.getName().equals(name)) {
				return oc;
			}
		}
		return null;
	}

	public static List<String> findFiles(Path path, String fileExtension)
			throws IOException {

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

	public static Resource loadFile(File projectRootDirectory, String projectName, File file, ResourceSet rs) {
		try {
			URL url = new URL("file:" + file.getAbsolutePath());
			InputStream stream = url.openConnection().getInputStream();

			String prefix = "platform:/resource/";
			String normalizedRelPath = relativize(projectRootDirectory, file).replace("\\", "/");
			System.out.println(normalizedRelPath);
			// came up with this uri by comparing what OSATE IDE serialized AIR produces
			URI resourceUri = URI.createURI(prefix + projectName + "/" + normalizedRelPath);
			Resource res = rs.createResource(resourceUri);

			if (res != null) {
				res.load(stream, Collections.EMPTY_MAP);
			}
			return res;
		} catch (IOException e) {
			System.err.println("ERROR LOADING RESOURCE: " + e.getMessage());
			return null;
		}
	}

	public static String relativize(File root, File other) {
		return Paths.get(root.toURI()).relativize(Paths.get(other.toURI())).toString();
	}

	public static String getProjectName(File projectFile) {
		String marker = "<name>";
		String line = readFile(projectFile).split("\n")[2];
		return line.substring(line.indexOf(marker) + marker.length(), line.indexOf("</name>"));
	}

	public static String readFile(File f) {
		try {
			return new String(Files.readAllBytes(Paths.get(f.toURI())));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}

	private static void printUsage() {
		// print usage information
	}

	@Override
	public void stop() {

	}

}
