package com.fooock.shodan;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class ServiceCreatorTest {

    private ServiceCreator serviceCreator;

    @Before
    public void setUp() throws Exception {
        serviceCreator = new ServiceCreator();
    }

    @Test
    public void testRestService() throws Exception {
        assertThat(serviceCreator.getRestService(), isA(ApiService.class));
    }

    @Test
    public void testExploitService() throws Exception {
        assertThat(serviceCreator.getExploitService(), isA(ExploitService.class));
    }

    @Test
    public void testStreamingService() throws Exception {
        assertThat(serviceCreator.getStreamingService(), isA(StreamingService.class));
    }
}