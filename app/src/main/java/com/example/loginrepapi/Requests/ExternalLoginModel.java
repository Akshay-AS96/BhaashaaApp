package com.example.loginrepapi.Requests;

public class ExternalLoginModel {
    private String id_token;
    private int login_type;
    private String client_id;
    private String client_secret;
    private String app_id;
    private int content_app_id;
    private int type;

    public ExternalLoginModel(String id_token, int login_type, String client_id, String client_secret,
                              String app_id, int content_app_id, int type) {
        this.id_token = id_token;
        this.login_type = login_type;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.app_id = app_id;
        this.content_app_id = content_app_id;
        this.type = type;
    }

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }

    public int getLogin_type() {
        return login_type;
    }

    public void setLogin_type(int login_type) {
        this.login_type = login_type;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public int getContent_app_id() {
        return content_app_id;
    }

    public void setContent_app_id(int content_app_id) {
        this.content_app_id = content_app_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
