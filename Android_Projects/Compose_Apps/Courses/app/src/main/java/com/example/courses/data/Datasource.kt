package com.example.courses.data

import androidx.privacysandbox.ads.adservices.topics.Topic
import com.example.courses.R
import com.example.courses.model.CourseInfo

class Datasource() {
	fun loadCourses(): List<CourseInfo> {
		return listOf(
			CourseInfo(R.string.architecture, R.string.architecture_count, R.drawable.architecture),
			CourseInfo(R.string.crafts, R.string.crafts_count, R.drawable.crafts),
			CourseInfo(R.string.business, R.string.business_count, R.drawable.business),
			CourseInfo(R.string.culinary, R.string.culinary_count, R.drawable.culinary),
			CourseInfo(R.string.design, R.string.design_count, R.drawable.design),
			CourseInfo(R.string.fashion, R.string.fashion_count, R.drawable.fashion),
			CourseInfo(R.string.film, R.string.film_count, R.drawable.film),
			CourseInfo(R.string.gaming, R.string.gaming_count, R.drawable.gaming),
			CourseInfo(R.string.drawing, R.string.drawing_count, R.drawable.drawing),
			CourseInfo(R.string.lifestyle, R.string.lifestyle_count, R.drawable.lifestyle),
			CourseInfo(R.string.music, R.string.music_count, R.drawable.music),
			CourseInfo(R.string.painting, R.string.painting_count, R.drawable.painting),
			CourseInfo(R.string.photography, R.string.photography_count, R.drawable.photography),
			CourseInfo(R.string.tech, R.string.tech_count, R.drawable.tech)
		)
	}
}