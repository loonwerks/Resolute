package com.rockwellcollins.atc.resolute.cli.results;

public class ResolintOutput {

	private String rule;
	private boolean status;
	private String severity;
	private int line;

	public ResolintOutput() {

	}

	public String getRule() {
		return this.rule;
	}

	public boolean getStatus() {
		return this.status;
	}

	public String getSeverity() {
		return this.severity;
	}

	public int getLine() {
		return this.line;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public void setLine(int line) {
		this.line = line;
	}
}
