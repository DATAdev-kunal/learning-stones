package com.example.blackcoffersampleapp.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.blackcoffersampleapp.Components.CategoryFilterChip
import com.example.blackcoffersampleapp.Components.SliderMinimalExample
import com.example.blackcoffersampleapp.Components.StatusDropdownMenu
import com.example.blackcoffersampleapp.Navigation.ScreenRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefineScreen(navController: NavController){
	Column(horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier.padding(top = 10.dp)) {
		Column(
			verticalArrangement = Arrangement.spacedBy(25.dp),
			modifier = Modifier
				.padding(20.dp)
		) {
			Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
				Text(
					text = "Show your Availability",
					style = MaterialTheme.typography.bodyLarge
				)
				StatusDropdownMenu()
			}
			Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
				Text(
					text = "Write your Status",
					style = MaterialTheme.typography.bodyLarge
				)
				StatusBoxTextField(keyboardOptions = KeyboardOptions.Default, value = "",
					onValueChanged = {})
			}
			Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
				Text(
					text = "Select discovery range",
					style = MaterialTheme.typography.bodyLarge
				)
				SliderMinimalExample()
			}
			Column {
				Text(
					text = "Select Category",
					style = MaterialTheme.typography.bodyLarge
				)
				Row(
					horizontalArrangement = Arrangement.spacedBy(8.dp),
					modifier = Modifier
						.padding(8.dp)
				) {
					CategoryFilterChip("Dating")
					CategoryFilterChip("Business")
					CategoryFilterChip("Matrimony")
				}
				Row(
					horizontalArrangement = Arrangement.spacedBy(8.dp),
					modifier = Modifier
						.padding(8.dp)
				) {
					CategoryFilterChip("Entrepreneurship")
					CategoryFilterChip("Coffee")
					CategoryFilterChip("Dinning")
				}
				Row(
					horizontalArrangement = Arrangement.spacedBy(8.dp),
					modifier = Modifier
						.padding(8.dp)
				) {
					CategoryFilterChip("Trip")
					CategoryFilterChip("Adventure Sport")
					CategoryFilterChip("Movie")
				}
			}
		}
		Column(
			modifier = Modifier) {
			Button(onClick = { navController.navigate(ScreenRoute.ExplorerScreen.route) }
			) {
				Text(
					text = "Apply",
					style = MaterialTheme.typography.displaySmall
				)
			}
		}
	}
}

//RangeSlider


@Composable
fun StatusBoxTextField(
		keyboardOptions: KeyboardOptions,
		value: String,
		onValueChanged: (String) -> Unit,
		modifier: Modifier = Modifier
){
	var statusText by remember {
		mutableStateOf("")
	}
	OutlinedTextField(
		value = statusText,
		leadingIcon = { Icon(imageVector = Icons.Filled.Edit, contentDescription = null
		) },
		onValueChange = { statusText = it },
		label = { Text(text = "Status") },
		singleLine = true,
		shape = RoundedCornerShape(12.dp),
		keyboardOptions = keyboardOptions,
		modifier = Modifier
			.fillMaxWidth()
	)
}
@Preview(showSystemUi = true)
@Composable
fun RefineScreenPreview(){
	RefineScreen(navController = NavController(LocalContext.current))
}