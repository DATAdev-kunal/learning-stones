package com.example.blackcoffersampleapp.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults.ContainerColor
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatusDropdownMenu() {
	val context = LocalContext.current
	val status = arrayOf(
		"Let's Connect",
		"Available now",
		"Wanna Hangout !",
		"On work, Do not disturb",
		"Join my Community"
	)
	var expanded by remember { mutableStateOf(false) }
	var selectedText by remember { mutableStateOf(status[0]) }
	
	Box(
		modifier = Modifier
	) {
		ExposedDropdownMenuBox(
			expanded = expanded,
			onExpandedChange = {
				expanded = !expanded
			}
		) {
			OutlinedTextField(
				value = selectedText,
				onValueChange = {},
				shape = RoundedCornerShape(12.dp),
				readOnly = true,
				trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
				modifier = Modifier
					.menuAnchor()
					.fillMaxWidth()
			)
			
			ExposedDropdownMenu(
				expanded = expanded,
				onDismissRequest = { expanded = false }
			) {
				status.forEach { item ->
					DropdownMenuItem(
						text = { Text(text = item) },
						onClick = {
							selectedText = item
							expanded = false
						}
					)
				}
			}
		}
	}
}

@Preview(showSystemUi = false)
@Composable
fun DropdownPreview(){
	StatusDropdownMenu()
}