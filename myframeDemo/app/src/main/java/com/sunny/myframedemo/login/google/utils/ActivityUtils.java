package com.sunny.myframedemo.login.google.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;



/**
 * Created by Sunny on 18-12-24.
 */

public class ActivityUtils {


    public static  void  addFragmentToActivity(FragmentManager fragmentManager, Fragment fragment,int fragmentId){
        if (fragmentManager !=null && fragment !=null){
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.add(fragmentId,fragment);
            transaction.commit();
        }
    }
}
