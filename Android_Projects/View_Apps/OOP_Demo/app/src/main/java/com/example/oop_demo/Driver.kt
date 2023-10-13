package com.example.oop_demo

import android.util.Log

class driver(name : String, credit: Int) {
    var totalCredit=50
    var driverName = ""
    //lateinit var driverName:String
    //var driverName=name

    init{
        totalCredit +=50
        driverName= name
    }

    fun showDetails() {
        Log.i("MyTag", "Driver name is $driverName with credits $totalCredit")
    }
}