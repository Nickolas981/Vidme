package com.example.nickolas.vidme.model.remote;

import com.example.nickolas.vidme.api.VidmeApi;

import okhttp3.ResponseBody;
import rx.Observable;

public class NewVideosDataSource implements INewVideosDataSource {

    private VidmeApi api;

    public NewVideosDataSource(VidmeApi api) {
        this.api = api;
    }

    @Override
    public Observable<ResponseBody> getVideos(int limit, int offset) {
        return api.newVideo(limit, offset);
    }
}
