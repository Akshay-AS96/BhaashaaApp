package com.example.loginrepapi.Activities.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.loginrepapi.Activities.DashBoardActivity;
import com.example.loginrepapi.Activities.SubTopicActivity;
import com.example.loginrepapi.Adapters.TopicAdapter;
import com.example.loginrepapi.Interfaces.ClickInterface;
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


public class Learn extends Fragment implements ClickInterface {

    private TopicAdapter adapter;
    private ArrayList<TopicData> data;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    SharedPreferencesManager sharedPreferencesManager;


    private OnFragmentInteractionListener mListener;

    public Learn() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferencesManager = new SharedPreferencesManager(getActivity());
        recyclerView = view.findViewById(R.id.CustomRecyclerView);
        TOPIC();
    }


    private void TOPIC() {
        String access_token = "Bearer " + sharedPreferencesManager.getAccessToken();
        TopicDataService service = SignUpClientInstance.getRetrofit().create(TopicDataService.class);
        Call<TopicResponse> call = service.getAllposts(access_token, "en", "ml", "17", "2");
        call.enqueue(new Callback<TopicResponse>() {
            @Override
            public void onResponse(Call<TopicResponse> call, Response<TopicResponse> response) {

                TopicResponse response1 = response.body();
                if (response.isSuccessful() && response1 != null && response1.getData() != null) {
                    // int Topicid = response1.getData().get(0).getId();
                    data = response1.getData();
                    generateDataList(data);


                } else {
                    Toast.makeText(getActivity(), "failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TopicResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void generateDataList(ArrayList<TopicData> dataArrayList) {
        adapter = new TopicAdapter(dataArrayList, getActivity(),  this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(adapter);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void click(String position) {
        Intent intent = new Intent(getActivity(), SubTopicActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
