package com.example.task1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TimeChangeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_TIME_CHANGED) {
            // handle time change event
            Toast.makeText(context, "Time changed", Toast.LENGTH_SHORT).show()
        }
    }
}