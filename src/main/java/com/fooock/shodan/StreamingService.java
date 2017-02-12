package com.fooock.shodan;

import com.fooock.shodan.model.banner.BannerReport;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * The Streaming API is an HTTP-based service that returns a real-time stream of data collected by Shodan.
 */
public interface StreamingService {

    /**
     * Subscribe to banners discovered on all IP ranges described in the network alerts.
     *
     * @param apiKey account api key
     */
    @GET("shodan/alert")
    Observable<BannerReport> alert(@Query(Constants.KEY) String apiKey);

    /**
     * Subscribe to banners discovered on the IP range defined in a specific network alert.
     *
     * @param id     The unique ID of the network alert; example "HKVGAIRWD79Z7W2T"
     * @param apiKey account api key
     */
    @GET("shodan/alert/{id}")
    Observable<BannerReport> alert(@Path(Constants.ID) String id, @Query(Constants.KEY) String apiKey);

    /**
     * This stream provides ALL of the data that Shodan collects. Use this stream if you need access to everything
     * and/ or want to store your own Shodan database locally. If you only care about specific ports, please use
     * the Ports stream.
     *
     * @param apiKey account api key
     */
    @GET("shodan/banners")
    Observable<BannerReport> banners(@Query(Constants.KEY) String apiKey);

    /**
     * This stream provides a filtered, bandwidth-saving view of the Banners stream in case you are only
     * interested in devices located in certain ASNs.
     *
     * @param asn    Comma-separated list of ASNs; example "3303,32475"
     * @param apiKey account api key
     */
    @GET("shodan/asn/{asn}")
    Observable<BannerReport> bannersByAsn(@Path(Constants.ASN) String asn, @Query(Constants.KEY) String apiKey);

    /**
     * This stream provides a filtered, bandwidth-saving view of the Banners stream in case you are only
     * interested in devices located in certain countries.
     *
     * @param countries Comma-separated list of countries indicated by their 2 letter code; example "DE,US"
     * @param apiKey    account api key
     */
    @GET("shodan/countries/{countries}")
    Observable<BannerReport> bannersByCountries(@Path(Constants.COUNTRIES) String countries,
                                                @Query(Constants.KEY) String apiKey);

    /**
     * Only returns banner data for the list of specified ports. This stream provides a filtered, bandwidth-saving
     * view of the Banners stream in case you are only interested in a specific list of ports.
     *
     * @param ports  Comma-separated list of ports; example "1434,27017,6379"
     * @param apiKey account api key
     */
    @GET("shodan/ports/{ports}")
    Observable<BannerReport> bannersByPorts(@Path(Constants.PORTS) String ports, @Query(Constants.KEY) String apiKey);

}
