package com.example.nickolas.vidme.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.nickolas.vidme.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class VideoActivity extends AppCompatActivity {

    private String videoPath = "http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8";

    SimpleExoPlayerView videoView;

    SimpleExoPlayer player;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = (SimpleExoPlayerView) findViewById(R.id.videoView);
        Intent intent = getIntent();

        videoPath = intent.getStringExtra("url");

//        progressDialog = ProgressDialog.show(VideoActivity.this, "", "Buffering video...", true);
//        progressDialog.setCancelable(true);
        playVideo();

//        PlayVideo();

    }
//    private void PlayVideo()
//    {
//        try
//        {
//            getWindow().setFormat(PixelFormat.TRANSLUCENT);
//            MediaController mediaController = new MediaController(VideoActivity.this);
//            mediaController.setAnchorView(videoView);
//
//            Uri video = Uri.parse(videoPath );
//            videoView.setMediaController(mediaController);
//            videoView.setVideoURI(video);
//            videoView.requestFocus();
//            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
//            {
//                public void onPrepared(MediaPlayer mp)
//                {
//                    progressDialog.dismiss();
//                    videoView.start();
//                }
//            });
//        }
//        catch(Exception e)
//        {
//            progressDialog.dismiss();
//            System.out.println("Video Play Error :"+e.toString());
//            finish();
//        }
//
//    }

    void playVideo() {
        Handler mainHandler = new Handler();
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector =
                new DefaultTrackSelector(videoTrackSelectionFactory);

        player =
                ExoPlayerFactory.newSimpleInstance(this, trackSelector);

        videoView.setPlayer(player);


        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "Vidme"));
        HlsDataSourceFactory hlsDataSourceFactory = new DefaultHlsDataSourceFactory(dataSourceFactory);
        Handler handler = new Handler();
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource videoSource = new HlsMediaSource(Uri.parse(videoPath), hlsDataSourceFactory
                , 1, null, null);
        player.prepare(videoSource);
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.stop();
    }
}
//    private VideoView videoView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_video);
//        Slidr.attach(this);
//        videoView = (VideoView) findViewById(R.id.videoView);
//
//        Intent intent = getIntent();
//
////        MediaSource dashSource = new DashSource(context, uri, new SimpleRateBasedAdaptationLogic());
////        videoView.setVideoURI(Uri.parse("http://www.androidbegin.com/tutorial/AndroidCommercial.3gp"));
//        videoView.setVideoURI(Uri.parse("http://24x7dash-i.akamaihd.net/dash/live/900080/elemental/dash.mpd"));
//        videoView.requestFocus();
//        videoView.start();
//
////        videoView.setVideoURI(Uri.parse(intent.getStringExtra("url")));
////        videoView.start();
////        videoView.setOnPreparedListener(new OnPreparedListener() {
////            @Override
////            public void onPrepared() {
////                videoView.start();
////            }
////        });
//
//
//    }
//

