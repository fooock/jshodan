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

package com.fooock.shodan.model.host;

import com.fooock.shodan.model.Property;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class FacetReportDeserializer implements JsonDeserializer<FacetReport> {

    @Override
    public FacetReport deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        if (json.isJsonNull()) {
            return new FacetReport(0, Collections.<Facet>emptyList());
        }
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject == null || jsonObject.isJsonNull()) {
            return new FacetReport(0, Collections.<Facet>emptyList());
        }
        JsonElement element = jsonObject.get("matches");
        if (element == null || element.isJsonNull()) {
            // parse directly facets, this is because when searching host with facets
            // the banners are parsed independently
            List<Facet> facets = getFacets(jsonObject);
            return new FacetReport(facets.size(), facets);

        } else {
            JsonElement totalElement = jsonObject.get("total");
            return parseFacetReport(jsonObject, totalElement);
        }
    }

    private FacetReport parseFacetReport(JsonObject jsonObject, JsonElement totalElement) {
        final int total = totalElement.getAsInt();
        JsonObject facetsElement = jsonObject.getAsJsonObject("facets");
        if (facetsElement == null || facetsElement.isJsonNull()) {
            return new FacetReport(total, Collections.<Facet>emptyList());
        }
        return new FacetReport(total, getFacets(facetsElement));
    }

    private List<Facet> getFacets(JsonObject facetsElement) {
        final List<Facet> facets = new ArrayList<>();

        for (Map.Entry<String, JsonElement> entry : facetsElement.entrySet()) {
            String key = entry.getKey();
            JsonElement property = entry.getValue();

            JsonArray jsonArray = property.getAsJsonArray();
            final List<Property> properties = new ArrayList<>(jsonArray.size());
            for (JsonElement element : jsonArray) {
                JsonObject facetElement = element.getAsJsonObject();
                JsonElement count = facetElement.get("count");
                JsonElement value = facetElement.get("value");

                final Property prop = new Property(count.getAsInt(), value.getAsString());
                properties.add(prop);
            }
            final Facet facet = new Facet(key, properties);
            facets.add(facet);
        }
        return facets;
    }
}
