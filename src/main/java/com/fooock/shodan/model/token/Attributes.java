package com.fooock.shodan.model.token;

import java.util.Arrays;

/**
 *
 */
public class Attributes {

    private int[] ports;

    Attributes() {

    }

    public int[] getPorts() {
        return ports;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "ports=" + Arrays.toString(ports) +
                '}';
    }
}
