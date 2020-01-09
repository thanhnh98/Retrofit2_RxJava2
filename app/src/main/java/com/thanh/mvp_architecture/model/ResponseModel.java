package com.thanh.mvp_architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel<T> {
    @SerializedName("exitcode")
    @Expose
    private Integer exitcode;
    @SerializedName("data")
    @Expose
    private T data = null;

    public Integer getExitcode() {
        return exitcode;
    }

    public void setExitcode(Integer exitcode) {
        this.exitcode = exitcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
