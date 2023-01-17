package com.rockwellcollins.atc.resolute.cli;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;

import com.google.inject.Injector;
import com.rockwellcollins.atc.resolute.ResoluteStandaloneSetup;

public class Main implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {

		System.out.println("Hello World!");

		context.applicationRunning();

		// Read the meta information about the plug-ins to get the annex information.
		// may be slow
		EcorePlugin.ExtensionProcessor.process(null);

		// or load the annexes individually

		// Add the EMV2 annex handling
		// AnnexRegistry.registerAnnex("EMV2", new EMV2AnnexParser(), new EMV2AnnexUnparser(),
		// new EMV2AnnexLinkingService(), null, null, null, null, null);

		final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();

		ResoluteStandaloneSetup.doSetup();


//		if (Platform.getBundle("com.rockwellcollins.atc.resolute") != null) {
//			// addInfo("Setting up Resolute");
//			// ResoluteStandaloneSetup.doSetup();
//			reflectDoSetup("com.rockwellcollins.atc.resolute.ResoluteStandaloneSetup");
//		}

//		if (Platform.getBundle("com.rockwellcollins.atc.agree") != null) {
			// addInfo("Setting up AGREE");
			// AgreeStandaloneSetup.doSetup();
//			reflectDoSetup("com.rockwellcollins.atc.agree.AgreeStandaloneSetup");
//		}
		System.out.println("Goodbye World!");
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {

	}

//	private void reflectDoSetup(String className) {
//		try {
//			Class.forName(className).getMethod("doSetup").invoke(null);
//		} catch (Exception e) {
//			System.out.println("Issue invoking " + className + ".doSetup(): " + e.getMessage());
//			e.printStackTrace();
//		}
//	}

}
