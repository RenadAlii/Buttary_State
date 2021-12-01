package com.example.buttarystate

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager

class ButteryStatus : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        // set the Battary status in the textView
        binding?.textOFBattarystatus?.text = displayBatteryChargingStatus(intent)
    }


    // fun to check if the device is charging
    fun displayBatteryChargingStatus(intent: Intent): String {

        val status: Int = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        return if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
            "Charging"
        } else {
            // if the device not charging the battery Level
            displaybatteryLevel(intent)
        }
    }


    // fun return Low Buttery if Buttery less than 20 else return normal Buttery
    fun displaybatteryLevel(intent: Intent): String {
        if (intent.action == "android.intent.action.BATTERY_CHANGED") {
            return when (intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)) {
                in 20 downTo 0 -> " Low Buttery"
                else -> " Normal Buttery"
            }
        }
        return "Normal Buttery"
    }

}
