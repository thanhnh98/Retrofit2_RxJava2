package com.thanh.mvp_architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileModel {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("coNguoiyeuChua")
    @Expose
    private String coNguoiyeuChua;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCoNguoiyeuChua() {
        return coNguoiyeuChua;
    }

    public void setCoNguoiyeuChua(String coNguoiyeuChua) {
        this.coNguoiyeuChua = coNguoiyeuChua;
    }
}
