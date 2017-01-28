package com.fooock.shodan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 */
public class ReadJson {

    private ReadJson() {

    }

    public static String readFile(String fileName) {
        try {
            InputStream stream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            reader.close();
            return sb.toString();

        } catch (IOException e) {
            return "";
        }
    }
}
