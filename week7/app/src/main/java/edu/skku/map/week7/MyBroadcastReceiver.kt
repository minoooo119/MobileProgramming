package edu.skku.map.week7

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        //context에 p1.intent 정보를 짧게 출력해줌
        //시스템 언어가 바뀔때 onReceiver가 호출되어서 toast를 띄어줌--> 설치만 되면 toast가 뜸
        Toast.makeText(p0, p1.toString(), Toast.LENGTH_LONG).show()
    }
}