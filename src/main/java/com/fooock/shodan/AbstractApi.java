package com.fooock.shodan;

/**
 * Base abstract class for all Shodan apis
 */
abstract class AbstractApi {

    final String apiKey;
    final ServiceCreator serviceCreator = new ServiceCreator();

    /**
     * Create a Shodan API. If the apiKey param is null or empty an {@link IllegalArgumentException}
     * is thrown
     *
     * @param apiKey account api key
     */
    AbstractApi(String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("Need to specify a valid api key!");
        }
        this.apiKey = apiKey.trim();
    }
}
