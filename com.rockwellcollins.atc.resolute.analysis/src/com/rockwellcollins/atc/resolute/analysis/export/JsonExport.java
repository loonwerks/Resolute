package com.rockwellcollins.atc.resolute.analysis.export;

import java.io.FileWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.osate.aadl2.NamedElement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.resolute.ClaimAssumption;
import com.rockwellcollins.atc.resolute.resolute.ClaimBody;
import com.rockwellcollins.atc.resolute.resolute.ClaimContext;
import com.rockwellcollins.atc.resolute.resolute.ClaimJustification;
import com.rockwellcollins.atc.resolute.resolute.ClaimStrategy;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.SolutionExpr;
import com.rockwellcollins.atc.resolute.resolute.UndevelopedExpr;

public class JsonExport {

	public static void export(ClaimResult cr) {

		if (cr.getChildren().isEmpty()) {
			// TODO Alert user
			return;
		}

		final ClaimResult topLevelGoal = (ClaimResult) cr.getChildren().get(0);
		final JsonObject arg = buildArgument(topLevelGoal);

		// Write to file
		final String claimName = ((FunctionDefinition) topLevelGoal.getLocation()).getName();
		final FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
		dialog.setText("Resolute - Export to JSON");
		dialog.setFileName(claimName);
		dialog.setFilterExtensions(new String[] { "*.json", "*.txt", "*.*" });
		dialog.setFilterIndex(0);
		dialog.setOverwrite(true);
		dialog.setFilterPath(
				ResourceUtil.getFile(cr.getLocation().eResource()).getFullPath().makeAbsolute().toString());
		final String fileName = dialog.open();
		if (fileName == null) {
			return;
		}
		final Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().setPrettyPrinting().create();

		try {
			final FileWriter writer = new FileWriter(fileName, false);
			writer.write(gson.toJson(arg));
			writer.close();
		} catch (Exception e) {
			// TODO Alert user
		}
	}

	private static JsonObject buildArgument(ResoluteResult resoluteResult) {
		final JsonObject argument = new JsonObject();

		if (resoluteResult instanceof ClaimResult) {
			final ClaimResult claimResult = (ClaimResult) resoluteResult;
			if (claimResult.getLocation() instanceof FunctionDefinition) {
				final FunctionDefinition functionDefinition = (FunctionDefinition) claimResult.getLocation();
				argument.addProperty("name", functionDefinition.getName());
				if (functionDefinition.getClaimType() != null && !functionDefinition.getClaimType().isBlank()) {
					argument.addProperty("type", functionDefinition.getClaimType());
				}
				argument.addProperty("description", claimResult.getText());
				argument.addProperty("valid", claimResult.isValid());
				final JsonArray supportedBy = new JsonArray();
				final JsonArray inContextOf = new JsonArray();
				if (functionDefinition.getBody() instanceof ClaimBody) {
					final ClaimBody claimBody = (ClaimBody) functionDefinition.getBody();
					JsonObject strategyObj = null;
					for (NamedElement attribute : claimBody.getAttributes()) {
						if (attribute instanceof ClaimStrategy) {
							final ClaimStrategy strategy = (ClaimStrategy) attribute;
							strategyObj = new JsonObject();
							strategyObj.addProperty("name", strategy.getName());
							strategyObj.addProperty("type", "strategy");
							strategyObj.addProperty("description", strategy.getVal().getValue());
							strategyObj.addProperty("valid", claimResult.isValid());
						} else if (attribute instanceof ClaimContext) {
							final ClaimContext context = (ClaimContext) attribute;
							final JsonObject contextObj = new JsonObject();
							contextObj.addProperty("name", context.getName());
							contextObj.addProperty("type", "context");
//							contextObj.addProperty("description", null);
							inContextOf.add(contextObj);
						} else if (attribute instanceof ClaimJustification) {
							final ClaimJustification justification = (ClaimJustification) attribute;
							final JsonObject justificationObj = new JsonObject();
							justificationObj.addProperty("name", justification.getName());
							justificationObj.addProperty("type", "justification");
							justificationObj.addProperty("description", justification.getVal().getValue());
							inContextOf.add(justificationObj);
						} else if (attribute instanceof ClaimAssumption) {
							final ClaimAssumption assumption = (ClaimAssumption) attribute;
							final JsonObject assumptionObj = new JsonObject();
							assumptionObj.addProperty("name", assumption.getName());
							assumptionObj.addProperty("type", "assumption");
//							assumptionObj.addProperty("description", null);
							inContextOf.add(assumptionObj);
						}
					}

					if (!inContextOf.isEmpty()) {
						argument.add("inContextOf", inContextOf);
					}

					for (ResoluteResult child : resoluteResult.getChildren()) {
						supportedBy.add(buildArgument(child));
					}

					if (supportedBy.isEmpty()) {
						// This is a Solution or Undeveloped leaf node
						if (claimBody.getExpr() instanceof UndevelopedExpr) {
							supportedBy.add("undeveloped");
						} else {
							final JsonObject leafObj = new JsonObject();
							leafObj.addProperty("type", "solution");
							if (claimBody.getExpr() instanceof SolutionExpr) {
								final SolutionExpr solutionExpr = (SolutionExpr) claimBody.getExpr();
								leafObj.addProperty("name", solutionExpr.getName());
//								leafObj.addProperty("description", solutionExpr.getVal().getValue());
								leafObj.addProperty("valid", true);
							} else {

							}
							supportedBy.add(leafObj);
						}
					}

					if (strategyObj != null) {
						strategyObj.add("supportedBy", supportedBy);
						argument.add("supportedBy", strategyObj);
					} else {
						argument.add("supportedBy", supportedBy);
					}
				}
			}
		} else if (resoluteResult instanceof ResoluteResult) {
			for (ResoluteResult child : resoluteResult.getChildren()) {
				argument.add("?", buildArgument(child));
			}
		}

		return argument;
	}
}
