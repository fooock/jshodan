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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (credits != account.credits) return false;
        if (member != account.member) return false;
        if (displayName != null ? !displayName.equals(account.displayName) : account.displayName != null) return false;
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
