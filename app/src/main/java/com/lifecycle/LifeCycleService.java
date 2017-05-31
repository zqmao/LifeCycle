package com.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/5/27.
 */

public class LifeCycleService extends Service {
    private final String TAG = "LifeCycle";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "LifeCycleService.onCreate()");
        handler.postDelayed(r, 5000);
    }

    private Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            Log.e(TAG, "LifeCycleService.Task()");
            if(handler == null){
                return;
            }
            handler.postDelayed(r, 5000);
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "LifeCycleService.onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onLowMemory() {
        Log.e(TAG, "LifeCycleService.onLowMemory()");
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        Log.e(TAG, "LifeCycleService.onTrimMemory()");
        super.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e(TAG, "LifeCycleService.onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.e(TAG, "LifeCycleService.onTaskRemoved()");
        super.onTaskRemoved(rootIntent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "LifeCycleService.onBind()");
        return null;
    }
    
    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "LifeCycleService.onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG, "LifeCycleService.onRebind()");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "LifeCycleService.onDestroy()");
        handler = null;
        super.onDestroy();
    }
}
