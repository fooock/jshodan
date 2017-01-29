package com.fooock.shodan.model.banner;

import com.google.gson.annotations.SerializedName;

/**
 *
 */
public class Banner {

    private int ip;
    private int port;

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

    public int getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getAsn() {
        return asn;
    }

    public String getData() {
        return data;
    }

    public String getIpStr() {
        return ipStr;
    }

    public String getIpv6() {
        return ipv6;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String[] getHostnames() {
        return hostnames;
    }

    public String[] getDomains() {
        return domains;
    }

    public Location getLocation() {
        return location;
    }

    public Options getOptions() {
        return options;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public int getUptime() {
        return uptime;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getHtml() {
        return html;
    }

    public String getProduct() {
        return product;
    }

    public String getVersion() {
        return version;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getInfo() {
        return info;
    }

    public String getCpe() {
        return cpe;
    }

    public String getIsp() {
        return isp;
    }

    public String getOs() {
        return os;
    }

    public String getTransport() {
        return transport;
    }
}
