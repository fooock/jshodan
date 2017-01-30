package com.fooock.shodan.model.token;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 *
 */
public class TokenReport {

    @SerializedName("string")
    private String query;

    private String[] filters;
    private String[] errors;

    private Attributes attributes;

    TokenReport() {

    }

    public String getQuery() {
        return query;
    }

    public String[] getFilters() {
        return filters;
    }

    public String[] getErrors() {
        return errors;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "TokenReport{" +
                "query='" + query + '\'' +
                ", filters=" + Arrays.toString(filters) +
                ", errors=" + Arrays.toString(errors) +
                ", attributes=" + attributes +
                '}';
    }
}
