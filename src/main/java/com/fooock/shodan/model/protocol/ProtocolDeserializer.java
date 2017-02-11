package com.fooock.shodan.model.protocol;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ProtocolDeserializer implements JsonDeserializer<List<Protocol>> {

    @Override
    public List<Protocol> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        final List<Protocol> protocols = new ArrayList<>();

        if (json.isJsonNull()) {
            return protocols;
        }
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.isJsonNull()) {
            return protocols;
        }

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();

            Protocol protocol = new Protocol(key, value.getAsString());
            protocols.add(protocol);
        }
        return protocols;
    }
}
