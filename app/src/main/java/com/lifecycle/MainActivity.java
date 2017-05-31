package com.lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    
    public static boolean screen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.screen = false;
                openActivity(NormalActivity.class);
            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.screen = false;
                openActivity(LifeCycleActivity.class);
            }
        });
        findViewById(R.id.tv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(LaunchTestActivity.class);
            }
        });
    }
    
    private void openActivity(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        intent.setClassName("packageName", "className");
    }
}
