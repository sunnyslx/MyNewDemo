package com.sunny.myframedemo.toolbarscroll;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sunny.myframedemo.R;

public class ScrollActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.draw_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_nativation
                , R.string.close_nativation);
        navigationView.setCheckedItem(R.id.toolBar);
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);
    }


    private NavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.toolBar:
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                    transaction1.replace(R.id.frame_content, new ToolBarFragment())
                            .commit();
                    break;
                case R.id.appbarLayout:
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_content, new AppBarFragment())
                            .commit();
                    break;
                case R.id.collapsingLayout:
                    FragmentTransaction transaction2=getSupportFragmentManager().beginTransaction();
                    transaction2.replace(R.id.frame_content,new CollapsingFragment())
                            .commit();
                    break;
            }
            drawerLayout.closeDrawers();
            return true;
        }
    };

}
