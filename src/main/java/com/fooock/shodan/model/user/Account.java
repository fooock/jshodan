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
 * Shodan account linked to the API KEY
 */
public class Account {

    private final int credits;
    private final boolean member;

    @SerializedName("display_name")
    private final String displayName;
    private final String created;

    Account(boolean member, int credits, String displayName, String created) {
        this.member = member;
        this.credits = credits;
        this.displayName = displayName;
        this.created = created;
    }

    public boolean isMember() {
        return member;
    }

    public int getCredits() {
        return credits;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (credits != account.credits) {
            return false;
        }
        if (member != account.member) {
            return false;
        }
        if (displayName != null ? !displayName.equals(account.displayName)
                : account.displayName != null) {
            return false;
        }
        return created.equals(account.created);
    }

    @Override
    public int hashCode() {
        int result = credits;
        result = 31 * result + (member ? 1 : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + created.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "credits=" + credits +
                ", member=" + member +
                ", displayName='" + displayName + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
