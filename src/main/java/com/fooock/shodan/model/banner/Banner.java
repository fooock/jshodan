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
 * The banner is the main type of information that Shodan provides through the REST and Streaming
 * API.
 */
public class Banner {

    private int port;

    private long ip;

    private String asn;
    private String data;
    private String ipStr;
    private String ipv6;
    private String timestamp;

    private String[] hostnames;
    private String[] domains;

    private Location location;

    @SerializedName("opts")
    private Options options;

    @SerializedName("_shodan")
    private Metadata metadata;

    // Optional properties
    private int uptime;

    private String link;
    private String title;
    private String html;
    private String product;
    private String version;
    private String isp;
    private String os;
    private String transport;

    @SerializedName("devicetype")
    private String deviceType;
    private String info;
    private String cpe;

    Banner() {

    }

    /**
     * @return The IP address of the host as an integer.
     */
    public long getIp() {
        return ip;
    }

    /**
     * @return The port number that the service is operating on.
     */
    public int getPort() {
        return port;
    }

    /**
     * @return The autonomous system number (ex. "AS4837")
     */
    public String getAsn() {
        return asn;
    }

    /**
     * @return Contains the banner information for the service.
     */
    public String getData() {
        return data;
    }

    /**
     * @return The IP address of the host as a string.
     */
    public String getIpStr() {
        return ipStr;
    }

    /**
     * @return The IPv6 address of the host as a string. If this is present then the "ip" and "ip_str"
     * fields wont be
     */
    public String getIpv6() {
        return ipv6;
    }

    /**
     * @return The timestamp for when the banner was fetched from the device in the UTC timezone.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @return An array of strings containing all of the hostnames that have been assigned to the IP
     * address for this device.
     */
    public String[] getHostnames() {
        return hostnames;
    }

    /**
     * @return An array of strings containing the top-level domains for the hostnames of the device.
     * This is a utility property in case you want to filter by TLD instead of subdomain. It is smart
     * enough to handle global TLDs with several dots in the domain (ex. "co.uk")
     */
    public String[] getDomains() {
        return domains;
    }

    /**
     * @return An object {@link Location} containing all of the location information for the device.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @return Contains experimental and supplemental data for the service. This can include the SSL
     * certificate, robots.txt and other raw information that hasn't yet been formalized into the
     * Banner Specification.
     */
    public Options getOptions() {
        return options;
    }

    /**
     * @return Shodan {@link Metadata}
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * @return The number of minutes that the device has been online.
     */
    public int getUptime() {
        return uptime;
    }

    /**
     * @return The network link type. Possible values are: "Ethernet or modem", "generic tunnel or
     * VPN", "DSL", "IPIP or SIT", "SLIP", "IPSec or GRE", "VLAN", "jumbo Ethernet", "Google", "GIF",
     * "PPTP", "loopback", "AX.25 radio modem".
     */
    public String getLink() {
        return link;
    }

    /**
     * @return The title of the website as extracted from the HTML source.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The raw HTML source for the website.
     */
    public String getHtml() {
        return html;
    }

    /**
     * @return The name of the product that generated the banner.
     */
    public String getProduct() {
        return product;
    }

    /**
     * @return The version of the product that generated the banner.
     */
    public String getVersion() {
        return version;
    }

    /**
     * @return The type of device (webcam, router, etc.).
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * @return Miscellaneous information that was extracted about the product.
     */
    public String getInfo() {
        return info;
    }

    /**
     * @return The relevant Common Platform Enumeration for the product or known vulnerabilities if
     * available.
     */
    public String getCpe() {
        return cpe;
    }

    /**
     * @return The ISP that is providing the organization with the IP space for this device. Consider
     * this the "parent" of the organization in terms of IP ownership.
     */
    public String getIsp() {
        return isp;
    }

    /**
     * @return The operating system that powers the device.
     */
    public String getOs() {
        return os;
    }

    /**
     * @return Either "udp" or "tcp" to indicate which IP transport protocol was used to fetch the
     * information
     */
    public String getTransport() {
        return transport;
    }
}
