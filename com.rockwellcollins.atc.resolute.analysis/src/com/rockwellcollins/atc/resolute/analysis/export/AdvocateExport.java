package com.rockwellcollins.atc.resolute.analysis.export;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.osate.aadl2.NamedElement;

import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.resolute.BinaryExpr;
import com.rockwellcollins.atc.resolute.resolute.BoolExpr;
import com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.ClaimAssumption;
import com.rockwellcollins.atc.resolute.resolute.ClaimBody;
import com.rockwellcollins.atc.resolute.resolute.ClaimContext;
import com.rockwellcollins.atc.resolute.resolute.ClaimJustification;
import com.rockwellcollins.atc.resolute.resolute.ClaimStrategy;
import com.rockwellcollins.atc.resolute.resolute.Expr;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionBody;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.IntExpr;
import com.rockwellcollins.atc.resolute.resolute.LetExpr;
import com.rockwellcollins.atc.resolute.resolute.LibraryFnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.RealExpr;
import com.rockwellcollins.atc.resolute.resolute.SolutionExpr;
import com.rockwellcollins.atc.resolute.resolute.StringExpr;
import com.rockwellcollins.atc.resolute.resolute.UndevelopedExpr;

public class AdvocateExport {

	public static void export(ClaimResult cr) throws IOException {
		List<String> claimNodes = new ArrayList<>();
		List<String> claimLinks = new ArrayList<>();
		StringBuilder str = new StringBuilder();

		// Getting the root resolute result creating a file dialog
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

		// Method call to build the nodes and links for export to AdvoCATE
		exportBuilder(cResult, -1, claimNodes, claimLinks);
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
			List<String> nodes, List<String> links) {
		int currentNodeIndex = -1;
		if (resoluteResult instanceof ClaimResult) {
			ClaimResult claimResult = (ClaimResult) resoluteResult;
			if (claimResult.getLocation() instanceof FunctionDefinition) {
				FunctionDefinition functionDefinition = (FunctionDefinition) claimResult.getLocation();
//				if (functionDefinition.getName().equalsIgnoreCase("agree_property_checked")) {
//					int a = 1;
//				}
				if (functionDefinition.getBody() instanceof ClaimBody) {
					String claim = "  <nodes xsi:type=\"argument:Argument";
					ClaimBody claimBody = (ClaimBody) functionDefinition.getBody();
					String claimText = claimResult.getText();
					if (functionDefinition.getClaimType() == "goal" || functionDefinition.getClaimType() == null) {
						claim += "Goal\" ";
					} else {
						claim += "Strategy\" ";
					}
					claim += "name=\"" + functionDefinition.getName() + "\" description=\"" + claimText + "\"/>"
							+ "\r\n";
					nodes.add(claim);
					if (parentNodeIndex >= 0) {
						String childLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISB_"
								+ functionDefinition.getName() + "\" " + "to=\"//@nodes." + (nodes.size() - 1) + "\" "
								+ "from=\"//@nodes." + parentNodeIndex + "\"/>" + "\r\n";
						links.add(childLink);
					}
					currentNodeIndex = nodes.size() - 1;
					int strategyIndex = buildClaimAttributes(claimBody.getAttributes(), claimResult, currentNodeIndex,
							functionDefinition.getName(), nodes, links);
					if (strategyIndex >= 0) {
						currentNodeIndex = strategyIndex;
					}

					// check for undeveloped expression and add it accordingly
					if (isUndevelopedExpr(claimBody.getExpr())) {
						String currNode = nodes.get(currentNodeIndex);
						String undevelopedNode = currNode.replace("/>", " toBeDeveloped=\"true\"/>");
						nodes.set(currentNodeIndex, undevelopedNode);
					}

					// build solution node for the claim if any
					if (claimResult.isValid()) {
						if (isSolutionExpression(claimBody.getExpr())) {
							String buildNode = "  <nodes xsi:type=\"argument:ArgumentSolution\" name=\"SLN:"
									+ functionDefinition.getName() + "\" description=\"" + claimText + "\"/>"
									+ "\r\n";
							nodes.add(buildNode);
							String buildLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBSLN_"
									+ functionDefinition.getName() + "\" to=\"//@nodes." + (nodes.size() - 1)
									+ "\" from=\"//@nodes." + currentNodeIndex + "\"/>" + "\r\n";
							links.add(buildLink);
						} else {
							buildSolutionNode(claimBody.getExpr(), currentNodeIndex, nodes, links);
						}
					}
				}
			}

			// check for a claim's children and recursively build the nodes and links
			List<ResoluteResult> children = claimResult.getChildren();
			for (ResoluteResult child : children) {
				exportBuilder(child, currentNodeIndex, nodes, links);
			}
		} else if (resoluteResult instanceof ResoluteResult) {
			List<ResoluteResult> children = resoluteResult.getChildren();
			for (ResoluteResult child : children) {
				exportBuilder(child, parentNodeIndex, nodes, links);
			}
		}
	}

