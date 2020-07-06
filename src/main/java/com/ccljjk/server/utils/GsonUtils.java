package com.ccljjk.server.utils;

import com.google.gson.*;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * json转换工具类  - gson
 */
public abstract class GsonUtils {
    private static Gson gson = new Gson();
    private static Gson gsonShowNull = new GsonBuilder().serializeNulls().create();

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Class<T> classOfT, Object adapter) {
        if (adapter == null) {
            Gson gson = new Gson();
            return gson.fromJson(json, classOfT);
        }
        Gson gson = new GsonBuilder().registerTypeAdapter(classOfT, adapter).create();
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    public static String toJson(Object object) {
        if (object == null) {
            return "";
        }
        return gson.toJson(object);
    }

    public static String toJsonShowNull(Object object) {
        if (object == null) {
            return "";
        }
        return gsonShowNull.toJson(object);
    }

    public static String prettyJson(String input) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(input).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }

    public static String jsonArrayAsString(JsonArray jsonArray) {
        List<String> strList = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            strList.add(jsonElement.getAsString());
        }
        return StringUtils.collectionToCommaDelimitedString(strList);
    }

    public static JsonElement toJsonElement(Object object) {
        return gson.toJsonTree(object);
    }
}


