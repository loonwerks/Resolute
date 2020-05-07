package com.rockwellcollins.atc.resolute.analysis.export;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

	public static void export(ClaimResult cr) throws IOException {
		List<String> claimNodes = new ArrayList<>();
		List<String> claimLinks = new ArrayList<>();
		HashMap<String, Integer> nodeMap = new HashMap<>();
//		int count = 0;
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
//					else if (isUniqueNodes) {
//						claim += "name=\"" + functionDefinition.getName() + "\" description=\"" + claimText + "\"/>"
//								+ "\r\n";
//						nodes.add(claim);
//					}
					if (nodeNames.containsKey(functionDefinition.getName())) {
						if (isUniqueNodes) {
							createUniqueNodeName(nodes, functionDefinition.getName());
						}
					} else {
						nodeNames.put(functionDefinition.getName(), nodes.size() - 1);
					}
					if (parentNodeIndex >= 0) {
						String childLink = "";
						if (nodeNames.containsKey(functionDefinition.getName()) && !isUniqueNodes) {
							childLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISB_"
									+ functionDefinition.getName() + "\" " + "to=\"//@nodes."
									+ nodeNames.get(functionDefinition.getName())
									+ "\" " + "from=\"//@nodes." + parentNodeIndex + "\"/>" + "\r\n";
						} else {
							childLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISB_"
								+ functionDefinition.getName() + "\" " + "to=\"//@nodes." + (nodes.size() - 1) + "\" "
								+ "from=\"//@nodes." + parentNodeIndex + "\"/>" + "\r\n";
						}
						links.add(childLink);
						if (nodeNames.containsKey(functionDefinition.getName())) {
							if (isUniqueNodes) {
								createUniqueLinkName(links, functionDefinition.getName(), nodes.size());
							}
						}
					}

					currentNodeIndex = buildClaimAttributes(claimBody.getAttributes(), claimResult, nodes.size() - 1,
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
							String buildLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBSLN_"
									+ functionDefinition.getName() + "\" to=\"//@nodes." + (nodes.size() - 1)
									+ "\" from=\"//@nodes." + currentNodeIndex + "\"/>" + "\r\n";
							links.add(buildLink);
							if (nodeNames.containsKey("SLN_" + functionDefinition.getName())) {
								if (isUniqueNodes) {
								createUniqueNodeName(nodes, functionDefinition.getName());
								createUniqueLinkName(links, functionDefinition.getName(), nodes.size());
								}
							} else {
								nodeNames.put(functionDefinition.getName(), nodes.size() - 1);
							}
						} else {
							buildSolutionNode(claimBody.getExpr(), currentNodeIndex, nodes, links, nodeNames,
									isUniqueNodes);
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

		for (NamedElement namedElement : claimAttributes) {
			String buildNode = "  <nodes xsi:type=\"argument:Argument";
			String buildLink = "  <links xsi:type=\"egsn:";
			if (namedElement instanceof ClaimContext) {
				ClaimContext claimContext = (ClaimContext) namedElement;
				Map<String, EObject> refs = res.getReferences();
				for (String description : new TreeSet<String>(refs.keySet())) {
					if (refs.get(description).equals(claimContext)) {
						if (!nodeNameMap.containsKey(claimContext.getName()) && !isUniqueNodes) {
							buildNode += "Context\" name=\"" + claimContext.getName() + "\" description=\""
								+ description + "\"/>" + "\r\n";
							cNode.add(buildNode);
							break;
						} else if (isUniqueNodes) {
							buildNode += "Context\" name=\"" + claimContext.getName() + "\" description=\""
									+ description + "\"/>" + "\r\n";
							cNode.add(buildNode);
							break;
						}
					}
				}

//				if (nodeNameMap.containsKey(claimContext.getName())) {
//					if (isUniqueNodes) {
//						createUniqueNodeName(cNode, claimContext.getName());
//					}
//				} else {
//					nodeNameMap.put(claimContext.getName(), cNode.size() - 1);
//				}

				if (nodeNameMap.containsKey(claimContext.getName()) && !isUniqueNodes) {
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimContext.getName() + "\" "
							+ "to=\"//@nodes." + nodeNameMap.get(claimContext.getName()) + "\" " + "from=\"//@nodes."
							+ parentNodeIndex + "\"/>" + "\r\n";
				} else {
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimContext.getName() + "\" "
						+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex + "\"/>"
						+ "\r\n";
				}
				cLink.add(buildLink);
				if (nodeNameMap.containsKey(claimContext.getName()) && isUniqueNodes) {
					createUniqueNodeName(cNode, claimContext.getName());
					createUniqueLinkName(cLink, claimContext.getName(), cNode.size());
				} else {
					nodeNameMap.put(claimContext.getName(), cNode.size() - 1);
				}
			} else if (namedElement instanceof ClaimAssumption) {
				ClaimAssumption claimAssumption = (ClaimAssumption) namedElement;
				if (!nodeNameMap.containsKey(claimAssumption.getName()) && !isUniqueNodes) {
					buildNode += "Assumption\" name=\"" + claimAssumption.getName() + "\" description="
							+ claimAssumption.getVal().getValue() + "/>" + "\r\n";
					cNode.add(buildNode);
				} else if (isUniqueNodes) {
					buildNode += "Assumption\" name=\"" + claimAssumption.getName() + "\" description="
							+ claimAssumption.getVal().getValue() + "/>" + "\r\n";
					cNode.add(buildNode);
				}

//				if (nodeNameMap.containsKey(claimAssumption.getName())) {
//					if (isUniqueNodes) {
//						createUniqueNodeName(cNode, claimAssumption.getName());
//					}
//				} else {
//					nodeNameMap.put(claimAssumption.getName(), cNode.size() - 1);
//				}

				if (nodeNameMap.containsKey(claimAssumption.getName()) && !isUniqueNodes) {
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimAssumption.getName() + "\" "
							+ "to=\"//@nodes." + nodeNameMap.get(claimAssumption.getName()) + "\" " + "from=\"//@nodes."
							+ parentNodeIndex + "\"/>"
						+ "\r\n";
				} else {
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimAssumption.getName() + "\" "
							+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex
							+ "\"/>" + "\r\n";
				}
				cLink.add(buildLink);
				if (nodeNameMap.containsKey(claimAssumption.getName()) && isUniqueNodes) {
					createUniqueNodeName(cNode, claimAssumption.getName());
					createUniqueLinkName(cLink, claimAssumption.getName(), cNode.size());
				} else {
					nodeNameMap.put(claimAssumption.getName(), cNode.size() - 1);
				}
			} else if (namedElement instanceof ClaimJustification) {
				ClaimJustification claimJustification = (ClaimJustification) namedElement;
				if (!nodeNameMap.containsKey(claimJustification.getName()) && !isUniqueNodes) {
					buildNode += "Justification\" name=\"" + claimJustification.getName() + "\" description="
						+ claimJustification.getVal().getValue() + "/>" + "\r\n";
					cNode.add(buildNode);
				} else if (isUniqueNodes) {
					buildNode += "Justification\" name=\"" + claimJustification.getName() + "\" description="
							+ claimJustification.getVal().getValue() + "/>" + "\r\n";
					cNode.add(buildNode);
				}

//				if (nodeNameMap.containsKey(claimJustification.getName())) {
//					if (isUniqueNodes) {
//						createUniqueNodeName(cNode, claimJustification.getName());
//					}
//				} else {
//					nodeNameMap.put(claimJustification.getName(), cNode.size() - 1);
//				}

				if (nodeNameMap.containsKey(claimJustification.getName()) && !isUniqueNodes) {
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimJustification.getName() + "\" "
							+ "to=\"//@nodes." + nodeNameMap.get(claimJustification.getName()) + "\" "
							+ "from=\"//@nodes." + parentNodeIndex + "\"/>"
						+ "\r\n";
				} else {
					buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimJustification.getName() + "\" "
							+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex
							+ "\"/>" + "\r\n";
				}
				cLink.add(buildLink);
				if (nodeNameMap.containsKey(claimJustification.getName()) && isUniqueNodes) {
					createUniqueNodeName(cNode, claimJustification.getName());
					createUniqueLinkName(cLink, claimJustification.getName(), cNode.size());
				} else {
					nodeNameMap.put(claimJustification.getName(), cNode.size() - 1);
				}
			} else if (namedElement instanceof ClaimStrategy) {
				ClaimStrategy claimStrategy = (ClaimStrategy) namedElement;
				if (!nodeNameMap.containsKey(claimStrategy.getName()) && !isUniqueNodes) {
					buildNode += "Strategy\" name=\"" + claimStrategy.getName() + "\" description="
						+ claimStrategy.getVal().getValue() + "/>" + "\r\n";
					cNode.add(buildNode);
				} else if (isUniqueNodes) {
					buildNode += "Strategy\" name=\"" + claimStrategy.getName() + "\" description="
							+ claimStrategy.getVal().getValue() + "/>" + "\r\n";
					cNode.add(buildNode);
				}

//				if (nodeNameMap.containsKey(claimStrategy.getName())) {
//					if (isUniqueNodes) {
//						createUniqueNodeName(cNode, claimStrategy.getName());
//					}
//				} else {
//					nodeNameMap.put(claimStrategy.getName(), cNode.size() - 1);
//				}

				if (nodeNameMap.containsKey(claimStrategy.getName()) && !isUniqueNodes) {
					buildLink += "IsSupportedBy\" name=\"" + funcDefName + "_" + claimStrategy.getName() + "\" "
							+ "to=\"//@nodes." + nodeNameMap.get(claimStrategy.getName()) + "\" " + "from=\"//@nodes."
							+ parentNodeIndex + "\"/>"
						+ "\r\n";
				} else {
					buildLink += "IsSupportedBy\" name=\"" + funcDefName + "_" + claimStrategy.getName() + "\" "
							+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex
							+ "\"/>" + "\r\n";
				}
				cLink.add(buildLink);
				if (nodeNameMap.containsKey(claimStrategy.getName()) && isUniqueNodes) {
					createUniqueNodeName(cNode, claimStrategy.getName());
					createUniqueLinkName(cLink, claimStrategy.getName(), cNode.size());
				} else {
					nodeNameMap.put(claimStrategy.getName(), cNode.size() - 1);
				}
				if (nodeNameMap.containsKey(claimStrategy.getName()) && !isUniqueNodes) {
					parentNodeIndex = nodeNameMap.get(claimStrategy.getName());
				} else if (isUniqueNodes) {
					parentNodeIndex = cNode.size() - 1;
				}
			}
//			if (nodeNameMap.containsKey(namedElement.getName())) {
//				if (isUniqueNodes) {
//					createUniqueNodeName(cNode, namedElement.getName());
//					createUniqueLinkName(cLink, namedElement.getName(), cNode.size());
//				}
//			} else {
//				nodeNameMap.put(namedElement.getName(), cNode.size() - 1);
//			}
		}
		return parentNodeIndex;
	}

	private static void buildSolutionNode(Expr expr, int parentNodeIndex, List<String> cNode, List<String> cLink,
			HashMap<String, Integer> nodeNameMap, boolean isUniqueNodes) {
		if (expr instanceof LetExpr) {
			LetExpr letExpr = (LetExpr) expr;
			buildSolutionNode(letExpr.getExpr(), parentNodeIndex, cNode, cLink, nodeNameMap, isUniqueNodes);
		} else if (expr instanceof SolutionExpr) {
			SolutionExpr solutionExpr = (SolutionExpr) expr;
			String buildNode = "";
			String buildLink = "";
			if (!nodeNameMap.containsKey(solutionExpr.getName()) && !isUniqueNodes) {
				buildNode = "  <nodes xsi:type=\"argument:ArgumentSolution\" name=\"" + solutionExpr.getName()
					+ "\" description=" + solutionExpr.getVal().getValue() + "/>" + "\r\n";
				cNode.add(buildNode);
			} else if (isUniqueNodes) {
				buildNode = "  <nodes xsi:type=\"argument:ArgumentSolution\" name=\"" + solutionExpr.getName()
						+ "\" description=" + solutionExpr.getVal().getValue() + "/>" + "\r\n";
				cNode.add(buildNode);
			}
			if (nodeNameMap.containsKey(solutionExpr.getName()) && !isUniqueNodes) {
				buildLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBSLN_" + solutionExpr.getName()
						+ "\" to=\"//@nodes." + nodeNameMap.get(solutionExpr.getName()) + "\" from=\"//@nodes."
						+ parentNodeIndex + "\"/>"
					+ "\r\n";
			} else {
				buildLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBSLN_" + solutionExpr.getName()
						+ "\" to=\"//@nodes." + (cNode.size() - 1) + "\" from=\"//@nodes." + parentNodeIndex + "\"/>"
						+ "\r\n";
			}
			cLink.add(buildLink);
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
