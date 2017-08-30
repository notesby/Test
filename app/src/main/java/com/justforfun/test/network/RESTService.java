package com.justforfun.test.network;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by hectormoreno on 8/30/17.
 */

public interface RESTService {
    @Headers({
            "SO: Android",
            "Version: 2.5.2"
    })
    @GET("users/{username}")
    Call<Response> getUser(@Path("username") String username);
}
