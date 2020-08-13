package com.example.taobao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ViewFlipper

class MainActivity : AppCompatActivity() {

    private val FLAG_MSG = 0x001;
    private lateinit var flipper : ViewFlipper
    private lateinit var message : Message
    private lateinit var animation: Array<Animation>
    private val images = arrayOf(R.drawable.img1, R.drawable.img2, R.drawable.img3,
    R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flipper = findViewById(R.id.viewFlipper)
        for(i in 0 until images.size){
            val imageView = ImageView(this)
            imageView.setImageResource(images[i])
            flipper.addView(imageView)
        }
        animation = arrayOf(AnimationUtils.loadAnimation(this, R.anim.slide_in_right),
            AnimationUtils.loadAnimation(this, R.anim.slide_out_left))

        flipper.inAnimation = animation[0]
        flipper.outAnimation = animation[1]

        message = Message.obtain()
        message.what = FLAG_MSG
        handler.sendMessage(message)
    }


    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if(msg.what == FLAG_MSG) {
                flipper.showPrevious()
            }
            message = obtainMessage(FLAG_MSG)
            sendMessageDelayed(message, 3000)
        }
    }
}
