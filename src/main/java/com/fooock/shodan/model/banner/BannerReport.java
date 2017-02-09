package com.fooock.shodan.model.banner;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Contains a list of {@link Banner}s
 */
public class BannerReport {

    private final int total;

    @SerializedName("matches")
    private final List<Banner> banners;

    public BannerReport(int total, List<Banner> banners) {
        this.total = total;
        this.banners = banners;
    }

    /**
     * @return Total number of retrieved banners
     */
    public int getTotal() {
        return total;
    }

    /**
     * @return List of {@link Banner}s
     */
    public List<Banner> getBanners() {
        return banners;
    }
}
