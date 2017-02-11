package com.fooock.shodan.model;

import java.util.List;

/**
 *
 */
public class FacetReport {

    private final int total;
    private final List<Facet> facets;

    FacetReport(int total, List<Facet> facets) {
        this.total = total;
        this.facets = facets;
    }

    public int getTotal() {
        return total;
    }

    public List<Facet> getFacets() {
        return facets;
    }

    @Override
    public String toString() {
        return "FacetReport{" +
                "total=" + total +
                ", facets=" + facets +
                '}';
    }
}
