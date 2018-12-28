package com.sunny.myframedemo.mvp.model;

/**
 * Created by Sunny on 18-12-22.
 */

public interface LoginPort {

    void login(String userName,String  password,OnLoginListener onLoginListener);
}
