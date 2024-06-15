package com.giantnovadevs.superapp.ui.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.giantnovadevs.superapp.ui.uievents.LoginUIEvent
import com.giantnovadevs.superapp.ui.states.LoginUIState
import com.giantnovadevs.superapp.navigation.Screen
import com.giantnovadevs.superapp.navigation.SuperAppRouter
import com.giantnovadevs.superapp.ui.rules.Validator
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
					SuperAppRouter.navigateTo(Screen.HomeScreen)
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