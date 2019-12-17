package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class SubTopicInfo {
    private String status;
    private String message;
    private String items_per_page;
    private String current_page;
    private String api_version;
    @SerializedName("start-time")
    private String start_time;
    @SerializedName("start-time")
    private String end_time;

    public SubTopicInfo(String status, String message, String items_per_page, String current_page, String api_version, String start_time, String end_time) {
        this.status = status;
        this.message = message;
        this.items_per_page = items_per_page;
        this.current_page = current_page;
        this.api_version = api_version;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getItems_per_page() {
        return items_per_page;
    }

    public void setItems_per_page(String items_per_page) {
        this.items_per_page = items_per_page;
    }

    public String getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(String current_page) {
        this.current_page = current_page;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
