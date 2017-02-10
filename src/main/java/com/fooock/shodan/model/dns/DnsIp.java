package com.fooock.shodan.model.dns;

/**
 *
 */
public class DnsIp {

    private final String hostname;
    private final String ip;

    DnsIp(String hostname, String ip) {
        this.hostname = hostname;
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "DnsIp{" +
                "hostname='" + hostname + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
