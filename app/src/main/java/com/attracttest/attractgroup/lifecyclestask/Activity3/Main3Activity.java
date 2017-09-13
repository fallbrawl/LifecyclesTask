package com.attracttest.attractgroup.lifecyclestask.Activity3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.attracttest.attractgroup.lifecyclestask.R;

public class Main3Activity extends AppCompatActivity {
    private static final String TAG = "prsc";
    private boolean result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.var_true:
//                if (checked)
//                    result = true;
//                    processinResults();
//                    break;
//            case R.id.var_false:
//                if (checked)
//                    result = false;
//                processinResults();
//                    break;
//        }

        if (checked)
        processinResults(view.getId()==R.id.var_true);
    }

    public void processinResults(boolean result) {
        Log.e(TAG, "processin results");

        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", String.valueOf(result));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "ActivityMain3: On destroy()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ActivityMain3: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ActivityMain3: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ActivityMain3: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ActivityMain3: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ActivityMain3: onStop()");
    }
}
