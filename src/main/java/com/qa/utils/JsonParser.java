package com.qa.utils;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonParser {

    public static JSONObject parse(String file) {
        InputStream is = JsonParser.class.getClassLoader().getResourceAsStream(file);
        assert is != null;
        return new JSONObject(new JSONTokener(is));
    }

    public static JSONObject getTestData() {
        return (JSONObject)JsonParser.parse("data/testData.json");
    }

    public static JSONObject getLoginData() {
        return(JSONObject)JsonParser.parse("data/loginData.json");
    }

    public static JSONObject getDevicesData(String platformName) {
        return new JSONObject(JsonParser.parse("data/devicesAndConfig.json").getJSONObject(platformName).toString());
    }
}
