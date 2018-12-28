package com.sunny.myframedemo.toolbarscroll;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunny.myframedemo.R;

import java.util.List;

/**
 * Created by Sunny on 18-11-20.
 */

public class ToolBarAdapter extends RecyclerView.Adapter<ToolBarAdapter.ViewHolder>{

    private List<String> mlist;

    public ToolBarAdapter(List<String> mlist) {
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(mlist.get(position));
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_content);
        }
    }
}



