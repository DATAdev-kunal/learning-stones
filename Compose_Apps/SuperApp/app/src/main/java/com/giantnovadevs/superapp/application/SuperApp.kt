package com.giantnovadevs.superapp.application

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.giantnovadevs.superapp.navigation.Screen
import com.giantnovadevs.superapp.navigation.SuperAppRouter
import com.giantnovadevs.superapp.ui.screens.HomeScreen
import com.giantnovadevs.superapp.ui.screens.LoginScreen
import com.giantnovadevs.superapp.ui.screens.SignUpScreen
import com.giantnovadevs.superapp.ui.screens.TermsAndConditionsScreen
import com.giantnovadevs.superapp.ui.viewModels.HomeViewModel

@Composable
fun SuperApp(homeViewModel: HomeViewModel = viewModel()) {
	homeViewModel.checkForActiveSession()
	
	Surface(
		color = Color.White,
		modifier = Modifier
			.fillMaxSize()
	) {
		if(homeViewModel.isUserLoggedIn.value == true){
			SuperAppRouter.navigateTo(Screen.HomeScreen)
		}
		
		Crossfade(targetState = SuperAppRouter.currentScreen, label = "") { currentState ->
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
	SuperApp()
}