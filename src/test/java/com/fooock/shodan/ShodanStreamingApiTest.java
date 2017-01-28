package com.fooock.shodan;

import org.junit.Test;

/**
 *
 */
public class ShodanStreamingApiTest {

    private final String apiKey = "1234567890";

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShodanRestApiWithNoKey() throws Exception {
        new ShodanStreamingApi(null);
        new ShodanStreamingApi("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBannersByAsnFail() throws Exception {
        ShodanStreamingApi shodanStreamingApi = new ShodanStreamingApi(apiKey);
        shodanStreamingApi.bannersByAsn("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBannersByCountryFail() throws Exception {
        ShodanStreamingApi shodanStreamingApi = new ShodanStreamingApi(apiKey);
        shodanStreamingApi.bannersByCountry("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBannersByPortFail() throws Exception {
        ShodanStreamingApi shodanStreamingApi = new ShodanStreamingApi(apiKey);
        shodanStreamingApi.bannersByPort(null);
    }
}