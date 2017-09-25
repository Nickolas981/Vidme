package com.example.nickolas.vidme.widgets.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nickolas.vidme.R;
import com.example.nickolas.vidme.activities.MainActivity;
import com.example.nickolas.vidme.activities.VideoActivity;
import com.example.nickolas.vidme.model.entities.Video;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {

    private List<Video> videos;
    private Context context;


    public VideoListAdapter(Context context) {
        this.context = context;
        videos = new ArrayList<>();

    }

    public void addVideos(List<Video> videos) {
        if (videos != null) this.videos.addAll(videos);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_preview, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.videoCountLikes.setText(Integer.toString(videos.get(position).getLikesCount()));
        holder.videoTitle.setText(videos.get(position).getTitle());

        Glide.with(context).load(videos.get(position).getThumbnailUrl()).into(holder.videoThumbnail);

        holder.videoThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.activity, VideoActivity.class);
                intent.putExtra("url", videos.get(position).getUrl());
                MainActivity.activity.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return videos.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.video_title)
        TextView videoTitle;
        @BindView(R.id.video_likes_count)
        TextView videoCountLikes;
        @BindView(R.id.thumbnail)
        ImageView videoThumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
