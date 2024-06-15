package com.example.loginapp.app

import android.app.Application
import android.content.Context
import com.google.firebase.FirebaseApp

class LoginApp: Application() {
	override fun onCreate() {
		super.onCreate()
		
		FirebaseApp.initializeApp(this)
	}
}