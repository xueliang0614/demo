package com.example.mvp_demo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp_demo.R;
import com.example.mvp_demo.bean.Info;
import com.example.mvp_demo.presenter.RecommendPresenter;
import com.example.mvp_demo.presenter.contract.RecommendContract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RecommendContract.View {

    @BindView(R.id.tv)
    TextView tv;
    private ProgressDialog mProgressDialog;
    private RecommendPresenter recommendPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mProgressDialog = new ProgressDialog(this);
        recommendPresenter = new RecommendPresenter(this);
        init();


    }

    private void init() {
        recommendPresenter.getData();
    }

    @Override
    public void showResult(Info datas) {
        List<Info.ResultBean> result = datas.getResult();
        String content = result.get(0).getContent();
        tv.setText(content);

    }

    @Override
    public void showNodata() {
        Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, "错误"+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showloading() {

            mProgressDialog.show();

    }

    @Override
    public void dissmiss() {
        if (mProgressDialog.isShowing()) {

            mProgressDialog.dismiss();
        }

    }
}
