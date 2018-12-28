package com.sunny.myframedemo.recyclerview;

/**
 * Created by Sunny on 18-12-7.
 */

public interface ItemMoveListener {

    boolean onItemMove(int fromPosition, int toPosition);

    boolean onItemRemove(int position);
}
