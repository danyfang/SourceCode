package com.example.gesturedetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ViewFlipper

class MainActivity() : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var flipper: ViewFlipper
    private lateinit var detector: GestureDetector
    private lateinit var animation: Array<Animation>
    private val distance = 50
    private val images = arrayOf(R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04,
        R.drawable.img05, R.drawable.img06, R.drawable.img07, R.drawable.img08, R.drawable.img09)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        detector = GestureDetector(this, this)
        flipper = findViewById(R.id.flipper)
        for (i in 0 until images.size) {
            val imageView = ImageView(this)
            imageView.setImageResource(images[i])
            flipper.addView(imageView)
        }
        animation = arrayOf(AnimationUtils.loadAnimation(this, R.anim.slide_in_left),
            AnimationUtils.loadAnimation(this, R.anim.slide_out_left),
            AnimationUtils.loadAnimation(this, R.anim.slide_in_right),
            AnimationUtils.loadAnimation(this, R.anim.slide_out_right))
    }

    override fun onDown(p0: MotionEvent?): Boolean {
            return false
    }

    override fun onShowPress(p0: MotionEvent?) { }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        return false
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        return false
    }

    override fun onLongPress(p0: MotionEvent?) { }

    override fun onFling(p0: MotionEvent, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        if (p0.x - p1.x > distance) {
            flipper.setInAnimation(animation[2])
            flipper.setOutAnimation(animation[1])
            flipper.showPrevious()
            return true
        } else if (p1.x - p0.x > distance) {
            flipper.setInAnimation(animation[0])
            flipper.setOutAnimation(animation[3])
            flipper.showNext()
            return true
        }
        return false
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return detector.onTouchEvent(event)
    }
}
