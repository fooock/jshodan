package com.fooock.shodan.model.user;

import java.util.List;

/**
 *
 */
public class HttpHeader {

    private final List<Value> headers;

    HttpHeader(List<Value> headers) {
        this.headers = headers;
    }

    public List<Value> getHeaders() {
        return headers;
    }
}
