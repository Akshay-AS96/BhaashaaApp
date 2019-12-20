package com.example.loginrepapi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.example.loginrepapi.Activities.Fragments.Activities;
import com.example.loginrepapi.Activities.Fragments.Learn;
import com.example.loginrepapi.Activities.Fragments.Teacher;
import com.example.loginrepapi.Adapters.PageAdapter;
import com.example.loginrepapi.R;
import com.google.android.material.tabs.TabLayout;

public class DashBoardVpager extends AppCompatActivity implements Learn.OnFragmentInteractionListener, Activities.OnFragmentInteractionListener, Teacher.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_vpager);
        
if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
{
    NotificationChannel channel=new NotificationChannel("mynotification","mynotification",
            NotificationManager.IMPORTANCE_DEFAULT);
    NotificationManager manager=getSystemService(NotificationManager.class);
    manager.createNotificationChannel(channel);
}




        TabLayout tabLayout=findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Learn"));
        tabLayout.addTab(tabLayout.newTab().setText("Activities"));
        tabLayout.addTab(tabLayout.newTab().setText("Teacher"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager=findViewById(R.id.vpager);
        final PageAdapter adapter=new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
