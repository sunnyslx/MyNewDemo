package com.sunny.myframedemo.mvp.model;

/**
 * Created by Sunny on 18-12-22.
 */

public interface OnLoginListener {
    //用户名错误
    void onUserError();
    //登录成功
    void onSuccess();
    //登录失败
    void onFailure();
}
