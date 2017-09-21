package com.example.nickolas.vidme.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nickolas.vidme.R;
import com.example.nickolas.vidme.model.entities.Video;
import com.example.nickolas.vidme.views.FeaturedVideosView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FeaturedFragment extends Fragment implements FeaturedVideosView {

    @BindView(R.id.featured_video_container)
    RecyclerView videoContainer;

    public static FeaturedFragment newInstance() {
        return new FeaturedFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_featured, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void showVideos(List<Video> videos) {

    }

}
