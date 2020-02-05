package kc.ac.kpu.foruser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
private const val COUNT_KEY = "com.example.key.count"

class MainActivity : AppCompatActivity() {

    var result: TextView? = null
    val database: FirebaseDatabase? = null
    val databaseReference: DatabaseReference? = null
    val client : GoogleApiClient? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wow.setOnClickListener{
            val nextIntent = Intent(this, ProfileActivity::class.java)
            startActivity(nextIntent)
        }

        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = database.getReference("message/text1")
        var tv = findViewById(R.id.examtext) as TextView
        //var string : String ? =null


        if (client != null) {
            if(client.isConnected==false){
                client.connect()


myRef.addValueEventListener(object : ValueEventListener {
    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onDataChange(dataSnapshot: DataSnapshot) {

        val option = dataSnapshot.exists()
        if (option == true) {
            val value = dataSnapshot.children.elementAt(0).value

            tv.text = "$value"
            //나중에 저장해서 워치로 보내려면 임시로 저장해야함
            //   string = tv.text as String?

        } else {
            tv.text = "메세지 전송 중입니다."
        }
/*
                val value = dataSnapshot?.value
                tv.text = "$value"


 */

    }


})
}
}