package com.example.mvp_demo.data;

import com.example.mvp_demo.bean.AppInfo;
import com.example.mvp_demo.bean.Info;
import com.example.mvp_demo.bean.PageBean;
import com.example.mvp_demo.http.ApiService;
import com.example.mvp_demo.http.HttpManager;

import java.util.List;

import retrofit2.Callback;

/**
 *
 * 对数据的获取
 *
 */

public class RecommendModel {

    /**
     * 获取数据的方法
     *
     * @param callback
     */

    public void getApp(Callback<Info> callback){

        HttpManager manager = new HttpManager();

        ApiService apiService =manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);


        apiService.getApps(1,20).enqueue(callback);

    }

}
