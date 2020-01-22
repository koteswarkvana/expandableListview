package com.kvana.expandablelistview.network;

import com.kvana.expandablelistview.Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface EdunixApikeys {

//    String BASE_URL = "http://52.183.29.32";

    //    https://api.learn2crack.com/android/jsonandroid/
    @GET("/android/jsonandroid")
    Call<String> getList();

    @POST("/admin/gate_keeper/item-history")
    Call<String> getdata(@Header("Content-Type") String content, @Body Model model);
}
