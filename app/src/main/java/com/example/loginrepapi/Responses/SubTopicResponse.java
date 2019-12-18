package com.example.loginrepapi.Responses;

import java.util.ArrayList;

public class SubTopicResponse {
private ArrayList<SubTopicData> data;
private SubTopicInfo info;

    public SubTopicResponse(ArrayList<SubTopicData> data, SubTopicInfo info) {
        this.data = data;
        this.info = info;
    }

    public ArrayList<SubTopicData> getData() {
        return data;
    }

    public void setData(ArrayList<SubTopicData> data) {
        this.data = data;
    }

    public SubTopicInfo getInfo() {
        return info;
    }

    public void setInfo(SubTopicInfo info) {
        this.info = info;
    }
}
