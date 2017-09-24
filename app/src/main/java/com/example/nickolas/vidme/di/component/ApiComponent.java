package com.example.nickolas.vidme.di.component;

import com.example.nickolas.vidme.model.remote.IFeaturedVideosDataSource;
import com.example.nickolas.vidme.model.remote.IFeedVideosDataSource;
import com.example.nickolas.vidme.model.remote.ILogInDataSource;
import com.example.nickolas.vidme.model.remote.INewVideosDataSource;

import retrofit2.Retrofit;

public interface ApiComponent {

    Retrofit retrofit();

    IFeaturedVideosDataSource featuredVideosDataSource();

    INewVideosDataSource newVideosDataSource();

    IFeedVideosDataSource feedVideosDataSource();

    ILogInDataSource logInDataSource();

}
