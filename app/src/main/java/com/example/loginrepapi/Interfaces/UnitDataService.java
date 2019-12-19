package com.example.loginrepapi.Interfaces;

import com.example.loginrepapi.Responses.UnitResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface UnitDataService {
    @GET("get-teachers-path-details")
    Call<UnitResponse> getAllposts(@Header("Authorization") String authToken,
                                    @Query("source") String source,
                                    @Query("destination") String destination,
                                    @Query("content_app_id") String content_app_id,
                                    @Query("type") String type,
                                    @Query("subtopic_id") String subtopic_id,
                                    @Query("page") String page);

}
