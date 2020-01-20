package com.kvana.expandablelistview.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitHandler {
    public static final String BASE_URL = "https://api.learn2crack.com";
//    https://api.learn2crack.com/android/jsonandroid/
    private static final RetrofitHandler ourInstance = new RetrofitHandler();

    public static RetrofitHandler getInstance() {
        return ourInstance;
    }

    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(3, TimeUnit.MINUTES)
            .connectTimeout(3, TimeUnit.MINUTES)
            .build();

    private RetrofitHandler() {
    }

    private Retrofit namesRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(StringConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private EdunixApikeys namesApikeys = namesRetrofit.create(EdunixApikeys.class);

    public Call<String> getNamesList() {
        return namesApikeys.getList();
    }
}
