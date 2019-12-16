package com.example.loginrepapi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.loginrepapi.R;
import com.example.loginrepapi.SharedPreferencesManager;

public class SplashScreenActivity extends AppCompatActivity {

    SharedPreferencesManager sharedPreferencesManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPreferencesManager=new SharedPreferencesManager(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String access_token=sharedPreferencesManager.getAccessToken();
                if(access_token!=null){
                    Intent intent=new Intent(SplashScreenActivity.this, DashBoardVpager.class);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },2000);
    }
}
