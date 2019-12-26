package com.example.loginrepapi.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginrepapi.Interfaces.ExternalLoginDataService;
import com.example.loginrepapi.Requests.AppRegDataModel;
import com.example.loginrepapi.Requests.ExternalLoginModel;
import com.example.loginrepapi.Responses.AppRegResponse;
import com.example.loginrepapi.BuildConfig;
import com.example.loginrepapi.Interfaces.AppDataService;
import com.example.loginrepapi.Interfaces.LoginDataService;
import com.example.loginrepapi.Requests.LoginDataModel;
import com.example.loginrepapi.Responses.ExternalLoginResponse;
import com.example.loginrepapi.Responses.LoginResponse;
import com.example.loginrepapi.R;
import com.example.loginrepapi.SharedPreferencesManager;
import com.example.loginrepapi.SignUpClientInstance;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText etext;
    EditText ptext;
    Button lbtn,signbtn,loginButton;
 /*   private TextView info;*/

  /*  private static final String EMAIL = "email";*/
    SharedPreferencesManager sharedPreferencesManager;
/*    private CallbackManager callbackManager;
   *//* LoginResult loginResult;*/
   /* public String fbtoken;
    public String fbuserid;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   info=findViewById(R.id.info);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        ((LoginButton) loginButton).setReadPermissions(Arrays.asList(EMAIL));*/
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
       /* callbackManager = CallbackManager.Factory.create();
        ((LoginButton) loginButton).registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                fbtoken=loginResult.getAccessToken().getToken();
                 fbuserid =loginResult.getAccessToken().getUserId();
                // App code
           *//*     info.setText(
                        "User ID: "
                                + loginResult.getAccessToken().getUserId()
                                + "\n" +
                                "Auth Token: "
                                + loginResult.getAccessToken().getToken()
                );*//*
           loginResult.getAccessToken().getUserId();
           loginResult.getAccessToken().getToken();

         *//*  externalAppreg();*//*
            }

            @Override
            public void onCancel() {
                info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException exception) {
            Log.d("","onError");    // App code
                info.setText("Login attempt failed.");
            }



        });
        LoginManager.getInstance().logInWithReadPermissions(this,Arrays.asList("public_profile"));*/
        init();
        sharedPreferencesManager=new SharedPreferencesManager(this);
    }

    private void init() {
        etext=findViewById(R.id.etext);
        ptext=findViewById(R.id.ptext);
        signbtn=findViewById(R.id.signbtn);
        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);            }
        });
        lbtn=findViewById(R.id.lbtn);
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               appreg();
            }
        });
    }

    private void appreg() {
        String model_info = Build.MANUFACTURER;
        String os_info = BuildConfig.VERSION_NAME;

        String device_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        AppRegDataModel appRegDataModel=new AppRegDataModel(device_id,model_info,os_info,1,
                "hsdbchjgjhgjsghj","1.0.0",1,
                1,"com.baashaa.com");
        final AppDataService service = SignUpClientInstance.getRetrofit().create(AppDataService.class);
        Call<AppRegResponse> call = service.getAllposts(appRegDataModel);
        call.enqueue(new Callback<AppRegResponse>() {
            @Override
            public void onResponse(Call<AppRegResponse> call, Response<AppRegResponse> response) {
                AppRegResponse appRegistrationResponse =response.body();
                String appId= appRegistrationResponse.getData().get(0).getApp_id();
                sharedPreferencesManager.saveappId(appId);
                Toast.makeText(getApplicationContext(),"APP id--"+ appId,Toast.LENGTH_SHORT).show();
               login(appId);

            }

            @Override
            public void onFailure(Call<AppRegResponse> call, Throwable t) {

            }
        });
    }





    private void login(String appId) {
        LoginDataModel loginDataModel=new LoginDataModel("BaashaaSCH","qwe@123",
                etext.getText().toString(),ptext.getText().toString(),"password",appId,
                "17",26);
        LoginDataService service= SignUpClientInstance.getRetrofit().create(LoginDataService.class);
        Call<LoginResponse> call = service.getAllposts(loginDataModel);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse=response.body();

                if(response.isSuccessful()&&loginResponse!=null){
                    String access_token=loginResponse.getAccess_token();
                    Toast.makeText(getApplicationContext(),access_token,Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this, DashBoardVpager.class);
                    startActivity(intent);
                    sharedPreferencesManager.saveAccessToken(access_token);
                }else {
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
*/
    }
    /*private void externalAppreg()  {
        String model_info = Build.MANUFACTURER;
        String os_info = BuildConfig.VERSION_NAME;

        String device_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        AppRegDataModel appRegDataModel=new AppRegDataModel(device_id,model_info,os_info,1,
                "hsdbchjgjhgjsghj","1.0.0",1,
                1,"com.baashaa.com");
        final AppDataService service = SignUpClientInstance.getRetrofit().create(AppDataService.class);
        Call<AppRegResponse> call = service.getAllposts(appRegDataModel);
        call.enqueue(new Callback<AppRegResponse>() {
            @Override
            public void onResponse(Call<AppRegResponse> call, Response<AppRegResponse> response) {
                AppRegResponse appRegistrationResponse =response.body();
                String appid= appRegistrationResponse.getData().get(0).getApp_id();
                sharedPreferencesManager.saveappId(appid);
                Toast.makeText(getApplicationContext(),"APP id--"+ appid,Toast.LENGTH_SHORT).show();
                String appidd=sharedPreferencesManager.getappid();
                externalLogin(appidd);

            }

            @Override
            public void onFailure(Call<AppRegResponse> call, Throwable t) {

            }
        });


    }
    private void externalLogin(String appidd) {

        ExternalLoginModel loginModel=new ExternalLoginModel(fbtoken,2,"BaashaaSCH",
                "qwe@123",appidd,6,26);
       ExternalLoginDataService service= SignUpClientInstance.getRetrofit().create(ExternalLoginDataService.class);
        Call<ExternalLoginResponse> call = service.getAllsignin(loginModel);
       call.enqueue(new Callback<ExternalLoginResponse>() {
           @Override
           public void onResponse(Call<ExternalLoginResponse> call, Response<ExternalLoginResponse> response) {
               ExternalLoginResponse externalLoginResponse=response.body();
               if(response.isSuccessful()&&externalLoginResponse!=null){
                   String access_token=externalLoginResponse.getAccess_token();
                   Toast.makeText(getApplicationContext(),access_token,Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(LoginActivity.this, DashBoardVpager.class);
                   startActivity(intent);
                   sharedPreferencesManager.saveAccessToken(access_token);
               }else {
                   Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();

               }

           }

           @Override
           public void onFailure(Call<ExternalLoginResponse> call, Throwable t) {

           }
       });
    }*/






