package com.thanh.mvp_architecture.presenter;

public interface LoginPresenter {
    void onLogin(String username,String password);
    interface View{
        void onLoginPending();
        void onLoginSuccess();
        void onLoginFail();
        void onStartProcessBar(String message);
        void onStopProcessBar();
        void requestLogin(String username,String password);
    }
}
