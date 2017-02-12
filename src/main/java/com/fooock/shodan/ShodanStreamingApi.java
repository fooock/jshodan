package com.fooock.shodan;

import com.fooock.shodan.model.banner.BannerReport;
import rx.Observable;

/**
 * Main entry point to request Shodan streaming data.
 * <p>
 * The Streaming API is an HTTP-based service that returns a real-time stream of data collected by Shodan.
 */
public final class ShodanStreamingApi extends AbstractApi {

    private final StreamingService streamingService;

    /**
     * Create this object with the account api key. If the key is null or empty
     * then an {@link IllegalArgumentException} is thrown
     *
     * @param apiKey account api key
     */
    public ShodanStreamingApi(String apiKey) {
        super(apiKey);
        this.streamingService = serviceCreator.getStreamingService();
    }

    /**
     * Subscribe to banners discovered on all IP ranges described in the network alerts.
     */
    public Observable<BannerReport> alert() {
        return streamingService.alert(apiKey);
    }

    /**
     * Subscribe to banners discovered on the IP range defined in a specific network alert.
     *
     * @param id The unique ID of the network alert; example "HKVGAIRWD79Z7W2T
     */
    public Observable<BannerReport> alert(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id con't be null or empty");
        }
        return streamingService.alert(id, apiKey);
    }

    /**
     * This stream provides ALL of the data that Shodan collects. Use this stream if you need access to everything
     * and/ or want to store your own Shodan database locally. If you only care about specific ports, please use
     * the Ports stream.
     */
    public Observable<BannerReport> banners() {
        return streamingService.banners(apiKey);
    }

    /**
     * This stream provides a filtered, bandwidth-saving view of the Banners stream in case you are only
     * interested in devices located in certain ASNs.
     *
     * @param asn Comma-separated list of ASNs; example "3303,32475"
     */
    public Observable<BannerReport> bannersByAsn(String asn) {
        if (asn == null || asn.isEmpty()) {
            throw new IllegalArgumentException("Asn can't be null or empty");
        }
        return streamingService.bannersByAsn(asn, apiKey);
    }

    /**
     * This stream provides a filtered, bandwidth-saving view of the Banners stream in case you are only
     * interested in devices located in certain countries.
     *
     * @param countries Comma-separated list of countries indicated by their 2 letter code; example "DE,US"
     */
    public Observable<BannerReport> bannersByCountry(String countries) {
        if (countries == null || countries.isEmpty()) {
            throw new IllegalArgumentException("Countries can't be null or empty");
        }
        return streamingService.bannersByCountries(countries, apiKey);
    }

    /**
     * Only returns banner data for the list of specified ports. This stream provides a filtered, bandwidth-saving
     * view of the Banners stream in case you are only interested in a specific list of ports.
     *
     * @param ports Comma-separated list of ports; example "1434,27017,6379"
     */
    public Observable<BannerReport> bannersByPort(String ports) {
        if (ports == null || ports.isEmpty()) {
            throw new IllegalArgumentException("Ports can't be null or empty");
        }
        return streamingService.bannersByPorts(ports, apiKey);
    }
}
