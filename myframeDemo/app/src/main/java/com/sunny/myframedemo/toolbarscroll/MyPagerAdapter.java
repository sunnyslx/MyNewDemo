package com.sunny.myframedemo.toolbarscroll;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunny on 18-11-20.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private String[] mTitle;

    public MyPagerAdapter(FragmentManager fm) {
        this(fm, null, null);
    }

    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] mTitle) {
        super(fm);
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        this.fragmentList = fragmentList;
        this.mTitle = mTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
