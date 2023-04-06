package edu.skku.MAP.Week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter=0;
        val text_view =findViewById<TextView>(R.id.textView)
        val imageview =findViewById<ImageView>(R.id.imageView)
        val left_btn=findViewById<Button>(R.id.button)
        val right_btn=findViewById<Button>(R.id.button2)


            text_view.text="pizza"
            imageview.setImageResource(R.drawable.pizza)
            right_btn.setOnClickListener{
                if(counter==0){
                    text_view.text="chicken"
                    imageview.setImageResource(R.drawable.chicken)
                    counter++
                }
                else if(counter==1){
                    text_view.text="hamburger"
                    imageview.setImageResource(R.drawable.hamburger)
                    counter++
                }
                else if(counter==2){
                    text_view.text="ramen"
                    imageview.setImageResource(R.drawable.ramen)
                    counter++
                }
                else{
                    Toast.makeText(applicationContext,"Last Image",Toast.LENGTH_LONG).show()
                }
            }
        left_btn.setOnClickListener {
                if(counter==0){
                    Toast.makeText(applicationContext,"First Image",Toast.LENGTH_LONG).show()
            }
            else if(counter==1){
                    text_view.text="pizza"
                    imageview.setImageResource(R.drawable.pizza)
                    counter--
            }
            else if(counter==2){
                    text_view.text="chicken"
                    imageview.setImageResource(R.drawable.chicken)
                    counter--
                }
            else if(counter==3){
                    text_view.text="hamburger"
                    imageview.setImageResource(R.drawable.hamburger)
                    counter--
                }

            }



    }
}