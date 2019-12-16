package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("access_token")
    private String  access_token;
    @SerializedName("expires_in")
    private int  expires_in;
    @SerializedName("token_type")
    private String  token_type;
    @SerializedName("scope")
    private String  scope;
    @SerializedName("refresh_token")
    private String  refresh_token;

    public String getAccess_token() {
        return access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getScope() {
        return scope;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public LoginResponse(String access_token, int expires_in, String token_type, String scope, String refresh_token) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.token_type = token_type;
        this.scope = scope;
        this.refresh_token = refresh_token;

    }
}
