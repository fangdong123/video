package com.fdd.andtroid_training2_video.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/12 19:19
 * 功能：
 */

@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideContext(){
        return mApplication;
    }

}
