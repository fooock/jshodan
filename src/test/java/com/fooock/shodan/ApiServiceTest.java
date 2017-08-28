package com.fooock.shodan;

import com.fooock.shodan.mock.ApiRestMock;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ApiServiceTest {

    private String apiKey = "1234567890";
    private NetworkBehavior networkBehavior = NetworkBehavior.create();
    private ApiService apiRestMock;

    @Before
    public void setUp() throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.shodan.io/")
                .build();

        MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
                .networkBehavior(networkBehavior).build();

        BehaviorDelegate<ApiService> delegate = mockRetrofit.create(ApiService.class);
        apiRestMock = new ApiRestMock(delegate);
    }

    @Test
    public void testSuccessAccount() throws Exception {
        networkBehavior.setDelay(0, TimeUnit.MILLISECONDS);
        networkBehavior.setVariancePercent(0);
        networkBehavior.setFailurePercent(0);

        apiRestMock.account(apiKey).subscribe();
    }

    @Test
    public void testFailureAccount() throws Exception {
        networkBehavior.setDelay(0, TimeUnit.MILLISECONDS);
        networkBehavior.setVariancePercent(0);
        networkBehavior.setFailurePercent(100);

        apiRestMock.account(apiKey).subscribe();
    }

    @Test
    public void testApiStatusSuccess() throws Exception {
        apiRestMock.info(apiKey).subscribe();
    }

    @Test
    public void testApiStatusFail() throws Exception {
        networkBehavior.setDelay(0, TimeUnit.MILLISECONDS);
        networkBehavior.setVariancePercent(0);
        networkBehavior.setFailurePercent(100);

        apiRestMock.info(apiKey).subscribe();
    }

    @Test
    public void testSearchHostSuccess() throws Exception {
        apiRestMock.hostByIp("127.0.0.1", apiKey).subscribe();
    }

    @Test
    public void testSearchHostMinifiedSuccess() throws Exception {
        apiRestMock.hostByIp("127.0.0.1", apiKey, false, true).subscribe();
    }

    @Test
    public void testTagsSuccess() throws Exception {
        apiRestMock.tags(apiKey).subscribe();
    }

    @Test
    public void testQueriesSuccess() throws Exception {
        apiRestMock.searches(apiKey, "webcam").subscribe();
    }

    @Test
    public void testTokensSuccess() throws Exception {
        apiRestMock.tokens(apiKey, "apache country:DE port:1234").subscribe();
    }
}