package com.sunny.myframedemo.login.google;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.sunny.myframedemo.R;
import com.sunny.myframedemo.login.google.presenter.TaskPresenter;
import com.sunny.myframedemo.login.google.utils.ActivityUtils;

public class TaskActivity extends AppCompatActivity {
    private static final String  CURRENT_FILTERING_KEY="CURRENT_FILTERING_KEY";

    private DrawerLayout drawerLayout;

    private TaskPresenter mTaskPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        //设置toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        //设置
        drawerLayout=findViewById(R.id.drawer_layout);
        if (drawerLayout !=null){
            drawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        }

        NavigationView navigationView=findViewById(R.id.nav_view);

        if (navigationView!=null){
            setUpDrawerContent(navigationView);
        }

        TaskFragment taskFragment=(TaskFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrameLayout);
        if (taskFragment==null){
            taskFragment=TaskFragment.INSTACNCE();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),taskFragment,R.id.contentFrameLayout);
        }

//        mTaskPresenter=new TaskPresenter(this)

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     *
     * @param navigationView
     */
    private void setUpDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.aa:
                        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.contentFrameLayout,TaskFragment.INSTACNCE());
                        transaction.commit();
                        break;
                    case R.id.bb:

                        break;
                }
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
