package com.example.fintechapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartScreen(){
	Surface (modifier = Modifier.foldIn(
	)){
		Column {
		
		}
	}
}

@Preview(showSystemUi = true)
@Composable
fun StartScreenPreview() {
	StartScreen()
}