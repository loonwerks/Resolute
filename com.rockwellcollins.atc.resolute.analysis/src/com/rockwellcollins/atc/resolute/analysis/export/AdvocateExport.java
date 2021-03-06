package com.rockwellcollins.atc.resolute.analysis.export;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.osate.aadl2.NamedElement;

import com.rockwellcollins.atc.resolute.analysis.Activator;
import com.rockwellcollins.atc.resolute.analysis.preferences.ResolutePreferenceConstants;
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.resolute.BinaryExpr;
import com.rockwellcollins.atc.resolute.resolute.ClaimAssumption;
import com.rockwellcollins.atc.resolute.resolute.ClaimBody;
import com.rockwellcollins.atc.resolute.resolute.ClaimContext;
import com.rockwellcollins.atc.resolute.resolute.ClaimJustification;
import com.rockwellcollins.atc.resolute.resolute.ClaimStrategy;
import com.rockwellcollins.atc.resolute.resolute.Expr;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.LetExpr;
import com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr;
import com.rockwellcollins.atc.resolute.resolute.SolutionExpr;
import com.rockwellcollins.atc.resolute.resolute.UndevelopedExpr;

public class AdvocateExport {

	private static HashSet<String> uniqueLinks = new HashSet<>();

	public static void export(ClaimResult cr) throws IOException {
		uniqueLinks = new HashSet<>();
		List<String> claimNodes = new ArrayList<>();
		List<String> claimLinks = new ArrayList<>();
		HashMap<String, Integer> nodeMap = new HashMap<>();
		StringBuilder str = new StringBuilder();
		boolean isUnique = false;

		// Getting the root resolute result and creating a file dialog
		List<ResoluteResult> result = cr.getChildren();
		ClaimResult cResult = (ClaimResult) result.get(0);
		String claimName = ((FunctionDefinition) cResult.getLocation()).getName();
		FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
		dialog.setText("Resolute - Export to Advocate");
		dialog.setFileName(claimName);
		dialog.setFilterExtensions(new String[] { "*.argument", "*.xml", "*.txt", "*.*" });
		dialog.setFilterIndex(0);
		dialog.setOverwrite(true);
		dialog.setFilterPath(
				ResourceUtil.getFile(cr.getLocation().eResource()).getFullPath().makeAbsolute().toString());
		String fileName = dialog.open();
		if (fileName == null) {
			return;
		}
		FileWriter writer = new FileWriter(fileName, false);
		str.append("<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\r\n");
		str.append(
				"<argument:Argument xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:argument=\"http://www.advocate.arc.nasa.gov/argument\" xmlns:egsn=\"http://www.advocate.arc.nasa.gov/egsn\" name=\""
						+ claimName + "\">" + "\r\n");

		String exportPreference = Activator.getDefault().getPreferenceStore()
				.getString(ResolutePreferenceConstants.EXPORT_NODES_PREFERENCE);
		if (exportPreference.equals(ResolutePreferenceConstants.UNIQUE_NODES)) {
			isUnique = true;
		}
		// Method call to build the nodes and links for export to AdvoCATE
		exportBuilder(cResult, -1, claimNodes, claimLinks, isUnique, nodeMap);
		for (String node : claimNodes) {
			str.append(node);
		}
		for (String link : claimLinks) {
			str.append(link);
		}
		str.append("</argument:Argument>");
		writer.write(str.toString());
		writer.close();
		System.out.println("Resolute result exported to AdvoCATE successfully!");
	}

