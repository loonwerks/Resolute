package com.rockwellcollins.atc.resolute.cli.results;

import java.util.List;

public class ResolintOutput extends ToolOutput {

	private int warnings;
	private int errors;
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
		this.warnings = 0;
		this.errors = 0;
		for (ResolintJsonResult r : this.results) {
			if (ResolintJsonResult.WARNING.equals(r.getSeverity())) {
				this.warnings++;
			} else if (ResolintJsonResult.ERROR.equals(r.getSeverity())) {
				this.errors++;
			}
		}
	}
}
