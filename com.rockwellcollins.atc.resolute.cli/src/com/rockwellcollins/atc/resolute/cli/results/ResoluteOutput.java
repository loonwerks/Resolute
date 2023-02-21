package com.rockwellcollins.atc.resolute.cli.results;

import java.util.List;

public class ResoluteOutput extends ToolOutput {

	private List<ResoluteJsonResult> results;

	public ResoluteOutput() {

	}

	public ResoluteOutput(ToolOutput output) {
		super(output);
	}

	public List<ResoluteJsonResult> getResults() {
		return this.results;
	}

	public void setResults(List<ResoluteJsonResult> results) {
		this.results = results;
	}

}
