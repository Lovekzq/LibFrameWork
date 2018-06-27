package com.cai.framework.dagger.module;

import android.content.Context;

import com.cai.framework.base.GodBaseApplication;
import com.cai.framework.base.GodBaseConfig;
import com.example.clarence.datastorelibrary.store.share_preference.ISharePreference;
import com.example.clarence.datastorelibrary.store.share_preference.StoreForSharePreference;
import com.example.clarence.imageloaderlibrary.ILoadImage;
import com.example.clarence.imageloaderlibrary.ImageForGlide;
import com.example.clarence.netlibrary.INet;
import com.example.clarence.netlibrary.NetForRetrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by clarence on 2018/3/26.
 */
@Module
public class FrameWorkModule {

    @Provides
    @Singleton
    public Context provideContext() {
        return GodBaseApplication.getAppContext();
    }

    @Provides
    @Singleton
    public ILoadImage provideImageLoader() {
        return new ImageForGlide.ImageForGlideBuild().build();
    }

    @Provides
    @Singleton
    public INet provideRequest(Context context) {
        return new NetForRetrofit.Builder().context(context).baseUrl(GodBaseConfig.getInstance().getBaseUrl()).build();
    }

    @Provides
    @Singleton
    public ISharePreference provideSharePreference(Context context) {
        return new StoreForSharePreference.Builder().context(context).spName("spSave").build();
    }
}
