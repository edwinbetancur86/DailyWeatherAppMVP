package com.example.edwinb.agiletrailblazers.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtility {

    //private static Context context;
    private static NetworkInfo activeNetworkInfo;

    public NetworkUtility(Context con) {
        //context = con;
    }

    public static boolean hasActiveInternetConnection(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
           activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
