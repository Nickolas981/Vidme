package com.example.nickolas.vidme.presenters;

import com.example.nickolas.vidme.model.entities.Video;
import com.example.nickolas.vidme.model.remote.FeedVideosDataSource;
import com.example.nickolas.vidme.model.remote.IFeedVideosDataSource;
import com.example.nickolas.vidme.utils.rx.RxRetryWithDelay;
import com.example.nickolas.vidme.views.FeedVideosView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class FeedVideosPresenter extends BasePresenter<FeedVideosView> {

    private final IFeedVideosDataSource feedVideoDataSource;

    public FeedVideosPresenter(IFeedVideosDataSource feedVideoDataSource) {
        this.feedVideoDataSource = feedVideoDataSource;
    }

    public void getVideos(int limit, int offset) {
        subscribe(feedVideoDataSource.getVideos(limit, offset)
                .retryWhen(new RxRetryWithDelay())
                .map(responseBody -> {
                    String res = null;
                    List<Video> videos = null;
                    try {
                        res = responseBody.string();
                        JSONObject r = new JSONObject(res);
//                        JSONArray ra = r.getJSONArray("videos");
                        JsonElement array = (JsonElement) r.get("videos");
                        Type listType = new TypeToken<List<String>>() {
                        }.getType();
                        videos = new Gson().fromJson(array, listType);
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }

                    return videos;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getView());

    }
}
