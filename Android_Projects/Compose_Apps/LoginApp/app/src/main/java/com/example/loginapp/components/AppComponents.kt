package com.example.loginapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.R
import com.example.loginapp.ui.theme.Primary
import com.example.loginapp.ui.theme.TextColor
import com.example.loginapp.ui.theme.componentShapes

@Composable
fun NormalTextComponents(value: String){
	Text(
		text = value,
		modifier = Modifier
			.fillMaxWidth()
			.heightIn(min = 40.dp),
		style = TextStyle(
			fontSize = 18.sp,
			fontWeight = FontWeight.Normal,
			fontStyle = FontStyle.Normal
		),
		color = TextColor,
		textAlign = TextAlign.Center
	)
}

@Composable
fun HeadingTextComponents(value: String){
	Text(
		text = value,
		modifier = Modifier
			.fillMaxWidth(),
		style = TextStyle(
			fontSize = 30.sp,
			fontWeight = FontWeight.Bold,
			fontStyle = FontStyle.Normal
		),
		color = TextColor,
		textAlign = TextAlign.Center
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldComponent(labelValue: String, imageVector: ImageVector){
	var textValue by remember {
		mutableStateOf("")
	}
	
	OutlinedTextField(
		modifier = Modifier
			.fillMaxWidth()
			.clip(componentShapes.small),
		label = { Text(text = labelValue) },
		colors = OutlinedTextFieldDefaults.colors(
			focusedBorderColor = Primary,
			focusedLabelColor = Primary,
			cursorColor = Primary
		),
		value = textValue,
		keyboardOptions = KeyboardOptions.Default,
		onValueChange = {
			textValue = it
		},
		leadingIcon ={
			Icon(imageVector = imageVector, contentDescription = "First name" )
		}
	)
}

@Composable
fun PasswordFieldComponent(labelValue: String, imageVector: ImageVector){
	var password by remember {
		mutableStateOf("")
	}
	
	val passwordVisible by remember {
		mutableStateOf(false)
	}
	OutlinedTextField(
		modifier = Modifier
			.fillMaxWidth()
			.clip(componentShapes.small),
		label = { Text(text = labelValue) },
		colors = OutlinedTextFieldDefaults.colors(
			focusedBorderColor = Primary,
			focusedLabelColor = Primary,
			cursorColor = Primary
		),
		value = password,
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
		onValueChange = {
			password = it
		},
		leadingIcon ={
			Icon(imageVector = imageVector, contentDescription = "First name" )
		},
		trailingIcon = {
			val iconImage = if(passwordVisible){
				Icons.Filled.Visibility
			}else{
				Icons.Filled.VisibilityOff
			}
			
			val description = if(passwordVisible){
				stringResource(R.string.hide_password)
			}else{
				stringResource(R.string.show_password)
			}
			
			IconButton(onClick = {passwordVisible != passwordVisible}) {
				Icon(imageVector = iconImage, contentDescription = description )
			}
		},
		visualTransformation = if(passwordVisible) VisualTransformation.None else
			PasswordVisualTransformation()
	)
}

@Composable
fun CheckboxComponent(value: String){
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.heightIn(56.dp)
			.padding(16.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		val checkedState by remember {
			mutableStateOf(false)
		}
		
		Checkbox(
			checked = checkedState,
			onCheckedChange = {
			checkedState != checkedState
		})
		
		NormalTextComponents(value = value)
	}
}