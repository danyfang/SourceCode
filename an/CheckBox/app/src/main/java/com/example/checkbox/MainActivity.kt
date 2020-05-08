package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ViewFlipper
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private val images = arrayOf(R.drawable.leon, R.drawable.mike, R.drawable.don, R.drawable.raph)
    private val distance = 20

    private lateinit var flipper: ViewFlipper
    private lateinit var radioGroup: RadioGroup
    private lateinit var detector: GestureDetector
    private lateinit var animation : Array<Animation>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        detector = GestureDetector(this, this)
        flipper = findViewById(R.id.ninjia_pic)
        radioGroup = findViewById(R.id.ninjia_group)

        for (i in 0 until images.size) {
            val imageView = ImageView(this)
            imageView.setImageResource(images[i])
            flipper.addView(imageView)
        }

        animation = arrayOf(
            AnimationUtils.loadAnimation(this, R.anim.slide_in_left),
            AnimationUtils.loadAnimation(this, R.anim.slide_out_left),
            AnimationUtils.loadAnimation(this, R.anim.slide_in_right),
            AnimationUtils.loadAnimation(this, R.anim.slide_out_right)
        )
        flipper.displayedChild = radioGroup.checkedRadioButtonId
    }

    fun radioButtonClick(view : View) {
        val id = when (view) {
            rd_leon -> 0
            rd_mike -> 1
            rd_don -> 2
            else -> 3
        }
        if (flipper.displayedChild != id) {
            flipper.displayedChild = id
        }
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
            val index = (flipper.displayedChild-1+images.size)%images.size
            radioGroup.check(getRadioButtonId(index))
            return true
        } else if (p1.x - p0.x > distance) {
            flipper.setInAnimation(animation[0])
            flipper.setOutAnimation(animation[3])
            flipper.showNext()
            val index = (flipper.displayedChild+1)%images.size
            radioGroup.check(getRadioButtonId(index))
            return true
        }
        return false
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return detector.onTouchEvent(event)
    }

    private fun getRadioButtonId(index : Int) : Int{
        val index = when(index) {
            0 -> R.id.rd_leon
            1 -> R.id.rd_mike
            2 -> R.id.rd_don
            else -> R.id.rd_raph
        }
        return index
    }
}
