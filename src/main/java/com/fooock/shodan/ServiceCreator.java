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

package com.fooock.shodan;

import com.fooock.shodan.model.dns.DnsHostname;
import com.fooock.shodan.model.dns.DnsHostnameDeserializer;
import com.fooock.shodan.model.dns.DnsIp;
import com.fooock.shodan.model.dns.DnsIpDeserializer;
import com.fooock.shodan.model.exploit.Exploit;
import com.fooock.shodan.model.exploit.ExploitDeserializer;
import com.fooock.shodan.model.host.FacetReport;
import com.fooock.shodan.model.host.FacetReportDeserializer;
import com.fooock.shodan.model.protocol.Protocol;
import com.fooock.shodan.model.protocol.ProtocolDeserializer;
import com.fooock.shodan.model.user.HttpHeader;
import com.fooock.shodan.model.user.HttpHeaderDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class to create the three different services that Shodan supports
 */
class ServiceCreator {

    private static final String SHODAN_REST_API_URL = "https://api.shodan.io/";
    private static final String SHODAN_STREAMING_API_URL = "https://stream.shodan.io/";
    private static final String SHODAN_EXPLOIT_API_URL = "https://exploits.shodan.io/";

    private static class Loader {

        private static final OkHttpClient.Builder CLIENT_BUILDER = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS);

        private Loader() {
            // empty
        }
    }

    /**
     * Shodan rest API
     *
     * @return {@link ApiService}
     */
    ApiService getRestService() {
        return createService(ApiService.class, SHODAN_REST_API_URL);
    }

    /**
     * Shodan streaming API
     *
     * @return {@link StreamingService}
     */
    StreamingService getStreamingService() {
        return createService(StreamingService.class, SHODAN_STREAMING_API_URL);
    }

    /**
     * Shodan exploit API
     *
     * @return {@link ExploitService}
     */
    ExploitService getExploitService() {
        return createService(ExploitService.class, SHODAN_EXPLOIT_API_URL);
    }

    /**
     * Method to create a service
     *
     * @param clazz   service class
     * @param baseUrl base url for the service
     * @param <T>     type of service
     * @return service implementation
     */
    private static <T> T createService(Class<T> clazz, String baseUrl) {
        Type exploitType = new TypeToken<List<Exploit>>() {
        }.getType();

        Type dnsIpType = new TypeToken<List<DnsIp>>() {
        }.getType();

        Type dnsHostnameType = new TypeToken<List<DnsHostname>>() {
        }.getType();

        Type protocolType = new TypeToken<List<Protocol>>() {
        }.getType();

        Type httpHeaderType = new TypeToken<HttpHeader>() {
        }.getType();

        Type facetReportType = new TypeToken<FacetReport>() {
        }.getType();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(exploitType, new ExploitDeserializer())
                .registerTypeAdapter(dnsIpType, new DnsIpDeserializer())
                .registerTypeAdapter(dnsHostnameType, new DnsHostnameDeserializer())
                .registerTypeAdapter(protocolType, new ProtocolDeserializer())
                .registerTypeAdapter(httpHeaderType, new HttpHeaderDeserializer())
                .registerTypeAdapter(facetReportType, new FacetReportDeserializer())
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(Loader.CLIENT_BUILDER.build())
                .build();
        return retrofit.create(clazz);
    }
}
