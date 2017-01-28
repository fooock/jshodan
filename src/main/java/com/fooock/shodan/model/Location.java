package com.fooock.shodan.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 */
public class Location {

    private int areaCode;

    private double latitude;
    private double longitude;

    private String city;

    @SerializedName("region_code")
    private String regionCode;

    @SerializedName("postal_code")
    private String postalCode;

    @SerializedName("dma_code")
    private String dmaCode;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("country_code3")
    private String countryCode3;

    @SerializedName("country_name")
    private String countryName;

    Location() {

    }

    public int getAreaCode() {
        return areaCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getRegionCode() {
        return regionCode;
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

    public String getCountryCode3() {
        return countryCode3;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "Location{" +
                "areaCode=" + areaCode +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", city='" + city + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", dmaCode='" + dmaCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryCode3='" + countryCode3 + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