	/**
	 * Recursive method to walk over the Resolute result tree and build nodes and links for export.
	 * Keeps track of the parentNodeIndex and passes it to the other recursive calls to ensure
	 * correct link building.
	 *
	 * Algorithm logic: If a resolute result is a claim result then build the node and then build
	 * corresponding nodes for its claim attributes. Update the index if an in-line strategy is
	 * encountered. Check if the expression of the claim result is an UndevelopedExpr then update the
	 * appropriate node. Otherwise, check if the expression is a solution expression (either a SolutionExpr or
	 * a function call that is not a claim) then build a node and its corresponding link.
	 *
	 * @param resoluteResult
	 * @param parentNodeIndex
	 * @param nodes
	 * @param links
	 **/
	public static void exportBuilder(ResoluteResult resoluteResult, int parentNodeIndex,
			List<String> nodes, List<String> links, boolean isUniqueNodes, HashMap<String, Integer> nodeNames) {
		int currentNodeIndex = -1;
		if (resoluteResult instanceof ClaimResult) {
			ClaimResult claimResult = (ClaimResult) resoluteResult;
			if (claimResult.getLocation() instanceof FunctionDefinition) {
				FunctionDefinition functionDefinition = (FunctionDefinition) claimResult.getLocation();
				if (functionDefinition.getBody() instanceof ClaimBody) {
					String claim = "  <nodes xsi:type=\"argument:Argument";
					ClaimBody claimBody = (ClaimBody) functionDefinition.getBody();
					String claimText = claimResult.getText();
					if (functionDefinition.getClaimType() == null
							|| functionDefinition.getClaimType().equalsIgnoreCase("goal")) {
						claim += "Goal\" ";
					} else {
						claim += "Strategy\" ";
					}
					if ((!nodeNames.containsKey(functionDefinition.getName()) && !isUniqueNodes) || isUniqueNodes) {
						claim += "name=\"" + functionDefinition.getName() + "\" description=\"" + claimText + "\"/>"
								+ "\r\n";
						nodes.add(claim);
					}
					if (nodeNames.containsKey(functionDefinition.getName())) {
						if (isUniqueNodes) {
							createUniqueNodeName(nodes, functionDefinition.getName());
						}
					} else {
						nodeNames.put(functionDefinition.getName(), nodes.size() - 1);
					}
					int tempNodeIndex = nodes.size() - 1;
					if (parentNodeIndex >= 0) {
						String childLink = "";
						if (nodeNames.containsKey(functionDefinition.getName()) && !isUniqueNodes) {
							childLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBBBBBBB_"
									+ functionDefinition.getName() + "\" " + "to=\"//@nodes."
									+ nodeNames.get(functionDefinition.getName())
									+ "\" " + "from=\"//@nodes." + parentNodeIndex + "\"/>" + "\r\n";
							tempNodeIndex = nodeNames.get(functionDefinition.getName());
						} else {
							childLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISB_"
								+ functionDefinition.getName() + "\" " + "to=\"//@nodes." + (nodes.size() - 1) + "\" "
								+ "from=\"//@nodes." + parentNodeIndex + "\"/>" + "\r\n";
						}
						if (!uniqueLinks.contains(childLink) && !isUniqueNodes) {
							links.add(childLink);
							uniqueLinks.add(childLink);
						} else if (isUniqueNodes) {
							links.add(childLink);
						}
						if ((nodeNames.containsKey(functionDefinition.getName()) && isUniqueNodes)
								|| nodeNames.containsKey(functionDefinition.getName()) && !isUniqueNodes) {
								createUniqueLinkName(links, functionDefinition.getName(), nodes.size());
						}
					}

					currentNodeIndex = buildClaimAttributes(claimBody.getAttributes(), claimResult, tempNodeIndex,
							functionDefinition.getName(), nodes, links, nodeNames, isUniqueNodes);

					// check for undeveloped expression and add it accordingly
					if (isUndevelopedExpr(claimBody.getExpr())) {
						String currNode = nodes.get(currentNodeIndex);
						String undevelopedNode = currNode.replace("/>", " toBeDeveloped=\"true\"/>");
						nodes.set(currentNodeIndex, undevelopedNode);
					}

					// build solution node for the claim if any
					if (claimResult.isValid()) {
						if (isSolutionExpression(claimBody.getExpr())) {
							if ((!nodeNames.containsKey("SLN_" + functionDefinition.getName()) && !isUniqueNodes)
									|| isUniqueNodes) {
								String buildNode = "  <nodes xsi:type=\"argument:ArgumentSolution\" name=\"SLN_"
									+ functionDefinition.getName() + "\" description=\"" + claimText
									+ " (Verified by Resolute)" + "\"/>"
									+ "\r\n";
								nodes.add(buildNode);
							}
							String buildLink = "";
							if (nodeNames.containsKey("SLN_" + functionDefinition.getName()) && !isUniqueNodes) {
								int index = currentNodeIndex;
								if (nodeNames.containsKey(functionDefinition.getName())) {
									if (nodeNames.get(functionDefinition.getName()) == currentNodeIndex) {
										index = nodeNames.get(functionDefinition.getName());
									}
								}
								buildLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBSLN_"
										+ functionDefinition.getName() + "\" to=\"//@nodes."
										+ nodeNames.get("SLN_" + functionDefinition.getName())
										+ "\" from=\"//@nodes." + index + "\"/>" + "\r\n";
							} else {
								buildLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBSLN_"
										+ functionDefinition.getName() + "\" to=\"//@nodes." + (nodes.size() - 1)
										+ "\" from=\"//@nodes." + currentNodeIndex + "\"/>" + "\r\n";
							}
							if (!uniqueLinks.contains(buildLink) && !isUniqueNodes) {
								links.add(buildLink);
								uniqueLinks.add(buildLink);
							} else if (isUniqueNodes) {
								links.add(buildLink);
							}
							if (nodeNames.containsKey("SLN_" + functionDefinition.getName())) {
								if (isUniqueNodes) {
									createUniqueNodeName(nodes, functionDefinition.getName());
									createUniqueLinkName(links, functionDefinition.getName(), nodes.size());
								}
							} else {
								nodeNames.put("SLN_" + functionDefinition.getName(), nodes.size() - 1);
							}
						} else {
							buildSolutionNode(claimBody.getExpr(), currentNodeIndex, nodes, links, nodeNames,
									isUniqueNodes, functionDefinition.getName());
						}
					}
				}
			}

			// check for a claim's children and recursively build the nodes and links
			List<ResoluteResult> children = claimResult.getChildren();
			for (ResoluteResult child : children) {
				exportBuilder(child, currentNodeIndex, nodes, links, isUniqueNodes, nodeNames);
			}
		} else if (resoluteResult instanceof ResoluteResult) {
			List<ResoluteResult> children = resoluteResult.getChildren();
			for (ResoluteResult child : children) {
				exportBuilder(child, parentNodeIndex, nodes, links, isUniqueNodes, nodeNames);
			}
		}
	}

