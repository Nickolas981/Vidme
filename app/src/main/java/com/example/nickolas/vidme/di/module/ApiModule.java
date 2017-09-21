package com.example.nickolas.vidme.di.module;

import com.example.nickolas.vidme.api.VidmeApi;
import com.example.nickolas.vidme.Constants;
import com.example.nickolas.vidme.model.remote.FeaturedVideosDataSource;
import com.example.nickolas.vidme.model.remote.IFeaturedVideosDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nickolas on 21.09.2017.
 */

@Module
public class ApiModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public IFeaturedVideosDataSource provideFeaturedVideosDataSource(Retrofit retrofit) {
        return new FeaturedVideosDataSource(retrofit.create(VidmeApi.class));
    }

}
