package com.giantnovadevs.superapp.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.giantnovadevs.superapp.R
import com.giantnovadevs.superapp.data.local.entities.NavigationItem
import com.giantnovadevs.superapp.ui.theme.AccentColor
import com.giantnovadevs.superapp.ui.theme.GrayColor
import com.giantnovadevs.superapp.ui.theme.Primary
import com.giantnovadevs.superapp.ui.theme.Secondary
import com.giantnovadevs.superapp.ui.theme.TextColor
import com.giantnovadevs.superapp.ui.theme.WhiteColor
import com.giantnovadevs.superapp.ui.theme.componentShapes
import com.giantnovadevs.superapp.ui.viewModels.HomeViewModel

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
fun MyTextFieldComponent(
		labelValue: String,
		imageVector: ImageVector,
		onTextChanged: (String) -> Unit,
		errorStatus: Boolean = false
){
	var textValue by remember {
		mutableStateOf("")
	}
	val localFocusManager = LocalFocusManager.current
	OutlinedTextField(
		modifier = Modifier
			.fillMaxWidth()
			.clip(componentShapes.small),
		label = { Text(text = labelValue) },
		shape = RoundedCornerShape(20.dp),
		colors = OutlinedTextFieldDefaults.colors(
			focusedBorderColor = Primary,
			focusedLabelColor = Primary,
			cursorColor = Primary
		),
		value = textValue,
		singleLine = true,
		maxLines = 1,
		keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
		onValueChange = {
			textValue = it
			onTextChanged(it)
		},
		leadingIcon ={
			Icon(imageVector = imageVector, contentDescription = "First name" )
		},
		isError = !errorStatus
	)
}

@Composable
fun PasswordFieldComponent(
		labelValue: String,
		imageVector: ImageVector,
		onTextSelected: (String) -> Unit,
		errorStatus: Boolean = false
){
	var password by remember {
		mutableStateOf("")
	}
	
	val localFocusManager = LocalFocusManager.current
	
	var passwordVisible by remember {
		mutableStateOf(false)
	}
	
	OutlinedTextField(
		modifier = Modifier
			.fillMaxWidth()
			.clip(componentShapes.small),
		label = { Text(text = labelValue) },
		shape = RoundedCornerShape(20.dp),
		colors = OutlinedTextFieldDefaults.colors(
			focusedBorderColor = Primary,
			focusedLabelColor = Primary,
			cursorColor = Primary
		),
		value = password,
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
		keyboardActions = KeyboardActions{
						  localFocusManager.clearFocus()
		},
		singleLine = true,
		maxLines = 1,
		onValueChange = {
			password = it
			onTextSelected(it)
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
			
			IconButton(onClick = {passwordVisible = !passwordVisible}) {
				Icon(imageVector = iconImage, contentDescription = description )
			}
		},
		visualTransformation = if(passwordVisible) VisualTransformation.None else
			PasswordVisualTransformation(),
		isError = !errorStatus
	)
}

@Composable
fun CheckboxComponent(
		value: String,
		onTextSelected: (String)-> Unit,
		onCheckedChange: (Boolean) -> Unit
){
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.heightIn(56.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		var checkedState by remember {
			mutableStateOf(false)
		}
		Checkbox(
			checked = checkedState,
			onCheckedChange = {
			checkedState = !checkedState
				onCheckedChange.invoke(it)
			}
		)
		
		ClickableTextComponent(
			value = value,
			onTextSelected
		)
	}
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String)-> Unit){
	val initialText = "By continuing you accept our "
	val privacyText = "Privacy Policy "
	val andText = "and "
	val termsAndConditionsText = "Terms of Use"
	
	val annotatedString = buildAnnotatedString {
		append(initialText)
		withStyle(style = SpanStyle(color = Primary)){
			pushStringAnnotation(tag = privacyText, annotation = privacyText)
			append(privacyText)
		}
		append(andText)
		withStyle(style = SpanStyle(color = Primary)){
			pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
			append(termsAndConditionsText)
		}
	}
	
	ClickableText(
		text = annotatedString,
		onClick = {offset ->
			annotatedString.getStringAnnotations(offset, offset)
				.firstOrNull()?.also{span ->
					Log.d("ClickableTextComponent", "{${span.item}}")
					
					if((span.item == termsAndConditionsText) || (span.item == privacyText)){
						onTextSelected(span.item)
					}
				}
		}
	)
}
@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean, onTextSelected: (String)-> Unit){
	val initialText = if(tryingToLogin)"Already have an account? " else "Don't have an account yet?"
	val loginText = if(tryingToLogin)"Login" else "Register"
	
	val annotatedString = buildAnnotatedString {
		append(initialText)
		withStyle(style = SpanStyle(color = Primary)){
			pushStringAnnotation(tag = loginText, annotation = loginText)
			append(loginText)
		}
	}
	
	ClickableText(
		modifier = Modifier
			.fillMaxWidth()
			.heightIn(min = 40.dp),
		style = TextStyle(
			fontSize = 16.sp,
			fontWeight = FontWeight.Normal,
			fontStyle = FontStyle.Normal,
			textAlign = TextAlign.Center
		),
		text = annotatedString,
		onClick = {offset ->
			annotatedString.getStringAnnotations(offset, offset)
				.firstOrNull()?.also{span ->
					Log.d("ClickableTextComponent", "{${span.item}}")
					
					if(span.item == loginText){
						onTextSelected(span.item)
					}
				}
		}
	)
}
@Composable
fun ButtonComponent(value: String, onButtonClicked: ()-> Unit, isEnabled: Boolean = false){
	Button(
		modifier = Modifier
			.fillMaxWidth()
			.heightIn(48.dp),
		onClick = {
				  onButtonClicked.invoke()
		},
		contentPadding = PaddingValues(),
		colors = ButtonDefaults.buttonColors(Color.Transparent),
		shape = RoundedCornerShape(50.dp),
		enabled = isEnabled
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.heightIn(48.dp)
				.background(
					brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
					shape = RoundedCornerShape(50.dp)
				),
			contentAlignment = Alignment.Center
		){
			Text(
				text = value,
				fontSize = 18.sp,
				fontWeight = FontWeight.Bold
			)
		}
	}
}

