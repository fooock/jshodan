package com.fooock.shodan.model.user;

/**
 *
 */
public class Value {

    private final String key;
    private final String value;

    Value(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Value{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
