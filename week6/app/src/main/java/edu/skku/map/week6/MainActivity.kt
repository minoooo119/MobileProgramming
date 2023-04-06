package edu.skku.map.week6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object{
        const val EXT_NAME="name"  //안에 값은 크게 중요하지 않음
        const val EXT_AGE="222" //어차피 자동완성으로 만들어짐
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnNewActivity=findViewById<Button>(R.id.buttonNewActivity)

        btnNewActivity.setOnClickListener{
            //실습
            val editTextName=findViewById<EditText>(R.id.editTextTextName)
            val editTextAGe=findViewById<EditText>(R.id.editTextAge)
            val name=editTextName.text.toString()
            val age=editTextAGe.text.toString().toInt()
            /*Toast.makeText(
                    applicationContext,
            "Welcome, ${name}(${age})!",
            Toast.LENGTH_SHORT
            ).show()*/
            editTextName.text.clear()
            editTextAGe.text.clear()
            //intent시에는 첫인자로 context--> this로 해도됨
            // 두번째는 어떤 activity에 넣을것인가.
            val intent= Intent(this,NothingActivity::class.java).apply{
                //실습
                putExtra(EXT_NAME,name)
                putExtra(EXT_AGE,age)
                //원래는 intent.putExtra()로 해야되는데
                //apply를 이용하면 intent. 생략하고 아래처럼 할 수 있음
                //putExtra(EXT_NAME,"Lee")
                //putExtra(EXT_AGE,2019313416)
                /*
                putExtra("KEY1","VALUE1")
                putExtra("KEY2","VALUE")
                putExtra("...","...")
                key,value로 묶여서 저장 dictionary같은 느낌
                startActivity로 하면됨*/
            }
            //새로 열렸으면 전에 Activity가 어디있는가?
            //뒤로 가기 버튼을 누르면 전 Activity로 가진다.
            //stack 형태로 쌓이는 느낌임
            //남아있는거지 전 Activity가
            startActivity(intent)
            finish()

            //이제 값이 잘왔는지 확인해보자 --> Go NothingActivity
        }
    }
    override fun onDestroy() {
        finish()
        super.onDestroy()
        Log.i(localClassName,"onDestory")
    }
}