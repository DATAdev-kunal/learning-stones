package com.example.loginapp.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginapp.data.home.HomeViewModel
import com.example.loginapp.navigation.AppRouter
import com.example.loginapp.navigation.Screen
import com.example.loginapp.screens.HomeScreen
import com.example.loginapp.screens.LoginScreen
import com.example.loginapp.screens.SignUpScreen
import com.example.loginapp.screens.TermsAndConditionsScreen

@Composable
fun LoginApplication(homeViewModel: HomeViewModel = viewModel()) {
	homeViewModel.checkForActiveSession()
	
	Surface(
		color = Color.White,
		modifier = Modifier
			.fillMaxSize()
	) {
		if(homeViewModel.isUserLoggedIn.value == true){
			AppRouter.navigateTo(Screen.HomeScreen)
		}
		
		Crossfade(targetState = AppRouter.currentScreen, label = "") { currentState ->
			when(currentState.value){
				is Screen.SignUpScreen ->{
					SignUpScreen()
				}
				is Screen.TermsAndConditionsScreen ->{
					TermsAndConditionsScreen()
				}
				is Screen.LoginScreen-> {
					LoginScreen()
				}
				is Screen.HomeScreen-> {
					HomeScreen()
				}
			}
		}
	}
}

@Preview(showSystemUi = true)
@Composable
fun LoginApplicationPreview(){
	LoginApplication()
}