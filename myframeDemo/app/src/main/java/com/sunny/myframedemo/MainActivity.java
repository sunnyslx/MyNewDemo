package com.sunny.myframedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.RefWatcher;
import com.sunny.myframedemo.login.LoginActivity;
import com.sunny.myframedemo.login.google.TaskActivity;
import com.sunny.myframedemo.recyclerview.DeleteRecyclerViewActivity;
import com.sunny.myframedemo.retrofit.RetrofitActivity;
import com.sunny.myframedemo.rxjava.RxJavaActivity;
import com.sunny.myframedemo.socket.SocketActivity;
import com.sunny.myframedemo.tool.ToolBarActivity;
import com.sunny.myframedemo.toolbarscroll.ScrollActivity;
import com.sunny.myframedemo.viewpager.ViewPagerActivity;
import com.sunny.myframedemo.webview.WebViewActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);

        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(this);

        MyAdapter myAdapter = new MyAdapter(getResources().getStringArray(R.array.myList), this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(onItemClickListener);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    jump(RetrofitActivity.class);
                    break;
                case 1:
                    jump(RxJavaActivity.class);
                    break;
                case 2:
                    jump(ScrollActivity.class);
                    break;
                case 3:
                    jump(ViewPagerActivity.class);
                    break;
                case 4:
                    jump(DeleteRecyclerViewActivity.class);
                    break;
                case 5:
                    jump(ToolBarActivity.class);
                    break;
                case 6:
                    jump(SocketActivity.class);
                    break;
                case 7:
                    jump(WebViewActivity.class);
                    break;
                case 8:
                    jump(LoginActivity.class);
                    break;
                case 9:
                    jump(TaskActivity.class);
                    break;
                default:
                    break;
            }
        }
    };

    private void jump(Class<?> cla) {
        Intent intent = new Intent(this, cla);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (listView != null) {
            listView = null;
        }
    }

}
