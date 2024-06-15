package com.giantnovadevs.superapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.giantnovadevs.superapp.R
import com.giantnovadevs.superapp.navigation.Screen
import com.giantnovadevs.superapp.navigation.SuperAppRouter
import com.giantnovadevs.superapp.navigation.SystemBackButtonHandler
import com.giantnovadevs.superapp.ui.components.ButtonComponent
import com.giantnovadevs.superapp.ui.components.ClickableLoginTextComponent
import com.giantnovadevs.superapp.ui.components.DividerComponent
import com.giantnovadevs.superapp.ui.components.HeadingTextComponents
import com.giantnovadevs.superapp.ui.components.MyTextFieldComponent
import com.giantnovadevs.superapp.ui.components.NormalTextComponents
import com.giantnovadevs.superapp.ui.components.PasswordFieldComponent
import com.giantnovadevs.superapp.ui.components.UnderlinedTextComponents
import com.giantnovadevs.superapp.ui.uievents.LoginUIEvent
import com.giantnovadevs.superapp.ui.viewModels.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()){
	Box(
		modifier = Modifier
			.fillMaxSize(),
		contentAlignment = Alignment.Center
	){
	Surface(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(28.dp)
	){
		Column(
			modifier = Modifier
			.fillMaxSize()
		) {
			NormalTextComponents(value = stringResource(id = R.string.login))
			
			HeadingTextComponents(value = stringResource(id = R.string.welcome_text))
			
			MyTextFieldComponent(
				labelValue = stringResource(id = R.string.email),
				imageVector = Icons.Outlined.Mail,
				onTextChanged = {
					loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
				},
				errorStatus = loginViewModel.loginUIState.value.emailError
			)
			
			Spacer(modifier = Modifier.heightIn(20.dp))
			
			PasswordFieldComponent(
				labelValue = stringResource(id = R.string.password),
				imageVector = Icons.Outlined.Lock,
				onTextSelected = {
					loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
				},
				errorStatus = loginViewModel.loginUIState.value.passwordError
			)
			
			UnderlinedTextComponents(value = stringResource(id = R.string.forgot_password))
			
			Spacer(modifier = Modifier.height(40.dp))
			
			ButtonComponent(
				value = stringResource(id = R.string.login),
				onButtonClicked = {
					loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
				},
				isEnabled = loginViewModel.allLoginValidationsPassed.value
			)
			DividerComponent()
			
			ClickableLoginTextComponent(
				tryingToLogin = false,
				onTextSelected = {
					SuperAppRouter.navigateTo(Screen.SignUpScreen)
				}
			)
		}
	}
		if(loginViewModel.loginInProgress.value) {
			CircularProgressIndicator()
		}
	}
	SystemBackButtonHandler {
		SuperAppRouter.navigateTo(Screen.SignUpScreen)
	}
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview(){
	LoginScreen()
}