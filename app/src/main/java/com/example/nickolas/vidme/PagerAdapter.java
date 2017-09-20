package com.example.nickolas.vidme;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;


public class PagerAdapter extends FragmentStatePagerAdapter {


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FeaturedFragment tab1 = new FeaturedFragment();
                return tab1;
            case 1:
                NewFragment tab2 = new NewFragment();
                return tab2;
            case 2:
                FeedFragment tab3 = new FeedFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
