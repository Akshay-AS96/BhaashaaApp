package com.example.loginrepapi.Responses;

import java.util.ArrayList;

public class EntityResponse {

    private ArrayList<EntityData> data;
    private EntityInfo info;

    public EntityResponse(ArrayList<EntityData> data, EntityInfo info) {
        this.data = data;
        this.info = info;
    }

    public ArrayList<EntityData> getData() {
        return data;
    }

    public void setData(ArrayList<EntityData> data) {
        this.data = data;
    }

    public EntityInfo getInfo() {
        return info;
    }

    public void setInfo(EntityInfo info) {
        this.info = info;
    }

}
