package com.example.loginrepapi.Interfaces;

import com.example.loginrepapi.Responses.BaashaTopicData;
import com.example.loginrepapi.Responses.BaashaTopicResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface BaashaaTopicService {
    @GET("explore-yourself")
    Call<BaashaTopicResponse> getTopics(@Header("Authorization") String authToken,
                                        @Query("source") String source,
                                        @Query("destination") String destination,
                                        @Query("mode") String mode,
                                        @Query("app_id") String app_id,
                                        @Query("page") String page);
}
