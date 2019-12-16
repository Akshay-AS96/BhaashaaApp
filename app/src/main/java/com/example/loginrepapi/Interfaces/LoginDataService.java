package com.example.loginrepapi.Interfaces;

import com.example.loginrepapi.Requests.LoginDataModel;
import com.example.loginrepapi.Responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginDataService {
    @POST("login")
    Call<LoginResponse> getAllposts(@Body LoginDataModel loginDataModel);
}
