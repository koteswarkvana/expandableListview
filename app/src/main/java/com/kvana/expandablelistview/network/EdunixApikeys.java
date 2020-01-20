package com.kvana.expandablelistview.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EdunixApikeys {

//    String BASE_URL = "http://52.183.29.32";

    //    https://api.learn2crack.com/android/jsonandroid/
    @GET("/android/jsonandroid")
    Call<String> getList();
}
