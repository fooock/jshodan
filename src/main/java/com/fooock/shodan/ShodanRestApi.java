package com.fooock.shodan;

import com.fooock.shodan.model.host.Host;
import com.fooock.shodan.model.query.QueryReport;
import com.fooock.shodan.model.tag.TagReport;
import com.fooock.shodan.model.token.TokenReport;
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

    /**
     * This method lets you determine which filters are being used by the query string and what parameters
     * were provided to the filters.
     *
     * @param query Shodan search query. The provided string is used to search the database of banners in Shodan,
     *              with the additional option to provide filters inside the search query using a "filter:value" format.
     * @return {@link Observable<TokenReport>}
     */
    public Observable<TokenReport> tokens(String query) {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Query can't be null or empty");
        }
        return apiService.tokens(apiKey, query);
    }

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan. This method
     * return for default the first ten queries
     *
     * @return {@link Observable<QueryReport>}
     */
    public Observable<QueryReport> queries() {
        return apiService.queries(apiKey);
    }

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan. If the page
     * param is < 0 then an {@link IllegalArgumentException} is thrown
     *
     * @param page Page number to iterate over results; each page contains 10 items
     * @return {@link Observable<QueryReport>}
     */
    public Observable<QueryReport> queries(int page) {
        if (page < 0) {
            throw new IllegalArgumentException("Page can't be < 0");
        }
        return apiService.queries(apiKey, page);
    }

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan. If the page
     * param is < 0 then an {@link IllegalArgumentException} is thrown. Also the possible values for the
     * sort param are votes and timestamp
     *
     * @param page Page number to iterate over results; each page contains 10 items
     * @param sort Sort the list based on a property. Possible values are: votes, timestamp
     * @return {@link Observable<QueryReport>}
     */
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

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan. If the page
     * param is < 0 then an {@link IllegalArgumentException} is thrown. Also the possible values for the
     * sort param are votes and timestamp. The possible values for the order param are asc and desc
     *
     * @param page  Page number to iterate over results; each page contains 10 items
     * @param sort  Sort the list based on a property. Possible values are: votes, timestamp
     * @param order Whether to sort the list in ascending or descending order. Possible values are: asc, desc
     * @return {@link Observable<QueryReport>}
     */
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

    /**
     * Use this method to queries the directory of queries queries that users have saved in Shodan. For default
     * this method only return the first ten queries
     *
     * @param query What to queries for in the directory of saved queries queries.
     * @return {@link Observable<QueryReport>}
     */
    public Observable<QueryReport> searches(String query) {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.searches(apiKey, query);
    }

    /**
     * Use this method to queries the directory of queries that users have saved in Shodan.
     *
     * @param page  Page number to iterate over results; each page contains 10 items
     * @param query What to queries for in the directory of saved queries queries
     * @return {@link Observable<QueryReport>}
     */
    public Observable<QueryReport> searches(int page, String query) {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        if (page < 0) {
            throw new IllegalArgumentException("Page can't be < 0");
        }
        return apiService.searches(apiKey, query, page);
    }

    /**
     * Use this method to obtain a list of popular tags for the saved queries in Shodan. This method only
     * return the first ten tags
     *
     * @return {@link Observable<TagReport>}
     */
    public Observable<TagReport> tags() {
        return apiService.tags(apiKey);
    }

    /**
     * Use this method to obtain a list of popular tags for the saved queries in Shodan.
     *
     * @param size The number of tags to return (default 10).
     * @return {@link Observable<TagReport>}
     */
    public Observable<TagReport> tags(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Page can't be < 0");
        }
        return apiService.tags(apiKey, size);
    }

    /**
     * Returns all services that have been found on the given host IP.
     *
     * @param ip Host IP address
     * @return
     */
    public Observable<Host> host(String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.host(ip, apiKey);
    }

    /**
     * Returns all services that have been found on the given host IP with all historical data if the
     * history param is true (default is false)
     *
     * @param history True if all historical banners should be returned (default false)
     * @param ip      Host IP address
     * @return
     */
    public Observable<Host> host(boolean history, String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.host(ip, apiKey, history);
    }

    /**
     * Returns all services that have been found on the given host IP. If the minify param is true this method
     * returns only the list of ports and the general host information, no banners. If the history param is true
     * and minify also, then the history not takes effect
     *
     * @param history True if all historical banners should be returned (default false)
     * @param minify  True to only return the list of ports and the general host information, no banners (default false)
     * @param ip      Host IP address
     * @return
     */
    public Observable<Host> host(boolean history, boolean minify, String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.host(ip, apiKey, history, minify);
    }

    /**
     * Returns information about the Shodan account linked to the api key.
     *
     * @return {@link Observable<Account>}
     */
    public Observable<Account> account() {
        return apiService.account(apiKey);
    }

    /**
     * Returns information about the API plan belonging to the given API key.
     *
     * @return {@link Observable<ApiStatus>}
     */
    public Observable<ApiStatus> info() {
        return apiService.info(apiKey);
    }

    /**
     * Get your current IP address as seen from the Internet.
     *
     * @return {@link Observable<String>}
     */
    public Observable<String> ip() {
        return apiService.ip(apiKey);
    }

    /**
     * Calculates a honeypot probability score ranging from 0 (not a honeypot) to 1.0 (is a honeypot).
     *
     * @param ip Host IP address
     * @return {@link Observable<Float>}
     */
    public Observable<Float> honeyScore(String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.honeyScore(ip, apiKey);
    }
}
