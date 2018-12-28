package com.sunny.myframedemo.login.google.utils;

import android.support.test.espresso.IdlingResource;

/**
 * Created by Sunny on 18-12-24.
 */

public class EspressoIdlingResource {

    private static final String RESOURCE = "GLOBAL";

    private static SimpleCountingIdlingResource mCountingIdlingResource=new SimpleCountingIdlingResource(RESOURCE);

    public static void increment(){
        mCountingIdlingResource.increment();
    }

    public static void decrement(){
        mCountingIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource(){
        return mCountingIdlingResource;
    }
}
