package edu.skku.map.week7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.widget.Button
import android.widget.TextView

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val TAG:String = "로그"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val time=intent.getStringExtra("time")
        val hour=time.toString().split(":")[0].toInt()
        val minute=time.toString().split(":")[1].toInt()
        val desc=intent.getStringExtra("desc")
        val textview=findViewById<TextView>(R.id.textViewcheck)
        textview.text="Do you want to set alram on time "+time+" with description '"+desc+"' ?"
        val ok=findViewById<Button>(R.id.okbtn)
        val canc=findViewById<Button>(R.id.canBtn)

        ok.setOnClickListener{
            val alramintent= Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE,desc.toString())
                putExtra(AlarmClock.EXTRA_HOUR,hour)
                putExtra(AlarmClock.EXTRA_MINUTES,minute)
            }

            if (alramintent.resolveActivity(packageManager) != null) {
                Log.d(TAG, "secondActivity - onCreate() called")
                startActivity(alramintent)
                this.finish()
            }

        }


        canc.setOnClickListener{
            this.finish()
        }





    }
}