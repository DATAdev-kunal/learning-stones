package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class CourseInfo(
	@StringRes val courseName: Int,
	@StringRes val courseCount: Int,
	@DrawableRes val courseImage: Int
)