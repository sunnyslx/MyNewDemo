package com.sunny.myframedemo.toolbarscroll;


import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.sunny.myframedemo.R;


import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToolBarFragment extends Fragment {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private List<String> stringList=new ArrayList<>();
    public ToolBarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i=0;i<20;i++){
            stringList.add("第"+i+"条数据");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tool_bar, container, false);
        recyclerView=view.findViewById(R.id.toolbar_recycleView);
        toolbar=view.findViewById(R.id.toolBAR);
        toolbar.setTitle("ToolBar");
        ToolBarAdapter toolBarAdapter=new ToolBarAdapter(stringList);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(toolBarAdapter);
        return view;
    }

}
