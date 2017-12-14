package com.fdd.andtroid_training2_video.di.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/12 20:25
 * 功能：
 */

@Module
public class ClientModule {

    private static final int TIME_OUT = 10;

    /**
     * 提供 {@link Retrofit}
     *
     * @param builder
     * @param client
     * @return
     * @author: jess
     * @date 8/30/16 1:15 PM
     */
    @Singleton
    @Provides
    Retrofit provideRetrofit( Retrofit.Builder builder, OkHttpClient client, String str) {
        builder
                .baseUrl(str)//域名
                .client(client);//设置okhttp


        builder
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用 Rxjava
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());//使用 Gson

        return builder.build();
    }

    /**
     * 提供 {@link OkHttpClient}
     *
     * @param builder
     * @return
     */
    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        builder
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
             ;

        return builder.build();
    }

    HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

            }
        });
    }


    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideClientBuilder() {
        return new OkHttpClient.Builder();
    }


}
