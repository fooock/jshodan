package com.fooock.shodan.model;

/**
 *
 */
public class Property {

    private final int count;
    private final String value;

    Property(int count, String value) {
        this.count = count;
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Property{" +
                "count=" + count +
                ", value='" + value + '\'' +
                '}';
    }
}
