package com.example.food8.condi_android;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by food8 on 2017-12-22.
 */

public interface ApiService {
    public static final String API_URL = "http://192.9.30.242/";

    @GET("index.php")
    Call<ResponseBody> getData(@Query("data") String aaa);
}
