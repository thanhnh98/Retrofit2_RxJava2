package com.thanh.mvp_architecture.service;

import com.thanh.mvp_architecture.model.PhotoModel;
import com.thanh.mvp_architecture.model.ResponseModel;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetPhotosService {
    @GET("v2/5e1597353400005200406612")
    Observable<ResponseModel<List<PhotoModel>>> getPhotos();
}
