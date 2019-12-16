package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class TopicInfo {
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


}