@Composable
fun DividerComponent(){
	Row(
		modifier = Modifier.fillMaxWidth(),
		verticalAlignment = Alignment.CenterVertically
	) {
		Divider(modifier = Modifier
			.fillMaxWidth()
			.weight(1f),
			thickness = 1.dp,
			color = GrayColor
		)
		Text(
			text = "or",
			fontSize = 18.sp,
			modifier = Modifier
				.padding(8.dp)
		)
		Divider(modifier = Modifier
			.fillMaxWidth()
			.weight(1f),
			thickness = 1.dp,
			color = GrayColor
		)
	}
}

@Composable
fun UnderlinedTextComponents(value: String){
	Text(
		text = value,
		modifier = Modifier
			.fillMaxWidth()
			.heightIn(min = 40.dp),
		style = TextStyle(
			fontSize = 16.sp,
			fontWeight = FontWeight.Normal,
			fontStyle = FontStyle.Normal
		),
		color = GrayColor,
		textAlign = TextAlign.Center,
		textDecoration = TextDecoration.Underline
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar(
		toolbarTitle: String,
		logoutButtonClicked: () -> Unit,
		navigationIconClicked: () -> Unit
){
	TopAppBar(
		colors = TopAppBarDefaults.topAppBarColors(Primary),
		title = {
			Text(
				text = toolbarTitle,
				color = WhiteColor
			)
		},
		actions = {
			IconButton(
				onClick = {
					logoutButtonClicked.invoke()
				}
			) {
				Icon(
					imageVector = Icons.Filled.Logout,
					contentDescription = "logout",
					tint = WhiteColor
				)
			}
		},
		navigationIcon = {
			IconButton(
				onClick = {
					navigationIconClicked.invoke()
				}
			) {
				Icon(imageVector = Icons.Outlined.Menu, contentDescription = "Open drawer")
			}
		}
	)
}

@Composable
fun DrawerContent(homeViewModel: HomeViewModel = viewModel(), modifier: Modifier) {
	ModalDrawerSheet{
		NavigationDrawerHeader(homeViewModel.emailId.value)
		NavigationDrawerBody(
			navigationDrawerItems = homeViewModel.navigationItemList,
			onNavigationItemClicked = {
			}
		)
	}
}
@Composable
fun NavigationDrawerHeader(value: String?) {
	Box(
		modifier = Modifier
			.background(
				Brush.horizontalGradient(
					listOf(Primary, Secondary)
				)
			)
			.fillMaxWidth()
			.height(180.dp)
			.padding(32.dp)
	) {
		NavigationDrawerText(
			title = value?: stringResource(id = R.string.navigation_header), 28.sp , AccentColor
		)
	}
}

@Composable
fun NavigationDrawerBody(navigationDrawerItems: List<NavigationItem>,
                         onNavigationItemClicked:(NavigationItem) -> Unit) {
	LazyColumn{
		items(navigationDrawerItems) {
			NavigationItemRow(item = it,onNavigationItemClicked)
		}
		
	}
}

@Composable
fun NavigationItemRow(
	item: NavigationItem,
	onNavigationItemClicked:(NavigationItem) -> Unit
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.clickable {
				onNavigationItemClicked.invoke(item)
			}
			.padding(all = 16.dp)
	) {
		Icon(
			imageVector = item.icon,
			contentDescription = item.description,
		)
		Spacer(modifier = Modifier.width(18.dp))
		
		NavigationDrawerText(title = item.title, 18.sp, Primary)
	}
}

@Composable
fun NavigationDrawerText(title: String, textUnit: TextUnit, color: Color) {
	
	val shadowOffset = Offset(4f, 4f)
	
	Text(
		text = title, style = TextStyle(
			color = Color.Black,
			fontSize = textUnit,
			fontStyle = FontStyle.Normal,
			shadow = Shadow(
				color = Primary,
				offset = shadowOffset, 2f
			)
		)
	)
}