package com.fdd.andtroid_training2_video.di.component;

import android.app.Activity;

import com.fdd.andtroid_training2_video.di.module.FragmentModule;
import com.fdd.andtroid_training2_video.di.scope.FragmentScope;

import dagger.Component;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/14 14:50
 * 功能：
 */

@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {



}
