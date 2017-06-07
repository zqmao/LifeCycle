package com.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/7.
 */

public class LandScapeActivityC extends Activity {
    private final String TAG = "screenOrientation";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "LandScapeActivityC.onCreate()");
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("C页面");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        });
        setContentView(tv);
    }
    @Override
    protected void onStart() {
        Log.e(TAG, "LandScapeActivityC.onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "LandScapeActivityC.onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "LandScapeActivityC.onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "LandScapeActivityC.onStop()");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "LandScapeActivityC.onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "LandScapeActivityC.onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.e(TAG, "LandScapeActivityC.onNewIntent()");
        super.onNewIntent(intent);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.e(TAG, "LandScapeActivityC.onWindowFocusChanged()");
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e(TAG, "LandScapeActivityC.onSaveInstanceState()");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e(TAG, "LandScapeActivityC.onRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e(TAG, "LandScapeActivityC.onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }
    
}
