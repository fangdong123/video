package com.fdd.andtroid_training2_video.di.component;

import android.app.Application;

import com.fdd.andtroid_training2_video.di.module.AppModule;
import com.fdd.andtroid_training2_video.di.module.ClientModule;
import com.fdd.andtroid_training2_video.di.module.GlobalConfigModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/12 19:22
 * 功能：
 */

@Singleton
@Component(modules = {AppModule.class, ClientModule.class, GlobalConfigModule.class})
public interface AppComponent {

    Application getApplication();

    Retrofit getRetrofit();

}
