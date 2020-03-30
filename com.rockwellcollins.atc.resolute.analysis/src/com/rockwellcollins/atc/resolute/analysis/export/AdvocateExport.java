package com.rockwellcollins.atc.resolute.analysis.export;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.resolute.ClaimAssumption;
import com.rockwellcollins.atc.resolute.resolute.ClaimBody;
import com.rockwellcollins.atc.resolute.resolute.ClaimContext;
import com.rockwellcollins.atc.resolute.resolute.ClaimJustification;
import com.rockwellcollins.atc.resolute.resolute.ClaimStrategy;
import com.rockwellcollins.atc.resolute.resolute.Expr;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.LetExpr;
import com.rockwellcollins.atc.resolute.resolute.UndevelopedExpr;

public class AdvocateExport {

	public static void export(ClaimResult cr) throws IOException {

//		ClaimResult claimResult = cr;
//		HashSet<String> funcNames = new HashSet<>();
		StringBuilder str = new StringBuilder();
		List<ResoluteResult> result = cr.getChildren();
		ClaimResult cResult = (ClaimResult) result.get(0);
		str.append("<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\r\n");
		str.append(
				"<argument:Argument xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:argument=\"http://www.advocate.arc.nasa.gov/argument\" xmlns:egsn=\"http://www.advocate.arc.nasa.gov/egsn\">"
						+ "\r\n");
		exportBuilder(cResult, str);
//		if (claimResult.getLocation() instanceof ProveStatement) {
//			ProveStatement proveStatement = (ProveStatement) claimResult.getLocation();
////			StringBuilder s = exportBuilder(proveStatement.getExpr(), str);
//		Path fileToDeletePath = Paths.get("C:\\Saqib\\Resolute\\docs\\AdvocateText1.txt");
//		Files.delete(fileToDeletePath);

		Path fileToDeletePath = Paths.get("C:\\Saqib\\Resolute\\docs\\AdvocateText.txt");
		Files.delete(fileToDeletePath);
		FileWriter writer = new FileWriter("C:\\Saqib\\Resolute\\docs\\AdvocateText.txt", true);
		str.append("</argument:Argument>");
		writer.write(str.toString());
		writer.close();
//		}
		System.out.println("Hello AdvoCATE!!");
	}

	public static StringBuilder exportBuilder(ResoluteResult resoluteResult, StringBuilder s) {
		String claim = "";
		if (resoluteResult instanceof ClaimResult) {
			String attributes = "";
			String undeveloped = "";
			ClaimResult claimResult = (ClaimResult) resoluteResult;
			if (claimResult.getLocation() instanceof FunctionDefinition) {
				FunctionDefinition functionDefinition = (FunctionDefinition) claimResult.getLocation();
				if (functionDefinition.getBody() instanceof ClaimBody) {
					claim = "  <nodes xsi:type=\"argument:Argument";
					ClaimBody claimBody = (ClaimBody) functionDefinition.getBody();
					attributes = buildClaimAttributes(claimBody.getAttributes(), claimResult);
					String claimText = claimResult.getText();
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
				}
			}
			System.out.println(claim);
			s.append(claim);
			s.append(attributes);
			List<ResoluteResult> children = claimResult.getChildren();
			for (ResoluteResult child : children) {
				exportBuilder(child, s);
			}
		} else if (resoluteResult instanceof ResoluteResult) {
			List<ResoluteResult> children = resoluteResult.getChildren();
			for (ResoluteResult child : children) {
				exportBuilder(child, s);
			}
		}
		return s;
	}

	private static String buildClaimAttributes(List<NamedElement> claimAttributes, ClaimResult res) {
		String buildAttribute = "";
		for (NamedElement namedElement : claimAttributes) {
			buildAttribute += "  <nodes xsi:type=\"argument:Argument";
			if (namedElement instanceof ClaimContext) {
				ClaimContext claimContext = (ClaimContext) namedElement;
				Map<String, EObject> refs = res.getReferences();
				for (String description : new TreeSet<String>(refs.keySet())) {
					if (refs.get(description).equals(claimContext)) {
						buildAttribute += "Context\" name=\"" + claimContext.getName() + "\" description=\""
								+ description + "\"/>" + "\r\n";
					}
				}
//				buildAttribute += "Context " + claimContext.getName() + " {" + "\r\n" + "\tdescription "
//						+ "\"" + claimContext.getExpr().toString() + "\"" + "\r\n" + "}" + "\r\n";
			} else if (namedElement instanceof ClaimAssumption) {
				ClaimAssumption claimAssumption = (ClaimAssumption) namedElement;
				buildAttribute += "Assumption\" name=\"" + claimAssumption.getName() + "\" description="
						+ claimAssumption.getVal().getValue() + "/>" + "\r\n";
//				buildAttribute += "Assumption " + claimAssumption.getName() + " {" + "\r\n"
//						+ "\tdescription "
//						+ claimAssumption.getVal().getValue() + "\r\n" + "}" + "\r\n";
			} else if (namedElement instanceof ClaimJustification) {
				ClaimJustification claimJustification = (ClaimJustification) namedElement;
				buildAttribute += "Justification\" name=\"" + claimJustification.getName() + "\" description="
						+ claimJustification.getVal().getValue() + "/>" + "\r\n";
//				buildAttribute += "Justification " + claimJustification.getName() + " {" + "\r\n"
//						+ "\tdescription "
//						+ claimJustification.getVal().getValue() + "\r\n" + "}" + "\r\n";
			} else if (namedElement instanceof ClaimStrategy) {
				ClaimStrategy claimStrategy = (ClaimStrategy) namedElement;
				buildAttribute += "Strategy\" name=\"" + claimStrategy.getName() + "\" description="
						+ claimStrategy.getVal().getValue() + "/>" + "\r\n";
//				buildAttribute += "Strategy " + claimStrategy.getName() + " {" + "\r\n"
//						+ "\tdescription "
//						+ claimStrategy.getVal().getValue() + "\r\n" + "}" + "\r\n";
			}
		}
		System.out.println(buildAttribute);
		return buildAttribute;
	}

	private static boolean isUndevelopedExpr(Expr expr) {
		if (expr instanceof UndevelopedExpr) {
			return true;
		} else if (expr instanceof LetExpr) {
			LetExpr lExpr = (LetExpr) expr;
			return isUndevelopedExpr(lExpr.getExpr());
		}
		return false;
	}

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
