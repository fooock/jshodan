package com.fooock.shodan.model.tag;

import com.fooock.shodan.model.Property;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 */
public class TagReport {

    private final int total;

    @SerializedName("matches")
    private final List<Property> tags;

    TagReport(int total, List<Property> tags) {
        this.total = total;
        this.tags = tags;
    }

    public List<Property> getTags() {
        return tags;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "TagReport{" +
                "total=" + total +
                ", tags=" + tags +
                '}';
    }
}
