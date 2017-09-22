package com.example.nickolas.vidme.widgets.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nickolas.vidme.R;
import com.example.nickolas.vidme.model.entities.Video;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder>  {

    private List<Video> videos;

    public VideoListAdapter(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_preview, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder  holder, int position) {
        holder.videoCountLikes.setText(videos.get(position).getLikesCount());
        holder.videoTitle.setText(videos.get(position).getTitle());
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
