package com.fooock.shodan.model.user;

import com.google.gson.annotations.SerializedName;

/**
 *
 */
public class ApiStatus {

    private boolean https;
    private boolean unlocked;
    private boolean telnet;

    @SerializedName("query_credits")
    private int queryCredits;

    @SerializedName("scan_credits")
    private int scanCredits;

    private String plan;

    ApiStatus() {

    }

    public boolean isHttps() {
        return https;
    }

    void setHttps(boolean https) {
        this.https = https;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public boolean isTelnet() {
        return telnet;
    }

    void setTelnet(boolean telnet) {
        this.telnet = telnet;
    }

    public int getQueryCredits() {
        return queryCredits;
    }

    void setQueryCredits(int queryCredits) {
        this.queryCredits = queryCredits;
    }

    public int getScanCredits() {
        return scanCredits;
    }

    void setScanCredits(int scanCredits) {
        this.scanCredits = scanCredits;
    }

    public String getPlan() {
        return plan;
    }

    void setPlan(String plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "ApiStatus{" +
                "https=" + https +
                ", unlocked=" + unlocked +
                ", telnet=" + telnet +
                ", queryCredits=" + queryCredits +
                ", scanCredits=" + scanCredits +
                ", plan='" + plan + '\'' +
                '}';
    }
}
