package com.fdd.andtroid_training2_video.mvp.presenter;

import com.fdd.andtroid_training2_video.mvp.model.MainModel;
import com.fdd.andtroid_training2_video.mvp.ui.common.BasePresenter;
import com.fdd.andtroid_training2_video.mvp.ui.view.MainView;

import javax.inject.Inject;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/13 10:59
 * 功能：
 */

public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    MainModel mMainModel;

    @Inject
    public MainPresenter() {
    }

    public void load(){
//        Flowable<String> data = mMainModel.getData();
//        data.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableSubscriber<String>() {
//                    @Override
//                    public void onNext(String s) {
//                        getView().success(s);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        System.out.println("失败"+t.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
        mMainModel.getData(new MainModel.getshuju() {
            @Override
            public void ge(String s) {
                getView().success(s);
            }
        });
    }

}
