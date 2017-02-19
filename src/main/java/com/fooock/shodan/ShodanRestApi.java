/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Newhouse (nhitbh at gmail dot com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.fooock.shodan;

import com.fooock.shodan.model.dns.DnsHostname;
import com.fooock.shodan.model.dns.DnsIp;
import com.fooock.shodan.model.host.FacetReport;
import com.fooock.shodan.model.host.Host;
import com.fooock.shodan.model.host.HostReport;
import com.fooock.shodan.model.protocol.Protocol;
import com.fooock.shodan.model.query.QueryReport;
import com.fooock.shodan.model.tag.TagReport;
import com.fooock.shodan.model.token.TokenReport;
import com.fooock.shodan.model.user.Account;
import com.fooock.shodan.model.user.ApiStatus;
import com.fooock.shodan.model.user.HttpHeader;
import io.reactivex.Observable;

import java.util.List;

/**
 * Main entry point to make queries to the Shodan rest API <p> This API provides methods to queries
 * Shodan, look up hosts, get summary information on queries and a variety of utility methods to
 * make developing easier
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
     * This method returns an object containing all the protocols that can be used when launching an
     * Internet scan.
     */
    public Observable<List<Protocol>> protocols() {
        return apiService.protocols(apiKey);
    }

    /**
     * Look up the hostnames that have been defined for the given list of IP addresses.
     *
     * @param ips Comma-separated list of IP addresses; example "74.125.227.230,204.79.197.200"
     */
    public Observable<List<DnsHostname>> reverseDns(String ips) {
        if (ips == null || ips.isEmpty()) {
            throw new IllegalArgumentException("Ip's can't be null or empty");
        }
        return apiService.reverseDns(apiKey, ips);
    }

    /**
     * Look up the IP address for the provided list of hostnames.
     *
     * @param hostnames Comma-separated list of hostnames; example "google.com,bing.com"
     */
    public Observable<List<DnsIp>> resolveDns(String hostnames) {
        if (hostnames == null || hostnames.isEmpty()) {
            throw new IllegalArgumentException("Hostnames can't be null or empty");
        }
        return apiService.resolveDns(apiKey, hostnames);
    }

    /**
     * This method returns a list of port numbers that the crawlers are looking for.
     */
    public Observable<List<Integer>> ports() {
        return apiService.ports(apiKey);
    }

    /**
     * This method lets you determine which filters are being used by the query string and what
     * parameters were provided to the filters.
     *
     * @param query Shodan search query. The provided string is used to search the database of banners
     *              in Shodan, with the additional option to provide filters inside the search query using a
     *              "filter:value" format.
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
     */
    public Observable<QueryReport> queries() {
        return apiService.queries(apiKey);
    }

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan. If the page
     * param is &lt; 0 then an {@link IllegalArgumentException} is thrown
     *
     * @param page Page number to iterate over results; each page contains 10 items
     */
    public Observable<QueryReport> queries(int page) {
        if (page < 0) {
            throw new IllegalArgumentException("Page can't be < 0");
        }
        return apiService.queries(apiKey, page);
    }

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan. If the page
     * param is &lt; 0 then an {@link IllegalArgumentException} is thrown. Also the possible values
     * for the sort param are votes and timestamp
     *
     * @param page Page number to iterate over results; each page contains 10 items
     * @param sort Sort the list based on a property. Possible values are: votes, timestamp
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
     * param is &lt; 0 then an {@link IllegalArgumentException} is thrown. Also the possible values
     * for the sort param are votes and timestamp. The possible values for the order param are asc and
     * desc
     *
     * @param page  Page number to iterate over results; each page contains 10 items
     * @param sort  Sort the list based on a property. Possible values are: votes, timestamp
     * @param order Whether to sort the list in ascending or descending order. Possible values are:
     *              asc, desc
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
     * Use this method to queries the directory of queries queries that users have saved in Shodan.
     * For default this method only return the first ten queries
     *
     * @param query What to queries for in the directory of saved queries queries.
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
     * Use this method to obtain a list of popular tags for the saved queries in Shodan. This method
     * only return the first ten tags
     */
    public Observable<TagReport> tags() {
        return apiService.tags(apiKey);
    }

    /**
     * Use this method to obtain a list of popular tags for the saved queries in Shodan.
     *
     * @param size The number of tags to return (default 10).
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
     */
    public Observable<Host> hostByIp(String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.hostByIp(ip, apiKey);
    }

    /**
     * Returns all services that have been found on the given host IP with all historical data if the
     * history param is true (default is false)
     *
     * @param history True if all historical banners should be returned (default false)
     * @param ip      Host IP address
     */
    public Observable<Host> hostByIp(boolean history, String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.hostByIp(ip, apiKey, history);
    }

    /**
     * Returns all services that have been found on the given host IP. If the minify param is true
     * this method returns only the list of ports and the general host information, no banners. If the
     * history param is true and minify also, then the history not takes effect
     *
     * @param history True if all historical banners should be returned (default false)
     * @param minify  True to only return the list of ports and the general host information, no
     *                banners (default false)
     * @param ip      Host IP address
     */
    public Observable<Host> hostByIp(boolean history, boolean minify, String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.hostByIp(ip, apiKey, history, minify);
    }

    /**
     * This method behaves identical to {@link #hostSearch(String)} with the only difference that this
     * method does not return any host results, it only returns the total number of results that
     * matched the query and any facet information that was requested. As a result this method does
     * not consume query credits.
     *
     * @param query Shodan search query. The provided string is used to search the database of banners
     *              in Shodan, with the additional option to provide filters inside the search query using a
     *              "filter:value" format
     */
    public Observable<FacetReport> hostCount(String query) {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Query can't be null or empty");
        }
        return apiService.hostCount(apiKey, query);
    }

    /**
     * This method behaves identical to {@link #hostSearch(String)} with the only difference that this
     * method does not return any host results, it only returns the total number of results that
     * matched the query and any facet information that was requested. As a result this method does
     * not consume query credits.
     *
     * @param query Shodan search query. The provided string is used to search the database of banners
     *              in Shodan, with the additional option to provide filters inside the search query using a
     *              "filter:value" format
     */
    public Observable<FacetReport> hostCount(String query, String facets) {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Query can't be null or empty");
        }
        return apiService.hostCount(apiKey, query, facets);
    }

    /**
     * Search Shodan using the same query syntax as the website and use facets to get summary
     * information for different properties. This method may use API query credits depending on usage.
     * If any of the following criteria are met, your account will be deducated 1 query credit: <ul>
     * <li>The search query contains a filter.</li> <li>Accessing results past the 1st page using the
     * "page". For every 100 results past the 1st page 1 query credit is deducted.</li> </ul>
     *
     * @param query Shodan search query. The provided string is used to search the database of banners
     *              in Shodan, with the additional option to provide filters inside the search query using a
     *              "filter:value" format.
     */
    public Observable<HostReport> hostSearch(String query) {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Query can't be null or empty");
        }
        return apiService.hostSearch(apiKey, query);
    }

    /**
     * Search Shodan using the same query syntax as the website and use facets to get summary
     * information for different properties. This method may use API query credits depending on usage.
     * If any of the following criteria are met, your account will be deducated 1 query credit: <ul>
     * <li>The search query contains a filter.</li> <li>Accessing results past the 1st page using the
     * "page". For every 100 results past the 1st page 1 query credit is deducted.</li> </ul>
     *
     * @param query  Shodan search query. The provided string is used to search the database of banners
     *               in Shodan, with the additional option to provide filters inside the search query using a
     *               "filter:value" format.
     * @param facets A comma-separated list of properties to get summary information on. Property
     *               names can also be in the format of "property:count", where "count" is the number of facets that
     *               will be returned for a property
     */
    public Observable<HostReport> hostSearch(String query, String facets) {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Query can't be null or empty");
        }
        return apiService.hostSearch(apiKey, query, facets);
    }

    /**
     * Search Shodan using the same query syntax as the website and use facets to get summary
     * information for different properties. This method may use API query credits depending on usage.
     * If any of the following criteria are met, your account will be deducated 1 query credit: <ul>
     * <li>The search query contains a filter.</li> <li>Accessing results past the 1st page using the
     * "page". For every 100 results past the 1st page 1 query credit is deducted.</li> </ul>
     *
     * @param page   The page number to page through results 100 at a time (default: 1)
     * @param query  Shodan search query. The provided string is used to search the database of banners
     *               in Shodan, with the additional option to provide filters inside the search query using a
     *               "filter:value" format.
     * @param facets A comma-separated list of properties to get summary information on. Property
     *               names can also be in the format of "property:count", where "count" is the number of facets that
     *               will be returned for a property
     */
    public Observable<HostReport> hostSearch(int page, String query, String facets) {
        if (page < 0) {
            throw new IllegalArgumentException("Page can't be < 0");
        }
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Query can't be null or empty");
        }
        return apiService.hostSearch(apiKey, query, facets, page);
    }

    /**
     * Returns information about the Shodan account linked to the api key.
     */
    public Observable<Account> account() {
        return apiService.account(apiKey);
    }

    /**
     * Returns information about the API plan belonging to the given API key.
     */
    public Observable<ApiStatus> info() {
        return apiService.info(apiKey);
    }

    /**
     * Get your current IP address as seen from the Internet.
     */
    public Observable<String> ip() {
        return apiService.ip(apiKey);
    }

    /**
     * Shows the HTTP headers that your client sends when connecting to a webserver.
     */
    public Observable<HttpHeader> httpHeaders() {
        return apiService.httpHeaders(apiKey);
    }

    /**
     * Calculates a honeypot probability score ranging from 0 (not a honeypot) to 1.0 (is a honeypot).
     *
     * @param ip Host IP address
     */
    public Observable<Float> honeyScore(String ip) {
        if (ip == null || ip.isEmpty()) {
            throw new IllegalArgumentException("Ip can't be null or empty");
        }
        return apiService.honeyScore(ip, apiKey);
    }
}
