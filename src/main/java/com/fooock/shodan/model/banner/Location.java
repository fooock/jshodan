package com.fooock.shodan.model.banner;

import com.google.gson.annotations.SerializedName;

/**
 * An object containing all of the location information for the device.
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

    /**
     * @return The area code for the device's location. Only available for the US.
     */
    public int getAreaCode() {
        return areaCode;
    }

    /**
     * @return The latitude for the geolocation of the device.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @return The longitude for the geolocation of the device.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @return The name of the city where the device is located.
     */
    public String getCity() {
        return city;
    }

    /**
     * @return The name of the region where the device is located.
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * @return The postal code for the device's location.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @return The designated market area code for the area where the device is located. Only available for the US.
     */
    public String getDmaCode() {
        return dmaCode;
    }

    /**
     * @return The 2-letter country code for the device location.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @return The 3-letter country code for the device location.
     */
    public String getCountryCode3() {
        return countryCode3;
    }

    /**
     * @return The name of the country where the device is located.
     */
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
