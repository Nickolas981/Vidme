package com.example.nickolas.vidme.model.remote;

import okhttp3.ResponseBody;
import rx.Observable;



public interface IFeedVideosDataSource {

    Observable<ResponseBody> getVideos(int limit, int offset, String token);

}
