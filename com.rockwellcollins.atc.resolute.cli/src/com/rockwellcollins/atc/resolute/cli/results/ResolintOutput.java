package com.rockwellcollins.atc.resolute.cli.results;

import java.util.List;

public class ResolintOutput extends ToolOutput {

	private List<ResolintJsonResult> results;

	public ResolintOutput() {

	}

	public ResolintOutput(ToolOutput output) {
		super(output);
	}

	public List<ResolintJsonResult> getResults() {
		return this.results;
	}

	public void setResults(List<ResolintJsonResult> results) {
		this.results = results;
	}
}
