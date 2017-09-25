package com.example.nickolas.vidme.di.module;

import com.example.nickolas.vidme.Constants;
import com.example.nickolas.vidme.api.VidmeApi;
import com.example.nickolas.vidme.model.remote.FeaturedVideosDataSource;
import com.example.nickolas.vidme.model.remote.FeedVideosDataSource;
import com.example.nickolas.vidme.model.remote.IFeaturedVideosDataSource;
import com.example.nickolas.vidme.model.remote.IFeedVideosDataSource;
import com.example.nickolas.vidme.model.remote.ILogInDataSource;
import com.example.nickolas.vidme.model.remote.INewVideosDataSource;
import com.example.nickolas.vidme.model.remote.LogInDataSource;
import com.example.nickolas.vidme.model.remote.NewVideosDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public IFeaturedVideosDataSource provideFeaturedVideosDataSource(Retrofit retrofit) {
        return new FeaturedVideosDataSource(retrofit.create(VidmeApi.class));
    }

    @Provides
    @Singleton
    public IFeedVideosDataSource provideFeedVideoDataSource(Retrofit retrofit) {
        return new FeedVideosDataSource(retrofit.create(VidmeApi.class));
    }

    @Provides
    @Singleton
    public INewVideosDataSource provideNewVideoDataSource(Retrofit retrofit) {
        return new NewVideosDataSource(retrofit.create(VidmeApi.class));
    }

    @Provides
    @Singleton
    public ILogInDataSource provideLogInDataSource(Retrofit retrofit) {
        return new LogInDataSource(retrofit.create(VidmeApi.class));
    }
}
