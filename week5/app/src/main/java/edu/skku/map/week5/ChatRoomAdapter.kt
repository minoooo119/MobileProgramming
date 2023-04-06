package edu.skku.map.week5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

//데이터를 받아오고 Context(inflater를 이용하기 위해서)를 받아옴
class ChatRoomAdapter (val data: ArrayList<ChatRoom>,val context: Context):BaseAdapter(){
    //아래들 다 구현해줘야함
    override fun getCount(): Int {
        //data size 리턴
        //몇개가 있는지 리턴, item의 개수 반환
        return data.size
    }

    override fun getItem(p0: Int): Any {
        //p0번째 item 반환
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        //id는 그냥 0리턴해줌
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //이제 inflater 이용시작 보여줄 view들을 위한 getView 구현
        val inflater=
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        //새로운 layout즉 xml파일 보여주고 싶을때 LayoutInflater가 일한다.
        //xml을 View로 바꿔줌 즉--> xml과 inflater를 이용해서 View를 만들어준다.
        //아래 만들어진 View를 generatedView에 넣는다.

        val generatedView =
            inflater.inflate(R.layout.item_chatroom, null)
        //위에꺼를 inflater 해달라고 요청함 (item_chatroom의 layout을 가져옴)
        //xml파일은 inflation하면 view gropu으로 만들어줌.
        //그 view group을 돌면서 차례로 띄어주는게 adapter


        //view들을 generatedView에서 가져옴
        val textViewName = generatedView.findViewById<TextView>(R.id.textViewRoomName)
        val textViewChat = generatedView.findViewById<TextView>(R.id.textViewRecentChat)
        val textViewGroupNumber = generatedView.findViewById<TextView>(R.id.textViewGroupSize)
        val textViewTime = generatedView.findViewById<TextView>(R.id.textViewLastTime)
        val imageViewThumbnail = generatedView.findViewById<ImageView>(R.id.imageViewProfile)
        val textViewRed=generatedView.findViewById<TextView>(R.id.red)

        //p0번째의 data class의 변수에 알맞게 넣어준다.

        textViewName.text = data[p0].name
        textViewChat.text = data[p0].lastChat
        textViewTime.text = data[p0].lastTime
        if(data[p0].groupNumber==1){//만약에 grupNumber가 1로 보여지면 text를 띄우지 않는다.
            textViewGroupNumber.text=""
        }
        else{
            textViewGroupNumber.text = "" + data[p0].groupNumber
        }
        //groupNumber는 int이므로 casting해준것임 위처럼 해주면 알아서 string으로 바꿔줌
        imageViewThumbnail.setImageResource(data[p0].thumbnail)
        textViewRed.text=""+data[p0].red

        return generatedView
        //view 리턴
        //이제 메인에서 adapter 이용해서 list 띄어주면 됨

    }

}