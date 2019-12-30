package com.example.loginrepapi.Interfaces;

import com.example.loginrepapi.Responses.EntityResponse;
import com.example.loginrepapi.Responses.UnitResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface EntityDataService {
    @GET("explore-yourself")
    Call<EntityResponse> getAllEntity(@Header("Authorization") String authToken,
                                      @Query("source") String source,
                                      @Query("destination") String destination,
                                      @Query("app_id") String appid,
                                      @Query("type") String type,
                                      @Query("parent_id") String parentid,
                                      @Query("page") String page);
}
