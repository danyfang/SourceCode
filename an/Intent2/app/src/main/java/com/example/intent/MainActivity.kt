package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButton = findViewById<ImageButton>(R.id.imageButton_phone)
        val imageButton1 = findViewById<ImageButton>(R.id.imageButton_sms)
        imageButton.setOnClickListener(listener)
        imageButton1.setOnClickListener(listener)
    }

    val listener = View.OnClickListener { view ->
        when (view.id) {
            R.id.imageButton_phone -> {val intent = Intent(Intent.ACTION_DIAL); intent.setData(Uri.parse("tel:10086"));
            startActivity(intent)}
            else -> {val intent = Intent(Intent.ACTION_SENDTO); intent.setData(Uri.parse("smsto:10086"));
            intent.putExtra("ms_body", "Hello Android"); startActivity(intent)}
        }
    }
}
