package com.example.superhero.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.superhero.R

val CabinBold = FontFamily(
	Font(R.font.cabin_bold)
)

val CabinRegular = FontFamily(
	Font(R.font.cabin_regular)
)

val Typography = Typography(
	displayLarge = TextStyle(
		fontFamily = CabinBold,
		fontWeight = FontWeight.Bold,
		fontSize = 34.sp
	),
	displaySmall = TextStyle(
		fontFamily = CabinBold,
		fontWeight = FontWeight.SemiBold,
		fontSize = 24.sp
	),
	bodyLarge = TextStyle(
		fontFamily = CabinRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp
	)
)