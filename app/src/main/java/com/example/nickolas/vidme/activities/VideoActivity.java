package com.example.nickolas.vidme.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.example.nickolas.vidme.R;
import com.r0adkll.slidr.Slidr;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Slidr.attach(this);
    }
}
