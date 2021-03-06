package com.attracttest.attractgroup.lifecyclestask.Activity1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.attracttest.attractgroup.lifecyclestask.R;

/**
 * Created by nexus on 09.09.1017.
 */
public class Fragment5 extends Fragment {

    private static final String TAG = "stages";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "Activity1/Fragment5: onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "Activity1/Fragment5: onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "Activity1/Fragment5: onCreateView()");
        View view = inflater.inflate(R.layout.fragment1_5, null);
        TextView textView = view.findViewById(R.id.frag);
        textView.setText("Fragment5 Activity1");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "Activity1/Fragment5: onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "Activity1/Fragment5: onStart()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "Activity1/Fragment5: onPause()");
    }

    @Override
    public void onStop() {
        Log.e(TAG, "Activity1/Fragment5: onStop()");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "Activity1/Fragment5: onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "Activity1/Fragment5: onDetach()");
    }
}
