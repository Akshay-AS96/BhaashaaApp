package com.example.loginrepapi.Interfaces;

import com.example.loginrepapi.Requests.LogOutDataModel;
import com.example.loginrepapi.Responses.LogOutResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LogOutDataService {
    @POST("logout")
    Call<LogOutResponse> getAllposts(@Body LogOutDataModel logoutDataModel);
}
