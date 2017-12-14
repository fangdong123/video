package com.fdd.andtroid_training2_video.mvp.ui.common;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/12 16:21
 * 功能：
 */

public class BasePresenter<V> {

    private WeakReference<V> mWeakReference;

    public void attachView(V v){
        mWeakReference = new WeakReference<V>(v);
    }

    public V getView(){
        if (mWeakReference != null && mWeakReference.get() != null){
            return mWeakReference.get();
        }
        return null;
    }

    public void detachView(){
        if (mWeakReference != null){
            mWeakReference.clear();
            mWeakReference = null;
        }
    }



}
