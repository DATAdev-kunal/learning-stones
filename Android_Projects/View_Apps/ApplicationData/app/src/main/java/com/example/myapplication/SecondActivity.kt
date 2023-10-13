package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i("myTag","SecondActivity: OnCreate")
        val userName= intent.getStringExtra("USER")
        val textView= findViewById<TextView>(R.id.tvOffer)
        val message = "$userName, You'll get extra hour !"
        textView.text= message
    }
    override fun onStart() {
        super.onStart()
        Log.i("myTag","SecondActivity: OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("myTag","SecondActivity: OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("myTag","SecondActivity: OnPause")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("myTag","SecondActivity: OnDestroy")

    }

    override fun onRestart() {
        super.onRestart()
        Log.i("myTag","SecondActivity: OnRestart")

    }
}
