package com.example.fordreams

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ForDreamsTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ForDreamsTheme {
				Surface(
					modifier = Modifier.fillMaxSize()
				) {
					ForDreamsApp()
				}
			}
		}
	}
}

@Composable
fun ForDreamsApp() {

}
@Composable
fun DreamItems(
		modifier: Modifier = Modifier
){
	Card(
		modifier = modifier
			.background(color = Color(R.color.purple_500))
			.wrapContentSize()
			.fillMaxWidth(0.8f)
			.padding(10.dp)
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier =  Modifier
			
		) {
			Text(
				text = "Univ_name"
			)
			Row(
				modifier = Modifier
			) {
				Text(
					text = "Welcome",
					modifier = modifier
						.padding(dimensionResource(id = R.dimen.padding_medium))
				)
			}
			Image(
				painter = painterResource(R.drawable.images),
				contentDescription = "univ image",
				modifier = Modifier
					.sizeIn(dimensionResource(id = R.dimen.image_size))
			)
		}
	}
}
@Composable
fun UniversityDetails(
	@StringRes universityName: Int,

){

}
@Preview(showBackground = true)
@Composable
fun ForDreamsPreview() {
	ForDreamsTheme {
		ForDreamsApp()
	}
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun CardPreview(){
	DreamItems()
}