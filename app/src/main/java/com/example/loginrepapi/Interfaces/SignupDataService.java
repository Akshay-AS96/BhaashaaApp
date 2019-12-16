package com.example.loginrepapi.Interfaces;

import com.example.loginrepapi.Requests.SignupDataModel;
import com.example.loginrepapi.Responses.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignupDataService {
    @POST("student-registration")
    Call<SignupResponse> getAllposts(@Body SignupDataModel signupDataModel);
}
