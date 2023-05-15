package com.example.task1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class AirplaneMode:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val AirplaneModeEnabled=intent?.getBooleanExtra("state",false)?:return
        if (AirplaneModeEnabled){
            Toast.makeText(context,"Airplane Mode Enabled",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context,"Airplane Mode Disabled",Toast.LENGTH_LONG).show()
        }
    }
}