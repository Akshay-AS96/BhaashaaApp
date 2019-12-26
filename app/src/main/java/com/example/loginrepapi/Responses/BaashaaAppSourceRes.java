package com.example.loginrepapi.Responses;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class BaashaaAppSourceRes {
    @SerializedName("status")
    private String  status;
    @SerializedName("message")
    private String  message;
    @SerializedName("api_version")
    private String  api_version;
    @SerializedName("start-time")
    private String  start_time;
    @SerializedName("end-time")
    private String  end_time;

    public BaashaaAppSourceRes(String status, String message, String api_version, String start_time, String end_time) {
        this.status = status;
        this.message = message;
        this.api_version = api_version;
        this.start_time = start_time;
        this.end_time = end_time;
    }
}

