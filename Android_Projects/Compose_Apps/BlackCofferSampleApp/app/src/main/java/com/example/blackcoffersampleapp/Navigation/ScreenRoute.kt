package com.example.blackcoffersampleapp.Navigation

sealed class ScreenRoute(val route: String){
	object RefineScreen: ScreenRoute("refine")
	object ExplorerScreen: ScreenRoute("explore")
	
}
