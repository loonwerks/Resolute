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
import com.rockwellcollins.atc.resolute.resolute.ClaimAssumption;
import com.rockwellcollins.atc.resolute.resolute.ClaimBody;
import com.rockwellcollins.atc.resolute.resolute.ClaimContext;
import com.rockwellcollins.atc.resolute.resolute.ClaimJustification;
import com.rockwellcollins.atc.resolute.resolute.ClaimStrategy;
import com.rockwellcollins.atc.resolute.resolute.Expr;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionBody;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.LetExpr;
import com.rockwellcollins.atc.resolute.resolute.SolutionExpr;
import com.rockwellcollins.atc.resolute.resolute.UndevelopedExpr;

public class AdvocateExport {

	public static void export(ClaimResult cr) throws IOException {

//		ClaimResult claimResult = cr;
//		HashSet<String> funcNames = new HashSet<>();
//		HashMap<String, Integer> Map = new HashMap<>();
		List<String> claimNodes = new ArrayList<>();
		List<String> claimLinks = new ArrayList<>();
//		StringBuilder str = new StringBuilder();
//		List<ResoluteResult> result = cr.getChildren();
//		ClaimResult cResult = (ClaimResult) result.get(0);
		StringBuilder str = new StringBuilder();
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
//		str.append(
//				"<argument:Argument xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:argument=\"http://www.advocate.arc.nasa.gov/argument\" xmlns:egsn=\"http://www.advocate.arc.nasa.gov/egsn\">"
//						+ "\r\n");
		str.append(
				"<argument:Argument xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:argument=\"http://www.advocate.arc.nasa.gov/argument\" xmlns:egsn=\"http://www.advocate.arc.nasa.gov/egsn\" name=\""
						+ claimName + "\">" + "\r\n");
//		exportBuilder(cResult, Map, claimNodes, claimLinks);
		exportBuilder(cResult, -1, claimNodes, claimLinks);
//		if (claimResult.getLocation() instanceof ProveStatement) {
//			ProveStatement proveStatement = (ProveStatement) claimResult.getLocation();
////			StringBuilder s = exportBuilder(proveStatement.getExpr(), str);
//		Path fileToDeletePath = Paths.get("C:\\Saqib\\Resolute\\docs\\AdvocateText1.txt");
//		Files.delete(fileToDeletePath);

//		Path fileToDeletePath = Paths.get("C:\\Saqib\\Resolute\\docs\\AdvocateText.txt");
//		Files.delete(fileToDeletePath);
//		FileWriter writer = new FileWriter("C:\\Saqib\\Resolute\\docs\\AdvocateText.txt", true);
//		System.out.println(claimNodes);
		for (String node : claimNodes) {
			str.append(node);
		}
		for (String link : claimLinks) {
			str.append(link);
		}
		str.append("</argument:Argument>");
		writer.write(str.toString());
		writer.close();
//		}
		System.out.println("Hello AdvoCATE!!");
	}

//	public static void exportBuilder(ResoluteResult resoluteResult, HashMap<String, Integer> claimMap,
//			List<String> nodes, List<String> links) {
	public static void exportBuilder(ResoluteResult resoluteResult, int parentNodeIndex,
			List<String> nodes, List<String> links) {
//		String claim = "";
		int currentNodeIndex = -1;
		if (resoluteResult instanceof ClaimResult) {
//			String attributes = "";
			String undeveloped = "";
			ClaimResult claimResult = (ClaimResult) resoluteResult;
			if (claimResult.getLocation() instanceof FunctionDefinition) {
				FunctionDefinition functionDefinition = (FunctionDefinition) claimResult.getLocation();
//				if (functionDefinition.getName().equalsIgnoreCase("filter_not_bypassed")) {
//					int a = 1;
//					int b = 2;
//				}
				if (functionDefinition.getBody() instanceof ClaimBody) {
					String claim = "  <nodes xsi:type=\"argument:Argument";
					ClaimBody claimBody = (ClaimBody) functionDefinition.getBody();
					String claimText = claimResult.getText();
//					if (!claimMap.containsKey(functionDefinition.getName())) {
//						Collection<Integer> funcNameValues = claimMap.values();
//						int index = findMaxVal(funcNameValues);
//						for (Integer val : values) {
//							if (index < val) {
//								index = val;
//							}
//						}
//						if (index == 0) {
//							claimMap.put(functionDefinition.getName(), index);
//						} else {
//							claimMap.put(functionDefinition.getName(), index + 1);
//						}
//					}
					if (functionDefinition.getClaimType() == "goal" || functionDefinition.getClaimType() == null) {
//						claim += "Goal ";
						claim += "Goal\" ";
					} else {
//						claim += "Strategy ";
						claim += "Strategy\" ";
					}
					if (isUndevelopedExpr(claimBody.getExpr())) {
						undeveloped = "toBeDeveloped ";
					}
					claim += "name=\"" + functionDefinition.getName() + "\" description=\"" + claimText + "\"/>"
							+ "\r\n";
//					claim += undeveloped + functionDefinition.getName() + " {" + "\r\n" + "\tdescription " + "\""
//							+ claimText
//							+ "\""
//							+ "\r\n" + "}" + "\r\n";
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

					// check for undeveloped and add it accordingly

					// build solution node for the claim if any
					if (claimResult.isValid()) {
						buildSolutionNode(claimBody.getExpr(), currentNodeIndex, nodes, links, claimText);
					}

//					buildClaimAttributes(claimBody.getAttributes(), claimResult, claimMap, functionDefinition.getName(),
//							nodes, links);
//					buildChildLinks(claimResult, claimMap, functionDefinition.getName(), nodes, links);
				}
			}
//			System.out.println(claim);
//			s.append(claim);
//			s.append(attributes);
//			if (!attributes.isEmpty()) {
//				nodes.add(attributes);
//			}
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
//		System.out.println(claimMap);
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

	private static void buildSolutionNode(Expr expr, int parentNodeIndex, List<String> cNode, List<String> cLink,
			String nodeText) {
		String buildNode = "  <nodes xsi:type=\"argument:ArgumentSolution\" name=\"";
		String buildLink = "  <links xsi:type=\"egsn:IsSupportedBy\" name=\"ISBSOL_";
		if (expr instanceof BinaryExpr) {
			BinaryExpr binaryExpr = (BinaryExpr) expr;
			buildSolutionNode(binaryExpr.getLeft(), parentNodeIndex, cNode, cLink, nodeText);
			buildSolutionNode(binaryExpr.getRight(), parentNodeIndex, cNode, cLink, nodeText);
		} else if (expr instanceof LetExpr) {
			LetExpr letExpr = (LetExpr) expr;
			buildSolutionNode(letExpr.getExpr(), parentNodeIndex, cNode, cLink, nodeText);
		} else if (expr instanceof SolutionExpr) {
			SolutionExpr solutionExpr = (SolutionExpr) expr;
			buildNode += solutionExpr.getName() + "\" description=" + solutionExpr.getVal().getValue() + "/>" + "\r\n";
			cNode.add(buildNode);
			buildLink += solutionExpr.getName() + "\" to=\"//@nodes." + (cNode.size() - 1) + "\" from=\"//@nodes."
					+ parentNodeIndex + "\"/>" + "\r\n";
			cLink.add(buildLink);
		} else if (expr instanceof FnCallExpr) {
			FnCallExpr fnCallExpr = (FnCallExpr) expr;
			FunctionDefinition functionDefinition = fnCallExpr.getFn();
			if (functionDefinition.getBody() instanceof FunctionBody) {
				buildNode += functionDefinition.getName() + "\" description=\"" + nodeText + "\"/>" + "\r\n";
				cNode.add(buildNode);
				buildLink += functionDefinition.getName() + "\" to=\"//@nodes." + (cNode.size() - 1)
						+ "\" from=\"//@nodes." + parentNodeIndex + "\"/>" + "\r\n";
				cLink.add(buildLink);
			}
		}
	}

//	private static void buildClaimAttributes(List<NamedElement> claimAttributes, ClaimResult res,
//			HashMap<String, Integer> claimIndexMap, String funcDefName, List<String> cNode, List<String> cLink) {
////		String buildAttribute = "";
//		String buildNode = "";
//		String buildLink = "";
//		for (NamedElement namedElement : claimAttributes) {
////			buildAttribute += "  <nodes xsi:type=\"argument:Argument";
//			buildNode = "  <nodes xsi:type=\"argument:Argument";
//			buildLink = "  <links xsi:type=\"egsn:";
//			if (!claimIndexMap.containsKey(namedElement.getName())) {
//				int index = findMaxVal(claimIndexMap.values());
//				claimIndexMap.put(namedElement.getName(), index + 1);
//			}
//			if (namedElement instanceof ClaimContext) {
//				ClaimContext claimContext = (ClaimContext) namedElement;
//				Map<String, EObject> refs = res.getReferences();
//				for (String description : new TreeSet<String>(refs.keySet())) {
//					if (refs.get(description).equals(claimContext)) {
////						buildAttribute += "Context\" name=\"" + claimContext.getName() + "\" description=\""
////								+ description + "\"/>" + "\r\n";
//						buildNode += "Context\" name=\"" + claimContext.getName() + "\" description=\""
//								+ description + "\"/>" + "\r\n";
//						cNode.add(buildNode);
//					}
//				}
//				if (claimIndexMap.containsKey(funcDefName)) {
//					buildLink += "InContextOf\" name=\"" + funcDefName + "_"
//							+ claimContext.getName() + "\" " + "to=\"//@nodes."
//							+ claimIndexMap.get(claimContext.getName()) + "\" " + "from=\"//@nodes."
//							+ claimIndexMap.get(funcDefName) + "\"/>" + "\r\n";
//					cLink.add(buildLink);
////					buildAttribute += "  <links xsi:type=\"egsn:InContextOf\" name=\"" + funcDefName + "_"
////							+ claimContext.getName() + "\" " + "to=\"//@nodes."
////							+ claimIndexMap.get(claimContext.getName()) + "\" " + "from=\"//@nodes."
////							+ claimIndexMap.get(funcDefName) + "\"/>" + "\r\n";
////					System.out.println(buildAttribute);
//				}
////				buildAttribute += "Context " + claimContext.getName() + " {" + "\r\n" + "\tdescription "
////						+ "\"" + claimContext.getExpr().toString() + "\"" + "\r\n" + "}" + "\r\n";
//			} else if (namedElement instanceof ClaimAssumption) {
//				ClaimAssumption claimAssumption = (ClaimAssumption) namedElement;
//				buildNode += "Assumption\" name=\"" + claimAssumption.getName() + "\" description="
//						+ claimAssumption.getVal().getValue() + "/>" + "\r\n";
//				cNode.add(buildNode);
////				buildAttribute += "Assumption\" name=\"" + claimAssumption.getName() + "\" description="
////						+ claimAssumption.getVal().getValue() + "/>" + "\r\n";
////				buildAttribute += "Assumption " + claimAssumption.getName() + " {" + "\r\n"
////						+ "\tdescription "
////						+ claimAssumption.getVal().getValue() + "\r\n" + "}" + "\r\n";
//				if (claimIndexMap.containsKey(funcDefName)) {
//					buildLink += "InContextOf\" name=\"" + funcDefName + "_"
//							+ claimAssumption.getName() + "\" " + "to=\"//@nodes."
//							+ claimIndexMap.get(claimAssumption.getName()) + "\" " + "from=\"//@nodes."
//							+ claimIndexMap.get(funcDefName) + "\"/>" + "\r\n";
//					cLink.add(buildLink);
////					buildAttribute += "  <links xsi:type=\"egsn:InContextOf\" name=\"" + funcDefName + "_"
////							+ claimAssumption.getName() + "\" " + "to=\"//@nodes."
////							+ claimIndexMap.get(claimAssumption.getName()) + "\" " + "from=\"//@nodes."
////							+ claimIndexMap.get(funcDefName) + "\"/>" + "\r\n";
////					System.out.println(buildAttribute);
//				}
//			} else if (namedElement instanceof ClaimJustification) {
//				ClaimJustification claimJustification = (ClaimJustification) namedElement;
//				buildNode += "Justification\" name=\"" + claimJustification.getName() + "\" description="
//						+ claimJustification.getVal().getValue() + "/>" + "\r\n";
//				cNode.add(buildNode);
////				buildAttribute += "Justification\" name=\"" + claimJustification.getName() + "\" description="
////						+ claimJustification.getVal().getValue() + "/>" + "\r\n";
////				buildAttribute += "Justification " + claimJustification.getName() + " {" + "\r\n"
////						+ "\tdescription "
////						+ claimJustification.getVal().getValue() + "\r\n" + "}" + "\r\n";
//				if (claimIndexMap.containsKey(funcDefName)) {
//					buildLink += "InContextOf\" name=\"" + funcDefName + "_"
//							+ claimJustification.getName() + "\" " + "to=\"//@nodes."
//							+ claimIndexMap.get(claimJustification.getName()) + "\" " + "from=\"//@nodes."
//							+ claimIndexMap.get(funcDefName) + "\"/>" + "\r\n";
//					cLink.add(buildLink);
////					buildAttribute += "  <links xsi:type=\"egsn:InContextOf\" name=\"" + funcDefName + "_"
////							+ claimJustification.getName() + "\" " + "to=\"//@nodes."
////							+ claimIndexMap.get(claimJustification.getName()) + "\" " + "from=\"//@nodes."
////							+ claimIndexMap.get(funcDefName) + "\"/>" + "\r\n";
////					System.out.println(buildAttribute);
//				}
//			} else if (namedElement instanceof ClaimStrategy) {
//				ClaimStrategy claimStrategy = (ClaimStrategy) namedElement;
//				buildNode += "Strategy\" name=\"" + claimStrategy.getName() + "\" description="
//						+ claimStrategy.getVal().getValue() + "/>" + "\r\n";
//				cNode.add(buildNode);
////				buildAttribute += "Strategy\" name=\"" + claimStrategy.getName() + "\" description="
////						+ claimStrategy.getVal().getValue() + "/>" + "\r\n";
////				buildAttribute += "Strategy " + claimStrategy.getName() + " {" + "\r\n"
////						+ "\tdescription "
////						+ claimStrategy.getVal().getValue() + "\r\n" + "}" + "\r\n";
//			}
//		}
////		System.out.println(buildAttribute);
////		return buildAttribute;
//	}

//	private static void buildChildLinks(ClaimResult res, HashMap<String, Integer> claimIndexMap, String funcDefName,
//			List<String> cNode, List<String> cLink) {
//		List<ResoluteResult> result = res.getChildren();
//		List<ResoluteResult> children = new ArrayList<>();
//		for (ResoluteResult child : result) {
//			children = child.getChildren();
//		}
//		for (ResoluteResult child : children) {
//			String childLink = "";
//			if (child instanceof ClaimResult) {
//				ClaimResult cResult = (ClaimResult) child;
//				if (cResult.getLocation() instanceof FunctionDefinition) {
//					FunctionDefinition funcDef = (FunctionDefinition) cResult.getLocation();
//					if (funcDef.getBody() instanceof ClaimBody) {
//						childLink += "  <links xsi:type=\"egsn:";
//						if (!claimIndexMap.containsKey(funcDef.getName())) {
//							Collection<Integer> funcNameValues = claimIndexMap.values();
//							int index = findMaxVal(funcNameValues);
//							claimIndexMap.put(funcDef.getName(), index + 1);
//						}
//						childLink += "IsSupportedBy\" name=\"" + funcDefName + "_" + funcDef.getName() + "\" "
//								+ "to=\"//@nodes." + claimIndexMap.get(funcDef.getName()) + "\" " + "from=\"//@nodes."
//								+ claimIndexMap.get(funcDefName) + "\"/>" + "\r\n";
//						cLink.add(childLink);
//					}
//				}
//			}
//		}
//
//	}

	private static boolean isUndevelopedExpr(Expr expr) {
		if (expr instanceof UndevelopedExpr) {
			return true;
		} else if (expr instanceof LetExpr) {
			LetExpr letExpr = (LetExpr) expr;
			return isUndevelopedExpr(letExpr.getExpr());
		}
		return false;
	}

//	private static int findMaxVal(Collection<Integer> values) {
//		int max = 0;
//		for (Integer value : values) {
//			if (max < value) {
//				max = value;
//			}
//		}
//		return max;
//	}

//	public static StringBuilder exportBuilder(Expr expr, StringBuilder s) {
//		if (expr instanceof BinaryExpr) {
//			BinaryExpr binaryExpr = (BinaryExpr) expr;
//			exportBuilder(binaryExpr.getLeft(), s);
//			exportBuilder(binaryExpr.getRight(), s);
//		} else if (expr instanceof LetExpr) {
//			LetExpr letExpr = (LetExpr) expr;
//			exportBuilder(letExpr.getExpr(), s);
//		} else if (expr instanceof IfThenElseExpr) {
//			IfThenElseExpr ifThenElseExpr = (IfThenElseExpr) expr;
//			exportBuilder(ifThenElseExpr.getCond(), s);
//			exportBuilder(ifThenElseExpr.getThen(), s);
//			exportBuilder(ifThenElseExpr.getElse(), s);
//		} else if (expr instanceof QuantifiedExpr) {
//			QuantifiedExpr quantifiedExpr = (QuantifiedExpr) expr;
//			exportBuilder(quantifiedExpr.getExpr(), s);
//		} else if (expr instanceof FnCallExpr) {
//			FnCallExpr fnCallExpr = (FnCallExpr) expr;
//			if (fnCallExpr.getFn() instanceof FunctionDefinition) {
//				String st = "";
//				String compName = "";
//				String undeveloped = "";
//				FunctionDefinition functionDefinition = fnCallExpr.getFn();
//				if (functionDefinition.getBody() instanceof ClaimBody) {
//					ClaimBody claimBody = (ClaimBody) functionDefinition.getBody();
//					if (functionDefinition.getClaimType() == "goal" | functionDefinition.getClaimType() == null) {
//						st += "Goal ";
//					} else {
//						st += "Strategy ";
//					}
//					String fName = functionDefinition.getName();
//					List<ClaimText> claimTextList = claimBody.getClaim();
//					for (ClaimText claimText : claimTextList) {
//						if (claimText instanceof ClaimString) {
//							ClaimString claimString = (ClaimString) claimText;
//							compName += claimString.getStr();
//						} else if (claimText instanceof ClaimArg) {
//							ClaimArg claimArg = (ClaimArg) claimText;
//							if (claimArg.getArg() instanceof Arg) {
//								Arg arg = (Arg) claimArg.getArg();
//								compName += arg.getName();
//							}
//						}
//					}
//					if (isUndevelopedExpr(claimBody.getExpr())) {
//						undeveloped = "toBeDeveloped ";
//					}
////					if (claimBody.getExpr() instanceof UndevelopedExpr) {
////						undeveloped = "toBeDeveloped ";
////					} else if (claimBody.getExpr() instanceof LetExpr) {
////						LetExpr lExpr = (LetExpr) claimBody.getExpr();
////						if (lExpr.getExpr() instanceof UndevelopedExpr) {
////							undeveloped = "toBeDeveloped ";
////						}
////					}
//					st = st + undeveloped + fName + " {" + "\r\n" + "\tdescription " + "\"" + compName + "\"" + "\r\n"
//							+ "}" + "\r\n";
//					exportBuilder(claimBody.getExpr(), s);
//				}
//				System.out.println(st);
//				s.append(st);
//			}
//		}
//		return s;
//	}
//
//	public static boolean isUndevelopedExpr(Expr expr) {
//		if (expr instanceof UndevelopedExpr) {
//			return true;
//		} else if (expr instanceof LetExpr) {
//			LetExpr lExpr = (LetExpr) expr;
//			return isUndevelopedExpr(lExpr.getExpr());
//		}
//		return false;
//	}
//
////	public static HashSet<String> getChildren(Expr expr){
////		if (expr instanceof Binary)
////	}

}
