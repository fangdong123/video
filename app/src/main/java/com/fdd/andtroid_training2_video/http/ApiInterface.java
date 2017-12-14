package com.fdd.andtroid_training2_video.http;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/13 08:07
 * 功能：
 */

public interface ApiInterface {

    @GET("/")
    Flowable<String> getdata();
;
}
