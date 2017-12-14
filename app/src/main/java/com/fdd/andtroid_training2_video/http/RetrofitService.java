package com.fdd.andtroid_training2_video.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/12 19:38
 * 功能：
 */

public class RetrofitService {

    private static RetrofitService mRetrofitService;

    private RetrofitService() {}

    public static RetrofitService getInstance(){
        if (mRetrofitService == null){
            synchronized(RetrofitService.class){
                if (mRetrofitService == null){
                    mRetrofitService = new RetrofitService();
                }
            }
        }
        return mRetrofitService;
    }

    public synchronized Retrofit getRetrofit(String url){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;

    }

    public <T> T getClient(Class<T> cla,String url){
        return getRetrofit(url).create(cla);
    }





}
