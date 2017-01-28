package com.fooock.shodan;

import org.junit.Test;

/**
 *
 */
public class ShodanRestApiTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShodanRestApiWithNoKey() throws Exception {
        new ShodanRestApi(null);
        new ShodanRestApi("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHoneyScoreFail() throws Exception {
        ShodanRestApi restApi = new ShodanRestApi("1234567890");
        restApi.honeyScore(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHostFail() throws Exception {
        ShodanRestApi restApi = new ShodanRestApi("1234567890");
        restApi.host(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHostWithHistoryFail() throws Exception {
        ShodanRestApi restApi = new ShodanRestApi("1234567890");
        restApi.host(true, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHostWithMinifyFail() throws Exception {
        ShodanRestApi restApi = new ShodanRestApi("1234567890");
        restApi.host(false, true, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQueriesWithPage() throws Exception {
        ShodanRestApi restApi = new ShodanRestApi("1234567890");
        restApi.queries(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQueriesWithSortParam() throws Exception {
        ShodanRestApi restApi = new ShodanRestApi("1234567890");
        restApi.queries(0, "aaaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQueriesWithOrderParam() throws Exception {
        ShodanRestApi restApi = new ShodanRestApi("1234567890");
        restApi.queries(1, "votes", "bbb");
    }
}