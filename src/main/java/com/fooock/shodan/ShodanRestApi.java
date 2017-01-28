package com.fooock.shodan;

import com.fooock.shodan.model.Host;
import com.fooock.shodan.model.query.QueryReport;
import com.fooock.shodan.model.tag.TagReport;
import com.fooock.shodan.model.user.Account;
import com.fooock.shodan.model.user.ApiStatus;
import rx.Observable;

/**
 * Main entry point to make queries to the Shodan rest API
 * <p>
 * This API provides methods to queries Shodan, look up hosts, get summary information on queries and a variety
 * of utility methods to make developing easier
 */
public final class ShodanRestApi extends AbstractApi {

    private final ApiService apiService;

    /**
     * Create this object with the account api key. If the key is null or empty
     * then an {@link IllegalArgumentException} is thrown
     *
     * @param apiKey account api key
     */
    public ShodanRestApi(String apiKey) {
        super(apiKey);
        this.apiService = serviceCreator.getRestService();
    }

    public Observable<QueryReport> queries() {
        return apiService.queries(apiKey);
    }

    public Observable<QueryReport> queries(int page) {
        if (page < 0) {
            throw new IllegalArgumentException("Page can't be < 0");
        }
        return apiService.queries(apiKey, page);
    }

    public Observable<QueryReport> queries(int page, String sort) {
        if (page < 0) {
            throw new IllegalArgumentException("Page can't be < 0");
        }
        if (sort != null && !("votes".equals(sort) || "timestamp".equals(sort))) {
            throw new IllegalArgumentException("Sort possible values are vote or timestamp, "
                    + sort + " is not a valid value");
        }
        return apiService.queries(apiKey, page, sort);
    }

    public Observable<QueryReport> queries(int page, String sort, String order) {
        if (page < 0) {
            throw new IllegalArgumentException("Page can't be < 0");
        }
        if (sort != null && !("votes".equals(sort) || "timestamp".equals(sort))) {
            throw new IllegalArgumentException("Sort possible values are vote or timestamp, "
                    + sort + " is not a valid value");
        }
        if (order != null && !("asc".equals(order) || "desc".equals(order))) {
            throw new IllegalArgumentException("Order possible values are asc or desc, "
                    + sort + " is not a valid value");
        }
        return apiService.queries(apiKey, page, sort, order);
    }

    public Observable<QueryReport> searches(String query) {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.searches(apiKey, query);
    }

    public Observable<QueryReport> searches(int page, String query) {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        if (page < 0) {
            throw new IllegalArgumentException("Page can't be < 0");
        }
        return apiService.searches(apiKey, query, page);
    }

    public Observable<TagReport> tags() {
        return apiService.tags(apiKey);
    }

    public Observable<TagReport> tags(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Page can't be < 0");
        }
        return apiService.tags(apiKey, size);
    }

    public Observable<Host> host(String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.host(ip, apiKey);
    }

    public Observable<Host> host(boolean history, String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.host(ip, apiKey, history);
    }

    public Observable<Host> host(boolean history, boolean minify, String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.host(ip, apiKey, history, minify);
    }

    public Observable<Account> account() {
        return apiService.account(apiKey);
    }

    public Observable<ApiStatus> info() {
        return apiService.info(apiKey);
    }

    public Observable<String> ip() {
        return apiService.ip(apiKey);
    }

    public Observable<Float> honeyScore(String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.honeyScore(ip, apiKey);
    }
}
