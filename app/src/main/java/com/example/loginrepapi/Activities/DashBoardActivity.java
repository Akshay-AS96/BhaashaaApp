package com.example.loginrepapi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.loginrepapi.Activities.Fragments.Learn;
import com.example.loginrepapi.Requests.AppRegDataModel;
import com.example.loginrepapi.Responses.AppRegResponse;
import com.example.loginrepapi.BuildConfig;
import com.example.loginrepapi.Interfaces.AppDataService;
import com.example.loginrepapi.Interfaces.LogOutDataService;
import com.example.loginrepapi.Interfaces.UserDataService;
import com.example.loginrepapi.Requests.LogOutDataModel;
import com.example.loginrepapi.Responses.LogOutResponse;
import com.example.loginrepapi.R;
import com.example.loginrepapi.SharedPreferencesManager;
import com.example.loginrepapi.SignUpClientInstance;
import com.example.loginrepapi.Adapters.TopicAdapter;
import com.example.loginrepapi.Responses.TopicData;
import com.example.loginrepapi.Interfaces.TopicDataService;
import com.example.loginrepapi.Responses.TopicResponse;
import com.example.loginrepapi.Responses.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardActivity extends AppCompatActivity {
   /* private TopicAdapter adapter;
    private ArrayList<TopicData> data;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    SharedPreferencesManager sharedPreferencesManager;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        setFragment(new Learn());
       /* sharedPreferencesManager = new SharedPreferencesManager(this);
        recyclerView = findViewById(R.id.CustomRecyclerView);
        progressDoalog = new ProgressDialog(DashBoardActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        TOPIC();*/

    }
    protected void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment, "fragment");
        fragmentTransaction.commit();
    }
   /* private  void  allUser(){
        String access_token = sharedPreferencesManager.getAccessToken();
        UserDataService service= SignUpClientInstance.getRetrofit().create(UserDataService.class);
        Call<UserResponse>call=service.getAllposts("Bearer"+access_token);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse response1=response.body();
                if (response.isSuccessful()&&response1!=null&&response1.getData()!=null){
                    String appId = response1.getInfo().getStatus();

                    Toast.makeText(getApplicationContext(), "Sucess"+appId, Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void TOPIC() {
        String access_token = "Bearer "+sharedPreferencesManager.getAccessToken();
        TopicDataService service = SignUpClientInstance.getRetrofit().create(TopicDataService.class);
        Call<TopicResponse> call = service.getAllposts(access_token,"en","ml","17","2");
        call.enqueue(new Callback<TopicResponse>() {
            @Override
            public void onResponse(Call<TopicResponse> call, Response<TopicResponse> response) {

                TopicResponse response1 = response.body();
                if (response.isSuccessful() && response1 != null && response1.getData() != null) {
                   // int Topicid = response1.getData().get(0).getId();
                    data=response1.getData();
                    generateDataList(data);



                } else {
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TopicResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void generateDataList( ArrayList<TopicData> dataArrayList) {
        adapter = new TopicAdapter(dataArrayList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DashBoardActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(adapter);
    }

   *//* private void init() {
        logoutbtn = findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TOPIC();

            }
        });
    }*//*

    private void Logout() {
        String access_token = sharedPreferencesManager.getAccessToken();
        final LogOutDataModel logoutDataModel = new LogOutDataModel(access_token);
        LogOutDataService service = SignUpClientInstance.getRetrofit().create(LogOutDataService.class);
        Call<LogOutResponse> call = service.getAllposts(logoutDataModel);
        call.enqueue(new Callback<LogOutResponse>() {
            @Override
            public void onResponse(Call<LogOutResponse> call, Response<LogOutResponse> response) {
                LogOutResponse logOutResponse = response.body();
                if (response.isSuccessful() && logOutResponse != null) {
                   // String access_token = logOutResponse.getStatus();
                    Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                   sharedPreferencesManager.ClearToken();
                    Intent intent = new Intent(DashBoardActivity.this, LoginActivity.class);
                    startActivity(intent);


                    // sharedPreferencesManager.saveAccessToken(access_token);
                } else {

                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<LogOutResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
*/

}
