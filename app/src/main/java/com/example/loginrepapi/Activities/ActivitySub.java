package com.example.loginrepapi.Activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginrepapi.Adapters.ActivityTopicAdapter;
import com.example.loginrepapi.Adapters.TopicAdapter;
import com.example.loginrepapi.Interfaces.TopicDataService;
import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.TopicData;
import com.example.loginrepapi.Responses.TopicResponse;
import com.example.loginrepapi.SharedPreferencesManager;
import com.example.loginrepapi.SignUpClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySub extends AppCompatActivity {
    private ActivityTopicAdapter adapter;
    private ArrayList<TopicData> data;
    private RecyclerView recyclerView;
    SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        sharedPreferencesManager=new SharedPreferencesManager(this);
        recyclerView = findViewById(R.id.rvitems);
        TOPIC();
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
        adapter = new ActivityTopicAdapter(dataArrayList,this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(ActivitySub.this,2);
        recyclerView.setLayoutManager(layoutManager);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
    }
}
