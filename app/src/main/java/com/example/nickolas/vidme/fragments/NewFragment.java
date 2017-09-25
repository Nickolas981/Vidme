package com.example.nickolas.vidme.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.nickolas.vidme.App;
import com.example.nickolas.vidme.R;
import com.example.nickolas.vidme.di.component.AppComponent;
import com.example.nickolas.vidme.di.component.DaggerPresentersComponent;
import com.example.nickolas.vidme.di.module.PresentersModule;
import com.example.nickolas.vidme.model.entities.Video;
import com.example.nickolas.vidme.presenters.NewVideosPresenter;
import com.example.nickolas.vidme.views.NewVideosView;
import com.example.nickolas.vidme.widgets.adapters.EndlessRecyclerViewScrollListener;
import com.example.nickolas.vidme.widgets.adapters.VideoListAdapter;
import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewFragment extends Fragment implements NewVideosView {

    @BindView(R.id.new_video_container)
    RecyclerView videoContainer;
    @BindView(R.id.swipe_refresh_new_videos)
    SwipyRefreshLayout swipyRefreshLayout;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    public VideoListAdapter videoListAdapter;
    public EndlessRecyclerViewScrollListener listener;

    @Inject
    NewVideosPresenter presenter;

    int limit, offset;

    public static NewFragment newInstance() {
        return new NewFragment();
    }

    public AppComponent getAppComponent() {
        return ((App) getActivity().getApplication()).appComponent();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerPresentersComponent.builder()
                .appComponent(getAppComponent())
                .presentersModule(new PresentersModule())
                .build()
                .inject(this);
        limit = 10;
        offset = 0;
        presenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new, container, false);
        ButterKnife.bind(this, v);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        videoContainer.setLayoutManager(linearLayoutManager);

        videoListAdapter = new VideoListAdapter(v.getContext());
        videoContainer = (RecyclerView) v.findViewById(R.id.new_video_container);


        listener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                offset += limit;
                presenter.getVideos(limit, offset);
            }
        };
        videoContainer.setOnScrollListener(listener);

        videoContainer.setAdapter(videoListAdapter);

        startLoad();
        presenter.getVideos(limit, offset);
        return v;
    }


    public void startLoad() {
        swipyRefreshLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    public void finishLoad() {
        swipyRefreshLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        swipyRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showVideos(List<Video> videos) {
        videoListAdapter.addVideos(videos);
        videoListAdapter.notifyDataSetChanged();
        finishLoad();
    }
}
