package com.attracttest.attractgroup.lifecyclestask.Activity2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attracttest.attractgroup.lifecyclestask.R;

/**
 * Created by nexus on 09.09.2017.
 */
public class Fragment3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("staty", "wow3");
        return inflater.inflate(R.layout.fragment2_3, null);
    }
}