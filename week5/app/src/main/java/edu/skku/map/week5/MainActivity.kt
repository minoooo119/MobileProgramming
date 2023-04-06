package edu.skku.map.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ChatRoom class에 있는 것들을 ArrayList로 만듬
        // adapter에 넘겨줄 data들 items에 넣어주자.
        val items=ArrayList<ChatRoom>()
        items.add(ChatRoom("Kakao T", "Please leave review.", R.drawable.ic_launcher_background, 1, "8:24 p.m.", 1))
        items.add(ChatRoom("SKKU Software", "Anybody taking MAP lecture? This week lab session is too hard. Can anybody give me the hint? I will be very happy if you help. If nobody help me, I will be very sad.", R.drawable.ic_launcher_background, 512, "7:15 p.m.", 128))
        items.add(ChatRoom("Brother", "Hey.", R.drawable.ic_launcher_background, 1, "4:21 p.m.", 12))
        items.add(ChatRoom("Family", "Emoji", R.drawable.ic_launcher_background, 4, "4:05 p.m.", 5))
        items.add(ChatRoom("Study group", "See you tomorrow!", R.drawable.ic_launcher_background, 5, "4:01 p.m.", 2))
        items.add(ChatRoom("Yogiyo", "How was the food?", R.drawable.ic_launcher_background, 1, "3:24 p.m.", 1))
        items.add(ChatRoom("lorem ipsum", "dolor", R.drawable.ic_launcher_background, 6, "2:22 p.m.", 123))
        items.add(ChatRoom("Placeholder", "Placeholder", R.drawable.ic_launcher_background, 12, "11:58 a.m.", 5))

        val myAdapter=ChatRoomAdapter(items,applicationContext)
        //myAapter에서 item값, context 가져가서 view 구성해준다

        val listView=findViewById<ListView>(R.id.listViewChatRoom)
        listView.adapter=myAdapter
        //adapter는 데이터를 관리하고 AdapterView에 연결해주는 역할
        //구성된 view를 adapter를 통해서 전달 --> ListView에 올려주기 (listView adpater에 myadapter 넣어주기)
        //myadapter객체를 listview에 연결, 데이터들을 list에 올려준다.


    }
}