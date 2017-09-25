package com.example.nickolas.vidme.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.nickolas.vidme.App;
import com.example.nickolas.vidme.R;
import com.example.nickolas.vidme.model.entities.User;
import com.example.nickolas.vidme.utils.InternetConnectivityUtil;
import com.example.nickolas.vidme.widgets.adapters.PagerAdapter;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    public static Activity activity;
    public static PagerAdapter adapter;
    public static ViewPager viewPager;

    public static ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String user = sharedPreferences.getString("user", null);
        App.user = user != null ? new Gson().fromJson(user, User.class) : null;

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Featured"));
        tabLayout.addTab(tabLayout.newTab().setText("New"));
        tabLayout.addTab(tabLayout.newTab().setText("Feed"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        imageButton = (ImageButton) findViewById(R.id.log_out_button);
        imageButton.setVisibility(App.user == null ? View.GONE : View.VISIBLE);


        ImageButton imageButton = (ImageButton) findViewById(R.id.log_out_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new PagerAdapter
                (getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        if (!InternetConnectivityUtil.isConnected(this))
            Toast.makeText(activity, "No Internet connection", Toast.LENGTH_SHORT).show();
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.log_out);

        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        App.user = null;
                        adapter.notifyDataSetChanged();
                        imageButton.setVisibility(View.GONE);
                        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                        sharedPreferences.edit().clear().apply();
                        return true;
                    }
                });
        popupMenu.show();
    }
}
