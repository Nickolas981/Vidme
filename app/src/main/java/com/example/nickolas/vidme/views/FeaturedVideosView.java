package com.example.nickolas.vidme.views;

import com.example.nickolas.vidme.model.entities.Video;

import java.util.List;

/**
 * Created by Nickolas on 21.09.2017.
 */

public interface FeaturedVideosView extends BaseView {

    void showVideos(List<Video> videos);

}
