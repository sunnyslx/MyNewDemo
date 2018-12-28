package com.sunny.myframedemo.login.google.utils;

import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by Sunny on 18-12-24.
 */

public class SimpleCountingIdlingResource implements IdlingResource {
    private final String mResourceName;

    private final AtomicInteger counter=new AtomicInteger(0);

    private volatile ResourceCallback recourceCallback;

    public SimpleCountingIdlingResource(String mResourceName) {
        this.mResourceName = mResourceName;
    }

    @Override
    public String getName() {
        return mResourceName;
    }

    @Override
    public boolean isIdleNow() {
        return counter.get()==0;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.recourceCallback=recourceCallback;
    }
    public void increment(){
        counter.getAndIncrement();
    }

    public void decrement(){
        int counterVal=counter.getAndDecrement();
        if (counterVal==0){
            if (recourceCallback !=null){
                recourceCallback.onTransitionToIdle();
            }
        }

        if (counterVal<0){
            throw new IllegalArgumentException("Counter has been corrupted!");
        }
    }
}
