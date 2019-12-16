package com.example.loginrepapi.Interfaces;

import com.example.loginrepapi.Responses.TopicResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface TopicDataService {
    @GET("get-teachers-path-details")
    Call<TopicResponse> getAllposts(@Header("Authorization") String authToken,
                                    @Query("source") String source,
                                    @Query("destination") String destination,
                                    @Query("content_app_id") String content_app_id,
                                    @Query("type") String type);

}
