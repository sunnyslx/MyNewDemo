package com.sunny.myframedemo.toolbarscroll;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sunny.myframedemo.R;
import java.util.ArrayList;
import java.util.List;


public class AppBarFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private List<Fragment> fragmentList;

    private String[] mtitle = new String[]{
            "微博",
            "发现",
            "相册"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_bar_layout, container, false);
        viewPager = view.findViewById(R.id.appbar_viewPager);
        tabLayout = view.findViewById(R.id.tabs);
        setUpViewPager();
        return view;
    }

    private void setUpViewPager() {
        fragmentList = new ArrayList<>();
        for (int i = 0; i<mtitle.length;i++){
            MyItemFragment myItemFragment=MyItemFragment.newInstance(mtitle[i]);
            fragmentList.add(myItemFragment);
        }
        //为ViewPager创建适配器
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getFragmentManager(),fragmentList,mtitle);
        viewPager.setAdapter(myPagerAdapter);
        //将ViewPager与TableLayout绑定在一起
        tabLayout.setupWithViewPager(viewPager);
    }

}
