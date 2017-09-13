package com.attracttest.attractgroup.lifecyclestask.Activity2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.attracttest.attractgroup.lifecyclestask.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    ViewPager mPager;
    Button frag1, frag2, frag3;
    private static final String TAG = "stages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        frag1 = (Button) findViewById(R.id.btn_frag1);
        frag2 = (Button) findViewById(R.id.btn_frag2);
        frag3 = (Button) findViewById(R.id.btn_frag3);

        frag1.setOnClickListener(this);
        frag2.setOnClickListener(this);
        frag3.setOnClickListener(this);

        //Default frag init

        Fragment fragmentDefault = null;
        Class fragmentDefaultClass = Fragment1.class;

        try {
            fragmentDefault = (Fragment) fragmentDefaultClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.contento, fragmentDefault).commit();

    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        Class fragmentClass;

        switch (view.getId()){
            case R.id.btn_frag1:
                fragmentClass = Fragment1.class;
                break;
            case R.id.btn_frag2:
                fragmentClass = Fragment2.class;
                break;
            case R.id.btn_frag3:
                fragmentClass = Fragment3.class;
                break;
            default: fragmentClass = Fragment1.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.contento, fragment).commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ActivityMain: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ActivityMain: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ActivityMain: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ActivityMain: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ActivityMain: onStop()");
    }
}