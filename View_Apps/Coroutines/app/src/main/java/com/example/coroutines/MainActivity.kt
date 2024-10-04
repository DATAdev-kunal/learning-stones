package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count=0
    private lateinit var messageTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView= findViewById<TextView>(R.id.tvCount)
        val downloadButton= findViewById<Button>(R.id.btnDownload)
        val countButton= findViewById<Button>(R.id.btnCount)
        messageTextView=findViewById(R.id.tvMessage)

        countButton.setOnClickListener{
            textView.text=count++.toString()
        }
        downloadButton.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                downloadUserData()
            }

        }
    }
    private suspend fun downloadUserData(){
        for (i in 1..200000){
            Log.i("MyTag","Downloading user $i in ${Thread.currentThread().name}")
            withContext(Dispatchers.Main){
                messageTextView.text= "Downloading user $i"
            }
            delay(100)
        }
    }
}

