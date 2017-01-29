package com.fooock.shodan.model;

import com.fooock.shodan.model.banner.Banner;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 */
public class Host {

    private int ip;

    private double latitude;
    private double longitude;

    private int[] ports;

    private String[] hostnames;
    private String[] tags;

    @SerializedName("vulns")
    private String[] vulnerabilities;

    @SerializedName("region_code")
    private String regionCode;

    @SerializedName("area_code")
    private String areaCode;

    @SerializedName("postal_code")
    private String postalCode;

    @SerializedName("dma_code")
    private String dmaCode;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("org")
    private String organization;
    private String asn;
    private String city;
    private String isp;

    @SerializedName("last_update")
    private String lastUpdate;

    @SerializedName("country_code3")
    private String countryCode3;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("ip_str")
    private String ipStr;
    private String os;

    @SerializedName("data")
    private List<Banner> banners;

    Host() {

    }

    public int getIp() {
        return ip;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int[] getPorts() {
        return ports;
    }

    public String[] getHostnames() {
        return hostnames;
    }

    public String[] getTags() {
        return tags;
    }

    public String[] getVulnerabilities() {
        return vulnerabilities;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getDmaCode() {
        return dmaCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getOrganization() {
        return organization;
    }

    public String getAsn() {
        return asn;
    }

    public String getCity() {
        return city;
    }

    public String getIsp() {
        return isp;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getIpStr() {
        return ipStr;
    }

    public String getOs() {
        return os;
    }

    public List<Banner> getBanners() {
        return banners;
    }
}
