package com.fooock.shodan.model.dns;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class DnsIpDeserializer implements JsonDeserializer<List<DnsIp>> {

    @Override
    public List<DnsIp> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        final List<DnsIp> dns = new ArrayList<>();

        if (json.isJsonNull()) {
            return dns;
        }
        JsonObject jsonObject = json.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();

            DnsIp dnsIp = new DnsIp(key, value.getAsString());
            dns.add(dnsIp);
        }
        return dns;
    }
}
