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
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
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
import com.example.loginapp.navigation.AppRouter
import com.example.loginapp.R
import com.example.loginapp.components.ButtonComponent
import com.example.loginapp.navigation.Screen
import com.example.loginapp.components.CheckboxComponent
import com.example.loginapp.components.ClickableLoginTextComponent
import com.example.loginapp.components.DividerComponent
import com.example.loginapp.components.HeadingTextComponents
import com.example.loginapp.components.MyTextFieldComponent
import com.example.loginapp.components.NormalTextComponents
import com.example.loginapp.components.PasswordFieldComponent
import com.example.loginapp.data.signup.SignUpViewModel
import com.example.loginapp.data.signup.SignUpUIEvent

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel()){
	
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
		) {
			Column(
				modifier = Modifier
					.fillMaxSize()
			) {
				NormalTextComponents(stringResource(id = R.string.hello))
				
				HeadingTextComponents(stringResource(id = R.string.welcome_text))
				Spacer(modifier = Modifier.heightIn(20.dp))
				
				MyTextFieldComponent(
					labelValue = stringResource(id = R.string.first_name),
					imageVector = Icons.Outlined.Person,
					onTextChanged = {
						signUpViewModel.onEvent(SignUpUIEvent.FirstNameChanged(it))
					},
					errorStatus = signUpViewModel.signUpUIState.value.firstNameError
				)
				Spacer(modifier = Modifier.heightIn(20.dp))
				
				MyTextFieldComponent(
					labelValue = stringResource(id = R.string.last_name),
					imageVector = Icons.Outlined.Person,
					onTextChanged = {
						signUpViewModel.onEvent(SignUpUIEvent.LastNameChanged(it))
					},
					errorStatus = signUpViewModel.signUpUIState.value.lastNameError
				)
				Spacer(modifier = Modifier.heightIn(20.dp))
				
				MyTextFieldComponent(
					labelValue = stringResource(id = R.string.email),
					imageVector = Icons.Outlined.MailOutline,
					onTextChanged = {
						signUpViewModel.onEvent(SignUpUIEvent.EmailChanged(it))
					},
					errorStatus = signUpViewModel.signUpUIState.value.emailError
				)
				Spacer(modifier = Modifier.heightIn(20.dp))
				
				PasswordFieldComponent(
					labelValue = stringResource(id = R.string.password),
					imageVector = Icons.Outlined.Lock,
					onTextSelected = {
						signUpViewModel.onEvent(SignUpUIEvent.PasswordChanged(it))
					},
					errorStatus = signUpViewModel.signUpUIState.value.passwordError
				)
				
				CheckboxComponent(
					value = stringResource(id = R.string.terms_conditions),
					onTextSelected = {
						AppRouter.navigateTo(Screen.TermsAndConditionsScreen)
					},
					onCheckedChange = {
						signUpViewModel.onEvent(SignUpUIEvent.PrivacyPolicyCheckBoxClicked(it))
					}
				)
				
				Spacer(modifier = Modifier.height(40.dp))
				
				ButtonComponent(
					value = stringResource(id = R.string.register),
					onButtonClicked = {
						signUpViewModel.onEvent(SignUpUIEvent.RegisterButtonClicked)
					},
					isEnabled = signUpViewModel.allValidationsPassed.value
				)
				
				Spacer(modifier = Modifier.height(30.dp))
				
				DividerComponent()
				
				ClickableLoginTextComponent(
					tryingToLogin = true,
					onTextSelected = {
						AppRouter.navigateTo(Screen.LoginScreen)
					}
				)
			}
		}
		
		if(signUpViewModel.signUpProgress.value){
			CircularProgressIndicator()
		}
	}

}

@Preview(showSystemUi = true)
@Composable
fun SignUpScreenPreview(){
	SignUpScreen()
}