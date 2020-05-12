package com.example.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.ProgressBar
import android.widget.Toast
import java.util.Timer

class MainActivity : AppCompatActivity() {

    private val TIME = 60
    private val TIMER_MSG = 0x001
    private var mProgressStatus = 0
    private lateinit var timer: ProgressBar
    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (TIME - mProgressStatus > 0) {
                mProgressStatus++
                timer.progress = TIME - mProgressStatus
                sendEmptyMessageDelayed(TIMER_MSG, 1000)
            } else {
                Toast.makeText(this@MainActivity, "Time is up", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timer = findViewById<ProgressBar>(R.id.timer)
        handler.sendEmptyMessage(TIMER_MSG)
    }

}
