package com.example.mvp_demo.http;


import com.example.mvp_demo.bean.AppInfo;
import com.example.mvp_demo.bean.Info;
import com.example.mvp_demo.bean.PageBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ivan on 2016/12/30.
 */

public interface ApiService {


    public static final String BASE_URL = "http://api.apiopen.top/";




    @GET("getSongPoetry")
    public Call<Info> getApps(@Query("page") int page,@Query("count") int count);


}
