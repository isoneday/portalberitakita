package com.workshop.aplikasiportalberita.portalberita.util;

import android.content.Context;
import android.net.ConnectivityManager;

import com.workshop.aplikasiportalberita.portalberita.MyTimesApplication;


public class UtilityMethods {
    /**
     * Method to detect network connection on the device
     */
    public static boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) MyTimesApplication.getMyTimesApplicationInstance()
                        .getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
