package edu.skku.map.week4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

//생성자에서 data를 가져오게 함 arraylist
class CustomAdapter(val data:ArrayList<restaurant>,val context: Context):BaseAdapter(){
    //안드로이드에서 제공하는 content대로해야함
    override fun getCount(): Int {
        //count를 반환하는 함수 (몇개의 아이템이 있는가)
        //개수에 맞게 알아서 반복문을 돈다
        return data.size
    }

    override fun getItem(p0: Int): Any {
        //p0번째 item 반환
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        //id값 반환
        return 0//따로 지정한게 없기때문에
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //p0번째 item에 대한거를 만들어서 return 을 해라
        val layoutInflater: LayoutInflater =
            context.getSystemService( //main에서 가능함 activity이므로 그러나
                //adapter는 activity가 아니므로 쓸수가 없음
                //그래서 생성자를 통해 받아와야함
                Context.LAYOUT_INFLATER_SERVICE
            )as LayoutInflater

        val view=layoutInflater.inflate(R.layout.restaurant_item,null,true)
        //view 하나 만드는거 성공함
        //p0번째 데이터를 연결해줘야함
        //가지고 와서 이름 이미지를 넣어줘야함
        //어디서 찾는지 모르니까 위에 view에서 찾는다 라는 의미로 view.findViewById를 해줌
        val imageView=view.findViewById<ImageView>(R.id.restaurantImageView)
        val textView=view.findViewById<TextView>(R.id.restaurantTextView)
        imageView.setImageResource(data[p0].imgId)
        textView.text=data[p0].name

        return view
    }
}