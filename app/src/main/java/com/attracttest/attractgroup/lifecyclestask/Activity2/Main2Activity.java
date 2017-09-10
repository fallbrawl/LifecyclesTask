package com.attracttest.attractgroup.lifecyclestask.Activity2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.attracttest.attractgroup.lifecyclestask.R;

public class Main2Activity extends FragmentActivity {

    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mPager = findViewById(R.id.viewpager);
        mPager.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager(),
                Main2Activity.this));
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mPager);

    }


}