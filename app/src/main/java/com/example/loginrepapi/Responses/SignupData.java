package com.example.loginrepapi.Responses;

import com.google.gson.annotations.SerializedName;

public class SignupData {
    @SerializedName("student_id")
    private String  student_id;

    public String getStudent_id() {
        return student_id;
    }

    public SignupData(String student_id) {
        this.student_id = student_id;
    }
}
