package com.example.viewbindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageView= findViewById<TextView>(R.id.tvMessage)
        val inputText= findViewById<EditText>(R.id.etName)
        val submitButton= findViewById<Button>(R.id.btnSubmit)

        submitButton.setOnClickListener{
            val name = inputText.text.toString()
            messageView.text="Hello! $name"
            inputText.setText("")
        }
    }
}