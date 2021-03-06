package com.cai.framework.dagger.module;

import android.content.Context;

import com.cai.framework.base.GodBaseApplication;
import com.cai.framework.base.GodBaseConfig;
import com.cai.framework.dataStore.ISharePreference;
import com.cai.framework.dataStore.StoreForSharePreference;
import com.cai.framework.http.INet;
import com.cai.framework.http.NetForRetrofit;
import com.cai.framework.imageload.ILoadImage;
import com.cai.framework.imageload.ImageForGlide;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import retrofit2.Retrofit;

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
    public INet provideRequestNet(Context context, Interceptor interceptor) {
        return new NetForRetrofit
                .Builder()
                .context(context)
                .baseUrl(GodBaseConfig.getInstance()
                .getBaseUrl())
                .interceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    public ISharePreference provideSharePreference(Context context) {
        return new StoreForSharePreference.Builder().context(context).spName("spSave").build();
    }

    @Provides
    @Singleton
    public Retrofit provideRequestRetrofit(INet iNet) {
        return iNet.request();
    }
}
