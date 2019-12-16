package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("items_per_page")
    int items_per_page;
    @SerializedName("page_count")
    int page_count;
    @SerializedName("current_page")
    int current_page;
    @SerializedName("api_version")
    int api_version;

    public UserInfo(String status, String message, int items_per_page, int page_count, int current_page, int api_version) {
        this.status = status;
        this.message = message;
        this.items_per_page = items_per_page;
        this.page_count = page_count;
        this.current_page = current_page;
        this.api_version = api_version;
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

    public int getItems_per_page() {
        return items_per_page;
    }

    public void setItems_per_page(int items_per_page) {
        this.items_per_page = items_per_page;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getApi_version() {
        return api_version;
    }

    public void setApi_version(int api_version) {
        this.api_version = api_version;
    }
}
