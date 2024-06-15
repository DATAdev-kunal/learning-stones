package com.giantnovadevs.superapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.giantnovadevs.superapp.R
import com.giantnovadevs.superapp.navigation.Screen
import com.giantnovadevs.superapp.navigation.SuperAppRouter
import com.giantnovadevs.superapp.navigation.SystemBackButtonHandler
import com.giantnovadevs.superapp.ui.components.HeadingTextComponents

@Composable
fun TermsAndConditionsScreen(){
	Surface(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp)
			.background(color = Color.White)
	) {
		HeadingTextComponents(value = stringResource(id = R.string.terms_of_use))
	}
	
	SystemBackButtonHandler {
		SuperAppRouter.navigateTo(Screen.SignUpScreen)
	}
}

@Preview(showSystemUi = true)
@Composable
fun TermsAndConditionScreenPreview(){
	TermsAndConditionsScreen()
}