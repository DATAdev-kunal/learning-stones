package com.example.mycalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalc.ui.theme.MyCalcTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MyCalcTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					CalculatorApp()
				}
			}
		}
	}
}

@Composable
fun CalculatorApp() {
	var calculationText by remember {
		mutableStateOf("")
	}
	Column(
	) {
		Text(fontSize = 34.sp,
			text = calculationText
		)
		Column(
			modifier = Modifier
				.padding(15.dp),
			horizontalAlignment = Alignment.End
		) {
			Row (
				modifier = Modifier
					.padding(15.dp)
			){
				Button(onClick = { calculationText = "" }) {
					Text(text = "C")
				}
				Button(onClick = { calculationText += "%" }) {
					Text(text = "%")
				}
				Button(onClick = {
				
				}) {
					Text(text = "del")
				}
				Button(onClick = { calculationText += "/" }) {
					Text(text = "/")
				}
				
			}
			Row {
				Button(onClick = { calculationText += "1" }) {
					Text(text = "1")
				}
				Button(onClick = { calculationText +="2" }) {
					Text(text = "2")
				}
				Button(onClick = { calculationText +="3" }) {
					Text(text = "3")
				}
				Button(onClick = {
					calculationText +="X"
					
				}) {
					Text(text = "X")
				}
				
			}
			Row {
				Button(onClick = { calculationText +="4" }) {
					Text(text = "4")
				}
				Button(onClick = { calculationText +="5" }) {
					Text(text = "5")
				}
				Button(onClick = { calculationText +="6" }) {
					Text(text = "6")
				}
				Button(onClick = { calculationText +="-" }) {
					Text(text = "-")
				}
				
			}
			Row {
				Button(onClick = { calculationText +="7" }) {
					Text(text = "7")
				}
				Button(onClick = { calculationText +="8"}) {
					Text(text = "8")
				}
				Button(onClick = { calculationText +="9" }) {
					Text(text = "9")
				}
				Button(onClick = { calculationText +="+" }) {
					Text(text = "+")
				}
				
			}
			Row {
				Button(onClick = { calculationText +="00" }) {
					Text(text = "00")
				}
				Button(onClick = { calculationText +="0" }) {
					Text(text = "0")
				}
				Button(onClick = { calculationText +="." }) {
					Text(text = ".")
				}
				Button(onClick = {  }) {
					Text(text = "=")
				}
				
			}
			
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculatorAppPreview() {
	MyCalcTheme {
		CalculatorApp()
	}
}