	private static int buildClaimAttributes(List<NamedElement> claimAttributes, ClaimResult res,
			int parentNodeIndex, String funcDefName, List<String> cNode, List<String> cLink) {
		int currentNodeIndex = -1;
		for (NamedElement namedElement : claimAttributes) {
			String buildNode = "  <nodes xsi:type=\"argument:Argument";
			String buildLink = "  <links xsi:type=\"egsn:";
			if (namedElement instanceof ClaimContext) {
				ClaimContext claimContext = (ClaimContext) namedElement;
				Map<String, EObject> refs = res.getReferences();
				for (String description : new TreeSet<String>(refs.keySet())) {
					if (refs.get(description).equals(claimContext)) {
						buildNode += "Context\" name=\"" + claimContext.getName() + "\" description=\""
								+ description + "\"/>" + "\r\n";
						cNode.add(buildNode);
						break;
					}
				}
				buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimContext.getName() + "\" "
						+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex + "\"/>"
						+ "\r\n";
				cLink.add(buildLink);
			} else if (namedElement instanceof ClaimAssumption) {
				ClaimAssumption claimAssumption = (ClaimAssumption) namedElement;
				buildNode += "Assumption\" name=\"" + claimAssumption.getName() + "\" description="
						+ claimAssumption.getVal().getValue() + "/>" + "\r\n";
				cNode.add(buildNode);
				buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimAssumption.getName() + "\" "
						+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex + "\"/>"
						+ "\r\n";
				cLink.add(buildLink);
			} else if (namedElement instanceof ClaimJustification) {
				ClaimJustification claimJustification = (ClaimJustification) namedElement;
				buildNode += "Justification\" name=\"" + claimJustification.getName() + "\" description="
						+ claimJustification.getVal().getValue() + "/>" + "\r\n";
				cNode.add(buildNode);
				buildLink += "InContextOf\" name=\"" + funcDefName + "_" + claimJustification.getName() + "\" "
						+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex + "\"/>"
						+ "\r\n";
				cLink.add(buildLink);
			} else if (namedElement instanceof ClaimStrategy) {
				ClaimStrategy claimStrategy = (ClaimStrategy) namedElement;
				buildNode += "Strategy\" name=\"" + claimStrategy.getName() + "\" description="
						+ claimStrategy.getVal().getValue() + "/>" + "\r\n";
				cNode.add(buildNode);
				currentNodeIndex = cNode.size() - 1;
				buildLink += "IsSupportedBy\" name=\"" + funcDefName + "_" + claimStrategy.getName() + "\" "
						+ "to=\"//@nodes." + (cNode.size() - 1) + "\" " + "from=\"//@nodes." + parentNodeIndex + "\"/>"
						+ "\r\n";
				cLink.add(buildLink);
			}
		}
		return currentNodeIndex;
	}

	private static void buildSolutionNode(Expr expr, int parentNodeIndex, List<String> cNode, List<String> cLink) {
		if (expr instanceof LetExpr) {
			LetExpr letExpr = (LetExpr) expr;
			buildSolutionNode(letExpr.getExpr(), parentNodeIndex, cNode, cLink);
		} else if (expr instanceof SolutionExpr) {
			SolutionExpr solutionExpr = (SolutionExpr) expr;
			String buildNode = "  <nodes xsi:type=\"argument:ArgumentSolution\" name=\"" + solutionExpr.getName()
					+ "\" description=" + solutionExpr.getVal().getValue() + "/>" + "\r\n";
			cNode.add(buildNode);
			String buildLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBSLN_" + solutionExpr.getName()
					+ "\" to=\"//@nodes." + (cNode.size() - 1) + "\" from=\"//@nodes."
					+ parentNodeIndex + "\"/>" + "\r\n";
			cLink.add(buildLink);
		}
	}

	private static boolean isSolutionExpression(Expr expr) {
		if (expr instanceof BinaryExpr) {
			BinaryExpr binaryExpr = (BinaryExpr) expr;
			return isSolutionExpression(binaryExpr.getLeft()) && isSolutionExpression(binaryExpr.getRight());
		} else if (expr instanceof LetExpr) {
			LetExpr letExpr = (LetExpr) expr;
			return isSolutionExpression(letExpr.getExpr());
		} else if (expr instanceof FnCallExpr) {
			FnCallExpr fnCallExpr = (FnCallExpr) expr;
			FunctionDefinition functionDefinition = fnCallExpr.getFn();
			if (functionDefinition.getBody() instanceof FunctionBody) {
				return true;
			}
		} else if (expr instanceof BuiltInFnCallExpr) {
			return true;
		} else if (expr instanceof LibraryFnCallExpr) {
			return true;
		} else if (expr instanceof IntExpr || expr instanceof RealExpr || expr instanceof BoolExpr
				|| expr instanceof StringExpr) {
			return true;
		}
		return false;
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

}
