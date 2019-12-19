package com.example.loginrepapi.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.loginrepapi.Activities.Fragments.UnitFragment;
import com.example.loginrepapi.Activities.UnitVPagerActivity;
import com.example.loginrepapi.Interfaces.ClickInterface;
import com.example.loginrepapi.R;
import com.example.loginrepapi.Responses.UnitData;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

public class UnitAdapter extends FragmentStatePagerAdapter {

    private ArrayList<UnitData> data;


    public UnitAdapter(@NonNull FragmentManager fm, ArrayList<UnitData> data) {
        super(fm);
        this.data = data;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        UnitFragment unitFragment = new UnitFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("Unit", data.get(position));
        unitFragment.setArguments(bundle);
        return unitFragment;
    }

}
