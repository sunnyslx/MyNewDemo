package com.sunny.myframedemo.login.google.addedittask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunny.myframedemo.R;

public class AddEditTaskActivity extends AppCompatActivity {

    public static final int REQUEST_ADD_TASK=1;

    public static final String SHOULD_LOAD_DATA_FROM_REPO_KEY="SHOULD_LOAD_DATA_FROM_REPO_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);
    }
}
