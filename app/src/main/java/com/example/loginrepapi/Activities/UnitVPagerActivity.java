package com.example.loginrepapi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.app.ActionBar;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.loginrepapi.Activities.Fragments.UnitFragment;
import com.example.loginrepapi.Adapters.SubTopicAdapter;
import com.example.loginrepapi.Adapters.UnitAdapter;
import com.example.loginrepapi.Interfaces.ClickInterface;
import com.example.loginrepapi.Interfaces.SubTopicDataService;
import com.example.loginrepapi.Interfaces.UnitDataService;
import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.SubTopicData;
import com.example.loginrepapi.Responses.SubTopicResponse;
import com.example.loginrepapi.Responses.TopicResponse;
import com.example.loginrepapi.Responses.UnitData;
import com.example.loginrepapi.Responses.UnitResponse;
import com.example.loginrepapi.SharedPreferencesManager;
import com.example.loginrepapi.SignUpClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UnitVPagerActivity extends AppCompatActivity {
    ViewPager viewPager;
    private MediaPlayer mediaPlayer;
    UnitAdapter adapter;
    private ArrayList<UnitData> data;
    SharedPreferencesManager sharedPreferencesManager;
    String position;
    //  ArgbEvaluator argbEvaluator=new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_vpager);
        viewPager = findViewById(R.id.unitvpager);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        sharedPreferencesManager = new SharedPreferencesManager(this);
        position = getIntent().getExtras().getString("position");
        Unit();


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    private void Unit() {
        String access_token = "Bearer " + sharedPreferencesManager.getAccessToken();
        UnitDataService service = SignUpClientInstance.getRetrofit().create(UnitDataService.class);
        Call<UnitResponse> call = service.getAllposts(access_token, "en", "ml", "17", "4", position, "1");
        call.enqueue(new Callback<UnitResponse>() {
            @Override
            public void onResponse(Call<UnitResponse> call, Response<UnitResponse> response) {

                UnitResponse response1 = response.body();
                if (response.isSuccessful() && response1 != null && response1.getData() != null) {
                    // int Topicid = response1.getData().get(0).getId();
                    data = response1.getData();
                    if (data != null && data.size() > 0)
                        generateDataList(data);
                    //Toast


                } else {
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UnitResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void generateDataList(ArrayList<UnitData> data) {
        adapter = new UnitAdapter(getSupportFragmentManager(), data);
        viewPager.setAdapter(adapter);
    }


}
