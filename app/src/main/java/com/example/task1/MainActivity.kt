package com.example.task1

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.hardware.camera2.CameraManager
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private var bluetoothReceiver: BluetoothMode?=null
    private var filter: IntentFilter?=null

    private var timeChangeReceiver:TimeChangeReceiver?=null


    private var binding: ActivityMainBinding?=null
    lateinit var receiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        receiver= TimeChangeReceiver()
        IntentFilter(Intent.ACTION_TIME_CHANGED).also {
            registerReceiver(receiver, it)
        }


        bluetoothReceiver = BluetoothMode()
        filter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)



        receiver=AirplaneMode()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }


        filter?.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(NetworkchangeMode(), filter)


    }

    override fun onResume() {
        super.onResume()
        registerReceiver(bluetoothReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(bluetoothReceiver)
}

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}