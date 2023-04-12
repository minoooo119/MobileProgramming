package edu.skku.map.week7

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    companion object{
        const val EXT_TIME="name"  //안에 값은 크게 중요하지 않음
        const val EXT_DESC="222" //어차피 자동완성으로 만들어짐
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val TAG:String = "로그"

        val btnStart = findViewById<Button>(R.id.button)
        btnStart.setOnClickListener {
            /*val urlEditText = findViewById<EditText>(R.id.editTextTime)
            val uri = Uri.parse("https://" + urlEditText.text.toString())
            val webIntent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(webIntent)*/
            val EditTime=findViewById<EditText>(R.id.editTextTime)
            val EditDesc=findViewById<EditText>(R.id.editTextDesc)
            val time=EditTime.text.toString()
            val desc=EditDesc.text.toString()
            Log.d(TAG, "MainActivity - onCreate() called")
            val intent_tosecond=Intent(this,secondActivity::class.java).apply {
                putExtra(EXT_TIME,time)
                putExtra(EXT_DESC,desc)
                Log.d(TAG, "MainActivity - onCreate() called in intent")
            }
            startActivity(intent_tosecond)



        }
    }

    override fun onResume() {
        super.onResume()
        val EditTime=findViewById<EditText>(R.id.editTextTime)
        val EditDesc=findViewById<EditText>(R.id.editTextDesc)
        EditTime.text.clear()
        EditDesc.text.clear()


    }
}