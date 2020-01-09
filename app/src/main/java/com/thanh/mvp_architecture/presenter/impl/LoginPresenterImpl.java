package com.thanh.mvp_architecture.presenter.impl;

import android.app.ProgressDialog;
import android.content.Context;

import com.thanh.mvp_architecture.network.RestClient;
import com.thanh.mvp_architecture.presenter.LoginPresenter;
import com.thanh.mvp_architecture.service.LoginService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenterImpl implements LoginPresenter {
    private final Context context;
    private final View view;
    public LoginPresenterImpl(Context context, View view){

        this.context = context;
        this.view = view;
    }
    @Override
    public void onLogin(String username,String password) {
        view.onLoginPending();
        if(username.equals("1")&&password.equals("1")){
            LoginService service= RestClient.createService(LoginService.class);
            service.requetLogin().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response->{
                        view.onLoginSuccess();
                        view.onStopProcessBar();
                    },throwable -> {
                        throwable.printStackTrace();
                        view.onLoginFail();
                    });
        }else view.onLoginFail();

    }

}
