package com.sunny.myframedemo;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Sunny on 18-9-18.
 */

public class MyAdapter extends BaseAdapter {
    private String[] strings;
    private Context context;

    public MyAdapter(String[] strings, Context context) {
        this.strings = strings;
        this.context = context;
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int position) {
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView !=null){
            textView=(TextView)convertView;
        }else {
            textView=new TextView(context);
        }
        textView.setHeight(60);
        textView.setTextSize(20);
        textView.setText(strings[position]);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}
