package com.example.oop_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        val objCar= Car()
        objCar.maxSpeed=150
        objCar.start()

        val objDriver= driver("Harry",180)
        objDriver.showDetails()
*/
        val objMyCar= MyCar()
        objMyCar.maxSpeed=180
        objMyCar.start()

    }

}