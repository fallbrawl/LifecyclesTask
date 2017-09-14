package com.attracttest.attractgroup.lifecyclestask.Activity1;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.attracttest.attractgroup.lifecyclestask.Activity2.Main2Activity;
import com.attracttest.attractgroup.lifecyclestask.Activity3.Main3Activity;
import com.attracttest.attractgroup.lifecyclestask.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "stages";
    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    private NavigationView nvDrawer;

    private FloatingActionButton myFabPager;
    private FloatingActionButton myFabResult;

    private Fragment defaultFragment;

    int currentFragmentId = 1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "ActivityMain: onCreate()");

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);

        // Setup drawer view
        setupDrawerContent(nvDrawer);

        myFabResult = (FloatingActionButton) findViewById(R.id.fabResult);
        final Intent intent = new Intent(this, Main3Activity.class);

        myFabResult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivityForResult(intent, currentFragmentId);
            }
        });

        myFabPager = (FloatingActionButton) findViewById(R.id.fabPager);
        final Intent intent2 = new Intent(this, Main2Activity.class);

        myFabPager.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent2);
            }
        });


        //Setting the first frag
        Class fragment1Class = Fragment1.class;

        try {
            defaultFragment = (Fragment) fragment1Class.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, defaultFragment, "FRAGMENT" + currentFragmentId).commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //Initial fragment id
        //currentFragmentId = findViewById(R.id.frag1_1).getId();

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;


        switch(menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                fragmentClass = Fragment1.class;
                //currentFragmentId = findViewById(R.id.frag1_1).getId();
                currentFragmentId = 1;
                break;

            case R.id.nav_second_fragment:
                fragmentClass = Fragment2.class;
                //currentFragmentId = findViewById(R.id.frag1_2).getId();
                currentFragmentId = 2;
                break;

            case R.id.nav_third_fragment:
                fragmentClass = Fragment3.class;
                //currentFragmentId = findViewById(R.id.frag1_3).getId();
                currentFragmentId = 3;
                break;

            case R.id.nav_fourth_fragment:
                fragmentClass = Fragment4.class;
                //currentFragmentId = findViewById(R.id.frag1_4).getId();
                currentFragmentId = 4;
                break;

            default:
                fragmentClass = Fragment5.class;
                //currentFragmentId = findViewById(R.id.frag1_5).getId();
                currentFragmentId = 5;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment, "FRAGMENT" + currentFragmentId).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        String wow = data.getStringExtra("result");
        FragmentManager fm = getSupportFragmentManager();
        Fragment currFragm = fm.findFragmentByTag("FRAGMENT" + requestCode);
        TextView result = currFragm.getView().findViewById(R.id.frag);
        result.append(" " + data.getStringExtra("result") + " ");

        //currFragm.getView().findViewById(R.id.frag1_2);

            //result.setText(data.getStringExtra("result"));
            Log.e(TAG, wow);
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
