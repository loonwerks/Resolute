package com.rockwellcollins.atc.resolute.cli.results;

public class ToolOutput {

	public final static String COMPLETED = "Analysis Completed";
	public final static String INTERRUPTED = "Analysis Interrupted";

	private String date;
	private String project;
	private String component;
	private String message;
	private String status;
	private SyntaxValidationResults syntaxValidation;

	public ToolOutput() {

	}

	public ToolOutput(ToolOutput output) {
		setDate(output.getDate());
		setProject(output.getProject());
		setComponent(output.getComponent());
		setMessage(output.getMessage());
		setStatus(output.getStatus());
		setSyntaxValidationResults(output.getSyntaxValidationResults());
	}

	public String getDate() {
		return this.date;
	}

	public String getProject() {
		return this.project;
	}

	public String getComponent() {
		return this.component;
	}

	public String getStatus() {
		return this.status;
	}

	public String getMessage() {
		return this.message;
	}

	public SyntaxValidationResults getSyntaxValidationResults() {
		return this.syntaxValidation;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		if (this.message == null || this.message.isBlank()) {
			this.message = message;
		} else {
			this.message += System.lineSeparator() + message;
		}
	}

	public void setSyntaxValidationResults(SyntaxValidationResults syntaxValidationResults) {
		this.syntaxValidation = syntaxValidationResults;
	}
}
