package com.thanh.mvp_architecture.presenter;

import android.content.Context;

import com.thanh.mvp_architecture.model.PhotoModel;

import java.util.List;

public interface MainActivityPresenter {
    void invokeData();
    interface View{
        void initAdapter(Context context, List<PhotoModel> listData);
        void initRecyclerView();
    }

}
