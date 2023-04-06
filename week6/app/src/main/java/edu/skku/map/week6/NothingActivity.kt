package edu.skku.map.week6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class NothingActivity : AppCompatActivity() {
    companion object{
        const val EXT_NAME="name"  //안에 값은 크게 중요하지 않음
        const val EXT_AGE="222" //어차피 자동완성으로 만들어짐
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nothing)
        //아래처럼 해서 현재 intent로 전달된 값을 name에 받아옴
        //실제론 getIntent()로 쓰이는거임
        val btnYes=findViewById<Button>(R.id.button)
        val btnNo=findViewById<Button>(R.id.button2)
        val name=intent.getStringExtra(MainActivity.EXT_NAME)
        //val name=getIntent().getStringArrayExtra(MainActivity.EXT_NAME) 이렇게 해도됨
        val age=intent.getIntExtra(MainActivity.EXT_AGE,-1)
        val nameageView=findViewById<TextView>(R.id.nameage)
        nameageView.text="You typed name "+name+" and age "+age.toString()+", is that right?"

        btnYes.setOnClickListener{
            val intent1= Intent(this,LastActivity::class.java).apply{
                putExtra(EXT_NAME,name)
                putExtra(EXT_AGE,age)
            }
            startActivity(intent1)
        }
        //다시 원래대로
        val intent2= Intent(this,MainActivity::class.java).apply{
        }
        btnNo.setOnClickListener{
            startActivity(intent2)
            finish()
        }

    }

    override fun onDestroy() {

        super.onDestroy()
        Log.i(localClassName,"onDestory")
    }
}