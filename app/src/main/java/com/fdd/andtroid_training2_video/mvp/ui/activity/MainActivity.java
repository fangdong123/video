package com.fdd.andtroid_training2_video.mvp.ui.activity;

import android.os.Bundle;

import com.fdd.andtroid_training2_video.R;
import com.fdd.andtroid_training2_video.di.component.ActivityComponent;
import com.fdd.andtroid_training2_video.mvp.presenter.MainPresenter;
import com.fdd.andtroid_training2_video.mvp.ui.common.BaseMVPActivity;
import com.fdd.andtroid_training2_video.mvp.ui.view.MainView;


public class MainActivity extends BaseMVPActivity<MainView,MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.load();
    }

    @Override
    protected void initInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void success(String str) {
        System.out.println("ttt"+str);
    }
}
