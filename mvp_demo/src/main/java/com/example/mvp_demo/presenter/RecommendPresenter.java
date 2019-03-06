package com.example.mvp_demo.presenter;

import com.example.mvp_demo.bean.AppInfo;
import com.example.mvp_demo.bean.Info;
import com.example.mvp_demo.bean.PageBean;
import com.example.mvp_demo.data.RecommendModel;
import com.example.mvp_demo.presenter.contract.RecommendContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *   对p层的实现
 *   p的实现必须要有View层的引用
 *   通过构造方法来船体数据
 *   作用 具体的实现
 *   P层需要持有Model和view的引用
 *
 *
 */

public class RecommendPresenter implements RecommendContract.Presenter {


    private  RecommendContract.View MView;
    private RecommendModel model;

    /**
     * 通过构造方法进行对view的船体
     *
     */

    public RecommendPresenter(RecommendContract.View view) {
         this.MView=view;
        model=new RecommendModel();
    }


    /**
     * 获取数据
     */
    @Override
    public void getData() {
        MView.showloading();

      model.getApp(new Callback<Info>() {

          @Override
          public void onResponse(Call<Info> call, Response<Info> response) {

              if(response!=null){
               MView.showResult(response.body());
              }else{
                  MView.showNodata();
              }
              MView.dissmiss();
          }

          @Override
          public void onFailure(Call<Info> call, Throwable t) {
              MView.showError(t.getMessage());
              MView.dissmiss();
          }
      });
    }
}
