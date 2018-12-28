package com.sunny.myframedemo.tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.sunny.myframedemo.R;

public class ToolBarActivity extends AppCompatActivity {

    private static final String TAG=ToolBarActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        getScreenDensity_ByWindowManager();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击了返回按钮", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //获得手机的宽度和高度像素单位为px
    //通过WindowManager获取
    public void getScreenDensity_ByWindowManager() {
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        //屏幕分辨率容器
        getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        int width = mDisplayMetrics.widthPixels;
        int height = mDisplayMetrics.heightPixels;
        float density = mDisplayMetrics.density;
        int densityDpi = mDisplayMetrics.densityDpi;
        Log.d(TAG, "Screen Ratio: [" + width + "x" + height + "],density=" + density + ",densityDpi=" + densityDpi);
        Log.d(TAG, "Screen mDisplayMetrics: " + mDisplayMetrics);
    }

}
