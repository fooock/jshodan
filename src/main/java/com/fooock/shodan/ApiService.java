package com.fooock.shodan;

import com.fooock.shodan.model.host.Host;
import com.fooock.shodan.model.query.QueryReport;
import com.fooock.shodan.model.tag.TagReport;
import com.fooock.shodan.model.user.Account;
import com.fooock.shodan.model.user.ApiStatus;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * This API provides methods to queries Shodan, look up hosts, get summary information on queries and a variety
 * of utility methods to make developing easier
 */
public interface ApiService {

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan.
     *
     * @param apiKey account api key
     * @return {@link Observable<QueryReport>}
     */
    @GET("shodan/query")
    Observable<QueryReport> queries(@Query("key") String apiKey);

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan.
     *
     * @param apiKey account api key
     * @param page   Page number to iterate over results; each page contains 10 items
     * @return {@link Observable<QueryReport>}
     */
    @GET("shodan/query")
    Observable<QueryReport> queries(@Query("key") String apiKey, @Query("page") int page);

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan.
     *
     * @param apiKey account api key
     * @param page   Page number to iterate over results; each page contains 10 items
     * @param sort   Sort the list based on a property. Possible values are: votes, timestamp
     * @return {@link Observable<QueryReport>}
     */
    @GET("shodan/query")
    Observable<QueryReport> queries(@Query("key") String apiKey, @Query("page") int page, @Query("sort") String sort);

    /**
     * Use this method to obtain a list of search queries that users have saved in Shodan.
     *
     * @param apiKey account api key
     * @param page   Page number to iterate over results; each page contains 10 items
     * @param sort   Sort the list based on a property. Possible values are: votes, timestamp
     * @param order  Whether to sort the list in ascending or descending order. Possible values are: asc, desc
     * @return {@link Observable<QueryReport>}
     */
    @GET("shodan/query")
    Observable<QueryReport> queries(@Query("key") String apiKey,
                                    @Query("page") int page,
                                    @Query("sort") String sort,
                                    @Query("order") String order);

    /**
     * Use this method to queries the directory of queries that users have saved in Shodan. For default
     * this method only return the first ten queries
     *
     * @param apiKey account api key
     * @param query  What to queries for in the directory of saved queries queries.
     * @return {@link Observable<QueryReport>}
     */
    @GET("shodan/query/search")
    Observable<QueryReport> searches(@Query("key") String apiKey, @Query("query") String query);

    /**
     * Use this method to queries the directory of queries that users have saved in Shodan.
     *
     * @param apiKey account api key
     * @param query  What to queries for in the directory of saved queries queries.
     * @param page   Page number to iterate over results; each page contains 10 items
     * @return {@link Observable<QueryReport>}
     */
    @GET("shodan/query/search")
    Observable<QueryReport> searches(@Query("key") String apiKey, @Query("query") String query, @Query("page") int page);

    /**
     * Use this method to obtain a list of popular tags for the saved queries in Shodan. This method only
     * return the first ten tags
     *
     * @param apiKey account api key
     * @return {@link Observable<TagReport>}
     */
    @GET("shodan/query/tags")
    Observable<TagReport> tags(@Query("key") String apiKey);

    /**
     * Use this method to obtain a list of popular tags for the saved queries in Shodan.
     *
     * @param apiKey    account api key
     * @param tagNumber The number of tags to return (default 10).
     * @return {@link Observable<TagReport>}
     */
    @GET("shodan/query/tags")
    Observable<TagReport> tags(@Query("key") String apiKey, @Query("size") int tagNumber);

    /**
     * Returns all services that have been found on the given host IP.
     *
     * @param ip     Host IP address
     * @param apiKey account api key
     * @return {@link Observable<Host>}
     */
    @GET("shodan/host/{ip}")
    Observable<Host> host(@Path("ip") String ip, @Query("key") String apiKey);

    /**
     * Returns all services that have been found on the given host IP with all historical data if the
     * history param is true (default is false)
     *
     * @param ip      Host IP address
     * @param apiKey  account api key
     * @param history True if all historical banners should be returned (default false)
     * @return {@link Observable<Host>}
     */
    @GET("shodan/host/{ip}")
    Observable<Host> host(@Path("ip") String ip, @Query("key") String apiKey, @Query("history") boolean history);

    /**
     * Returns all services that have been found on the given host IP. If the minify param is true this method
     * returns only the list of ports and the general host information, no banners. If the history param is true
     * and minify also, then the history not takes effect
     *
     * @param ip      Host IP address
     * @param apiKey  account api key
     * @param history True if all historical banners should be returned (default false)
     * @param minify  True to only return the list of ports and the general host information, no banners (default false)
     * @return {@link Observable<Host>}
     */
    @GET("shodan/host/{ip}")
    Observable<Host> host(@Path("ip") String ip,
                          @Query("key") String apiKey,
                          @Query("history") boolean history,
                          @Query("minify") boolean minify);

    /**
     * Returns information about the Shodan account linked to the api key.
     *
     * @param apiKey account api key
     * @return {@link Observable<Account>}
     */
    @GET("account/profile")
    Observable<Account> account(@Query("key") String apiKey);

    /**
     * Returns information about the API plan belonging to the given API key.
     *
     * @param apiKey account api key
     * @return {@link Observable<ApiStatus>}
     */
    @GET("api-info")
    Observable<ApiStatus> info(@Query("key") String apiKey);

    /**
     * Get your current IP address as seen from the Internet.
     *
     * @param apiKey account api key
     * @return {@link Observable<String>}
     */
    @GET("tools/myip")
    Observable<String> ip(@Query("key") String apiKey);

    /**
     * Calculates a honeypot probability score ranging from 0 (not a honeypot) to 1.0 (is a honeypot).
     *
     * @param ip     Host IP address
     * @param apiKey account api key
     * @return {@link Observable<Float>}
     */
    @GET("labs/honeyscore/{ip}")
    Observable<Float> honeyScore(@Path("ip") String ip, @Query("key") String apiKey);
}
