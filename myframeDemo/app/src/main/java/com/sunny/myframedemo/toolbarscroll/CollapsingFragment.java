package com.sunny.myframedemo.toolbarscroll;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunny.myframedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollapsingFragment extends Fragment {

    private String[] mTitle = new String[]{
            "微博",
            "发现",
            "相册"
    };

    private ViewPager viewPager;
    private List<Fragment> fragmentList;

    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_collapsing, container, false);
        viewPager=view.findViewById(R.id.collap_viewPager);
        toolbar=view.findViewById(R.id.collap_toolbar);
        tabLayout=view.findViewById(R.id.collap_tablayout);
        toolbar.setTitle("王祖贤");

        setUpViewPager();

        return view;
    }

    private void setUpViewPager(){
        fragmentList=new ArrayList<>();
        for (int i=0;i<mTitle.length;i++){
            MyItemFragment itemFragment=MyItemFragment.newInstance(mTitle[i]);
            fragmentList.add(itemFragment);
        }

        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getFragmentManager(),fragmentList,mTitle);
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
