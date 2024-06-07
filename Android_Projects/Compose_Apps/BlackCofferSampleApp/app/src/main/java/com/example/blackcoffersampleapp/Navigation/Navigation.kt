package com.example.blackcoffersampleapp.Navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blackcoffersampleapp.Screens.ExplorerScreen
import com.example.blackcoffersampleapp.Screens.RefineScreen

@Composable
fun BlackCofferApp(){
	val navController = rememberNavController()
	
	NavHost(
		navController = navController,
		startDestination = ScreenRoute.ExplorerScreen.route
	) {
		composable(route = ScreenRoute.ExplorerScreen.route,
			enterTransition = {
				when (ScreenRoute.ExplorerScreen.route) {
					"explore" ->
						slideIntoContainer(
							AnimatedContentTransitionScope.SlideDirection.Right,
							animationSpec = tween(350)
						)
					
					else -> null
				}
			}){
			ExplorerScreen(navController = navController)
		}
		composable(
			route = ScreenRoute.RefineScreen.route,
			enterTransition = {
				when (ScreenRoute.RefineScreen.route) {
					"refine" ->
						slideIntoContainer(
							AnimatedContentTransitionScope.SlideDirection.Left,
							animationSpec = tween(500)
						)
					
					else -> null
				}
			},
		){
			RefineScreen(navController = navController)
		}
	}
}

