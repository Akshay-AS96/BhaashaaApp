package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("id")
    int id;
    @SerializedName("content_app_id")
    int content_app_id;
    @SerializedName("firstname")
    String firstname;
    @SerializedName("lastname")
    String lastname;
    @SerializedName("email")
    String email;
    @SerializedName("mobile")
    int mobile;
    @SerializedName("username")
    String username;

    public UserData(int id, int content_app_id, String firstname, String lastname, String email, int mobile, String username) {
        this.id = id;
        this.content_app_id = content_app_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContent_app_id() {
        return content_app_id;
    }

    public void setContent_app_id(int content_app_id) {
        this.content_app_id = content_app_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
