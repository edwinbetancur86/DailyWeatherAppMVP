package com.example.edwinb.agiletrailblazers.Deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Deserializer which deserializes the element into a generic object for later conversion at runtime.
 */
public class ElementToObjectDeserializer<T> implements JsonDeserializer<Object> {

    private final Class<T> clazz;
    private String serializedName;

    public ElementToObjectDeserializer(Class<T> clazz, String serializedName) {
        this.clazz = clazz;
        this.serializedName = serializedName;
    }

    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonArray()) {
            List<T> resultList = new ArrayList<>();
            for (JsonElement e : json.getAsJsonArray()) {
                resultList.add(context.<T>deserialize(e, clazz));
            }
            return resultList;
        } else if (json.isJsonPrimitive()) {
            return context.<T>deserialize(json, clazz);
        } else {
            throw new RuntimeException("Unexpected JSON type: " + json.getClass());
        }
    }

}
