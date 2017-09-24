package com.example.nickolas.vidme.widgets.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nickolas.vidme.App;
import com.example.nickolas.vidme.R;
import com.example.nickolas.vidme.fragments.FeaturedFragment;
import com.example.nickolas.vidme.fragments.FeedFragment;
import com.example.nickolas.vidme.fragments.LogInFragment;
import com.example.nickolas.vidme.fragments.NewFragment;


public class PagerAdapter extends FragmentStatePagerAdapter {


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FeaturedFragment.newInstance();
            case 1:
                return NewFragment.newInstance();
            case 2:
                return App.user == null ? LogInFragment.newInstance() : FeedFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getItemPosition(Object object) {
       return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_preview, parent, false);
            ViewHolder viewHolder = new ViewHolder(v);

            viewHolder.title = (TextView) v.findViewById(R.id.video_title);
            viewHolder.likes = (TextView) v.findViewById(R.id.video_likes_count);

            viewHolder.thumbnail = (ImageView) v.findViewById(R.id.thumbnail);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        protected static class ViewHolder extends RecyclerView.ViewHolder {
            TextView title, likes;
            ImageView thumbnail;
            View item;

            public ViewHolder(View itemView) {
                super(itemView);
                item = itemView;
            }

        }
    }
}
