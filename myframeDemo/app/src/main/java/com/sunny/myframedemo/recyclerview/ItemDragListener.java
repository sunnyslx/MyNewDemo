package com.sunny.myframedemo.recyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Sunny on 18-12-7.
 * 拖动监听
 */

public interface ItemDragListener {

    void  startDrags(RecyclerView.ViewHolder viewHolder);
}
