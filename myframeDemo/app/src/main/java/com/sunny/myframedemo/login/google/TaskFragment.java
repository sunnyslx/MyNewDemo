package com.sunny.myframedemo.login.google;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunny.myframedemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment {


    public static TaskFragment INSTACNCE(){
        return new TaskFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

}
