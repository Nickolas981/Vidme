package com.example.nickolas.vidme;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nickolas on 20.09.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {



    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_preview, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        viewHolder.title = (TextView) v.findViewById(R.id.video_title);
        viewHolder.likes = (TextView) v.findViewById(R.id.video_likes_count);

        viewHolder.thumbnail = (ImageView) v.findViewById(R.id.thumbnail);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder  {
        TextView title, likes;
        ImageView thumbnail;
        View item;

        public ViewHolder(View itemView) {
            super(itemView);
            item = itemView;
        }

    }
}

