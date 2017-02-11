package com.fooock.shodan.model.host;

import com.fooock.shodan.model.Property;

import java.util.List;

/**
 *
 */
public class Facet {

    private final String name;
    private final List<Property> properties;

    Facet(String name, List<Property> properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "Facet{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                '}';
    }
}
