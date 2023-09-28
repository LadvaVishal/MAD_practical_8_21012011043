package com.vishal.mad_practical_8_21012011043
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if(intent != null){

            val data = intent.getStringExtra(Alarmkey)
            if (data!=null)
            {
                val intentservices = (Intent(context,AlarmService::class.java))
                if (data== Alarmstart) {
                    context.startService(intentservices)
                }
                else{
                    context.stopService(intentservices)
                }

            }
        }
    }
    companion object{
        val Alarmkey="alarm"
        val Alarmstart="start"
        val Alarmstop="stop"
    }
}