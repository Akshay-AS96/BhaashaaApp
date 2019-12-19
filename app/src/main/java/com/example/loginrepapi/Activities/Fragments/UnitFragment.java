package com.example.loginrepapi.Activities.Fragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginrepapi.Adapters.UnitAdapter;
import com.example.loginrepapi.Interfaces.ClickInterface;
import com.example.loginrepapi.Interfaces.UnitDataService;
import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.UnitData;
import com.example.loginrepapi.Responses.UnitResponse;
import com.example.loginrepapi.SampleMediaPlayer;
import com.example.loginrepapi.SharedPreferencesManager;
import com.example.loginrepapi.SignUpClientInstance;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UnitFragment extends Fragment {
    public String voice = "https://s3.ap-south-1.amazonaws.com/dev.baashaa/data/content/en_voice/177.mp3";
    public String url = "https://s3-ap-south-1.amazonaws.com/dev.baashaa/data/content/bs_image/";
    public String urlvoice = " https://s3.ap-south-1.amazonaws.com/dev.baashaa/data/content/";
    MediaPlayer mp;
    ImageButton unitimagebtn;
    TextView dlTextView, slTextView;
    ImageView unitimg;


    private UnitData data;
    private ArrayList<UnitData> unitData;
    private Context context;
    int position;
    SampleMediaPlayer sampleMediaPlayer;


    public UnitFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dlTextView = view.findViewById(R.id.dlTextView);
        slTextView = view.findViewById(R.id.slTextView);
        unitimg = view.findViewById(R.id.unitimg);
        unitimagebtn = view.findViewById(R.id.untimgbtn);
        sampleMediaPlayer = new SampleMediaPlayer();

        Bundle b = getArguments();
        data = b.getParcelable("Unit");
        if (data != null) {
            final String id = data.getUnitDestination().getVoice();
            final String sourceLangCode = data.getSource_langcode();
            final String destinationLangCode=data.getDestination_langcode();
            dlTextView.setText(data.getUnitDestination().getContent());
            Picasso.with(context).load(url + data.getImg() + ".png").into(unitimg);
            slTextView.setText(data.getContent());
            final String voice = "https://s3.ap-south-1.amazonaws.com/dev.baashaa/data/content/"+sourceLangCode+"_voice/"+ id.trim() + ".mp3";
            final String dvoice = "https://s3.ap-south-1.amazonaws.com/dev.baashaa/data/content/"+destinationLangCode+"_voice/"+ id.trim() + ".mp3";
   //         urlvoice = urlvoice + sourceLangCode + "_voice/" + id.trim() + ".mp3";
            unitimagebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sampleMediaPlayer.killMediaPlayer();
                    sampleMediaPlayer.playAudio(voice,dvoice);

                }
            });

        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unit, container, false);
    }
}


