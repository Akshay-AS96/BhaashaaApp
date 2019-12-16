package com.example.loginrepapi.Responses;

public class LogOutResponse {
    String status;
    String message;

    public LogOutResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
