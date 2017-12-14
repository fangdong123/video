package com.fdd.andtroid_training2_video.app;

import android.app.Application;

import com.fdd.andtroid_training2_video.di.component.AppComponent;
import com.fdd.andtroid_training2_video.di.component.DaggerAppComponent;
import com.fdd.andtroid_training2_video.di.module.AppModule;
import com.fdd.andtroid_training2_video.di.module.GlobalConfigModule;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/12 20:35
 * 功能：
 */

public class MyApp extends Application {

    public static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .globalConfigModule(new GlobalConfigModule.Builder().baseurl("http://www.qq.com/").bulide())
                .build();
    }
}
