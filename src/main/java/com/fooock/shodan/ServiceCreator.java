package com.fooock.shodan;

import com.fooock.shodan.model.dns.DnsHostname;
import com.fooock.shodan.model.dns.DnsHostnameDeserializer;
import com.fooock.shodan.model.dns.DnsIp;
import com.fooock.shodan.model.dns.DnsIpDeserializer;
import com.fooock.shodan.model.exploit.Exploit;
import com.fooock.shodan.model.exploit.ExploitDeserializer;
import com.fooock.shodan.model.protocol.Protocol;
import com.fooock.shodan.model.protocol.ProtocolDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Class to create the three different services that Shodan supports
 */
class ServiceCreator {

    private static final String SHODAN_REST_API_URL = "https://api.shodan.io/";
    private static final String SHODAN_STREAMING_API_URL = "https://stream.shodan.io/";
    private static final String SHODAN_EXPLOIT_API_URL = "https://exploits.shodan.io/";

    private static class Loader {
        private static final OkHttpClient.Builder CLIENT_BUILDER = new OkHttpClient.Builder();

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

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(exploitType, new ExploitDeserializer())
                .registerTypeAdapter(dnsIpType, new DnsIpDeserializer())
                .registerTypeAdapter(dnsHostnameType, new DnsHostnameDeserializer())
                .registerTypeAdapter(protocolType, new ProtocolDeserializer())
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(Loader.CLIENT_BUILDER.build())
                .build();
        return retrofit.create(clazz);
    }
}
