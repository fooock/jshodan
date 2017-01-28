package com.fooock.shodan.model.banner;

import com.fooock.shodan.model.Banner;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 */
public class BannerReport {

    private final int total;

    @SerializedName("matches")
    private final List<Banner> banners;

    public BannerReport(int total, List<Banner> banners) {
        this.total = total;
        this.banners = banners;
    }

    public int getTotal() {
        return total;
    }

    public List<Banner> getBanners() {
        return banners;
    }
}
