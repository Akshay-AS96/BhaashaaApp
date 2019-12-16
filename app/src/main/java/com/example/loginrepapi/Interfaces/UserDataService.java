package com.example.loginrepapi.Interfaces;

import com.example.loginrepapi.Responses.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface UserDataService {
    @GET("user")
    Call<UserResponse> getAllposts(@Header("Authorization") String authToken);
}
