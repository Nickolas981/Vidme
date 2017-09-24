package com.example.nickolas.vidme.di.module;

import com.example.nickolas.vidme.di.scopes.Scope;
import com.example.nickolas.vidme.di.scopes.Scopes;
import com.example.nickolas.vidme.model.remote.IFeaturedVideosDataSource;
import com.example.nickolas.vidme.model.remote.IFeedVideosDataSource;
import com.example.nickolas.vidme.model.remote.ILogInDataSource;
import com.example.nickolas.vidme.model.remote.INewVideosDataSource;
import com.example.nickolas.vidme.presenters.FeaturedVideosPresenter;
import com.example.nickolas.vidme.presenters.FeedVideosPresenter;
import com.example.nickolas.vidme.presenters.LogInPresenter;
import com.example.nickolas.vidme.presenters.NewVideosPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {

    @Provides
    @Scope(Scopes.VIEW)
    public FeaturedVideosPresenter provideFeaturedVideosPresenter(IFeaturedVideosDataSource featuredVideosDataSource) {
        return new FeaturedVideosPresenter(featuredVideosDataSource);
    }

    @Provides
    @Scope(Scopes.VIEW)
    public FeedVideosPresenter provideFeedVideosPresenter(IFeedVideosDataSource feedVideosDataSource) {
        return new FeedVideosPresenter(feedVideosDataSource);
    }

    @Provides
    @Scope(Scopes.VIEW)
    public NewVideosPresenter provideNewVideosPresenter(INewVideosDataSource newVideosDataSource) {
        return new NewVideosPresenter(newVideosDataSource);
    }

    @Provides
    @Scope(Scopes.VIEW)
    public LogInPresenter provideLogInPresenter(ILogInDataSource logInDataSource) {
        return new LogInPresenter(logInDataSource);
    }

}
