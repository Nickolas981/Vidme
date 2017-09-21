package com.example.nickolas.vidme;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Nickolas on 20.09.2017.
 */

public class Utils {
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) MainActivity.activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
