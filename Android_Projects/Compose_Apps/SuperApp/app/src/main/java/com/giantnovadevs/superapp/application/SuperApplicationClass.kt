package com.giantnovadevs.superapp.application

import android.app.Application
import com.google.firebase.FirebaseApp

class SuperApplicationClass: Application() {
	override fun onCreate() {
		super.onCreate()
		
		FirebaseApp.initializeApp(this)
	}
}