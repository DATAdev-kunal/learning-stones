package com.example.blackcoffersampleapp.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blackcoffersampleapp.R
import com.example.blackcoffersampleapp.Navigation.ScreenRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlackCofferAppBar(
){
	TopAppBar(
		navigationIcon = {
			Image(
				painter = painterResource(R.drawable.blackcoffer), contentDescription = null,
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_small))
					.size(dimensionResource(id = R.dimen.top_app_bar_image))
			)
		},
		title = {
			Text(
				text = "BlackCoffer Sample App",
//					style = MaterialTheme.typography.displaySmall
			)
		}
	)
}

@Preview(showSystemUi = false)
@Composable
fun BlackCofferAppBarPreview(){
	BlackCofferAppBar()
}