package com.example.wechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView1 = findViewById<ImageView>(R.id.image1)
        val imageView2 = findViewById<ImageView>(R.id.image2)
        val imageView3 = findViewById<ImageView>(R.id.image3)
        val imageView4 = findViewById<ImageView>(R.id.image4)

        imageView1.setOnClickListener(listener)
        imageView2.setOnClickListener(listener)
        imageView3.setOnClickListener(listener)
        imageView4.setOnClickListener(listener)
    }

    val listener = View.OnClickListener {view ->

        val trans = supportFragmentManager.beginTransaction()
        when(view.id) {
            R.id.image1 ->  trans.replace(R.id.container, Wechat_Fragment())
            R.id.image2 ->  trans.replace(R.id.container, Message_Fragment())
            R.id.image3 ->  trans.replace(R.id.container, Find_Fragment())
            else ->  trans.replace(R.id.container, Me_Fragment())
        }
        trans.commit()
    }
}
