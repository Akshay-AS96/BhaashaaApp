package com.example.loginrepapi.Interfaces;

import com.example.loginrepapi.Requests.ExternalLoginModel;
import com.example.loginrepapi.Responses.ExternalLoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ExternalLoginDataService {
        @POST("external-registeration")
        Call<ExternalLoginResponse> getAllsignin(@Body ExternalLoginModel externalLoginModel);


}
