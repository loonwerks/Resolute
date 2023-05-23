package com.rockwellcollins.atc.resolute.tests;

import com.rockwellcollins.atc.resolute.ResoluteRuntimeModule;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResoluteRuntimeModuleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBindIGenerator() {
		ResoluteRuntimeModule test = new ResoluteRuntimeModule();
		test.bindIGenerator();
		//fail("Not yet implemented");
	}

	@Test
	public void testBindIQualifiedNameConverter() {
		//fail("Not yet implemented");
	}

	@Test
	public void testBindICrossReferenceSerializer() {
		//fail("Not yet implemented");
	}

}
