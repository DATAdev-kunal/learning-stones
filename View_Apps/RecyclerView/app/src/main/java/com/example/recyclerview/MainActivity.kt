package com.example.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val songs= listOf<song>(
        song("Anti Hero","Taylor Swift"),
        song("Willow","Taylor Swift"),
        song("Vigilant Shit","Taylor Swift"),
        song("Karma","Taylor Swift"),
        song("Bejeweled","Taylor Swift"),
        song("Lover","Taylor Swift"),
        song("Dorothea","Taylor Swift")
    )
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView=findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter= MyRecyclerViewAdapter(songs)
    }
}