package com.fooock.shodan.model.query;

import java.util.Arrays;

/**
 *
 */
public class Query {

    private int votes;

    private String description;
    private String title;
    private String timestamp;
    private String query;

    private String[] tags;

    Query() {

    }

    public int getVotes() {
        return votes;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getQuery() {
        return query;
    }

    public String[] getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Query{" +
                "votes=" + votes +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", query='" + query + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
