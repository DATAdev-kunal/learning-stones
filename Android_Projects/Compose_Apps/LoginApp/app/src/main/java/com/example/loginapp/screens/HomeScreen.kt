package com.example.loginapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.credentials.exceptions.domerrors.InvalidModificationError
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginapp.R
import com.example.loginapp.components.AppToolBar
import com.example.loginapp.components.ButtonComponent
import com.example.loginapp.components.DrawerContent
import com.example.loginapp.components.HeadingTextComponents
import com.example.loginapp.components.NavigationDrawerBody
import com.example.loginapp.components.NavigationDrawerHeader
import com.example.loginapp.components.NormalTextComponents
import com.example.loginapp.data.NavigationItem
import com.example.loginapp.data.home.HomeViewModel
import com.example.loginapp.data.signup.SignUpViewModel
import com.example.loginapp.ui.theme.BgColor
import com.example.loginapp.ui.theme.GrayColor
import com.example.loginapp.ui.theme.Primary
import kotlinx.coroutines.coroutineScope
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