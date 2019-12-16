package com.example.loginrepapi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpClientInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://dev.baashaa.com/school_api/public/";

    public static Retrofit getRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        httpClient.readTimeout(60L, TimeUnit.SECONDS);
        httpClient.interceptors().add(logging);

        httpClient.addNetworkInterceptor(new Interceptor() {
            public Response intercept(Chain chain) throws IOException {
                okhttp3.Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("Accept", "application/json");
                builder.addHeader("Content-Type", "application/json");

                return chain.proceed(builder.build());
            }
        });
        OkHttpClient client = httpClient.build();
        if (retrofit == null) {
            retrofit = (new retrofit2.Retrofit.Builder()).baseUrl(BASE_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }


        return retrofit;


    }
}
