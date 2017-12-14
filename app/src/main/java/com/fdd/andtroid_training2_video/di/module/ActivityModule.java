package com.fdd.andtroid_training2_video.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/12 21:06
 * 功能：
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity Activity) {
        this.mActivity = Activity;
    }

    @Provides
    Activity provideActivity(){
        return mActivity;
    }
}
