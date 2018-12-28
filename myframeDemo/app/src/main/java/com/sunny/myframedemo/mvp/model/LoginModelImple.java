package com.sunny.myframedemo.mvp.model;

/**
 * Created by Sunny on 18-12-22.
 */

public class LoginModelImple implements LoginPort {

    @Override
    public void login(String userName, String password, OnLoginListener onLoginListener) {
        if (userName.equals("admin") && password.equals("123456")){
            onLoginListener.onSuccess();
        }else if (!userName.equals("admin") || !password.equals("123456")){
            onLoginListener.onUserError();
        }else {
            onLoginListener.onFailure();
        }
    }
}
