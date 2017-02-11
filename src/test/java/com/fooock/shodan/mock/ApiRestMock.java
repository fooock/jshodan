package com.fooock.shodan.mock;

import com.fooock.shodan.ApiService;
import com.fooock.shodan.ReadJson;
import com.fooock.shodan.model.FacetReport;
import com.fooock.shodan.model.dns.DnsHostname;
import com.fooock.shodan.model.dns.DnsIp;
import com.fooock.shodan.model.host.Host;
import com.fooock.shodan.model.host.HostReport;
import com.fooock.shodan.model.protocol.Protocol;
import com.fooock.shodan.model.query.QueryReport;
import com.fooock.shodan.model.tag.TagReport;
import com.fooock.shodan.model.token.TokenReport;
import com.fooock.shodan.model.user.Account;
import com.fooock.shodan.model.user.ApiStatus;
import com.fooock.shodan.model.user.HttpHeader;
import com.google.gson.Gson;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

import java.util.List;

/**
 *
 */
public class ApiRestMock implements ApiService {

    private final Gson gson = new Gson();
    private final BehaviorDelegate<ApiService> behaviorDelegate;

    public ApiRestMock(BehaviorDelegate<ApiService> behaviorDelegate) {
        this.behaviorDelegate = behaviorDelegate;
    }

    @Override
    public Observable<List<Protocol>> protocols(@Query("key") String apiKey) {
        return null;
    }

    @Override
    public Observable<List<DnsHostname>> reverseDns(@Query("key") String apiKey, @Query("ips") String ips) {
        return null;
    }

    @Override
    public Observable<List<DnsIp>> resolveDns(@Query("key") String apiKey, @Query("hostnames") String hostnames) {
        return null;
    }

    @Override
    public Observable<List<Integer>> ports(@Query("key") String apiKey) {
        return null;
    }

    @Override
    public Observable<TokenReport> tokens(@Query("key") String apiKey, @Query("query") String query) {
        TokenReport tokenReport = gson.fromJson(ReadJson.readFile("search_token.json"), TokenReport.class);
        return behaviorDelegate.returningResponse(tokenReport).tokens(apiKey, query);
    }

    @Override
    public Observable<QueryReport> queries(@Query("key") String apiKey) {
        return null;
    }

    @Override
    public Observable<QueryReport> queries(@Query("key") String apiKey, @Query("page") int page) {
        return null;
    }

    @Override
    public Observable<QueryReport> queries(@Query("key") String apiKey, @Query("page") int page, @Query("sort") String sort) {
        return null;
    }

    @Override
    public Observable<QueryReport> queries(@Query("key") String apiKey, @Query("page") int page, @Query("sort") String sort, @Query("order") String order) {
        return null;
    }

    @Override
    public Observable<QueryReport> searches(@Query("key") String apiKey, @Query("query") String query) {
        QueryReport queryReport = gson.fromJson(ReadJson.readFile("query_search.json"), QueryReport.class);
        return behaviorDelegate.returningResponse(queryReport).searches(apiKey, query);
    }

    @Override
    public Observable<QueryReport> searches(@Query("key") String apiKey, @Query("query") String query, @Query("page") int page) {
        return null;
    }

    @Override
    public Observable<TagReport> tags(@Query("key") String apiKey) {
        TagReport tagReport = gson.fromJson(ReadJson.readFile("tags.json"), TagReport.class);
        return behaviorDelegate.returningResponse(tagReport).tags(apiKey);
    }

    @Override
    public Observable<TagReport> tags(@Query("key") String apiKey, @Query("size") int tagNumber) {
        return null;
    }

    @Override
    public Observable<Host> hostByIp(@Path("ip") String ip, @Query("key") String apiKey) {
        Host host = gson.fromJson(ReadJson.readFile("shodan_host.json"), Host.class);
        return behaviorDelegate.returningResponse(host).hostByIp(ip, apiKey);
    }

    @Override
    public Observable<Host> hostByIp(@Path("ip") String ip, @Query("key") String apiKey, @Query("history") boolean history) {
        return null;
    }

    @Override
    public Observable<Host> hostByIp(@Path("ip") String ip, @Query("key") String apiKey, @Query("history") boolean history, @Query("minify") boolean minify) {
        Host host = gson.fromJson(ReadJson.readFile("shodan_host_minified.json"), Host.class);
        return behaviorDelegate.returningResponse(host).hostByIp(ip, apiKey, history, minify);
    }

    @Override
    public Observable<FacetReport> hostCount(@Query("key") String apiKey, @Query("query") String query) {
        return null;
    }

    @Override
    public Observable<FacetReport> hostCount(@Query("key") String apiKey, @Query("query") String query, @Query("facets") String facets) {
        return null;
    }

    @Override
    public Observable<HostReport> hostSearch(@Query("key") String apiKey, @Query("query") String query) {
        return null;
    }

    @Override
    public Observable<HostReport> hostSearch(@Query("key") String apiKey, @Query("query") String query, @Query("facets") String facets) {
        return null;
    }

    @Override
    public Observable<HostReport> hostSearch(@Query("key") String apiKey, @Query("query") String query, @Query("facets") String facets, @Query("page") int page) {
        return null;
    }

    @Override
    public Observable<Account> account(@Query("key") String apiKey) {
        Account account = gson.fromJson(
                ReadJson.readFile("account.json"), Account.class);
        return behaviorDelegate.returningResponse(account).account(apiKey);
    }

    @Override
    public Observable<ApiStatus> info(@Query("key") String apiKey) {
        ApiStatus apiStatus = gson.fromJson(ReadJson.readFile("api_info.json"), ApiStatus.class);
        return behaviorDelegate.returningResponse(apiStatus).info(apiKey);
    }

    @Override
    public Observable<String> ip(@Query("key") String apiKey) {
        return null;
    }

    @Override
    public Observable<HttpHeader> httpHeaders(@Query("key") String apiKey) {
        return null;
    }

    @Override
    public Observable<Float> honeyScore(@Path("ip") String ip, @Query("key") String apiKey) {
        return null;
    }
}
