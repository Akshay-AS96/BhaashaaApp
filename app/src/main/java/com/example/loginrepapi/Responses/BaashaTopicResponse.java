package com.example.loginrepapi.Responses;

import java.util.ArrayList;

public class BaashaTopicResponse {
    ArrayList<BaashaTopicData> data;

    public BaashaTopicResponse(ArrayList<BaashaTopicData> data) {
        this.data = data;
    }

    public ArrayList<BaashaTopicData> getData() {
        return data;
    }

    public void setData(ArrayList<BaashaTopicData> data) {
        this.data = data;
    }
}
