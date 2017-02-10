package com.fooock.shodan.model.dns;

import java.util.Arrays;

/**
 *
 */
public class DnsHostname {

    private final String ip;
    private final String[] hostnames;

    DnsHostname(String ip, String[] hostnames) {
        this.ip = ip;
        this.hostnames = hostnames;
    }

    public String getIp() {
        return ip;
    }

    public String[] getHostnames() {
        return hostnames;
    }

    @Override
    public String toString() {
        return "DnsHostname{" +
                "ip='" + ip + '\'' +
                ", hostnames=" + Arrays.toString(hostnames) +
                '}';
    }
}
