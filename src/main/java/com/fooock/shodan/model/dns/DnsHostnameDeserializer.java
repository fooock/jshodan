package com.fooock.shodan.model.dns;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class DnsHostnameDeserializer implements JsonDeserializer<List<DnsHostname>> {

    @Override
    public List<DnsHostname> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        final List<DnsHostname> dnsHostnames = new ArrayList<>();

        if (json.isJsonNull()) {
            return dnsHostnames;
        }
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject == null) {
            return dnsHostnames;
        }
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();

            if (value == null || value.isJsonNull()) {
                String[] unknown = new String[]{""};
                DnsHostname dnsHostname = new DnsHostname(key, unknown);
                dnsHostnames.add(dnsHostname);
                continue;
            }

            String hostnameString = value.getAsString();
            if (hostnameString != null && !hostnameString.isEmpty()) {
                String[] hostnames = hostnameString.split(",");

                DnsHostname dnsHostname = new DnsHostname(key, hostnames);
                dnsHostnames.add(dnsHostname);
            }
        }
        return dnsHostnames;
    }
}
