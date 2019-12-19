package com.example.loginrepapi.Responses;

import java.util.ArrayList;

public class UnitResponse {
    private ArrayList<UnitData> data;
    private UnitInfo info;

    public UnitResponse(ArrayList<UnitData> data, UnitInfo info) {
        this.data = data;
        this.info = info;
    }

    public ArrayList<UnitData> getData() {
        return data;
    }

    public void setData(ArrayList<UnitData> data) {
        this.data = data;
    }

    public UnitInfo getInfo() {
        return info;
    }

    public void setInfo(UnitInfo info) {
        this.info = info;
    }
}
