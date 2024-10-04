package com.example.blackcoffersampleapp.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SliderMinimalExample() {
	var sliderPosition by remember { mutableFloatStateOf(0f) }
	Column(
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.fillMaxWidth()
	) {
		Text(text = sliderPosition.toInt().toString(),
			fontWeight = FontWeight.Bold,
			fontSize = 24.sp
		)
		Slider(
			value = sliderPosition,
			onValueChange = { sliderPosition = it },
			valueRange = 1f..100f
		)
		Row(horizontalArrangement = Arrangement.spacedBy(290.dp)
		) {
			Text(text = "1 Km")
			Text(text = "100 Km")
		}
	}
}
