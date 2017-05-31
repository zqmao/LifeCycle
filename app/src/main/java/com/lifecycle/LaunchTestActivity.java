package com.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/31.
 */

public class LaunchTestActivity extends Activity  implements View.OnClickListener{
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        findViewById(R.id.a).setOnClickListener(this);
        findViewById(R.id.b).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.d).setOnClickListener(this);
        textView = (TextView)findViewById(R.id.tv);
        String text = this.getTaskId() + "   " + this.toString();
        textView.setText(text);
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
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("LifeCycle", "LaunchTestActivity.onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }
}
