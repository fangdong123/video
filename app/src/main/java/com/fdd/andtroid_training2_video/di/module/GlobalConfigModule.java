package com.fdd.andtroid_training2_video.di.module;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： 方冬冬
 * 时间： 2017/12/12 20:44
 * 功能：
 */

@Module
public class GlobalConfigModule {

    private String url;

    public GlobalConfigModule(Builder builder) {
        this.url = builder.url;
    }

    @Provides
    String providesUrl(){
        return url;
    }

    public static class Builder{
        String url;

        public Builder baseurl(String url) {
            this.url = url;
            return this;
        }

        public GlobalConfigModule bulide(){
            return new GlobalConfigModule(this);
        }
    }


}
