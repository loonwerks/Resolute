package com.rockwellcollins.atc.resolute.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
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

public class Json extends ResoluteExternalFunctionLibrary {

	@Override
	public ResoluteValue run(EvaluationContext context, String function, List<ResoluteValue> args) {

		try {
			switch (function.toLowerCase()) {
			case "parse": {
				final ResoluteValue arg0 = args.get(0);
				assert (arg0.isString());
				return parseString(arg0.getString());
			}
			case "isarray": {
				return new BoolValue(args.get(0).isList());
			}
			case "isobject": {
				return new BoolValue(args.get(0).isRecord());
			}
			case "isprimitive": {
				return new BoolValue(
						args.get(0).isBool() || args.get(0).isInt() || args.get(0).isReal() || args.get(0).isString());
			}
			case "isboolean": {
				return new BoolValue(args.get(0).isBool());
			}
			case "isinteger": {
				return new BoolValue(args.get(0).isInt());
			}
			case "isnull": {
				return new BoolValue(args.get(0) == null);
			}
			case "isreal": {
				return new BoolValue(args.get(0).isReal());
			}
			case "isstring": {
				return new BoolValue(args.get(0).isString());
			}
			case "toarray": {
				assert (args.get(0).isList());
				return args.get(0);
			}
			case "toobject": {
				assert (args.get(0).isRecord());
				return args.get(0);
			}
			case "toprimitive": {
				assert (args.get(0).isBool() || args.get(0).isInt() || args.get(0).isReal() || args.get(0).isString());
				return args.get(0);
			}
			case "toboolean": {
				assert (args.get(0).isBool());
				return args.get(0);
			}
			case "tointeger": {
				assert (args.get(0).isInt());
				return args.get(0);
			}
			case "toreal": {
				assert (args.get(0).isReal());
				return args.get(0);
			}
			case "tostring": {
				assert (args.get(0).isString());
				return args.get(0);
			}
			case "get": {
				assert (args.get(0).isRecord());
				assert (args.get(1).isString());
				final ResoluteRecordValue object = args.get(0).getRecord();
				final String key = args.get(1).getString();
				final ResoluteValue val = object.getField(key);
				if (val == null) {
					throw new Exception("JSON object does not contain specified field: " + key);
				} else {
					return val;
				}
			}
			case "getarray": {
				assert (args.get(0).isRecord());
				assert (args.get(1).isString());
				final ResoluteRecordValue object = args.get(0).getRecord();
				final String key = args.get(1).getString();
				final ResoluteValue val = object.getField(key);
				if (val == null) {
					throw new Exception("JSON object does not contain specified field: " + key);
				} else if (!(val instanceof ListValue)) {
					throw new Exception("JSON element is not an array.");
				} else {
					return val;
				}
			}
			case "getobject": {
				assert (args.get(0).isRecord());
				assert (args.get(1).isString());
				final ResoluteRecordValue object = args.get(0).getRecord();
				final String key = args.get(1).getString();
				final ResoluteValue val = object.getField(key);
				if (val == null) {
					throw new Exception("JSON object does not contain specified field: " + key);
				} else if (!(val instanceof ResoluteRecordValue)) {
					throw new Exception("JSON element is not an object.");
				} else {
					return val;
				}
			}
			case "getprimitive": {
				assert (args.get(0).isRecord());
				assert (args.get(1).isString());
				final ResoluteRecordValue object = args.get(0).getRecord();
				final String key = args.get(1).getString();
				final ResoluteValue val = object.getField(key);
				if (val == null) {
					throw new Exception("JSON object does not contain specified field: " + key);
				} else if (!(val instanceof IntValue || val instanceof RealValue || val instanceof BoolValue
						|| val instanceof StringValue)) {
					throw new Exception("JSON element is not a primitive.");
				} else {
					return val;
				}
			}
			case "getboolean": {
				assert (args.get(0).isRecord());
				assert (args.get(1).isString());
				final ResoluteRecordValue object = args.get(0).getRecord();
				final String key = args.get(1).getString();
				final ResoluteValue val = object.getField(key);
				if (val == null) {
					throw new Exception("JSON object does not contain specified field: " + key);
				} else if (!(val instanceof BoolValue)) {
					throw new Exception("JSON element is not a Boolean.");
				} else {
					return val;
				}
			}
			case "getinteger": {
				assert (args.get(0).isRecord());
				assert (args.get(1).isString());
				final ResoluteRecordValue object = args.get(0).getRecord();
				final String key = args.get(1).getString();
				final ResoluteValue val = object.getField(key);
				if (val == null) {
					throw new Exception("JSON object does not contain specified field: " + key);
				} else if (!(val instanceof IntValue)) {
					throw new Exception("JSON element is not an integer.");
				} else {
					return val;
				}
			}
			case "getreal": {
				assert (args.get(0).isRecord());
				assert (args.get(1).isString());
				final ResoluteRecordValue object = args.get(0).getRecord();
				final String key = args.get(1).getString();
				final ResoluteValue val = object.getField(key);
				if (val == null) {
					throw new Exception("JSON object does not contain specified field: " + key);
				} else if (!(val instanceof RealValue)) {
					throw new Exception("JSON element is not a real number.");
				} else {
					return val;
				}
			}
			case "getstring": {
				assert (args.get(0).isRecord());
				assert (args.get(1).isString());
				final ResoluteRecordValue object = args.get(0).getRecord();
				final String key = args.get(1).getString();
				final ResoluteValue val = object.getField(key);
				if (val == null) {
					throw new Exception("JSON object does not contain specified field: " + key);
				} else if (!(val instanceof StringValue)) {
					throw new Exception("JSON element is not a string.");
				} else {
					return val;
				}
			}
			case "hasmember": {
				assert (args.get(0).isRecord());
				assert (args.get(1).isString());
				final ResoluteRecordValue object = args.get(0).getRecord();
				final String key = args.get(1).getString();
				final ResoluteValue val = object.getField(key);
				return new BoolValue(val != null);
			}
			default:
				throw new Exception("Function " + function + " not part of JsonParser Library.");
			}
		} catch (Exception e) {
			throw new ResoluteFailException(e.getMessage(), context.getThisInstance());
		}

	}

