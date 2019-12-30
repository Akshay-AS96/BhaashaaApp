package com.example.loginrepapi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.loginrepapi.Adapters.EntityAdapter;
import com.example.loginrepapi.Adapters.SubTopicAdapter;
import com.example.loginrepapi.Adapters.UnitAdapter;
import com.example.loginrepapi.Interfaces.ClickInterface;
import com.example.loginrepapi.Interfaces.EntityDataService;
import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.EntityData;
import com.example.loginrepapi.Responses.EntityResponse;
import com.example.loginrepapi.SharedPreferencesManager;
import com.example.loginrepapi.SignUpClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntityActivity extends AppCompatActivity implements ClickInterface {
    private ArrayList<EntityData> data;
    SharedPreferencesManager sharedPreferencesManager;
    String position;
    EntityAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entity);
        recyclerView = findViewById(R.id.entity_recycler);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        sharedPreferencesManager = new SharedPreferencesManager(this);
        position = getIntent().getExtras().getString("position");
        Entity();
    }

    private void Entity() {

            String access_token = "Bearer " + sharedPreferencesManager.getAccessToken();
            EntityDataService service = SignUpClientInstance.getRetrofit().create(EntityDataService.class);
            Call<EntityResponse> call = service.getAllEntity(access_token, "en", "ml", "17", "6", position, "1");
            call.enqueue(new Callback<EntityResponse>() {
                @Override
                public void onResponse(Call<EntityResponse> call, Response<EntityResponse> response) {

                    EntityResponse response1 = response.body();
                    if (response.isSuccessful() && response1 != null && response1.getData() != null) {
                        data = response1.getData();
                        if (data != null && data.size() > 0)
                            generateEntityDataList(data);

                    } else {
                        Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<EntityResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });



    }

    private void generateEntityDataList(ArrayList<EntityData> data) {
        adapter = new EntityAdapter(data, this, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void click(String position) {

    }
}
