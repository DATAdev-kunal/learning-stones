package com.example.navigationScreenApp

sealed class Screen(val route: String) {
	object MainScreen : Screen("main_Screen")
	object DetailScreen : Screen("detail_Screen")
	fun withArgs(vararg args: String): String{
		return buildString {
			append(route)
			args.forEach {arg ->
				append("/$arg")
			}
		}
	}
}