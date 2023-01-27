package com.rockwellcollins.atc.resolute.cli.results;

import java.util.List;

public class CommandLineOutput {
	private String date;
	private String project;
	private String component;
	private String status;
	private String message;
	private SyntaxValidationResults syntaxValidation;
	private List<ResoluteOutput> resolute;
	private List<ResolintOutput> resolint;

	public final static String COMPLETED = "Analysis Completed";
	public final static String INTERRUPTED = "Analysis Interrupted";

	public CommandLineOutput() {

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

	public List<ResoluteOutput> getResoluteOutput() {
		return this.resolute;
	}

	public List<ResolintOutput> getResolintOutput() {
		return this.resolint;
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
		this.message = message;
	}

	public void setSyntaxValidationResults(SyntaxValidationResults syntaxValidationResults) {
		this.syntaxValidation = syntaxValidationResults;
	}

	public void setResoluteOutput(List<ResoluteOutput> resoluteOutput) {
		this.resolute = resoluteOutput;
	}

	public void setResolintOutput(List<ResolintOutput> resolintOutput) {
		this.resolint = resolintOutput;
	}

}
