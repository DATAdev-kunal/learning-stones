package com.example.fordreams

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ForDreamsTheme

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
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier =  Modifier
				.fillMaxSize()
			
		) {
			Text(
				text = "Univ_name"
			)
			Text(
				text = "Welcome",
				modifier = modifier
					.padding(dimensionResource(id = R.dimen.padding_medium))
			)
			Image(painter = painterResource(id = R.id.), contentDescription = )
		}
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	ForDreamsTheme {
		ForDreamsApp()
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardPreview(){
	DreamItems()
}