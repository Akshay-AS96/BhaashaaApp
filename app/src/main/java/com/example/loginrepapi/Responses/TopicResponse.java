package com.example.loginrepapi.Responses;

import com.example.loginrepapi.Responses.TopicData;
import com.example.loginrepapi.Responses.TopicInfo;

import java.util.ArrayList;

public class TopicResponse {
    private ArrayList<TopicData> data;
    private TopicInfo info;

    public TopicResponse(ArrayList<TopicData> data, TopicInfo info) {
        this.data = data;
        this.info = info;
    }

    public ArrayList<TopicData> getData() {
        return data;
    }

    public TopicInfo getInfo() {
        return info;
    }

    public void setData(ArrayList<TopicData> data) {
        this.data = data;
    }

    public void setInfo(TopicInfo info) {
        this.info = info;
    }

}
