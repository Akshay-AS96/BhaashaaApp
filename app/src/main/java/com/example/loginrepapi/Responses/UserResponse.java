package com.example.loginrepapi.Responses;

import com.example.loginrepapi.Responses.UserData;
import com.example.loginrepapi.Responses.UserInfo;

import java.util.ArrayList;

public class UserResponse {
    private ArrayList<UserData> data;
    private UserInfo info;

    public UserResponse(ArrayList<UserData> data, UserInfo info) {
        this.data = data;
        this.info = info;
    }

    public ArrayList<UserData> getData() {
        return data;
    }

    public void setData(ArrayList<UserData> data) {
        this.data = data;
    }

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }
}
