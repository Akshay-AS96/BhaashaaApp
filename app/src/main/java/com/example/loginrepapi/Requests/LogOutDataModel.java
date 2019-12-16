package com.example.loginrepapi.Requests;

import com.google.gson.annotations.SerializedName;

public class LogOutDataModel {
    @SerializedName("app_id")
    String app_id;

    public LogOutDataModel(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_id() {
        return app_id;
    }
}
