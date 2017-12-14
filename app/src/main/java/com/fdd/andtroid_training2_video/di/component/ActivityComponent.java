package com.fdd.andtroid_training2_video.di.component;

import com.fdd.andtroid_training2_video.di.scope.ActivityScope;
import com.fdd.andtroid_training2_video.di.module.ActivityModule;
import com.fdd.andtroid_training2_video.mvp.ui.activity.MainActivity;

import dagger.Component;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/12 21:06
 * 功能：
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}
