package com.thanh.mvp_architecture.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.thanh.mvp_architecture.R;
import com.thanh.mvp_architecture.presenter.LoginPresenter;
import com.thanh.mvp_architecture.presenter.impl.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.View {
    private ProgressDialog dialog;
    private LoginPresenter loginPresenter;
    private EditText edt_username;
    private EditText edt_password;
    private Button btn_login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogin(edt_username.getText().toString(),edt_password.getText().toString());
            }
        });
    }

    @Override
    public void onLoginPending() {
        onStartProcessBar("Đợi chút...");
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        this.finish();
    }

    @Override
    public void onLoginFail() {
        onStopProcessBar();
        Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartProcessBar(String message) {
        dialog.setMessage(message);
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onStopProcessBar() {
        dialog.dismiss();
    }

    @Override
    public void requestLogin(String username, String password) {
        loginPresenter.onLogin(username,password);

    }

    private void init(){
        dialog=new ProgressDialog(this);
        loginPresenter=new LoginPresenterImpl(this,this);
        edt_username=findViewById(R.id.edt_username);
        edt_password=findViewById(R.id.edt_password);
        btn_login=findViewById(R.id.btn_login);
    }
}
