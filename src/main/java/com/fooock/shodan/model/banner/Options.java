package com.fooock.shodan.model.banner;

/**
 * Contains experimental and supplemental data for the service. This can include the SSL certificate,
 * robots.txt and other raw information that hasn't yet been formalized into the Banner Specification.
 * <p>
 * This class is not completed, more info is needed
 */
public class Options {

    private String raw;

    Options() {

    }

    public String getRaw() {
        return raw;
    }

    @Override
    public String toString() {
        return "Options{" +
                "raw='" + raw + '\'' +
                '}';
    }
}
