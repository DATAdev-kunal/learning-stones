package com.giantnovadevs.superapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.giantnovadevs.superapp.R
import com.giantnovadevs.superapp.ui.components.AppToolBar
import com.giantnovadevs.superapp.ui.components.DrawerContent
import com.giantnovadevs.superapp.ui.theme.GrayColor
import com.giantnovadevs.superapp.ui.viewModels.HomeViewModel
import kotlinx.coroutines.launch

//@Composable
//fun HomeScreen(signUpViewModel: SignUpViewModel = viewModel()) {
//	Scaffold (
//		topBar = {
//			AppToolBar(
//				toolbarTitle = "Home",
//				logoutButtonClicked = {
//					signUpViewModel.logout()
//				}
//			)
//		},
//
//	){
//		Surface(
//			modifier = Modifier
//				.fillMaxSize()
//				.background(Color.White)
//				.padding(it)
//		) {
//			Column(
//				modifier = Modifier
//					.fillMaxSize()
//			) {
//
//			}
//		}
//	}
//}
//
//@Preview(showSystemUi = true)
//@Composable
//fun HomeScreenPreview(){
//	HomeScreen()
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
	
	val drawerState = rememberDrawerState(DrawerValue.Closed)
	val scope = rememberCoroutineScope()
	
	homeViewModel.getUserData()
	// ModalDrawer composable to set up the layout with a drawer
	ModalNavigationDrawer(
		scrimColor = GrayColor,
		drawerState = drawerState,
		gesturesEnabled = drawerState.isOpen,
		drawerContent = {
			DrawerContent(modifier = Modifier
				.wrapContentWidth(unbounded = true)
			)
		},
		content = {
			Scaffold(
				topBar = {
					AppToolBar(
						toolbarTitle = stringResource(id = R.string.home),
						logoutButtonClicked = {
							homeViewModel.logout()
						},
						navigationIconClicked = {
							scope.launch {
								drawerState.open()
							}
						}
					)
				}
			){  innerPadding ->
				Column(
					modifier = Modifier
						.padding(innerPadding)
				) {
					Text(text = "Hello World !")
				}
			}
		}
	)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	HomeScreen()
}