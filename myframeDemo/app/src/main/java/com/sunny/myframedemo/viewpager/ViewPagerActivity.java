package com.sunny.myframedemo.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sunny.myframedemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ViewPagerActivity extends AppCompatActivity {
    private static final String TAG=ViewPagerActivity.class.getSimpleName();
    private ViewPager viewPager;
    private List<View> viewList;
    private LinearLayout linearLayout;
    private ViewPagerAdapter adapter;
    //存放三个小圆点
    private ImageView[] tips = new ImageView[3];
    private ImageView imageView;
    private int lastPosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.viewPager);
        viewList = new ArrayList<>();
        //设置第一个点处于未激活状态
        linearLayout = findViewById(R.id.myLinear);

        //循环添加ViewPager
        for (int i = 0; i < 3; i++) {
            viewList.add(getGlidePage(i));
        }
        //在布局中添加
        for (int i=0;i<3;i++){
            imageView=new ImageView(this);
            tips[i]=imageView;
            //默认第一张为选中状态
            if (i==0){
                tips[0].setImageResource(R.drawable.circle_select);
            }else {
                tips[i].setImageResource(R.drawable.circle_unselect);
            }
            linearLayout.addView(tips[i]);
        }
        adapter = new ViewPagerAdapter(this, viewList);
        viewPager.setAdapter(adapter);

        //滑动监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //滚动过程回调
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //滚动成功后回调
            @Override
            public void onPageSelected(int position) {
                //选中时view的圆点
                tips[position].setImageResource(R.drawable.circle_select);
                //这个图片是未选中view的圆点
                tips[lastPosition].setImageResource(R.drawable.circle_unselect);
                lastPosition=position;
            }

            //手指按下屏幕时回调
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private View getGlidePage(int i) {
        View view = View.inflate(this, R.layout.viewpager_content, null);
        ImageView imageView = view.findViewById(R.id.image1);
        TextView textView = view.findViewById(R.id.tv1);
        switch (i) {
            case 0:
                imageView.setImageResource(R.drawable.view3);
                textView.setText("田间");
                break;
            case 1:
                imageView.setImageResource(R.drawable.view1);
                textView.setText("左耳");
                break;
            case 2:
                imageView.setImageResource(R.drawable.view2);
                textView.setText("倾听");
                break;
        }
        return view;
    }
}
