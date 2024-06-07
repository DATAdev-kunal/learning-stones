package com.example.blackcoffersampleapp.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blackcoffersampleapp.Data.BottomNavigationItem

val items = listOf(
	BottomNavigationItem(
		title = "Explore",
		selectedIcon = Icons.Filled.Place,
		unselectedIcon = Icons.Outlined.Place,
		hasNews = false,
	),
	BottomNavigationItem(
		title = "Requests",
		selectedIcon = Icons.Filled.Person,
		unselectedIcon = Icons.Outlined.Person,
		hasNews = false,
		badgeCount = 45
	),
	BottomNavigationItem(
		title = "Chats",
		selectedIcon = Icons.Filled.MailOutline,
		unselectedIcon = Icons.Outlined.MailOutline,
		hasNews = false,
		badgeCount = 12
	),
	BottomNavigationItem(
		title = "Contacts",
		selectedIcon = Icons.Filled.AccountBox,
		unselectedIcon = Icons.Outlined.AccountBox,
		hasNews = false
	),
	BottomNavigationItem(
		title = "Settings",
		selectedIcon = Icons.Filled.Settings,
		unselectedIcon = Icons.Outlined.Settings,
		hasNews = true
	)

)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBar(
		modifier: Modifier = Modifier
){
	var selectedItemIndex by rememberSaveable {
		mutableIntStateOf(0)
	}
	NavigationBar {
		items.forEachIndexed { index, item ->
			NavigationBarItem(
				selected = selectedItemIndex == index,
				onClick = {
						  selectedItemIndex = index
//					navController.navigate(item.title)
				},
				label = {
						Text(text = item.title)
				},
				alwaysShowLabel = true,
				icon
				= {
					BadgedBox(
						badge = {
							if(item.badgeCount != null){
								Badge{
									Text(text = item.badgeCount.toString())
								}
							}else if (item.hasNews){
								Badge()
							}
						}
					) {
						Icon(
							imageVector = if(index == selectedItemIndex){
								item.selectedIcon
							}else item.unselectedIcon
							, contentDescription = item.title
						)
					}
				}
			)
		}
	}
}

@Preview(showSystemUi = false)
@Composable
fun BottomBarPreview(){
	BottomAppBar()
}