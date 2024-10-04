package com.giantnovadevs.superapp.ui.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.giantnovadevs.superapp.ui.uievents.SignUpUIEvent
import com.giantnovadevs.superapp.ui.states.SignUpUIState
import com.giantnovadevs.superapp.navigation.Screen
import com.giantnovadevs.superapp.navigation.SuperAppRouter
import com.giantnovadevs.superapp.ui.rules.Validator
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel: ViewModel() {
	private val TAG = SignUpViewModel::class.simpleName
	
	var signUpUIState = mutableStateOf(SignUpUIState())
	
	var allValidationsPassed = mutableStateOf(false)
	
	var signUpProgress = mutableStateOf(false)
	
	fun onEvent(event: SignUpUIEvent){
		when(event){
			is SignUpUIEvent.FirstNameChanged -> {
				signUpUIState.value = signUpUIState.value.copy(
					firstName = event.firstName
				)
				printState()
			}
			
			is SignUpUIEvent.LastNameChanged -> {
				signUpUIState.value = signUpUIState.value.copy(
					lastName = event.lastName
				)
				printState()
			}
			is SignUpUIEvent.EmailChanged -> {
				signUpUIState.value = signUpUIState.value.copy(
					email = event.email
				)
				printState()
			}
			is SignUpUIEvent.PasswordChanged -> {
				signUpUIState.value = signUpUIState.value.copy(
					password = event.password
				)
				printState()
			}
			is SignUpUIEvent.PrivacyPolicyCheckBoxClicked -> {
				signUpUIState.value = signUpUIState.value.copy(
					privacyPolicyAccepted = event.check
				)
			}
			SignUpUIEvent.RegisterButtonClicked -> {
				signUp()
			}
		}
		validateDataWithRules()
	}
	
	private fun validateDataWithRules() {
		val fNameResult = Validator.validateFirstName(
			fName = signUpUIState.value.firstName
		)
		val lNameResult = Validator.validateLastName(
			lName = signUpUIState.value.lastName
		)
		val emailResult = Validator.validateEmail(
			email = signUpUIState.value.email
		)
		val passwordResult = Validator.validatePassword(
			password = signUpUIState.value.password
		)
		val privacyPolicyResult = Validator.validatePrivacyPolicyAccepted(
			statusValue = signUpUIState.value.privacyPolicyAccepted
		)
		
		Log.d(TAG, "Inside_validateDataWithRules")
		Log.d(TAG, "fNameResult = $fNameResult")
		Log.d(TAG, "lNameResult = $lNameResult")
		Log.d(TAG, "emailResult = $emailResult")
		Log.d(TAG, "passwordResult = $passwordResult")
		Log.d(TAG, "privacyPolicyResult = $privacyPolicyResult")
		
		signUpUIState.value = signUpUIState.value.copy(
			firstNameError = fNameResult.status,
			lastNameError = lNameResult.status,
			emailError = emailResult.status,
			passwordError = passwordResult.status,
			privacyError = privacyPolicyResult.status
		)
		
		allValidationsPassed.value = fNameResult.status && lNameResult.status && emailResult.status && passwordResult.status && privacyPolicyResult.status
		
	}
	private fun signUp(){
		Log.d(TAG, "Inside_signUp")
		printState()
		
		createUserInFirebase(
			email = signUpUIState.value.email,
			password = signUpUIState.value.password
		)
	}
	private fun printState(){
		Log.d(TAG, "Inside_printState")
		Log.d(TAG, signUpUIState.value.toString())
	}
	
	private fun createUserInFirebase(email: String, password: String) {
		signUpProgress.value = true
		
		FirebaseAuth.getInstance()
		    .createUserWithEmailAndPassword(email, password)
		    .addOnCompleteListener{
				Log.d(TAG, "Inside_OnCompleteListener")
			    Log.d(TAG, "isSuccessful = ${it.isSuccessful}")
			    
			    signUpProgress.value = false
			    if(it.isSuccessful){
					SuperAppRouter.navigateTo(Screen.HomeScreen)
				   
			    }
			}
		    .addOnFailureListener {
				Log.d(TAG, "Inside_OnFailureListener")
				Log.d(TAG, "Exception = ${it.message}")
				Log.d(TAG, "Exception = ${it.localizedMessage}")
		    }
	}
}