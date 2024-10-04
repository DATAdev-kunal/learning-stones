package com.example.oop_demo

import android.util.Log

class MyCar: Car(), SpeedController {
    override fun start() {
        Log.i("MyTag", "this is speedController...brand Id is ${getBrandId()}")
    }

    override fun accelerate() {

    }

    override fun decelerate() {

    }
}

