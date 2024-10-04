package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Log.i("myTag","MainActivity: OnCreate")
        val welcomeMessage = findViewById<TextView>(R.id.tv_message)
        val inputField = findViewById<EditText>(R.id.etName)
        val submitBtn= findViewById<Button>(R.id.button)
        val offerBtn= findViewById<Button>(R.id.offerBtn)
        var enteredName=""
        submitBtn.setOnClickListener{
            enteredName= inputField.text.toString()

            if(enteredName==""){
                offerBtn.visibility= INVISIBLE
                welcomeMessage.text=""
                Toast.makeText(
                    this@MainActivity,
                    "Please enter your name",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else{
                val message= "Welcome $enteredName"
                welcomeMessage.text=message
                inputField.text.clear()
                offerBtn.visibility= VISIBLE
            }
        }
        offerBtn.setOnClickListener {
            val intent= Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }

    }


    override fun onStart() {
        super.onStart()
        Log.i("myTag","MainActivity: OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("myTag","MainActivity: OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("myTag","MainActivity: OnPause")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("myTag","MainActivity: OnDestroy")

    }

    override fun onRestart() {
        super.onRestart()
        Log.i("myTag","MainActivity: OnRestart")

    }
}