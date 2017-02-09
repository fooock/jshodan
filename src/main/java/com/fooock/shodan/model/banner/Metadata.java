package com.fooock.shodan.model.banner;

/**
 * Shodan banner metadata
 */
public class Metadata {

    private String crawler;
    private String id;
    private String module;

    Metadata() {

    }

    public String getCrawler() {
        return crawler;
    }

    public String getId() {
        return id;
    }

    public String getModule() {
        return module;
    }
}
