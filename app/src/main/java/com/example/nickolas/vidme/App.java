package com.example.nickolas.vidme;

import android.app.Application;

import com.example.nickolas.vidme.model.entities.User;


public class App extends Application {


//    private static VidmeApi vidmeApi;
//    private Retrofit retrofit;

    public static User user;

    @Override
    public void onCreate() {
        super.onCreate();
//        retrofit = new Retrofit.Builder().baseUrl(API_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .build();
//
//        vidmeApi = retrofit.create(VidmeApi.class);
    }

//    public static VidmeApi getVidmeApi() {
//        return vidmeApi;
//    }
}
