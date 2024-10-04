package com.example.superhero.model

import com.example.superhero.R

object HeroRepo {
	val heroes = listOf(
		Hero(
			name = R.string.hero1,
			description = R.string.description1,
			image = R.drawable.hero_1
		),
		Hero(
			name = R.string.hero2,
			description = R.string.description2,
			image = R.drawable.hero_2
		),
		Hero(
			name = R.string.hero3,
			description = R.string.description3,
			image = R.drawable.hero_3
		),
		Hero(
			name = R.string.hero4,
			description = R.string.description4,
			image = R.drawable.hero_4
		),
		Hero(
			name = R.string.hero5,
			description = R.string.description5,
			image = R.drawable.hero_5
		),
		Hero(
			name = R.string.hero6,
			description = R.string.description6,
			image = R.drawable.hero_6
		)
	)
}