package com.example.task1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class NetworkchangeMode:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Check the network state and take appropriate action
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            // Network is available
            Toast.makeText(context, "Network available", Toast.LENGTH_SHORT).show()
        } else {
            // Network is unavailable
            Toast.makeText(context, "Network unavailable", Toast.LENGTH_SHORT).show()
        }
    }
}