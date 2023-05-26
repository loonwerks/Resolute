package com.rockwellcollins.atc.resolute.tests;

import com.google.inject.Injector;
import com.rockwellcollins.atc.resolute.ResoluteStandaloneSetup;
import org.osate.testsupport.Aadl2InjectorProvider;

public class ResoluteInjectorProvider extends Aadl2InjectorProvider{
	@Override
	protected Injector internalCreateInjector() {
		System.out.println("Initalizing Injector!");
		ResoluteStandaloneSetup.doSetup();
		return super.internalCreateInjector();
	}
}