	private ResoluteValue parseString(String jsonString) throws Exception {

		try {
			final JsonElement jsonElement = JsonParser.parseString(jsonString);
			return parseElement(jsonElement);
		} catch (JsonSyntaxException e) {
			throw new Exception("Malformed Json");
		}
	}

	private ResoluteValue parseElement(JsonElement jsonElement) throws Exception {
		if (jsonElement.isJsonArray()) {
			return parseArray(jsonElement.getAsJsonArray());
		} else if (jsonElement.isJsonObject()) {
			return parseObject(jsonElement.getAsJsonObject());
		} else if (jsonElement.isJsonPrimitive()) {
			return parsePrimitive(jsonElement.getAsJsonPrimitive());
		} else if (jsonElement.isJsonNull()) {
			return null;
		} else {
			throw new Exception("Unrecognized JsonElement: " + jsonElement.getClass());
		}
	}

	private ListValue parseArray(JsonArray jsonArray) throws Exception {
		final List<ResoluteValue> array = new ArrayList<>();
		for (JsonElement jsonElement : jsonArray) {
			array.add(parseElement(jsonElement));
		}
		return new ListValue(array);
	}

	private ResoluteRecordValue parseObject(JsonObject jsonObject) throws Exception {
		final Map<String, ResoluteValue> object = new HashMap<>();
		for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
			object.put(entry.getKey(), parseElement(entry.getValue()));
		}
		return new ResoluteRecordValue(object);
	}

	private ResoluteValue parsePrimitive(JsonPrimitive jsonPrimitive) throws Exception {
		if (jsonPrimitive.isBoolean()) {
			return new BoolValue(jsonPrimitive.getAsBoolean());
		} else if (jsonPrimitive.isNumber()) {
			final String num = jsonPrimitive.getAsString();
			if (num.matches("[-+]?[0-9]*\\.[0-9]+")) {
				return new RealValue(jsonPrimitive.getAsDouble());
			} else {
				return new IntValue(jsonPrimitive.getAsLong());
			}
		} else if (jsonPrimitive.isString()) {
			return new StringValue(jsonPrimitive.getAsString());
		} else {
			throw new Exception("Unrecognized JsonPrimitive: " + jsonPrimitive.toString());
		}
	}

}
