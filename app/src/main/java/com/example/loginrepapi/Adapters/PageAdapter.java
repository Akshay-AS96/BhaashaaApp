package com.example.loginrepapi.Adapters;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.loginrepapi.Activities.Fragments.Activities;
import com.example.loginrepapi.Activities.Fragments.Learn;
import com.example.loginrepapi.Activities.Fragments.Teacher;

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;
    public PageAdapter(@NonNull FragmentManager fm, int NoOfTabs) {
        super(fm);
        this.mNoOfTabs=NoOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Learn learn=new Learn();
                return learn;
            case 1:
                Activities activities=new Activities();
                return activities;
            case 2:
                Teacher teacher=new Teacher();
                return teacher;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
