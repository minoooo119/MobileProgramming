package edu.skku.map.week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class LastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        val name=intent.getStringExtra(MainActivity.EXT_NAME)
        //val name=getIntent().getStringArrayExtra(MainActivity.EXT_NAME) 이렇게 해도됨
        val age=intent.getIntExtra(MainActivity.EXT_AGE,-1)

        Toast.makeText(
            applicationContext,
            "Welcome, ${name}(${age})!",
            Toast.LENGTH_SHORT
        ).show()
    }
}