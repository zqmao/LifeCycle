package com.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Administrator on 2017/5/31.
 */

public class LaunchTestC extends LaunchTestActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(LaunchTestA.class);
            }
        });
    }

    private void openActivity(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
