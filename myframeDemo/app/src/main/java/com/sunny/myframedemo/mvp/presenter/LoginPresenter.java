package com.sunny.myframedemo.mvp.presenter;

import com.sunny.myframedemo.mvp.model.LoginModelImple;
import com.sunny.myframedemo.mvp.model.LoginPort;
import com.sunny.myframedemo.mvp.model.OnLoginListener;
import com.sunny.myframedemo.mvp.view.LoginView;

/**
 * Created by Sunny on 18-12-22.
 */

public class LoginPresenter implements OnLoginListener {
    //登录接口
    private LoginPort loginPort;
    //登录view
    private LoginView loginView;

    //实例化登录接口和登录view
    public LoginPresenter( LoginView loginView) {
        this.loginView = loginView;
        loginPort=new LoginModelImple();
    }

    //将从view层获取的数据传给model层，让activity中的登录按钮调用它
    public void  login(){
        String userName=loginView.getUserName();
        String password=loginView.getPassword();
        loginPort.login(userName,password,this);
    }

    @Override
    public void onUserError() {
        loginView.showToast("登录失败,用户名或者密码错误");
    }

    @Override
    public void onSuccess() {
         loginView.showToast("登录成功");
    }

    @Override
    public void onFailure() {
        loginView.showToast("异常错误");
    }
}
