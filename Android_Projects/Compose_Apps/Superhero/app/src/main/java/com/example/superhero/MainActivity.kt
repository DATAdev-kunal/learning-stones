package com.example.superhero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.SuperheroAppTheme
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroRepo.heroes
import androidx.compose.material3.TopAppBar as TopAppBar

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			SuperheroAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier
						.fillMaxSize()
				) {
					SuperheroApp()
				}
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroApp() {
	Scaffold(
		topBar = {
			TopAppBar()
		}
	) {it ->
		LazyColumn(contentPadding = it) {
			items(heroes) {
				SuperheroItem(
					hero = it,
					modifier = Modifier
						.padding(dimensionResource(id = R.dimen.padding_small))
				)
			}
		}
	}
}

@Composable
fun SuperheroItem(
		hero: Hero,
		modifier: Modifier = Modifier
){
	Card(
		modifier = modifier
	) {
		Column(
			modifier = modifier
		) {
			Row(
				modifier = modifier
					.sizeIn(minHeight = 72.dp)
			) {
				SuperheroInformation(name = hero.name, description = hero.description)
				Spacer(modifier = Modifier.weight(1f))
				SuperheroIcon(heroIcon = hero.image)
			}
		}
	}
}

@Composable
fun SuperheroInformation(
		@StringRes name: Int,
		@StringRes description : Int,
		modifier: Modifier = Modifier
){
	Column(
		modifier = modifier
	) {
		Text(
			text = stringResource(name),
			style = MaterialTheme.typography.displaySmall,
			modifier = modifier
		)
		Text(
			text = stringResource(description),
			style = MaterialTheme.typography.bodyLarge,
			modifier = modifier
		)
	}
}

@Composable
fun SuperheroIcon(
		@DrawableRes heroIcon: Int,
		modifier: Modifier = Modifier
){
	Image(
		modifier = modifier
			.size(dimensionResource(R.dimen.image_size))
			.clip(MaterialTheme.shapes.medium),
		painter = painterResource(heroIcon),
		contentDescription = null
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(){
	CenterAlignedTopAppBar(
		title = {
			Row(horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
			){
				Text(
					maxLines = 1,
					softWrap = true,
					text = stringResource(id = R.string.app_name),
					style = MaterialTheme.typography.displayLarge,
					modifier = Modifier
				)
			}
		}
	)
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
fun SuperheroLightThemePreview() {
	SuperheroAppTheme(darkTheme = false) {
		SuperheroApp()
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SuperheroDarkThemePreview() {
	SuperheroAppTheme(darkTheme = true) {
		SuperheroApp()
	}
}