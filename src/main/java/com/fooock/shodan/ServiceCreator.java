package com.fooock.shodan;

import com.fooock.shodan.model.exploit.Exploit;
import com.fooock.shodan.model.exploit.ExploitDeserializer;
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
 *
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

    ApiService getRestService() {
        return createService(ApiService.class, SHODAN_REST_API_URL);
    }

    StreamingService getStreamingService() {
        return createService(StreamingService.class, SHODAN_STREAMING_API_URL);
    }

    ExploitService getExploitService() {
        return createService(ExploitService.class, SHODAN_EXPLOIT_API_URL);
    }

    private static <T> T createService(Class<T> clazz, String baseUrl) {
        Type exploitType = new TypeToken<List<Exploit>>() {
        }.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(exploitType, new ExploitDeserializer()).create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(Loader.CLIENT_BUILDER.build())
                .build();
        return retrofit.create(clazz);
    }
}
