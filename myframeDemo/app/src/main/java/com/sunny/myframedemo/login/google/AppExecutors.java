package com.sunny.myframedemo.login.google;

import android.support.annotation.VisibleForTesting;

import com.sunny.myframedemo.retrofit.PostRequestInterface;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Created by Sunny on 18-12-24.
 */

public class AppExecutors {
    private static final int THREAD_COUNT = 3;

    private final Executor diskIO;

    private final Executor networkIO;

    private final Executor mainThread;

    @VisibleForTesting
    AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }






}
