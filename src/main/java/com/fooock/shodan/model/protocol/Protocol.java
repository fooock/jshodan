package com.fooock.shodan.model.protocol;

/**
 *
 */
public class Protocol {

    private final String name;
    private final String description;

    Protocol(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Protocol{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
