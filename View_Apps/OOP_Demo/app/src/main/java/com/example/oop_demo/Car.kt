package com.example.oop_demo

import android.util.Log

open class Car {
    var maxSpeed= 300
    open fun start(){
        Log.i("MyTag", "MainActivity: Starting Car")
        Log.i("MyTag", "Max speed is $maxSpeed")
    }

    }