package com.example.voiceassit

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Locale

class MainActivity : AppCompatActivity() {


    private val RQ_SPEECH_REC = 102
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val gTTSbutton = findViewById<Button>(R.id.bt)

m
        gTTSbutton.setOnClickListener{
            askSpeechInput()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val textBox = findViewById<TextView>(R.id.tv)
        if(requestCode==RQ_SPEECH_REC && resultCode== Activity.RESULT_OK){
            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            textBox.text = result?.get(0).toString()
        }
    }
    private fun askSpeechInput(){
        if(!SpeechRecognizer.isRecognitionAvailable(this)){
            Toast.makeText(this, "Speech recognition not available", Toast.LENGTH_SHORT).show()
        }else{
            val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak Now !")
            startActivityForResult(i,RQ_SPEECH_REC)
        }
    }
}