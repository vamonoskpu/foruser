package kc.ac.kpu.foruser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.io.FileInputStream
import java.io.FileOutputStream
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    var result: TextView? = null
    val database: FirebaseDatabase? = null
    val databaseReference: DatabaseReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wow.setOnClickListener{
            val nextIntent = Intent(this, ProfileActivity::class.java)
            startActivity(nextIntent)
        }

        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
val myRef : DatabaseReference = database.getReference("message/text1")
// var tv = findViewById(R.id.examtext) as TextView

myRef.addValueEventListener(object : ValueEventListener {
    override fun onCancelled(p0: DatabaseError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onDataChange(dataSnapshot: DataSnapshot) {
/*
                val value = dataSnapshot?.value
                tv.text = "$value"


 */

    }


})
}
}