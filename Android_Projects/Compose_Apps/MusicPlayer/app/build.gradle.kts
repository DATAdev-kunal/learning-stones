plugins {
	alias(libs.plugins.androidApplication)
	alias(libs.plugins.jetbrainsKotlinAndroid) version("1.9.24")
	id("com.google.devtools.ksp")
	id("com.google.gms.google-services")
}

android {
	namespace = "com.example.musicplayer"
	compileSdk = 34
	
	defaultConfig {
		applicationId = "com.example.musicplayer"
		minSdk = 24
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}
	
	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.1"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
	
	//material design
	implementation("com.google.android.material:material:1.12.0")
	
	// Architectural Components
	implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
	
	// Lifecycle
	implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
	implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
	implementation ("androidx.lifecycle:lifecycle-runtime:2.2.0")
	implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
	
	// Coroutines
	implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
	implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
	
	// Coroutine Lifecycle Scopes
	implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
	implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
	
	// Navigation Component
	implementation ("androidx.navigation:navigation-fragment-ktx:2.3.0")
	implementation ("androidx.navigation:navigation-ui-ktx:2.3.0")
	
	// Glide
	implementation ("com.github.bumptech.glide:glide:4.11.0")
	ksp("groupId:artifactId:version")
	
	// Activity KTX for viewModels()
	implementation ("androidx.activity:activity-ktx:1.1.0")
	
	//Dagger - Hilt
	implementation("com.google.dagger:dagger-compiler:2.51.1")
	ksp("com.google.dagger:dagger-compiler:2.51.1")
	implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
	ksp ("androidx.hilt:hilt-compiler:1.0.0-alpha02")
	
	// Timber
	implementation ("com.jakewharton.timber:timber:4.7.1")
	
	// Firebase Firestore
	implementation("com.google.firebase:firebase-bom:33.0.0")
	implementation ("com.google.firebase:firebase-auth")
	implementation ("com.google.firebase:firebase-firestore")
	
	// Firebase Storage KTX
	implementation ("com.google.firebase:firebase-storage-ktx:19.2.0")
	
	// Firebase Coroutines
	implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.1.1")
	
	// ExoPlayer
	api ("com.google.android.exoplayer:exoplayer-core:2.11.8")
	api ("com.google.android.exoplayer:exoplayer-ui:2.11.8")
	api ("com.google.android.exoplayer:extension-mediasession:2.11.8")
}
