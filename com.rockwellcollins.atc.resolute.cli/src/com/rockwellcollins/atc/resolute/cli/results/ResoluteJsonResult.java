package com.rockwellcollins.atc.resolute.cli.results;

import java.util.List;

public class ResoluteJsonResult {

	private String claim;
	private boolean status;
	private List<ResoluteJsonResult> subclaims;

	public ResoluteJsonResult() {

	}

	public String getClaim() {
		return this.claim;
	}

	public boolean getStatus() {
		return this.status;
	}

	public List<ResoluteJsonResult> getSubclaims() {
		return this.subclaims;
	}

	public void setClaim(String claim) {
		this.claim = claim;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setSubclaims(List<ResoluteJsonResult> subclaims) {
		if (!subclaims.isEmpty()) {
			this.subclaims = subclaims;
		}
	}

}