	private static int buildClaimAttributes(List<NamedElement> claimAttributes, ClaimResult res,
			int parentNodeIndex, String funcDefName, List<String> cNode, List<String> cLink, HashMap<String, Integer> nodeNameMap, boolean isUniqueNodes) {

		Map<String, Integer> uniqueNameIndexer = new HashMap<>();
		for (NamedElement namedElement : claimAttributes) {
			int index = parentNodeIndex;
			String buildNode = "  <nodes xsi:type=\"argument:Argument";
			String buildLink = "  <links xsi:type=\"egsn:";
			if (namedElement instanceof ClaimContext) {
				ClaimContext claimContext = (ClaimContext) namedElement;
				// If context was not assigned a name, give it one
				if (claimContext.getName() == null) {
					int idx = uniqueNameIndexer.getOrDefault("C", 1);
					claimContext.setName(funcDefName + "_C" + idx);
					uniqueNameIndexer.put("C", ++idx);
				}
				Map<String, EObject> refs = res.getReferences();
				for (String description : new TreeSet<String>(refs.keySet())) {
					if (refs.get(description).equals(claimContext)) {
						if ((!nodeNameMap.containsKey(claimContext.getName()) && !isUniqueNodes) || isUniqueNodes) {
							buildNode += "Context\" name=\"" + claimContext.getName() + "\" description=\""
								+ description + "\"/>" + "\r\n";
							cNode.add(buildNode);
							break;
						}
					}
				}

				if (nodeNameMap.containsKey(claimContext.getName()) && !isUniqueNodes) {
					if (nodeNameMap.containsKey(funcDefName)) {
						index = nodeNameMap.get(funcDefName);
					}
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimContext.getName() + "\" "
							+ "to=\"//@nodes." + nodeNameMap.get(claimContext.getName()) + "\" " + "from=\"//@nodes."
							+ index + "\"/>" + "\r\n";
				} else {
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimContext.getName() + "\" "
						+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex + "\"/>"
						+ "\r\n";
				}
				if (!uniqueLinks.contains(buildLink) && !isUniqueNodes) {
					cLink.add(buildLink);
					uniqueLinks.add(buildLink);
				} else if (isUniqueNodes) {
					cLink.add(buildLink);
				}
				if (nodeNameMap.containsKey(claimContext.getName())) {
					if (isUniqueNodes) {
						createUniqueNodeName(cNode, claimContext.getName());
						createUniqueLinkName(cLink, claimContext.getName(), cNode.size());
					}
				} else {
					nodeNameMap.put(claimContext.getName(), cNode.size() - 1);
				}
			} else if (namedElement instanceof ClaimAssumption) {
				ClaimAssumption claimAssumption = (ClaimAssumption) namedElement;
				// If assumption was not assigned a name, give it one
				if (claimAssumption.getName() == null) {
					int idx = uniqueNameIndexer.getOrDefault("A", 1);
					claimAssumption.setName(funcDefName + "_A" + idx);
					uniqueNameIndexer.put("A", ++idx);
				}
				Map<String, EObject> refs = res.getReferences();
				for (String description : new TreeSet<String>(refs.keySet())) {
					if (refs.get(description).equals(claimAssumption)) {
						if ((!nodeNameMap.containsKey(claimAssumption.getName()) && !isUniqueNodes) || isUniqueNodes) {
							buildNode += "Assumption\" name=\"" + claimAssumption.getName() + "\" description=\""
									+ description + "\"/>" + "\r\n";
							cNode.add(buildNode);
							break;
						}
					}
				}

				if (nodeNameMap.containsKey(claimAssumption.getName()) && !isUniqueNodes) {
					if (nodeNameMap.containsKey(funcDefName)) {
						index = nodeNameMap.get(funcDefName);
					}
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimAssumption.getName() + "\" "
							+ "to=\"//@nodes." + nodeNameMap.get(claimAssumption.getName()) + "\" " + "from=\"//@nodes."
							+ index + "\"/>"
						+ "\r\n";
				} else {
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimAssumption.getName() + "\" "
							+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex
							+ "\"/>" + "\r\n";
				}
				if (!uniqueLinks.contains(buildLink) && !isUniqueNodes) {
					cLink.add(buildLink);
					uniqueLinks.add(buildLink);
				} else if (isUniqueNodes) {
					cLink.add(buildLink);
				}
				if (nodeNameMap.containsKey(claimAssumption.getName())) {
					if (isUniqueNodes) {
						createUniqueNodeName(cNode, claimAssumption.getName());
						createUniqueLinkName(cLink, claimAssumption.getName(), cNode.size());
					}
				} else {
					nodeNameMap.put(claimAssumption.getName(), cNode.size() - 1);
				}
			} else if (namedElement instanceof ClaimJustification) {
				ClaimJustification claimJustification = (ClaimJustification) namedElement;
				// If justification was not assigned a name, give it one
				if (claimJustification.getName() == null) {
					int idx = uniqueNameIndexer.getOrDefault("J", 1);
					claimJustification.setName(funcDefName + "_J" + idx);
					uniqueNameIndexer.put("J", ++idx);
				}
				if ((!nodeNameMap.containsKey(claimJustification.getName()) && !isUniqueNodes) || isUniqueNodes) {
					buildNode += "Justification\" name=\"" + claimJustification.getName() + "\" description="
						+ claimJustification.getVal().getValue() + "/>" + "\r\n";
					cNode.add(buildNode);
				}

				if (nodeNameMap.containsKey(claimJustification.getName()) && !isUniqueNodes) {
					if (nodeNameMap.containsKey(funcDefName)) {
						index = nodeNameMap.get(funcDefName);
					}
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimJustification.getName() + "\" "
							+ "to=\"//@nodes." + nodeNameMap.get(claimJustification.getName()) + "\" "
							+ "from=\"//@nodes." + index + "\"/>"
						+ "\r\n";
				} else {
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimJustification.getName() + "\" "
							+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex
							+ "\"/>" + "\r\n";
				}
				if (!uniqueLinks.contains(buildLink) && !isUniqueNodes) {
					cLink.add(buildLink);
					uniqueLinks.add(buildLink);
				} else if (isUniqueNodes) {
					cLink.add(buildLink);
				}
				if (nodeNameMap.containsKey(claimJustification.getName())) {
					if (isUniqueNodes) {
						createUniqueNodeName(cNode, claimJustification.getName());
						createUniqueLinkName(cLink, claimJustification.getName(), cNode.size());
					}
				} else {
					nodeNameMap.put(claimJustification.getName(), cNode.size() - 1);
				}
			} else if (namedElement instanceof ClaimStrategy) {
				ClaimStrategy claimStrategy = (ClaimStrategy) namedElement;
				// If strategy was not assigned a name, give it one
				if (claimStrategy.getName() == null) {
					int idx = uniqueNameIndexer.getOrDefault("S", 1);
					claimStrategy.setName(funcDefName + "_S" + idx);
					uniqueNameIndexer.put("S", ++idx);
				}
				if ((!nodeNameMap.containsKey(claimStrategy.getName()) && !isUniqueNodes) || isUniqueNodes) {
					buildNode += "Strategy\" name=\"" + claimStrategy.getName() + "\" description="
						+ claimStrategy.getVal().getValue() + "/>" + "\r\n";
					cNode.add(buildNode);
				}

				if (nodeNameMap.containsKey(claimStrategy.getName()) && !isUniqueNodes) {
					if (nodeNameMap.containsKey(funcDefName)) {
						index = nodeNameMap.get(funcDefName);
					}
					buildLink += "IsSupportedBy\" name=\"" + funcDefName + "_" + claimStrategy.getName() + "\" "
							+ "to=\"//@nodes." + nodeNameMap.get(claimStrategy.getName()) + "\" " + "from=\"//@nodes."
							+ index + "\"/>"
						+ "\r\n";
				} else {
					buildLink += "IsSupportedBy\" name=\"" + funcDefName + "_" + claimStrategy.getName() + "\" "
							+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex
							+ "\"/>" + "\r\n";
				}
				if (!uniqueLinks.contains(buildLink) && !isUniqueNodes) {
					cLink.add(buildLink);
					uniqueLinks.add(buildLink);
				} else if (isUniqueNodes) {
					cLink.add(buildLink);
				}
				if (nodeNameMap.containsKey(claimStrategy.getName())) {
					if (isUniqueNodes) {
						createUniqueNodeName(cNode, claimStrategy.getName());
						createUniqueLinkName(cLink, claimStrategy.getName(), cNode.size());
					}
				} else {
					nodeNameMap.put(claimStrategy.getName(), cNode.size() - 1);
				}
				if (nodeNameMap.containsKey(claimStrategy.getName()) && !isUniqueNodes) {
					parentNodeIndex = nodeNameMap.get(claimStrategy.getName());
				} else if (isUniqueNodes) {
					parentNodeIndex = cNode.size() - 1;
				}
			}
		}
		return parentNodeIndex;
	}

