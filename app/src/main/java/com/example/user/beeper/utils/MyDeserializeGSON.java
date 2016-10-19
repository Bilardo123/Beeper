package com.example.user.beeper.utils;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by user on 8/2/2016.
 */
public class MyDeserializeGSON<T> implements JsonDeserializer<T> {

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        JsonElement element = json.getAsJsonObject().get("errors");

        return new Gson().fromJson(element, typeOfT);
    }
}
