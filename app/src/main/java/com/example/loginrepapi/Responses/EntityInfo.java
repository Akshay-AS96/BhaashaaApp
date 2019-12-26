package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class EntityInfo {
    private String status;
    private String message;
    @SerializedName("items_per_page")
    private int itemsperpage;
    @SerializedName("page_count")
    private int pagecount;
    @SerializedName("current_page")
    private int currentpage;
    @SerializedName("apiversion")
    private String apiversion;
    @SerializedName("start-time")
    private String starttime;
    @SerializedName("end_time")
    private String endtime;

    public EntityInfo(String status, String message, int itemsperpage, int pagecount, int currentpage, String apiversion, String starttime, String endtime) {
        this.status = status;
        this.message = message;
        this.itemsperpage = itemsperpage;
        this.pagecount = pagecount;
        this.currentpage = currentpage;
        this.apiversion = apiversion;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getItemsperpage() {
        return itemsperpage;
    }

    public int getPagecount() {
        return pagecount;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public String getApiversion() {
        return apiversion;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }
}
