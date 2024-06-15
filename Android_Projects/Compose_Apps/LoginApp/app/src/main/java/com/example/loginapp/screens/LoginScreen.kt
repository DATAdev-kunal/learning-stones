package com.example.loginapp.screens

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
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.MailOutline
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
import com.example.loginapp.R
import com.example.loginapp.components.ButtonComponent
import com.example.loginapp.components.ClickableLoginTextComponent
import com.example.loginapp.components.DividerComponent
import com.example.loginapp.components.HeadingTextComponents
import com.example.loginapp.components.MyTextFieldComponent
import com.example.loginapp.components.NormalTextComponents
import com.example.loginapp.components.PasswordFieldComponent
import com.example.loginapp.components.UnderlinedTextComponents
import com.example.loginapp.data.login.LoginUIEvent
import com.example.loginapp.data.login.LoginViewModel
import com.example.loginapp.navigation.AppRouter
import com.example.loginapp.navigation.Screen
import com.example.loginapp.navigation.SystemBackButtonHandler

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
					AppRouter.navigateTo(Screen.SignUpScreen)
				}
			)
		}
	}
		if(loginViewModel.loginInProgress.value) {
			CircularProgressIndicator()
		}
	}
	SystemBackButtonHandler {
		AppRouter.navigateTo(Screen.SignUpScreen)
	}
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview(){
	LoginScreen()
}