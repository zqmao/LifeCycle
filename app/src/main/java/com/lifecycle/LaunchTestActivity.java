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
 * Created by Administrator on 2017/5/31.
 */

public class LaunchTestActivity extends Activity  implements View.OnClickListener{
    protected TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.b2).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
        textView = (TextView)findViewById(R.id.tv);
        String text = this.getTaskId() + "   " + this.toString();
        textView.setText(text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                switchScreen();
            }
        });
    }

    private void switchScreen(){
        if(MainActivity.screen){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        MainActivity.screen = !MainActivity.screen;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.a:
                openActivity(LaunchTestA.class);
                break;
            case R.id.b:
                openActivity(LaunchTestB.class);
                break;
            case R.id.b2:
                openActivity(LaunchTestB2.class);
                break;
            case R.id.c:
                openActivity(LaunchTestC.class);
                break;
            case R.id.d:
                openActivity(LaunchTestD.class);
                break;
        }
    }
    
    private void openActivity(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("LifeCycle", "LaunchTestActivity.onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("LifeCycle", "LaunchTestActivity.onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }
}
