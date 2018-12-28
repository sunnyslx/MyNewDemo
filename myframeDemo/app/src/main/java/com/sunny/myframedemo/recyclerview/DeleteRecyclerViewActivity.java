package com.sunny.myframedemo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sunny.myframedemo.R;

import java.util.ArrayList;
import java.util.Collections;

public class DeleteRecyclerViewActivity extends AppCompatActivity implements ItemDragListener{
    private static final String TAG=DeleteRecyclerViewActivity.class.getSimpleName();
    private ArrayList<String> mList;
    private RecyclerView recyclerView;
    private DeleteAdapter deleteAdapter;

    private  ItemTouchHelper itemTouchHelper;
    private MyItemTouchHelperCallback myItemTouchHelperCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_recycler_view);
        initData();
        recyclerView = findViewById(R.id.delete_recyclerview);
        setRecyclerView();

        myItemTouchHelperCallback=new MyItemTouchHelperCallback(deleteAdapter);
        itemTouchHelper=new ItemTouchHelper(myItemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mList.add("我是第" + i + "条数据");
        }
    }


    private void setRecyclerView(){
        deleteAdapter=new DeleteAdapter(mList,this);
        recyclerView.setLayoutManager(new MyLinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(deleteAdapter);
    }

    //开始拖动
    @Override
    public void startDrags(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }
}