	private static void buildSolutionNode(Expr expr, int parentNodeIndex, List<String> cNode, List<String> cLink,
			HashMap<String, Integer> nodeNameMap, boolean isUniqueNodes, String funcDefName) {
		if (expr instanceof LetExpr) {
			LetExpr letExpr = (LetExpr) expr;
			buildSolutionNode(letExpr.getExpr(), parentNodeIndex, cNode, cLink, nodeNameMap, isUniqueNodes,
					funcDefName);
		} else if (expr instanceof SolutionExpr) {
			SolutionExpr solutionExpr = (SolutionExpr) expr;
			String buildLink = "";
			int index = parentNodeIndex;
			if ((!nodeNameMap.containsKey(solutionExpr.getName()) && !isUniqueNodes) || isUniqueNodes) {
				String buildNode = "  <nodes xsi:type=\"argument:ArgumentSolution\" name=\"" + solutionExpr.getName()
					+ "\" description=" + solutionExpr.getVal().getValue() + "/>" + "\r\n";
				cNode.add(buildNode);
			}
			if (nodeNameMap.containsKey(solutionExpr.getName()) && !isUniqueNodes) {
				if (nodeNameMap.containsKey(funcDefName)) {
					index = nodeNameMap.get(funcDefName);
				}
				buildLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBSLN_" + solutionExpr.getName()
						+ "\" to=\"//@nodes." + nodeNameMap.get(solutionExpr.getName()) + "\" from=\"//@nodes."
						+ index + "\"/>"
					+ "\r\n";
			} else {
				buildLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBSLN_" + solutionExpr.getName()
						+ "\" to=\"//@nodes." + (cNode.size() - 1) + "\" from=\"//@nodes." + parentNodeIndex + "\"/>"
						+ "\r\n";
			}
			if (!uniqueLinks.contains(buildLink) && !isUniqueNodes) {
				cLink.add(buildLink);
				uniqueLinks.add(buildLink);
			} else if (isUniqueNodes) {
				cLink.add(buildLink);
			}
			if (nodeNameMap.containsKey(solutionExpr.getName())) {
				if (isUniqueNodes) {
					createUniqueNodeName(cNode, solutionExpr.getName());
					createUniqueLinkName(cLink, solutionExpr.getName(), cNode.size());
				}
			} else {
				nodeNameMap.put(solutionExpr.getName(), cNode.size() - 1);
			}
		}
	}

