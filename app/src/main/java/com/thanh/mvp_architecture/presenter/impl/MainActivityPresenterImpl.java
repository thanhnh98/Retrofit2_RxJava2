package com.thanh.mvp_architecture.presenter.impl;

import android.content.Context;

import com.thanh.mvp_architecture.model.PhotoModel;
import com.thanh.mvp_architecture.network.RestClient;
import com.thanh.mvp_architecture.presenter.MainActivityPresenter;
import com.thanh.mvp_architecture.service.GetPhotosService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenterImpl implements MainActivityPresenter {
    private Context context;
    private View view;
    public MainActivityPresenterImpl(Context context,View view){
        this.context = context;
        this.view = view;

    }

    @Override
    public void invokeData() {
        GetPhotosService service= RestClient.createService(GetPhotosService.class);
        service.getPhotos().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(data->{
                    List<PhotoModel> list=data.getData();
                    for(PhotoModel t:list){
                        if(t.getName().equals("Con mèo")) t.setName("Thanh");
                    }
                    data.setData(list);
                    return true;
                })
                .subscribe(response->{
                   // Log.e("respone",new Gson().toJson(response));
                    view.initAdapter(context,response.getData());
                    view.initRecyclerView();
                },throwable -> {
                    throwable.printStackTrace();
                });
    }
}
