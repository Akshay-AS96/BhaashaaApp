package com.example.loginrepapi.Interfaces;

import com.example.loginrepapi.Requests.AppRegDataModel;
import com.example.loginrepapi.Responses.AppRegResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AppDataService {
    @POST("app-registration")
    Call<AppRegResponse> getAllposts(@Body AppRegDataModel appData);
}
