package com.example.nickolas.vidme.views;


import com.example.nickolas.vidme.model.entities.Video;

import java.util.List;

public interface NewVideosView extends BaseView {

        void showVideos(List<Video> videos);

}
