package com.rockwellcollins.atc.resolute.shellcmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteExternalFunctionLibrary;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteFailException;
import com.rockwellcollins.atc.resolute.analysis.values.IntValue;
import com.rockwellcollins.atc.resolute.analysis.values.ResoluteRecordValue;
import com.rockwellcollins.atc.resolute.analysis.values.ResoluteValue;
import com.rockwellcollins.atc.resolute.analysis.values.StringValue;

public class ResoluteShellCmdLibrary extends ResoluteExternalFunctionLibrary {

	@Override
	public ResoluteValue run(EvaluationContext context, String function, List<ResoluteValue> args) {
		switch (function.toLowerCase()) {
		case ResoluteShellCmdLibraryType.SHELL_EXEC_FUNCTION_NAME:
			return runExec(context, args);
		case ResoluteShellCmdLibraryType.SHELL_GET_RETURN_CODE_FUNCTION_NAME:
			return runGetReturnCode(context, args);
		case ResoluteShellCmdLibraryType.SHELL_GET_OUTPUT_FUNCTION_NAME:
			return runGetOutput(context, args);
		}
		throw new ResoluteFailException("Function " + function + " not part of ShellCMD Library.",
				context.getThisInstance().getSubcomponent());
	}

	@SuppressWarnings("serial")
	private ResoluteValue runExec(EvaluationContext context, List<ResoluteValue> args) {
		StringBuilder outputStringBuilder = new StringBuilder();
		ResoluteValue arg0 = args.get(0);

		assert (arg0.isString());

		try {
			// Build command
			List<String> commands = Arrays.asList(arg0.getString().split(" "));
			System.out.println(commands);

			// Run
			ProcessBuilder processBuilder = new ProcessBuilder(commands);
			processBuilder.redirectErrorStream(true);
			Process process = processBuilder.start();

			// Read output
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null, previous = null;
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.equals(previous)) {
					previous = line;
					outputStringBuilder.append(line).append('\n');
					System.out.println(line);
				}
			}

			// Check result
			int returnCode = process.waitFor();
			if (returnCode == 0) {
				System.out.println("Success!");
			} else {
				// Abnormal termination: Log command parameters and output and throw ExecutionException
				System.err.println(commands);
				System.err.println(outputStringBuilder.toString());
			}

			return new ResoluteRecordValue(new HashMap<String, ResoluteValue>() {{
					put(ResoluteShellCmdLibraryType.SHELL_RETURN_CODE_FIELD_NAME, new IntValue(returnCode));
					put(ResoluteShellCmdLibraryType.SHELL_OUTPUT_FIELD_NAME,
							new StringValue(outputStringBuilder.toString()));
			}});

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private ResoluteValue runGetReturnCode(EvaluationContext context, List<ResoluteValue> args) {
		assert (args.size() == 1);
		ResoluteValue arg0 = args.get(0);
		assert (arg0 instanceof ResoluteRecordValue);
		return ((ResoluteRecordValue) arg0).getField(ResoluteShellCmdLibraryType.SHELL_RETURN_CODE_FIELD_NAME);
	}

	private ResoluteValue runGetOutput(EvaluationContext context, List<ResoluteValue> args) {
		assert (args.size() == 1);
		ResoluteValue arg0 = args.get(0);
		assert (arg0 instanceof ResoluteRecordValue);
		return ((ResoluteRecordValue) arg0).getField(ResoluteShellCmdLibraryType.SHELL_OUTPUT_FIELD_NAME);
	}

}
