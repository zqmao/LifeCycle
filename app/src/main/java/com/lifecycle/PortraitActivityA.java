package com.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/7.
 */

public class PortraitActivityA extends Activity {
    private final String TAG = "screenOrientation";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "PortraitActivityA.onCreate()");
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("A页面，点击进入B页面");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PortraitActivityB.class);
                startActivity(intent);
            }
        });
        setContentView(tv);
    }
    @Override
    protected void onStart() {
        Log.e(TAG, "PortraitActivityA.onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "PortraitActivityA.onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "PortraitActivityA.onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "PortraitActivityA.onStop()");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "PortraitActivityA.onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "PortraitActivityA.onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.e(TAG, "PortraitActivityA.onNewIntent()");
        super.onNewIntent(intent);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.e(TAG, "PortraitActivityA.onWindowFocusChanged()");
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e(TAG, "PortraitActivityA.onSaveInstanceState()");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e(TAG, "PortraitActivityA.onRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e(TAG, "PortraitActivityA.onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }
}
