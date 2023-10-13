package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(val songs:List<song>):RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val song= songs[position]
    holder.bind(song)
    }

    override fun getItemCount(): Int {

        return songs.size
    }

}

class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){
    fun bind(song: song){
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text=song.name

        view.setOnClickListener{
            Toast.makeText(
                view.context,
                "Selected song is ${song.name}",
                Toast.LENGTH_LONG
            ).show()

        }
    }



}