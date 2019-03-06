package com.example.mvp_demo.presenter.contract;

import com.example.mvp_demo.bean.AppInfo;
import com.example.mvp_demo.bean.Info;
import com.example.mvp_demo.presenter.BasePresenter;
import com.example.mvp_demo.ui.BaseView;

import java.util.List;

/**
 * 公共接口
 * 作用：存放view 于prenter的引用
 *
 */
public interface RecommendContract {
    /**
     * View的接口
     *
     */

    public  interface  View extends BaseView {
        void  showResult(Info datas);
        void showNodata();
        void showError(String msg);
    }

    /**
     * p层的接口
     *
     *
     */
     public interface Presenter extends BasePresenter {

         //业务逻辑层
        /**
         * 获取数据
         */
           void getData();
    }

}
