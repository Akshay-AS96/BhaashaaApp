package com.example.loginrepapi.Requests;

import com.google.gson.annotations.SerializedName;

public class LoginDataModel {
    @SerializedName("client_id")
    private String  client_id;
    @SerializedName("client_secret")
    private String client_secret;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("grant_type")
    private String grant_type;
    @SerializedName("app_id")
    private String app_id;
    @SerializedName("content_app_id")
    private String content_app_id;
    @SerializedName("type")
    private int type;

    public LoginDataModel(String client_id, String client_secret, String username, String password,
                          String grant_type, String app_id, String content_app_id, int type) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.username = username;
        this.password = password;
        this.grant_type = grant_type;
        this.app_id = app_id;
        this.content_app_id = content_app_id;
        this.type = type;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public String getApp_id() {
        return app_id;
    }

    public String getContent_app_id() {
        return content_app_id;
    }

    public int getType() {
        return type;
    }
}
