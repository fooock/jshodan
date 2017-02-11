package com.fooock.shodan.model.host;

import com.fooock.shodan.model.banner.Banner;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 */
public class HostReport {

    private final int total;

    @SerializedName("matches")
    private final List<Banner> banners;
    private final FacetReport facets;

    public HostReport(int total, List<Banner> hosts, FacetReport facets) {
        this.total = total;
        this.banners = hosts;
        this.facets = facets;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public FacetReport getFacets() {
        return facets;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "HostReport{" +
                "total=" + total +
                ", banners=" + banners +
                ", facets=" + facets +
                '}';
    }
}
