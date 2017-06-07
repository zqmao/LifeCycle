package com.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/7.
 */

public class PortraitActivityB extends Activity {
    private final String TAG = "screenOrientation";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "PortraitActivityB.onCreate()");
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("B页面，点击进入C页面");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LandScapeActivityC.class);
                startActivity(intent);
            }
        });
        setContentView(tv);
    }
    @Override
    protected void onStart() {
        Log.e(TAG, "PortraitActivityB.onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "PortraitActivityB.onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "PortraitActivityB.onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "PortraitActivityB.onStop()");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "PortraitActivityB.onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "PortraitActivityB.onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.e(TAG, "PortraitActivityB.onNewIntent()");
        super.onNewIntent(intent);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.e(TAG, "PortraitActivityB.onWindowFocusChanged()");
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e(TAG, "PortraitActivityB.onSaveInstanceState()");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e(TAG, "PortraitActivityB.onRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e(TAG, "PortraitActivityB.onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }
    
}
