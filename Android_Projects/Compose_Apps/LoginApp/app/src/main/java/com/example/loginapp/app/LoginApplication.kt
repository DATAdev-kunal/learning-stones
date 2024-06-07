package com.example.loginapp.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginapp.screens.SignUpScreen

@Composable
fun LoginApplication() {
	Surface(color = Color.White,
		modifier = Modifier
			.fillMaxSize()
	) {
	SignUpScreen()
	}
}

@Preview(showSystemUi = true)
@Composable
fun LoginApplicationPreview(){
	LoginApplication()
}