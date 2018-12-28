package com.sunny.myframedemo.toolbarscroll;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunny.myframedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyItemFragment extends Fragment {


    public static MyItemFragment newInstance(String title){
        MyItemFragment myItemFragment=new MyItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Title", title);
        myItemFragment.setArguments(bundle);
        return myItemFragment;
    }

    private RecyclerView recyclerView;
    private String title;
    private List<String>  mList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_item, container, false);
        recyclerView=view.findViewById(R.id.item_recyclerView);

        Bundle bundle=getArguments();
        if (bundle !=null){
            title=bundle.getString("Title");
        }

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        initData();

        ToolBarAdapter toolBarAdapter=new ToolBarAdapter(mList);
        recyclerView.setAdapter(toolBarAdapter);

        return view;
    }

    private void initData(){
        for (int i=0;i<20;i++){
            mList.add("我是第"+i+"个"+title);
        }
    }
}
