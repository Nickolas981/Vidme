package com.example.nickolas.vidme.model.remote;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by Nickolas on 21.09.2017.
 */

public interface IFeaturedVideosDataSource {

    Observable<ResponseBody> getVideos(int limit, int offset);

}
