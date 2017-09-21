package com.example.nickolas.vidme.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Nickolas on 21.09.2017.
 */

public class InternetConnectivityUtil {

    private static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }


    public static boolean isConnected(Context context) {
        NetworkInfo info = InternetConnectivityUtil.getNetworkInfo(context);
        return (info != null && info.isConnected());
    }

}
