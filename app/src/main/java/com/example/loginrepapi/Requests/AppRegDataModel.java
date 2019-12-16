package com.example.loginrepapi.Requests;

import com.google.gson.annotations.SerializedName;

public class AppRegDataModel {

    @SerializedName("device_id")
    String device_id;
    @SerializedName("model_info")
    String model_info;
    @SerializedName("os_info")
    String os_info;
    @SerializedName("os_type")
    int os_type;
    @SerializedName("device_token")
    String device_token;
    @SerializedName("app_version")
    String app_version;
    @SerializedName("content_app_id")
    int content_app_id;
    @SerializedName("content_app_platform_id")
    int content_app_platform_id;
    @SerializedName("content_app_package_name")
    String content_app_package_name;

    public AppRegDataModel(String device_id, String model_info, String os_info, int os_type, String device_token, String app_version, int content_app_id, int content_app_platform_id, String content_app_package_name) {
        this.device_id = device_id;
        this.model_info = model_info;
        this.os_info = os_info;
        this.os_type = os_type;
        this.device_token = device_token;
        this.app_version = app_version;
        this.content_app_id = content_app_id;
        this.content_app_platform_id = content_app_platform_id;
        this.content_app_package_name = content_app_package_name;
    }

}
