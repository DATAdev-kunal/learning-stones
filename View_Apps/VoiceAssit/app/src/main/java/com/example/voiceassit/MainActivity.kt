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
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import org.w3c.dom.Text
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private val RQ_SPEECH_REC = 102
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val gTTSbutton = findViewById<Button>(R.id.bt)
        
        gTTSbutton.setOnClickListener{
            askSpeechInput()
        }
//        mlResponseViaAPI()
    }
    
    
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val textBox = findViewById<TextView>(R.id.tv)
        super.onActivityResult(requestCode, resultCode, data)
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
//            registerForActivityResult(RQ_SPEECH_REC)
        }
    }
    private fun mlResponseViaAPI(){
        val url = "https://projectapi-yrtybbyihq-uc.a.run.app/"

        val responseView = findViewById<TextView>(R.id.mlResponseTv)
        
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener<String?> { response ->
                try {
                    val jsonObject = JSONObject(response)
                    val data = jsonObject.getString("speech")
                    responseView.text = data.toString()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(
                    this@MainActivity,
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["speech"] = responseView.text.toString()
                return params
            }
        }
        val queue = Volley.newRequestQueue(this@MainActivity)
        queue.add(stringRequest)
    }
}