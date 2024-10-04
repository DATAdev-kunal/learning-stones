package com.example.oop_demo

import android.util.Log

interface SpeedController {
    fun accelerate()
    fun decelerate()

    fun getBrandId():String{
        return "ASDF12340978"
    }

}