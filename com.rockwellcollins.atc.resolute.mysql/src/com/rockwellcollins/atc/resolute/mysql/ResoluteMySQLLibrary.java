package com.rockwellcollins.atc.resolute.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteExternalFunctionLibrary;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteFailException;
import com.rockwellcollins.atc.resolute.analysis.values.BoolValue;
import com.rockwellcollins.atc.resolute.analysis.values.IntValue;
import com.rockwellcollins.atc.resolute.analysis.values.ListValue;
import com.rockwellcollins.atc.resolute.analysis.values.RealValue;
import com.rockwellcollins.atc.resolute.analysis.values.ResoluteRecordValue;
import com.rockwellcollins.atc.resolute.analysis.values.ResoluteValue;
import com.rockwellcollins.atc.resolute.analysis.values.StringValue;

public class ResoluteMySQLLibrary extends ResoluteExternalFunctionLibrary {

	private Class<?> driverClass = null;

	public final static Pattern namePattern = Pattern.compile("\\A[\\p{L}_@$][\\p{L}\\p{N}@$#_]{0,127}\\z");

	@Override
	public ResoluteValue run(EvaluationContext context, String function, List<ResoluteValue> args) {

		if (driverClass == null) {
			try {
				driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				throw new ResoluteFailException("MySQL could not load JDBC driver", e,
						context.getThisInstance().getSubcomponent());
			}
		}

		switch (function.toLowerCase()) {
		case ResoluteMySQLLibraryType.SELECT_FUNCTION_NAME:
			return runSelect(context, args);
		case ResoluteMySQLLibraryType.GET_BOOL_FIELD_FUNCTION_NAME:
		case ResoluteMySQLLibraryType.GET_INT_FIELD_FUNCTION_NAME:
		case ResoluteMySQLLibraryType.GET_REAL_FIELD_FUNCTION_NAME:
		case ResoluteMySQLLibraryType.GET_STRING_FIELD_FUNCTION_NAME:
			return runGetField(context, args);
		}
		throw new ResoluteFailException("Function " + function + " not part of MySQL Library.",
				context.getThisInstance().getSubcomponent());
	}

	private String getConnectionURL() {
		String hostname = System.getenv("MYSQL_HOSTNAME");
		if (hostname == null) {
			hostname = "localhost";
		}
		String port = System.getenv("MYSQL_PORT");
		if (port == null) {
			port = "3306";
		}
		return "jdbc:mysql://" + hostname + ":" + port + "/";
	}

	private ResoluteValue runSelect(EvaluationContext context, List<ResoluteValue> args) {
		ResoluteValue arg0 = args.get(0);
		ResoluteValue arg1 = args.get(1);
		ResoluteValue arg2 = args.get(2);

		assert (arg0.isString());
		assert (arg1.isString());
		assert (arg2.isList());
		assert (arg2.getListValues().stream().allMatch(v -> v.isString()));

		assert (namePattern.matcher(arg0.getString()).matches());
		assert (namePattern.matcher(arg1.getString()).matches());
		assert (arg2.getListValues().stream().allMatch(v -> namePattern.matcher(v.getString()).matches()));

		List<ResoluteValue> resultRows = new ArrayList<>();
		Connection connection = null;

		final String username = System.getenv("MYSQL_USERNAME");
		if (username == null) {
			throw new ResoluteFailException(
					"MySQL select: required MYSQL_USERNAME environment variable is not not set.",
					context.getThisInstance().getSubcomponent());
		}
		final String password = System.getenv("MYSQL_PASSWORD");
		if (password == null) {
			throw new ResoluteFailException(
					"MySQL select: required MY_SQLPASSWORD environment variable is not not set.",
					context.getThisInstance().getSubcomponent());
		}

		final String url = getConnectionURL() + arg0.getString();
		final String selectStatement = "SELECT "
				+ String.join(", ", arg2.getListValues().stream().map(v -> v.getString()).collect(Collectors.toList()))
				+ " FROM " + arg1.getString() + ";";

		try {
			connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectStatement);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			while (resultSet.next()) {
				Map<String, ResoluteValue> rowRecord = new HashMap<String, ResoluteValue>();
				for (int index = 1; index <= resultSetMetaData.getColumnCount(); ++index) {
					int typeNumber = resultSetMetaData.getColumnType(index);
					switch (typeNumber) {
					case java.sql.Types.BIT:
					case java.sql.Types.BOOLEAN:
						rowRecord.put(resultSetMetaData.getColumnName(index),
								new BoolValue(resultSet.getBoolean(index)));
						break;
					case java.sql.Types.TINYINT:
					case java.sql.Types.SMALLINT:
					case java.sql.Types.INTEGER:
						rowRecord.put(resultSetMetaData.getColumnName(index),
								new IntValue(resultSet.getLong(index)));
						break;
					case java.sql.Types.FLOAT:
					case java.sql.Types.DOUBLE:
						rowRecord.put(resultSetMetaData.getColumnName(index),
								new RealValue(resultSet.getDouble(index)));
						break;
					case java.sql.Types.CHAR:
					case java.sql.Types.VARCHAR:
						rowRecord.put(resultSetMetaData.getColumnName(index),
								new StringValue(resultSet.getString(index)));
						break;
					default:
						throw new ResoluteFailException(
								"MySQL select: type " + resultSetMetaData.getColumnTypeName(index)
										+ " not supported for column " + resultSetMetaData.getColumnName(index) + ".",
								context.getThisInstance().getSubcomponent());
					}
				}
				resultRows.add(new ResoluteRecordValue(rowRecord));
			}

		} catch (Exception e) {
			throw new ResoluteFailException("Unexpected exception occurred accessing MySQL JDBC driver.", e,
					context.getThisInstance().getSubcomponent());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				throw new ResoluteFailException("MySQL select statement \"" + selectStatement + "\" threw exception.",
						e,
						context.getThisInstance().getSubcomponent());
			}
		}

		return new ListValue(resultRows);
	}

	private ResoluteValue runGetField(EvaluationContext context, List<ResoluteValue> args) {
		assert (args.size() == 2);
		ResoluteValue arg0 = args.get(0);
		ResoluteValue arg1 = args.get(1);
		assert (arg0 instanceof ResoluteRecordValue);
		assert (arg1.isString());
		return ((ResoluteRecordValue) arg0).getField(arg1.getString());
	}

}
