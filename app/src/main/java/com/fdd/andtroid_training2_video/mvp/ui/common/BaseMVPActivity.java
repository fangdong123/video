package com.fdd.andtroid_training2_video.mvp.ui.common;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.fdd.andtroid_training2_video.app.MyApp;
import com.fdd.andtroid_training2_video.di.component.ActivityComponent;
import com.fdd.andtroid_training2_video.di.component.DaggerActivityComponent;
import com.fdd.andtroid_training2_video.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/12 15:54
 * 功能：
 */

public abstract class BaseMVPActivity<V,P extends BasePresenter<V>> extends AppCompatActivity {

    @Inject
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        ButterKnife.bind(this);
        setTranslucentStatus(true);
        initInject(getActivityComponent());

        if (presenter != null){
            presenter.attachView((V) this);
        }

        initView();
        initData();
    }

    /**
     * 布局ID
     */
    protected abstract int setLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initInject(ActivityComponent activityComponent);

    public ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder().appComponent(MyApp.mAppComponent).activityModule(new ActivityModule(this)).build();
    }

    /**
     * 设置沉浸式
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
