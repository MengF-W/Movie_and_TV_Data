package com.movietv.utilities;

import com.google.gson.Gson;

public class JsonProcessor {

    private static JsonProcessor jsonParser;
    private static Gson gSon;

    private JsonProcessor(){}

    public static JsonProcessor getInstance() {

        if(jsonParser == null){

            jsonParser = new JsonProcessor();
            gSon = new Gson();
        }

        return jsonParser;
    }

    public String serializeJson(Object sourceObject)
    {
        return gSon.toJson(sourceObject);
    }

    public <T> T deserializeJson(String jsonString, Class<T> targetObject)
    {
        T t = gSon.fromJson(jsonString,
                targetObject);

        return t;
    }

}