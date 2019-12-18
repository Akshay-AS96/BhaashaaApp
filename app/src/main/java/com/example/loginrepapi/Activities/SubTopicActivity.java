package com.example.loginrepapi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.loginrepapi.Adapters.ActivityTopicAdapter;
import com.example.loginrepapi.Adapters.SubTopicAdapter;
import com.example.loginrepapi.Interfaces.SubTopicDataService;
import com.example.loginrepapi.Interfaces.TopicDataService;
import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.SubTopicData;
import com.example.loginrepapi.Responses.SubTopicResponse;
import com.example.loginrepapi.Responses.TopicData;
import com.example.loginrepapi.Responses.TopicResponse;
import com.example.loginrepapi.SharedPreferencesManager;
import com.example.loginrepapi.SignUpClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubTopicActivity extends AppCompatActivity {
    private SubTopicAdapter adapter;
    private ArrayList<SubTopicData> data;
    private RecyclerView recyclerView;
    SharedPreferencesManager sharedPreferencesManager;
   String position;
    //SubTopicData subTopicData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_topic);
        sharedPreferencesManager=new SharedPreferencesManager(this);
        recyclerView = findViewById(R.id.rvitems2);
       position = getIntent().getExtras().getString("position");

        SubTOPIC();
    }
    private void SubTOPIC() {
        String access_token = "Bearer "+sharedPreferencesManager.getAccessToken();
        SubTopicDataService service = SignUpClientInstance.getRetrofit().create(SubTopicDataService.class);
        Call<SubTopicResponse> call = service.getAllposts(access_token,"en","ml","17","3",position);
        call.enqueue(new Callback<SubTopicResponse>() {
            @Override
            public void onResponse(Call<SubTopicResponse> call, Response<SubTopicResponse> response) {

                SubTopicResponse response1 = response.body();
                if (response.isSuccessful() && response1 != null && response1.getData() != null) {
                    // int Topicid = response1.getData().get(0).getId();
                    data=response1.getData();
                    generateDataList(data);



                } else {
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SubTopicResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void generateDataList(ArrayList<SubTopicData> data) {
        adapter = new SubTopicAdapter(data,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
    }
}
