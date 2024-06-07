package com.example.loginapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginapp.R
import com.example.loginapp.components.CheckboxComponent
import com.example.loginapp.components.HeadingTextComponents
import com.example.loginapp.components.MyTextFieldComponent
import com.example.loginapp.components.NormalTextComponents
import com.example.loginapp.components.PasswordFieldComponent

@Composable
fun SignUpScreen(){
	Surface(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.padding(28.dp)
	) {
		Column(
			modifier = Modifier
			.fillMaxSize()
		) {
			NormalTextComponents(stringResource(id = R.string.hello))
			
			HeadingTextComponents(stringResource(id = R.string.welcome_text))
			Spacer(modifier = Modifier.heightIn(20.dp))
			
			MyTextFieldComponent(
				labelValue = stringResource(id = R.string.first_name),
				imageVector = Icons.Outlined.Person
			)
			Spacer(modifier = Modifier.heightIn(20.dp))
			
			MyTextFieldComponent(
				labelValue = stringResource(id = R.string.last_name),
				imageVector = Icons.Outlined.Person
			)
			Spacer(modifier = Modifier.heightIn(20.dp))
			
			MyTextFieldComponent(
				labelValue = stringResource(id = R.string.email),
				imageVector = Icons.Outlined.MailOutline
			)
			Spacer(modifier = Modifier.heightIn(20.dp))
			
			PasswordFieldComponent(
				labelValue = stringResource(id = R.string.password),
				imageVector = Icons.Outlined.Lock
			)
			
			CheckboxComponent(value = stringResource(id = R.string.terms_conditions))
		}
	}
}

@Preview(showSystemUi = true)
@Composable
fun SignUpScreenPreview(){
	SignUpScreen()
}