	private static boolean isSolutionExpression(Expr expr) {
		if (expr instanceof BinaryExpr) {
			BinaryExpr binaryExpr = (BinaryExpr) expr;
			return isSolutionExpression(binaryExpr.getLeft()) && isSolutionExpression(binaryExpr.getRight());
		} else if (expr instanceof LetExpr) {
			LetExpr letExpr = (LetExpr) expr;
			return isSolutionExpression(letExpr.getExpr());
		} else if (expr instanceof UndevelopedExpr) {
			return false;
		} else if (expr instanceof FnCallExpr) {
			FnCallExpr fnCallExpr = (FnCallExpr) expr;
			FunctionDefinition functionDefinition = fnCallExpr.getFn();
			if (functionDefinition.getBody() instanceof ClaimBody) {
				return false;
			}
		} else if (expr instanceof QuantifiedExpr) {
			QuantifiedExpr quantifiedExpr = (QuantifiedExpr) expr;
			return isSolutionExpression(quantifiedExpr.getExpr());
		} else if (expr instanceof SolutionExpr) {
			return false;
		}
		return true;
	}

	private static boolean isUndevelopedExpr(Expr expr) {
		if (expr instanceof UndevelopedExpr) {
			return true;
		} else if (expr instanceof LetExpr) {
			LetExpr letExpr = (LetExpr) expr;
			return isUndevelopedExpr(letExpr.getExpr());
		}
		return false;
	}

	private static void createUniqueNodeName(List<String> cNode, String currNodeName) {
		String currNode = cNode.get(cNode.size() - 1);
		String updatedNodeName = currNodeName + "_" + cNode.size();
		String updatedNode = currNode.replace(currNodeName, updatedNodeName);
		cNode.set(cNode.size() - 1, updatedNode);
	}

	private static void createUniqueLinkName(List<String> cLink, String currNodeName, int cNodeSize) {
		String currNode = cLink.get(cLink.size() - 1);
		String updatedNodeName = currNodeName + "_" + cNodeSize;
		String updatedNode = currNode.replace(currNodeName, updatedNodeName);
		cLink.set(cLink.size() - 1, updatedNode);
	}
}
