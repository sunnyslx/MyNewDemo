package com.sunny.myframedemo;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Sunny on 18-11-26.
 */

public class MyApplication extends Application {
    private RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher= LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context){
        MyApplication myApplication=(MyApplication) context.getApplicationContext();
        return myApplication.refWatcher;
    }
}
