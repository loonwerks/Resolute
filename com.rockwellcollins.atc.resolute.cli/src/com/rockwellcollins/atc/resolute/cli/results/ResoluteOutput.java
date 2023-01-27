package com.rockwellcollins.atc.resolute.cli.results;

import java.util.List;

public class ResoluteOutput {
	private String claim;
	private boolean status;
	private List<ResoluteOutput> subclaims;

	public ResoluteOutput() {

	}

	public String getClaim() {
		return this.claim;
	}

	public boolean getStatus() {
		return this.status;
	}

	public List<ResoluteOutput> getSubclaims() {
		return this.subclaims;
	}

	public void setClaim(String claim) {
		this.claim = claim;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setSubclaims(List<ResoluteOutput> subclaims) {
		if (!subclaims.isEmpty()) {
			this.subclaims = subclaims;
		}
	}
}
