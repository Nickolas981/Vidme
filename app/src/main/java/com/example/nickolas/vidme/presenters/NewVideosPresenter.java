package com.example.nickolas.vidme.presenters;

import com.example.nickolas.vidme.model.entities.Video;
import com.example.nickolas.vidme.model.remote.INewVideosDataSource;
import com.example.nickolas.vidme.utils.rx.RxErrorAction;
import com.example.nickolas.vidme.utils.rx.RxRetryWithDelay;
import com.example.nickolas.vidme.views.NewVideosView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class NewVideosPresenter extends BasePresenter<NewVideosView> {

    private final INewVideosDataSource newVideoDataSource;

    public NewVideosPresenter(INewVideosDataSource newVideoDataSource) {

        this.newVideoDataSource = newVideoDataSource;
    }

    public void getVideos(int limit, int offset) {
        subscribe(newVideoDataSource.getVideos(limit, offset)
                .retryWhen(new RxRetryWithDelay())
                .map(responseBody -> {
                    String res = null;
                    List<Video> videos = null;
                    try {
                        res = responseBody.string();
                        JsonParser parser = new JsonParser();
                        JsonObject r = parser.parse(res).getAsJsonObject();
                        Type listType = new TypeToken<List<Video>>() {}.getType();
                        videos = new Gson().fromJson((JsonElement) r.get("videos"),listType);
                    } catch (IOException  e) {
                        e.printStackTrace();
                    }

                    return videos;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getView()::showVideos, new RxErrorAction(getView().getContext()))
        );

    }
}
