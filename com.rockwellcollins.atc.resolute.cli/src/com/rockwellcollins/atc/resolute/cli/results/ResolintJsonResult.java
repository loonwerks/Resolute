package com.rockwellcollins.atc.resolute.cli.results;

public class ResolintJsonResult {

	public final static String WARNING = "warning";
	public final static String ERROR = "error";

	private String rule;
	private boolean status;
	private String severity;
	private String element;
	private String file;
	private int line;

	public String getRule() {
		return this.rule;
	}

	public boolean getStatus() {
		return this.status;
	}

	public String getSeverity() {
		return this.severity;
	}

	public String getElement() {
		return this.element;
	}

	public String getFile() {
		return this.file;
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

	public void setElement(String element) {
		this.element = element;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public void setLine(int line) {
		this.line = line;
	}

}
