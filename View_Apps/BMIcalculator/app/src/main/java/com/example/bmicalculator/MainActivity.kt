package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText= findViewById<EditText>(R.id.etWeight)
        val heightText= findViewById<EditText>(R.id.etHeight)
        val calcButton= findViewById<Button>(R.id.btnCalculate)

        calcButton.setOnClickListener {
            val weight= weightText.text.toString()
            val height= heightText.text.toString()

            if(validateInput(weight,height)) {
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

                val bmi2decimal = String.format("%.2f", bmi).toFloat()
                display(bmi2decimal)
            }
        }
    }

    private fun validateInput(weight:String?, height:String?):Boolean{

        return when{
            weight.isNullOrEmpty()->{
                Toast.makeText(this, "Weight is empty",Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty()->{
                Toast.makeText(this, "Height is empty",Toast.LENGTH_LONG).show()
                return false
            }
            else->{
                return true
            }
        }
    }

    private fun display(bmi:Float){
        val resultIndex= findViewById<TextView>(R.id.tvIndex)
        val resultStatement=findViewById<TextView>(R.id.tvResult)
        val resultInfo=findViewById<TextView>(R.id.tvInfo)

        resultIndex.text= bmi.toString()
        resultInfo.text= "(Normal range is 18.4- 24.9)"

        var resultText= ""
        var color=0

        when{
            bmi<18.49 ->{
                resultText="Under Weight"
                color=R.color.under_weight
            }
            bmi in 18.50..24.90->{
                resultText="Healthy"
                color=R.color.normal
            }
            bmi in 25.00..29.9->{
                resultText="Overweight"
                color=R.color.over_weight
            }
            bmi>29.9->{
                resultText="Obese"
                color=R.color.obese
            }
        }

        resultStatement.setTextColor(ContextCompat.getColor(this, color))
        resultStatement.text= resultText

    }
}