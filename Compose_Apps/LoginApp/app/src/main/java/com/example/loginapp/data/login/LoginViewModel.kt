package com.example.loginapp.data.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.loginapp.data.rules.Validator
import com.example.loginapp.navigation.AppRouter
import com.example.loginapp.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel() {
	private val TAG = LoginViewModel::class.simpleName
	
	var loginUIState = mutableStateOf(LoginUIState())
	var allLoginValidationsPassed = mutableStateOf(false)
	var loginInProgress = mutableStateOf(false)
	
	fun onEvent(event: LoginUIEvent) {
		validateLoginUIDataWithRules()
		when(event){
			is LoginUIEvent.EmailChanged -> {
				loginUIState.value = loginUIState.value.copy(
					email = event.email
				)
				printState()
			}
			is LoginUIEvent.PasswordChanged -> {
				loginUIState.value = loginUIState.value.copy(
					password = event.password
				)
				printState()
			}
			is LoginUIEvent.LoginButtonClicked -> {
				login()
			}
		}
	}
	
	private fun validateLoginUIDataWithRules() {
		val emailResult = Validator.validateEmail(
			email = loginUIState.value.email
		)
		
		val passwordResult = Validator.validatePassword(
			password = loginUIState.value.password
		)
		
		loginUIState.value = loginUIState.value.copy(
			emailError = emailResult.status,
			passwordError = passwordResult.status
		)
		
		Log.d(TAG, "emailResult = $emailResult")
		Log.d(TAG, "passwordResult = $passwordResult")
		
		allLoginValidationsPassed.value = emailResult.status && passwordResult.status
	}
	
	private fun login() {
		loginInProgress.value = true
		
		val email = loginUIState.value.email
		val password = loginUIState.value.password
		
		FirebaseAuth.getInstance()
			.signInWithEmailAndPassword(email, password)
			.addOnCompleteListener{
				Log.d(TAG, "Inside_login_success")
				Log.d(TAG, "${it.isSuccessful}")
				
				if(it.isSuccessful){
					loginInProgress.value = false
					AppRouter.navigateTo(Screen.HomeScreen)
				}
			}
			.addOnFailureListener{
				Log.d(TAG, "Inside_login_failure")
				Log.d(TAG, "${it.localizedMessage}")
				
				loginInProgress.value = false
			}
	}
	
	private fun printState(){
		Log.d(TAG, "Inside_printState")
		Log.d(TAG, loginUIState.value.toString())
	}
}