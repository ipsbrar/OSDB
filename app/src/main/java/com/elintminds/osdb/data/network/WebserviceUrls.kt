package com.elintminds.osdb.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object WebserviceUrls {
    // Apis base urls
    internal val GOOGEL_PLACES = "https://maps.googleapis.com/maps/api/place/"

    internal val BASE_URL = "http://introducem.elintminds.work/api/"


    fun isInternetIsAvailable(mContext: Context): Boolean {
        val connectivity = mContext
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivity.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            return true
        }
        return false
    }
}
