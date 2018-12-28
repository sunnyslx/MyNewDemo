package com.sunny.myframedemo.login;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sunny.myframedemo.R;
import com.sunny.myframedemo.mvp.presenter.LoginPresenter;
import com.sunny.myframedemo.mvp.view.LoginView;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  implements View.OnClickListener,LoginView{

    private Button singIn;
    private EditText userName;
    private EditText password;

    private LoginPresenter loginPresenter;
    private Button google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        singIn=findViewById(R.id.email_sign_in_button);
        userName=findViewById(R.id.email);
        password=findViewById(R.id.password);
        google=findViewById(R.id.google);
        singIn.setOnClickListener(this);
        google.setOnClickListener(this);
        loginPresenter=new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.email_sign_in_button){
            loginPresenter.login();
        }else if (v.getId()==R.id.google){

        }
    }

    @Override
    public String getUserName() {
        return userName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}

