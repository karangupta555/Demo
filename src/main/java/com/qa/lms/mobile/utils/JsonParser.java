package com.qa.lms.mobile.utils;

import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.InputStream;

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
        return new JSONObject(JsonParser.parse("data/devicesData.json").getJSONObject(platformName).toString());
    }
}
