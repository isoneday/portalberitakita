package com.workshop.aplikasiportalberita.portalberita.network;


import com.workshop.aplikasiportalberita.portalberita.helper.MyConstant;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {
    // URL Server API
  //  public static String API_URL = MyConstant.BASE_URL;




    private static Retrofit retrofit = null;

    public static Retrofit getClient(OkHttpClient.Builder httpClient) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(MyConstant.BASE_URL)                                  //<-- Base URL is loaded
                    .addConverterFactory(GsonConverterFactory.create()) //<-- Uses GSON convertor to convert the JSON to JAVA objects
                    .client(httpClient.build())                         //<-- Builds the request with OkHttp
                    .build();
        }
        return retrofit;
    }


}
