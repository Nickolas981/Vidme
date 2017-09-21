package com.example.nickolas.vidme.model.remote;

import com.example.nickolas.vidme.api.VidmeApi;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by Nickolas on 21.09.2017.
 */

public class FeaturedVideosDataSource implements IFeaturedVideosDataSource {

    private VidmeApi api;

    public FeaturedVideosDataSource(VidmeApi api) {
        this.api = api;
    }

    @Override
    public Observable<ResponseBody> getVideos(int limit, int offset) {
        return api.featuredVideo(limit, offset);
    }

}
