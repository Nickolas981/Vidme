package com.example.nickolas.vidme.di.component;

import com.example.nickolas.vidme.model.remote.IFeaturedVideosDataSource;

import retrofit2.Retrofit;

public interface ApiComponent {

    Retrofit retrofit();

    IFeaturedVideosDataSource featuredVideosDataSource();
    IFeaturedVideosDataSource newVideosDataSource();
    IFeaturedVideosDataSource feedVideosDataSource();

}
