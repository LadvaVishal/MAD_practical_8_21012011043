package com.vishal.mad_practical_8_21012011043
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.card.MaterialCardView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val card=findViewById<MaterialCardView>(R.id.card_cancle)


        val alarmbutton=findViewById<Button>(R.id.clock)
        alarmbutton.setOnClickListener {
            //card.visibility=View.VISIBLE
            TimePickerDialog(this,{tp,hour,minute->setalarmtime(hour,minute)},Calendar.HOUR,Calendar.MINUTE,false).show()
        }

    }
    fun setalarmtime(hour: Int, Minute: Int){
        //card.visibility=View.GONE
        val alarmtime = Calendar.getInstance()
        val year = alarmtime.get(Calendar.YEAR)
        val month = alarmtime.get(Calendar.MONTH)
        val date = alarmtime.get(Calendar.DATE)
        val minute = alarmtime.get(Calendar.MINUTE)
        val hour = alarmtime.get(Calendar.HOUR)
        alarmtime.set(year,month,date,hour,minute)
        setalarm(alarmtime.timeInMillis,AlarmBroadcastReceiver.Alarmstart)
    }
    fun stop(){
        setalarm(-1,AlarmBroadcastReceiver.Alarmstop)
    }

    fun setalarm(millitime:Long,action: String){
        val intentalarm = Intent(applicationContext,AlarmBroadcastReceiver::class.java)
        intentalarm.putExtra(AlarmBroadcastReceiver.Alarmkey,action)
        val pendingIntent=PendingIntent.getBroadcast(applicationContext,4356,intentalarm,PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        if (action == AlarmBroadcastReceiver.Alarmstart){
            if(alarmManager.canScheduleExactAlarms())
                alarmManager.setExact(AlarmManager.RTC_WAKEUP,millitime,pendingIntent)
        }
        else if (action == AlarmBroadcastReceiver.Alarmstop){
            alarmManager.cancel(pendingIntent)
            sendBroadcast(intentalarm)
        }
    }

}