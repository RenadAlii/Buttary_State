package com.example.buttarystate


import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buttarystate.databinding.ActivityMainBinding

var binding: ActivityMainBinding? = null

class MainActivity : AppCompatActivity() {
    // create object from the BroadcastReceiver.
    private var broadcastReceiver: BroadcastReceiver? = ButteryStatus()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //send charging state & Battery level.
        registerReceiver(broadcastReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }
}