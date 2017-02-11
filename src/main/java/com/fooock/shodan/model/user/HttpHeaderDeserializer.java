package com.fooock.shodan.model.user;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class HttpHeaderDeserializer implements JsonDeserializer<HttpHeader> {

    @Override
    public HttpHeader deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        if (json.isJsonNull()) {
            return new HttpHeader(Collections.<Value>emptyList());
        }
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.isJsonNull()) {
            return new HttpHeader(Collections.<Value>emptyList());
        }

        final List<Value> values = new ArrayList<>();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();

            values.add(new Value(key, value.getAsString()));
        }
        return new HttpHeader(values);
    }
}
