package com.example.loginrepapi.Responses;

import com.example.loginrepapi.Responses.AppData;
import com.example.loginrepapi.Responses.Appinfo;

import java.util.ArrayList;

public class AppRegResponse {
    private Appinfo info;
    private ArrayList<AppData> data;

    public AppRegResponse(Appinfo info, ArrayList<AppData> data) {
        this.info = info;
        this.data = data;
    }

    public Appinfo getInfo() {
        return info;
    }

    public ArrayList<AppData> getData() {
        return data;
    }
}
