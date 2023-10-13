package com.example.ts_lover

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private var tsAntiHero: MediaPlayer? = null
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button= findViewById<Button>(R.id.btnAntiHero)
        button.setOnClickListener {
            if (tsAntiHero == null) {
                tsAntiHero = MediaPlayer.create(this, R.raw.antihero)
                initializeSeekBar()
            }
            tsAntiHero?.start()
        }

        seekBar = findViewById<SeekBar>(R.id.sbAntiHero)
        handler= Handler(Looper.getMainLooper())

        val btnPlay = findViewById<FloatingActionButton>(R.id.fabPlay)
        btnPlay.setOnClickListener {
            if (tsAntiHero == null) {
                tsAntiHero = MediaPlayer.create(this, R.raw.antihero)
                initializeSeekBar()
            }
            tsAntiHero?.start()
        }

        val btnPause = findViewById<FloatingActionButton>(R.id.fabPause)
        btnPause.setOnClickListener {
            tsAntiHero?.pause()
        }

        val btnStop = findViewById<FloatingActionButton>(R.id.fabStop)
        btnStop.setOnClickListener {
            tsAntiHero?.stop()
            tsAntiHero?.reset()
            tsAntiHero?.release()
            tsAntiHero = null
            handler.removeCallbacks(runnable)
            seekBar.progress=0
        }

    }

    private fun initializeSeekBar() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(SeekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) tsAntiHero?.seekTo(progress)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        val tvPlayed=findViewById<TextView>(R.id.tvPlayed)
        val tvDue=findViewById<TextView>(R.id.tvDue)
        seekBar.max= tsAntiHero!!.duration
        runnable= Runnable {
            seekBar.progress= tsAntiHero!!.currentPosition
            val playedTime= tsAntiHero!!.currentPosition/1000
            tvPlayed.text= "$playedTime sec"
            val duration=tsAntiHero!!.duration/1000
            val dueTime= duration-playedTime
            tvDue.text="$dueTime sec"
            handler.postDelayed(runnable,50)
        }
        handler.postDelayed(runnable, 50)
    }
}