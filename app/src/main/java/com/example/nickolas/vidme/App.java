package com.example.nickolas.vidme;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nickolas on 20.09.2017.
 */

public class App extends Application {
    private static final String API_URL = "https://api.vid.me",
            API_OAUTH_CLIENTID = "kUQILZ7u1rWzCUKl7MTXbO0NCgIfUOy3",
            API_OAUTH_CLIENTSECRET = "j6o54XLwcrqZsCrHFLXwKKZJRZQEXUYk1HlZiH6P";

    private static VidmeApi vidmeApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder().baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        vidmeApi = retrofit.create(VidmeApi.class);
    }

    public static VidmeApi getVidmeApi() {
        return vidmeApi;
    }
}
