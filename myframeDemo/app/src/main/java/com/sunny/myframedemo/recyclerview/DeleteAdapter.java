package com.sunny.myframedemo.recyclerview;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sunny.myframedemo.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Sunny on 18-10-19.
 */

public class DeleteAdapter extends RecyclerView.Adapter<DeleteAdapter.DeleteHolder> implements ItemMoveListener{


    private ArrayList<String> mList;
    private ItemDragListener itemDragListener;

    public DeleteAdapter( ArrayList<String> mList, ItemDragListener itemDragListener) {
        this.mList = mList;
        this.itemDragListener = itemDragListener;
    }

    @NonNull
    @Override
    public DeleteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_layout,null);
        return new DeleteHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final DeleteHolder holder, int position) {
        holder.textView.setText(mList.get(position));
        holder.imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                itemDragListener.startDrags(holder);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //交换数据
        Collections.swap(mList,fromPosition,toPosition);
        //刷新
        notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public boolean onItemRemove(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
        return true;
    }


    public class DeleteHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imageView;
        public DeleteHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_content);
            imageView=itemView.findViewById(R.id.imv_delete);
        }
    }


}
