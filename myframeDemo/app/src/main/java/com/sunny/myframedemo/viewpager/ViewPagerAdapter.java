package com.sunny.myframedemo.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Sunny on 18-10-17.
 */

public class ViewPagerAdapter extends PagerAdapter{
    private Context context;
    List<View> views;

    public ViewPagerAdapter(Context context, List<View> views) {
        this.context = context;
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }
    //决定一个页面视图关联的一个特征的关键对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    //为给定位置创造页面
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewGroup parent=(ViewGroup) views.get(position).getParent();
        if (parent !=null){
            parent.removeAllViews();
        }
        container.addView(views.get(position));
        return views.get(position);
    }
    //删除指定位置的页面
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
}
