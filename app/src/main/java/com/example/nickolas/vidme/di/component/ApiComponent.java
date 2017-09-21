package com.example.nickolas.vidme.di.component;

import com.example.nickolas.vidme.model.remote.IFeaturedVideosDataSource;

import retrofit2.Retrofit;

/**
 * Created by Nickolas on 21.09.2017.
 */

public interface ApiComponent {

    Retrofit retrofit();

    IFeaturedVideosDataSource featuredVideosDataSource();

}
