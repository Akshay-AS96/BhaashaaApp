package com.example.loginrepapi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.loginrepapi.Adapters.ActivityTopicAdapter;
import com.example.loginrepapi.Adapters.SubTopicAdapter;
import com.example.loginrepapi.Interfaces.ClickInterface;
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

public class SubTopicActivity extends AppCompatActivity implements ClickInterface {
    private SubTopicAdapter adapter;
    private ArrayList<SubTopicData> data;
    private RecyclerView recyclerView;
    SharedPreferencesManager sharedPreferencesManager;
    String position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setContentView(R.layout.activity_sub_topic);
        sharedPreferencesManager = new SharedPreferencesManager(this);
        recyclerView = findViewById(R.id.rvitems2);
        position = getIntent().getExtras().getString("position");
        SubTOPIC();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void SubTOPIC() {
        String access_token = "Bearer " + sharedPreferencesManager.getAccessToken();
        SubTopicDataService service = SignUpClientInstance.getRetrofit().create(SubTopicDataService.class);
        Call<SubTopicResponse> call = service.getAllposts(access_token, "en", "ml", "17", "3", position);
        call.enqueue(new Callback<SubTopicResponse>() {
            @Override
            public void onResponse(Call<SubTopicResponse> call, Response<SubTopicResponse> response) {

                SubTopicResponse response1 = response.body();
                if (response.isSuccessful() && response1 != null && response1.getData() != null) {
                    data = response1.getData();
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
        adapter = new SubTopicAdapter(data, this, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void click(String position) {
        Intent intent = new Intent(this, UnitVPagerActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
