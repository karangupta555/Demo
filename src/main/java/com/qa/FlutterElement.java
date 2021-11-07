package com.qa;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class FlutterElement extends MobileElement{
    private final Map<String, Object> rawMap;
    private final Gson gson = new Gson();

    public FlutterElement(ImmutableMap<String, Object> rawMap)
    {
        this.rawMap = rawMap;
        id = serialize(rawMap);
    }

    public Map<String, Object> getRawMap() {
        return rawMap;
    }

    //TODO Optimize usage of maps
    public String serialize(Map<String, Object> rawMap) {
        final JsonPrimitive INSTANCE = new JsonPrimitive(false);
        Map<String, Object> tempMap = new HashMap<String, Object>();
        rawMap.forEach(
                (key, value) -> {
                    if (value instanceof String || value instanceof Integer || value instanceof Boolean) {
                        tempMap.put(key, new JsonPrimitive((String) value));
                    } else if (value instanceof JsonElement) {
                        tempMap.put(key, value);
                    } else {
                        tempMap.put(key, INSTANCE);
                    }
                });
        Map<String, Object> iMap = ImmutableMap.copyOf(tempMap);
        String mapJsonStringField = gson.toJson(tempMap);
        return Base64.getEncoder().encodeToString(mapJsonStringField.getBytes());
    }
}