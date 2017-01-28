package com.fooock.shodan;

/**
 *
 */
abstract class AbstractApi {

    final String apiKey;
    final ServiceCreator serviceCreator = new ServiceCreator();

    AbstractApi(String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("Need to specify a valid api key!");
        }
        this.apiKey = apiKey;
    }
}
