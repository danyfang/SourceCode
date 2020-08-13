package com.example.musicplayer

import android.app.Activity
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.Toast
import java.io.File

class MainActivity : Activity() {

    private lateinit var file : File
    private var player : MediaPlayer = MediaPlayer()
    private var isPause = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val btn_play = findViewById<ImageButton>(R.id.btn_play)
        val btn_stop = findViewById<ImageButton>(R.id.btn_stop)

        file = File("/sdcard/Music/Red Highheel.mp3")
        if (!file.exists()) {
            Toast.makeText(this, "Music file does not exist!", Toast.LENGTH_SHORT).show()
            return
        }
        player.setDataSource(file.absolutePath)
        player.prepare()

        player.setOnCompletionListener { MediaPlayer.OnCompletionListener { mediaPlayer ->
            play()
        } }

        btn_play.setOnClickListener(View.OnClickListener {  view ->
            if (player.isPlaying && !isPause) {
                player.pause()
                isPause = true
                btn_play.setImageResource(R.drawable.play)
            } else {
                player.start()
                isPause = false
                btn_play.setImageResource(R.drawable.pause)
            }
        })

        btn_stop.setOnClickListener(View.OnClickListener { view ->
            player.stop()
            btn_play.setImageResource(R.drawable.play)
            player.prepare()
        })
    }

    private fun play() {
        try {
            player.reset()
            player.setDataSource(file.absolutePath)
            player.prepare()
            player.start()
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        if (player.isPlaying) {
            player.stop()
        }
        player.release()
        super.onDestroy()
        Log.i("Danny", "On Destory called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Danny", "On stop called")
    }
}
