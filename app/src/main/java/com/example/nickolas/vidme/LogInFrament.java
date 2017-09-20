package com.example.nickolas.vidme;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class LogInFrament extends Fragment {

    private static final String API_LOGIN_URL = "https://api.vid.me/auth/create",
                                API_OAUTH_CLIENTID = "kUQILZ7u1rWzCUKl7MTXbO0NCgIfUOy3",
                                API_OAUTH_CLIENTSECRET = "j6o54XLwcrqZsCrHFLXwKKZJRZQEXUYk1HlZiH6P";


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_log_in_frament, container, false);
    }
}
