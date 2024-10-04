package com.example.loginapp.data.home

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginapp.data.NavigationItem
import com.example.loginapp.data.signup.SignUpViewModel
import com.example.loginapp.navigation.AppRouter
import com.example.loginapp.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel(){
	private val TAG = HomeViewModel::class.simpleName
	
	val navigationItemList = listOf(
		NavigationItem(
			title = "Home",
			description = "Home Screen",
			icon = Icons.Filled.Home,
			itemId = "homeScreen"
		),
		NavigationItem(
			title = "Settings",
			description = "Settings Screen",
			icon = Icons.Filled.Settings,
			itemId = "settingsScreen"
		),
		NavigationItem(
			title = "Favorite",
			description = "Favorite Screen",
			icon = Icons.Filled.Favorite,
			itemId = "favoriteScreen"
		)
		
		
	)
	
	val isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData()
	
	val emailId: MutableLiveData<String> = MutableLiveData()
	
	fun logout(){
		val firebaseAuth = FirebaseAuth.getInstance()
		
		firebaseAuth.signOut()
		
		val authStateListener = FirebaseAuth.AuthStateListener {
			if (it.currentUser == null) {
				Log.d(TAG, "Inside_signOut_success")
				AppRouter.navigateTo(Screen.LoginScreen)
			} else {
				Log.d(TAG, "Inside_signOut_inComplete")
			}
		}
		
		firebaseAuth.addAuthStateListener(authStateListener)
	}
	
	fun checkForActiveSession() {
		if(FirebaseAuth.getInstance().currentUser != null) {
			Log.d(TAG, "Valid Session")
			isUserLoggedIn.value = true
		}else{
			Log.d(TAG, "User is not logged in")
			isUserLoggedIn.value = false
		}	
	}
	
	fun getUserData(){
		FirebaseAuth.getInstance().currentUser?.also {
			it.email?.also { email ->
				emailId.value = email
			}
		}
	}
}