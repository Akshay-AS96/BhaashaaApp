package com.example.loginrepapi.Responses;

import com.example.loginrepapi.Responses.SignupData;
import com.example.loginrepapi.Responses.SignupInfo;

import java.util.ArrayList;

public class SignupResponse {
    private ArrayList<SignupData> data;
    private SignupInfo info;

    public SignupResponse(ArrayList<SignupData> data, SignupInfo info) {
        this.data = data;
        this.info = info;
    }

    public ArrayList<SignupData> getData() {
        return data;
    }

    public SignupInfo getInfo() {
        return info;
    }
}
