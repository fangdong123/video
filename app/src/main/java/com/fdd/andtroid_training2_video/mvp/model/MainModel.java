package com.fdd.andtroid_training2_video.mvp.model;

import com.fdd.andtroid_training2_video.http.ApiInterface;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/13 10:54
 * 功能：
 */

public class MainModel {

    @Inject
    public MainModel() {
    }

    @Inject
    Retrofit retrofit;

    public void getData(final getshuju s){
        Flowable<String> getdata = retrofit.create(ApiInterface.class).getdata();
        getdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<String>() {
                    @Override
                    public void onNext(String st) {
                        s.ge(st);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("失败"+t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public interface getshuju{
        void ge(String s);
    }


}
