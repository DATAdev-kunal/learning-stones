package com.giantnovadevs.superapp.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
	data object SignUpScreen: Screen()
	data object TermsAndConditionsScreen: Screen()
	data object LoginScreen: Screen()
	data object HomeScreen: Screen()
}

object SuperAppRouter {
	var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)
	
	fun navigateTo(destination: Screen){
		currentScreen.value = destination
	}
}