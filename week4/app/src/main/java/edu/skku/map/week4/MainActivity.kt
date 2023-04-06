package edu.skku.map.week4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {//onCreate 밖에 있으면 안됨
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val showButton =findViewById<Button>(R.id.showButton)
        showButton.setOnClickListener{
            val layoutInflater: LayoutInflater =
                applicationContext.getSystemService(//context를 불러오는 과정
                    Context.LAYOUT_INFLATER_SERVICE
                )as LayoutInflater
            //inflate를 통해 xml파일을 가져와서 코드를 파싱해서 디자인에 띄어줌(이미지로)
            //즉 그려주는것이 inflate

            //여기서는 showbutton을 누르면 inflate가 호출됨
            // 그러면 sub_layout들의 코드들이 inflation되어서 activity에 추가되고 화면에 띄어줌


            val container=findViewById<LinearLayout>(R.id.container)
            //--------------------------------------------------
            layoutInflater.inflate( //inflate 해준다 sublayout를
                R.layout.sub_layout,container,true)
            val leftImageView=findViewById<ImageView>(R.id.leftImageView)
            val rightImageView=findViewById<ImageView>(R.id.rightImageView)

            leftImageView.setImageResource(R.drawable.bbq)
            //이미지 값은 타입이 int
            //text값은 string
            rightImageView.setImageResource(R.drawable.bhc)
            //--------------------------------------------------

        }
        val pizzaButton=findViewById<Button>(R.id.pizzaButton)
        pizzaButton.setOnClickListener{
            val pizzaData=ArrayList<restaurant>()
            pizzaData.add(restaurant(R.drawable.domino,"domino pizza"))
            pizzaData.add(restaurant(R.drawable.pizzanarachickengongju,"pizza nara chicken gongju"))
            pizzaData.add(restaurant(R.drawable.pizzahut,"pizza hut"))
            val myAdapter=CustomAdapter(pizzaData,applicationContext)

            val listView=findViewById<ListView>(R.id.restaurantview)
            listView.adapter=myAdapter //실제로는 listView.setAdapter(myAdapter)로 동작함
            //adapter 설정해줌
        }
        val hamburgerButton=findViewById<Button>(R.id.hanburgerButton)
        hamburgerButton.setOnClickListener{
            val pizzaData=ArrayList<restaurant>()
            pizzaData.add(restaurant(R.drawable.mcdonalds,"mcdonalds"))
            pizzaData.add(restaurant(R.drawable.momstouch,"momstouch"))
            pizzaData.add(restaurant(R.drawable.lotteria,"lotteria"))
            pizzaData.add(restaurant(R.drawable.burgerking,"burgerking"))
            val myAdapter=CustomAdapter(pizzaData,applicationContext)

            val listView=findViewById<ListView>(R.id.restaurantview)
            listView.adapter=myAdapter //실제로는 listView.setAdapter(myAdapter)로 동작함
            //adapter 설정해줌
        }
        val chickenButton=findViewById<Button>(R.id.chickenButton)
        chickenButton.setOnClickListener{
            val pizzaData=ArrayList<restaurant>()
            pizzaData.add(restaurant(R.drawable.bbq,"bbq"))
            pizzaData.add(restaurant(R.drawable.pizzanarachickengongju,"pizza nara chicken gongju"))
            pizzaData.add(restaurant(R.drawable.bhc,"bhc"))
            pizzaData.add(restaurant(R.drawable.goobne,"goobne"))
            val myAdapter=CustomAdapter(pizzaData,applicationContext)

            val listView=findViewById<ListView>(R.id.restaurantview)
            listView.adapter=myAdapter //실제로는 listView.setAdapter(myAdapter)로 동작함
            //adapter 설정해줌
        }
    }
}