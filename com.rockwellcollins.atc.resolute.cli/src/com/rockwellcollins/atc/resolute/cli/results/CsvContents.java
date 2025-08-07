package com.rockwellcollins.atc.resolute.cli.results;

public class CsvContents {
	private String nodeContents;
	private String edgeContents;
	private int numNodes;
	private int numEdges;

	public CsvContents() {
		nodeContents = "id,ParentID,Name,Status" + System.lineSeparator();
		edgeContents = "id,source,target,thickness,highlighted,color" + System.lineSeparator();
		numNodes = 0;
		numEdges = 0;
	}

	public void appendNode(String claim, int parentId, boolean status) {
		nodeContents += "node" + ++numNodes + "," + (parentId <= 0 ? "NULL" : parentId) + "," + claim + ","
				+ (status ? "TRUE" : "FALSE")
				+ System.lineSeparator();
	}

	public void appendEdge(int srcNodeId, int dstNodeId, boolean status) {
		edgeContents += "edge" + ++numEdges + ",node" + srcNodeId + ",node" + dstNodeId + ",2,TRUE,"
				+ (status ? "green" : "red") + System.lineSeparator();
	}

	public String getNodeContents() {
		return nodeContents;
	}

	public String getEdgeContents() {
		return edgeContents;
	}

	public int getNumNodes() {
		return numNodes;
	}

}
