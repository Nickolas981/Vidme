package com.example.nickolas.vidme.model.remote;

import com.example.nickolas.vidme.api.VidmeApi;

import okhttp3.ResponseBody;
import rx.Observable;

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
