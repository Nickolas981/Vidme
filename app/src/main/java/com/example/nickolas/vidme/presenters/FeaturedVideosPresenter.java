package com.example.nickolas.vidme.presenters;

import com.example.nickolas.vidme.model.remote.IFeaturedVideosDataSource;
import com.example.nickolas.vidme.views.FeaturedVideosView;

/**
 * Created by Nickolas on 21.09.2017.
 */

public class FeaturedVideosPresenter extends BasePresenter<FeaturedVideosView> {

    private final IFeaturedVideosDataSource featuredVideosDataSource;

    public FeaturedVideosPresenter(IFeaturedVideosDataSource featuredVideosDataSource) {
        this.featuredVideosDataSource = featuredVideosDataSource;
    }



}
