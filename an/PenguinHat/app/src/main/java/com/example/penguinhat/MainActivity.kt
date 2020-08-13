package com.example.penguinhat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var gapX = -1F
    private var gapY = -1F
    private var flag = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val relativeLayout = findViewById<RelativeLayout>(R.id.relativeLayout)
        val hat = HatView(this@MainActivity)

        hat.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(v : View?, event : MotionEvent?) : Boolean {
                if (event != null) {
                    if (flag) {
                        flag = false
                        gapX = event.getX() - hat.bitmapX
                        gapY = event.getY() - hat.bitmapY
                    }
                    hat.bitmapX = event.getX() - gapX
                    hat.bitmapY = event.getY() - gapY
                    hat.invalidate()
                    return true
                }
                return false
            }
        })
        relativeLayout.addView(hat)
    }
}
