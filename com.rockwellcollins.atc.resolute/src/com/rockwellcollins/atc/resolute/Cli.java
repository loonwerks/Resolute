package com.rockwellcollins.atc.resolute;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;

import com.google.inject.Injector;

public class Cli implements IApplication {

//		final boolean debugging = System.getenv().containsKey("DEBUGGING_CLI");

		/**
		 * based on instructions from
		 *
		 * https://github.com/osate/osate2/wiki/Using-annex-extensions-in-stand-alone-applications
		 *
		 * and examples contained in
		 *
		 * https://github.com/osate/osate2/tree/1388_stand_alone_property_sets/standalone_tests
		 *
		 */
		@Override
		public Object start(IApplicationContext context) throws Exception {
			System.out.println("hello world 1");
			
			context.applicationRunning();

			// Read the meta information about the plug-ins to get the annex information.
			// may be slow
			EcorePlugin.ExtensionProcessor.process(null);

			// or load the annexes individually

			// Add the EMV2 annex handling
			// AnnexRegistry.registerAnnex("EMV2", new EMV2AnnexParser(), new EMV2AnnexUnparser(),
			// new EMV2AnnexLinkingService(), null, null, null, null, null);

			final Injector injector = new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();

			// important that this comes next, otherwise emv2 libraries won't resolve
			// see https://github.com/osate/osate2/issues/1387#issuecomment-483739761
//			ErrorModelStandaloneSetup.doSetup();

			if (Platform.getBundle("com.rockwellcollins.atc.resolute") != null) {
				// addInfo("Setting up Resolute");
				// ResoluteStandaloneSetup.doSetup();
				reflectDoSetup("com.rockwellcollins.atc.resolute.ResoluteStandaloneSetup");
			}

//			if (Platform.getBundle("com.rockwellcollins.atc.agree") != null) {
				// addInfo("Setting up AGREE");
				// AgreeStandaloneSetup.doSetup();
//				reflectDoSetup("com.rockwellcollins.atc.agree.AgreeStandaloneSetup");
//			}
			System.out.println("hello world 2");
			return IApplication.EXIT_OK;
		}
		
		private void reflectDoSetup(String className) {
			try {
				Class.forName(className).getMethod("doSetup").invoke(null);
			} catch (Exception e) {
//				addError("Issue invoking " + className + ".doSetup()");
			}
		}

		@Override
		public void stop() {
			// TODO Auto-generated method stub
			
		}
}

