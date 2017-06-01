package com.lifecycle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/5/27.
 */

public class NormalActivity extends Activity implements View.OnClickListener{
    private final String TAG = "LifeCycle";
    
    private EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "NormalActivity.onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
        findViewById(R.id.e).setOnClickListener(this);
        findViewById(R.id.f).setOnClickListener(this);
        findViewById(R.id.g).setOnClickListener(this);
        findViewById(R.id.h).setOnClickListener(this);
        et = (EditText)findViewById(R.id.et);
        handler.postDelayed(r, 10000);
    }
    
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            Log.e(TAG, "NormalActivity.Runnable()"+NormalActivity.this.toString());
            handler.postDelayed(r, 10000);
        }
    };

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onStart() {
        Log.e(TAG, "NormalActivity.onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "NormalActivity.onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "NormalActivity.onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "NormalActivity.onStop()");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "NormalActivity.onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "NormalActivity.onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.e(TAG, "NormalActivity.onNewIntent()");
        super.onNewIntent(intent);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.e(TAG, "NormalActivity.onWindowFocusChanged()");
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String etStr = et.getText().toString();
        outState.putString("input", etStr);
        Log.e(TAG, "NormalActivity.onSaveInstanceState()：" + etStr);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e(TAG, "NormalActivity.onRestoreInstanceState()");
        if(et != null){
            Object o = savedInstanceState.get("input");
            if(o != null){
                String etStr = o.toString();
                et.setText(etStr);
            }
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e(TAG, "NormalActivity.onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.a:
                openActivity();
                break;
            case R.id.b:
                openDialog();
                break;
            case R.id.c:
                openInstance();
                break;
            case R.id.d:
                switchScreen();
                break;
            case R.id.e:
                startService();
                break;
            case R.id.f:
                stopService();
                break;
            case R.id.g:
                bindService();
                break;
            case R.id.h:
                unBindService();
                break;
        }

    }

    private void openDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提升");
        builder.setMessage("请点击下面按钮");
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void openActivity(){
        Intent intent = new Intent(this, TransparentActivity.class);
        startActivity(intent);
    }

    private void openInstance(){
        Intent intent = new Intent(this, NormalActivity.class);
        startActivity(intent);
    }

    private void switchScreen(){
        if(MainActivity.screen){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        MainActivity.screen = !MainActivity.screen;
    }

    private void startService(){
        Intent intent = new Intent(this, LifeCycleService.class);
        startService(intent);
    }

    private void stopService(){
        Intent intent = new Intent(this, LifeCycleService.class);
        stopService(intent);
    }

    private void bindService(){
        Intent intent = new Intent(this, LifeCycleService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private void unBindService(){
        unbindService(connection);
    }
}
