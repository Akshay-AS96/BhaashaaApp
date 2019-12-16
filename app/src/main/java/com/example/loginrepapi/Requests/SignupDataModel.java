package com.example.loginrepapi.Requests;

import com.google.gson.annotations.SerializedName;

public class SignupDataModel {
    @SerializedName("content_app_id")
    private int  content_app_id;
    @SerializedName("username")
    private String  username;
    @SerializedName("email")
    private String  email;
    @SerializedName("password")
    private String  password;
    @SerializedName("confirm_password")
    private String  confirm_password;

    public SignupDataModel(int content_app_id, String username, String email, String password, String confirm_password) {
        this.content_app_id = content_app_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
    }

    public int getContent_app_id() {
        return content_app_id;
    }

    public void setContent_app_id(int content_app_id) {
        this.content_app_id = content_app_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
}
