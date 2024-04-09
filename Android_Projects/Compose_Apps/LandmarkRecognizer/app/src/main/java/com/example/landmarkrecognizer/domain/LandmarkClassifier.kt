package com.example.landmarkrecognizer.domain

import android.graphics.Bitmap
import androidx.compose.ui.graphics.vector.VectorProperty

interface LandmarkClassifier {
	
	fun classify(bitmap: Bitmap, rotation: Int): List<Classification>
}