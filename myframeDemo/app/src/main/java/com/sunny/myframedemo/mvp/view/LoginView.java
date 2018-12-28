package com.sunny.myframedemo.mvp.view;

/**
 * Created by Sunny on 18-12-22.
 */

public interface LoginView {

    String getUserName();
    String getPassword();

    void showToast(String msg);
}
