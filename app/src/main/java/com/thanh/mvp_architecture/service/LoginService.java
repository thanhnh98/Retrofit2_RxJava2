package com.thanh.mvp_architecture.service;

import com.thanh.mvp_architecture.model.ProfileModel;
import com.thanh.mvp_architecture.model.ResponseModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LoginService {
    @GET("v2/5e15a0d03400006500406661")
    Observable<ResponseModel<ProfileModel>> requetLogin();
}
