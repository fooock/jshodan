/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Newhouse (nhitbh at gmail dot com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
    public List<DnsHostname> deserialize(JsonElement json, Type typeOfT,
                                         JsonDeserializationContext context)
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
