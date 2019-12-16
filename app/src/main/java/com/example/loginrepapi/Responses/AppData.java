package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class AppData {
    @SerializedName("app_id")
    private String  app_id;

    public AppData(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_id() {
        return app_id;
    }
}
