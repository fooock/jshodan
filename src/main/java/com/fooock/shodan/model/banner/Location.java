/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Newhouse (nhitbh at gmail dot com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.fooock.shodan.model.banner;

import com.google.gson.annotations.SerializedName;

/**
 * An object containing all of the location information for the device.
 */
public class Location {

    @SerializedName("area_code")
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
     * @return The designated market area code for the area where the device is located. Only
     * available for the US.
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

    void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    void setCity(String city) {
        this.city = city;
    }

    void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    void setDmaCode(String dmaCode) {
        this.dmaCode = dmaCode;
    }

    void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    void setCountryName(String countryName) {
        this.countryName = countryName;
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
