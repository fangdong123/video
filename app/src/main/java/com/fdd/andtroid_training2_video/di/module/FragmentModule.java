package com.fdd.andtroid_training2_video.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.fdd.andtroid_training2_video.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/14 14:46
 * 功能：
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }

}
