package com.sunny.myframedemo.recyclerview;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Sunny on 18-12-7.
 */

public class MyItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private ItemMoveListener itemMoveListener;

    public MyItemTouchHelperCallback(ItemMoveListener itemMoveListener) {
        this.itemMoveListener = itemMoveListener;
    }

    //判断recyclerView上的哪个方向的操作交由ItemTouchHelper.Callback处理
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //获取动作标志,
        //不想上下拖动可以将dragFlags置为0
        int dragFlags=ItemTouchHelper.UP |ItemTouchHelper.DOWN;
        //如果不想左右滑动，可以将swipeFlags置为0；
        int swipeFlags=ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        //最终的flags交由makeMovementFlags生成
        int flag=makeMovementFlags(dragFlags,swipeFlags);
        return flag;
    }

    //发生拖拽时候回调
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return itemMoveListener.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
    }

    //侧滑的时候回调
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        itemMoveListener.onItemRemove(viewHolder.getAdapterPosition());
    }

    //item长按实现拖拽
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    //当item被拖拽或者侧滑时回调
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (actionState!=ItemTouchHelper.ACTION_STATE_IDLE){
            viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getResources().getColor(android.R.color.darker_gray));
        }
    }

    //当item的交互动画结束时触发
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getResources().getColor(android.R.color.white));

    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
