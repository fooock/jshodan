package com.fooock.shodan;

import com.fooock.shodan.mock.ApiRestMock;
import com.fooock.shodan.model.host.Host;
import com.fooock.shodan.model.query.QueryReport;
import com.fooock.shodan.model.tag.TagReport;
import com.fooock.shodan.model.user.Account;
import com.fooock.shodan.model.user.ApiStatus;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;
import rx.observers.TestSubscriber;

import java.io.IOException;
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
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
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

        TestSubscriber<Account> subscriber = new TestSubscriber<>();

        apiRestMock.account(apiKey).subscribe(subscriber);

        subscriber.assertCompleted();
        subscriber.assertNoErrors();
    }

    @Test
    public void testFailureAccount() throws Exception {
        networkBehavior.setDelay(0, TimeUnit.MILLISECONDS);
        networkBehavior.setVariancePercent(0);
        networkBehavior.setFailurePercent(100);

        TestSubscriber<Account> subscriber = new TestSubscriber<>();

        apiRestMock.account(apiKey).subscribe(subscriber);

        subscriber.assertNoValues();
        subscriber.assertError(IOException.class);
    }

    @Test
    public void testApiStatusSuccess() throws Exception {
        TestSubscriber<ApiStatus> subscriber = new TestSubscriber<>();

        apiRestMock.info(apiKey).subscribe(subscriber);

        subscriber.assertCompleted();
        subscriber.assertNoErrors();
    }

    @Test
    public void testApiStatusFail() throws Exception {
        networkBehavior.setDelay(0, TimeUnit.MILLISECONDS);
        networkBehavior.setVariancePercent(0);
        networkBehavior.setFailurePercent(100);

        TestSubscriber<ApiStatus> subscriber = new TestSubscriber<>();

        apiRestMock.info(apiKey).subscribe(subscriber);

        subscriber.assertNoValues();
        subscriber.assertError(IOException.class);
    }

    @Test
    public void testSearchHostSuccess() throws Exception {
        TestSubscriber<Host> subscriber = new TestSubscriber<>();

        apiRestMock.host("127.0.0.1", apiKey).subscribe(subscriber);

        subscriber.assertCompleted();
        subscriber.assertNoErrors();
    }

    @Test
    public void testSearchHostMinifiedSuccess() throws Exception {
        TestSubscriber<Host> subscriber = new TestSubscriber<>();

        apiRestMock.host("127.0.0.1", apiKey, false, true).subscribe(subscriber);

        subscriber.assertCompleted();
        subscriber.assertNoErrors();
    }

    @Test
    public void testTagsSuccess() throws Exception {
        TestSubscriber<TagReport> subscriber = new TestSubscriber<>();

        apiRestMock.tags(apiKey).subscribe(subscriber);

        subscriber.assertCompleted();
        subscriber.assertNoErrors();
    }

    @Test
    public void testQueriesSuccess() throws Exception {
        TestSubscriber<QueryReport> subscriber = new TestSubscriber<>();

        apiRestMock.searches(apiKey, "webcam").subscribe(subscriber);

        subscriber.assertCompleted();
        subscriber.assertNoErrors();
    }
}