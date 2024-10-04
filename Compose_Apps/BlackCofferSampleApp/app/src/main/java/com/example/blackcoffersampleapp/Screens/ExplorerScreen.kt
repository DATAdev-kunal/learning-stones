package com.example.blackcoffersampleapp.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.blackcoffersampleapp.Components.BlackCofferAppBar
import com.example.blackcoffersampleapp.Components.BottomAppBar
import com.example.blackcoffersampleapp.Components.ProfileItem
import com.example.blackcoffersampleapp.Data.SearchViewModel
import com.example.blackcoffersampleapp.Data.TabItem
import com.example.blackcoffersampleapp.Data.profiles
import com.example.blackcoffersampleapp.Navigation.ScreenRoute
import com.example.blackcoffersampleapp.R
import com.example.blackcoffersampleapp.ui.theme.BlackCofferSampleAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplorerScreen(navController: NavController) {
	val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
	Scaffold(
		modifier = Modifier
			.fillMaxSize()
			.nestedScroll(scrollBehavior.nestedScrollConnection),
		topBar = {
			TopAppBar(
				title = {
					BlackCofferAppBar()
				},
				actions = {
					Box {
						Column(
							horizontalAlignment = Alignment.End,
							modifier = Modifier
						) {
							IconButton(
								onClick = {
									navController.navigate(
										ScreenRoute.RefineScreen.route
									)
								},
								modifier = Modifier
								
							) {
								Icon(
									painter = painterResource(R.drawable.filter),
									contentDescription
									= "Refine",
									modifier = Modifier
										.size(30.dp)
								)
							}
							Text(text = "Refine",
								fontSize = 13.sp)
						}
					}
				},
				scrollBehavior = scrollBehavior
			)
		},
		bottomBar = {
			BottomAppBar()
		},
		floatingActionButton = {
			FloatingActionButton(onClick = { /*TODO*/ }
			) {
				Icon(Icons.Default.Add, contentDescription = "Add icon")
			}
		},
		content = {values ->
			Surface {
				var selectedTabIndex by remember {
					mutableIntStateOf(0)
				}
				val tabBarItem = listOf(
					TabItem(title = "Personal"),
					TabItem(title = "Work"),
					TabItem(title = "Community"),
				)
				Column(modifier = Modifier
					.fillMaxSize()
					.padding(values)) {
					TabRow(selectedTabIndex = selectedTabIndex) {
						tabBarItem.forEachIndexed{index, tabItem ->
							Tab(
								selected = index == selectedTabIndex,
								onClick = {
									selectedTabIndex = index
								},
								text = { Text(text = tabItem.title) }
							)
						}
					}
					
					val viewModel = viewModel<SearchViewModel>()
					val searchText by viewModel.searchText.collectAsState()
					val persons by viewModel.persons.collectAsState()
					val isSearching by viewModel.isSearching.collectAsState()
					
					Column(modifier = Modifier
						.padding(top = 5.dp,bottom = 5.dp, start = 10.dp, end = 10.dp)) {
						OutlinedTextField(
							value = searchText,
							trailingIcon = {
								Icon(imageVector = Icons.Filled.Search, contentDescription =
								"Search")},
							onValueChange = viewModel::onSearchTextChange,
							placeholder = {Text(text = "Search")},
							shape = RoundedCornerShape(100),
							modifier = Modifier
								.fillMaxWidth()
						)
					}
					LazyColumn(
						modifier = Modifier
							.fillMaxSize()
					) {
						items(profiles) {
							ProfileItem(
								profile = it,
								modifier = Modifier
									.padding(dimensionResource(id = R.dimen.padding_small))
							)
						}
					}
				}
			}
		}
	)
}

@Preview(showSystemUi = true)
@Composable
fun BlackCofferSampleAppPreview(){
	BlackCofferSampleAppTheme {
		ExplorerScreen(navController = NavController(LocalContext.current))
	}
}