package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class UnitInfo {
    private String status;
    private String message;
    private String items_per_page;
    private String page_count;
    private String current_page;
    private String api_version;
    @SerializedName("start-time")
    private String start_time;
    @SerializedName("end_time")
    private String end_time;

    public UnitInfo(String status, String message, String items_per_page, String page_count, String current_page, String api_version, String start_time, String end_time) {
        this.status = status;
        this.message = message;
        this.items_per_page = items_per_page;
        this.page_count = page_count;
        this.current_page = current_page;
        this.api_version = api_version;
        this.start_time = start_time;
        this.end_time = end_time;
    }

}
