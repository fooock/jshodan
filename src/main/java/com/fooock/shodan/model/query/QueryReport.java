package com.fooock.shodan.model.query;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 */
public class QueryReport {

    private final int total;

    @SerializedName("matches")
    private final List<Query> queries;

    public QueryReport(int total, List<Query> queries) {
        this.total = total;
        this.queries = queries;
    }

    public int getTotal() {
        return total;
    }

    public List<Query> getQueries() {
        return queries;
    }

    @Override
    public String toString() {
        return "QueryReport{" +
                "total=" + total +
                ", queries=" + queries +
                '}';
    }
}
