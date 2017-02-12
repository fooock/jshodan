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
