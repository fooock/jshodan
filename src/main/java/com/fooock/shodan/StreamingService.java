package com.fooock.shodan;

import com.fooock.shodan.model.banner.Banner;
import com.fooock.shodan.model.banner.BannerReport;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import java.util.List;

/**
 * The Streaming API is an HTTP-based service that returns a real-time stream of data collected by Shodan.
 */
public interface StreamingService {

    /**
     * This stream provides ALL of the data that Shodan collects. Use this stream if you need access to everything
     * and/ or want to store your own Shodan database locally. If you only care about specific ports, please use
     * the Ports stream.
     *
     * @param apiKey account api key
     * @return {@link Observable<List<Banner>>}
     */
    @GET("shodan/banners")
    Observable<BannerReport> banners(@Query("key") String apiKey);

    /**
     * This stream provides a filtered, bandwidth-saving view of the Banners stream in case you are only
     * interested in devices located in certain ASNs.
     *
     * @param asn    Comma-separated list of ASNs; example "3303,32475"
     * @param apiKey account api key
     * @return {@link Observable<List<Banner>>}
     */
    @GET("shodan/asn/{asn}")
    Observable<BannerReport> bannersByAsn(@Path("asn") String asn, @Query("key") String apiKey);

    /**
     * This stream provides a filtered, bandwidth-saving view of the Banners stream in case you are only
     * interested in devices located in certain countries.
     *
     * @param countries Comma-separated list of countries indicated by their 2 letter code; example "DE,US"
     * @param apiKey    account api key
     * @return {@link Observable<List<Banner>>}
     */
    @GET("shodan/countries/{countries}")
    Observable<BannerReport> bannersByCountries(@Path("countries") String countries, @Query("key") String apiKey);

    /**
     * Only returns banner data for the list of specified ports. This stream provides a filtered, bandwidth-saving
     * view of the Banners stream in case you are only interested in a specific list of ports.
     *
     * @param ports  Comma-separated list of ports; example "1434,27017,6379"
     * @param apiKey account api key
     * @return {@link Observable<List<Banner>>}
     */
    @GET("shodan/ports/{ports}")
    Observable<BannerReport> bannersByPorts(@Path("ports") String ports, @Query("key") String apiKey);

}
