package com.rockwellcollins.atc.resolute.analysis.export;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.resolute.ClaimBody;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;

public class AdvocateExport {

	public static void export(ClaimResult cr) throws IOException {

//		ClaimResult claimResult = cr;
//		HashSet<String> funcNames = new HashSet<>();
		StringBuilder str = new StringBuilder();
		List<ResoluteResult> result = cr.getChildren();
		ClaimResult cResult = (ClaimResult) result.get(0);
		exportBuilder(cResult, str);
//		if (claimResult.getLocation() instanceof ProveStatement) {
//			ProveStatement proveStatement = (ProveStatement) claimResult.getLocation();
////			StringBuilder s = exportBuilder(proveStatement.getExpr(), str);
		Path fileToDeletePath = Paths.get("C:\\Saqib\\Resolute\\docs\\AdvocateText.txt");
		Files.delete(fileToDeletePath);
		FileWriter writer = new FileWriter("C:\\Saqib\\Resolute\\docs\\AdvocateText.txt", true);
		writer.write(str.toString());
		writer.close();
//		}
		System.out.println("Hello AdvoCATE!!");
	}

	public static StringBuilder exportBuilder(ResoluteResult resoluteResult, StringBuilder s) {
		String st = "";
		if (resoluteResult instanceof ClaimResult) {
			ClaimResult claimResult = (ClaimResult) resoluteResult;
			if (claimResult.getLocation() instanceof FunctionDefinition) {
				FunctionDefinition functionDefinition = (FunctionDefinition) claimResult.getLocation();
				if (functionDefinition.getBody() instanceof ClaimBody) {
					ClaimBody claimBody = (ClaimBody) functionDefinition.getBody();
					String claimText = claimResult.getText();
					if (functionDefinition.getClaimType() == "goal" | functionDefinition.getClaimType() == null) {
						st += "Goal ";
					} else {
						st += "Strategy ";
					}
					st = st + functionDefinition.getName() + " {" + "\r\n" + "\tdescription " + "\"" + claimText + "\""
							+ "\r\n"
							+ "}" + "\r\n";
				}
			}
			System.out.println(st);
			s.append(st);
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
