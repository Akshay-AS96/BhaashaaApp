package com.example.loginrepapi;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    SharedPreferences pref;



    public SharedPreferencesManager(Context ctx) {
        pref = ctx.getSharedPreferences("MyPref", 0); // 0 - for private mode

    }

    public void saveAccessToken(String token){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("access_token", token); // Storing string
        editor.commit();

    }

    public String getAccessToken(){

        return pref.getString("access_token",null);
    }
    public void ClearToken()
    {
        pref.edit().clear().commit();
    }

    public void saveappId ( String appid){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("app id", appid); // Storing string
        editor.commit();

    }
    public String getappid(){

        return pref.getString("app id",null);
    }

}
