package com.example.loginrepapi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginrepapi.Requests.AppRegDataModel;
import com.example.loginrepapi.Responses.AppRegResponse;
import com.example.loginrepapi.BuildConfig;
import com.example.loginrepapi.Interfaces.AppDataService;
import com.example.loginrepapi.Interfaces.LoginDataService;
import com.example.loginrepapi.Requests.LoginDataModel;
import com.example.loginrepapi.Responses.LoginResponse;
import com.example.loginrepapi.R;
import com.example.loginrepapi.SharedPreferencesManager;
import com.example.loginrepapi.SignUpClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText etext;
    EditText ptext;
    Button lbtn, signbtn, loginButton;
    SharedPreferencesManager sharedPreferencesManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sharedPreferencesManager = new SharedPreferencesManager(this);
    }

    private void init() {
        etext = findViewById(R.id.etext);
        ptext = findViewById(R.id.ptext);
        signbtn = findViewById(R.id.signbtn);
        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        lbtn = findViewById(R.id.lbtn);
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
        AppRegDataModel appRegDataModel = new AppRegDataModel(device_id, model_info, os_info, 1,
                "hsdbchjgjhgjsghj", "1.0.0", 1,
                1, "com.baashaa.com");
        final AppDataService service = SignUpClientInstance.getRetrofit().create(AppDataService.class);
        Call<AppRegResponse> call = service.getAllposts(appRegDataModel);
        call.enqueue(new Callback<AppRegResponse>() {
            @Override
            public void onResponse(Call<AppRegResponse> call, Response<AppRegResponse> response) {
                AppRegResponse appRegistrationResponse = response.body();
                String appId = appRegistrationResponse.getData().get(0).getApp_id();
                sharedPreferencesManager.saveappId(appId);
                Toast.makeText(getApplicationContext(), "APP id--" + appId, Toast.LENGTH_SHORT).show();
                login(appId);

            }

            @Override
            public void onFailure(Call<AppRegResponse> call, Throwable t) {

            }
        });
    }


    private void login(String appId) {
        LoginDataModel loginDataModel = new LoginDataModel("BaashaaSCH", "qwe@123",
                etext.getText().toString(), ptext.getText().toString(), "password", appId,
                "17", 26);
        LoginDataService service = SignUpClientInstance.getRetrofit().create(LoginDataService.class);
        Call<LoginResponse> call = service.getAllposts(loginDataModel);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (response.isSuccessful() && loginResponse != null) {
                    String access_token = loginResponse.getAccess_token();
                    Toast.makeText(getApplicationContext(), access_token, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, DashBoardVpager.class);
                    startActivity(intent);
                    sharedPreferencesManager.saveAccessToken(access_token);
                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}

