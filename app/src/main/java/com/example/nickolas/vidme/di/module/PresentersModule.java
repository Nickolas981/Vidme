package com.example.nickolas.vidme.di.module;

import com.example.nickolas.vidme.di.scopes.Scope;
import com.example.nickolas.vidme.di.scopes.Scopes;
import com.example.nickolas.vidme.model.remote.IFeaturedVideosDataSource;
import com.example.nickolas.vidme.presenters.FeaturedVideosPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roman Tsekhmeistruk on 11.04.2017.
 */

@Module
public class PresentersModule {

    @Provides
    @Scope(Scopes.VIEW)
    public FeaturedVideosPresenter provideFeaturedVideosPresenter(IFeaturedVideosDataSource featuredVideosDataSource) {
        return new FeaturedVideosPresenter(featuredVideosDataSource);
    }

}
