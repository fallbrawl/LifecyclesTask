package com.attracttest.attractgroup.lifecyclestask.Activity1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attracttest.attractgroup.lifecyclestask.R;

/**
 * Created by nexus on 09.09.2017.
 */
public class Fragment5 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1_5, null);
    }
}
