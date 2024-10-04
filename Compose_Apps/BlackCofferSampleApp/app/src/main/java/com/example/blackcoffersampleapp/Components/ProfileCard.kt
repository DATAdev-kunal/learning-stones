package com.example.blackcoffersampleapp.Components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackcoffersampleapp.Data.Profile
import com.example.blackcoffersampleapp.R

@Composable
fun ProfileItem(
		profile: Profile,
		modifier: Modifier = Modifier
) {
	var expanded by remember {
		mutableStateOf(false)
	}
	val color by animateColorAsState(
		targetValue = if(expanded) MaterialTheme.colorScheme.tertiaryContainer
		else MaterialTheme.colorScheme.primaryContainer, label = "animation color"
	)
	Card(
		modifier = modifier
	) {
		Column(
			modifier = Modifier
				.background(color = color)
				.animateContentSize(
					animationSpec = spring(
						dampingRatio = Spring.DampingRatioMediumBouncy,
						stiffness = Spring.StiffnessMediumLow
					)
				)
		) {
			Row(
				modifier = modifier
					.fillMaxWidth()
					.padding(dimensionResource(R.dimen.padding_small))
			) {
				ProfileIcon(profile.imageResourceId)
				ProfileInformation(profile.name, profile.age, profile.location, profile.profession)
				Spacer(modifier = Modifier.weight(1f))
				ProfileInfo(
					expanded = expanded,
					onClick = { expanded = ! expanded }
				)
			}
			if (expanded) {
				ProfileDescription(
					profile.hobbies,
					modifier = Modifier
						.padding(
							start = dimensionResource(R.dimen.padding_medium),
							top = dimensionResource(R.dimen.padding_small),
							end = dimensionResource(R.dimen.padding_medium),
							bottom = dimensionResource(R.dimen.padding_medium)
						)
				)
			}
		}
	}
}

@Composable
private fun ProfileInfo(
		expanded: Boolean,
		onClick: ()->Unit,
		modifier: Modifier = Modifier
){
	IconButton(
		onClick = onClick,
		modifier = modifier
	) {
		Icon(
			imageVector = if(expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
			contentDescription = stringResource(id = R.string.expand_button_content_description),
			tint = MaterialTheme.colorScheme.secondary
		)
	}
}

@Composable
fun ProfileDescription(
		@StringRes profileHobby: Int,
		modifier: Modifier = Modifier
){
	Column(
		modifier = modifier
	) {
		Text(
			text = stringResource(R.string.about),
			style = MaterialTheme.typography.labelSmall
		)
		Text(
			text = stringResource(profileHobby),
			style = MaterialTheme.typography.bodyLarge
		)
	}
}

@Composable
fun ProfileIcon(
		@DrawableRes profileIcon: Int,
		modifier: Modifier = Modifier
) {
	Image(
		modifier = modifier
			.size(dimensionResource(R.dimen.image_size))
			.padding(dimensionResource(R.dimen.padding_small))
			.clip(MaterialTheme.shapes.small),
		painter = painterResource(profileIcon),
		contentScale = ContentScale.Crop,
		
		contentDescription = null
	)
}

@Composable
fun ProfileInformation(
		@StringRes profileName: Int,
		profileAge: Int,
		profileLocation: Int,
		profileProfession: Int,
		modifier: Modifier = Modifier
) {
	Column(modifier = modifier){
		Row {
			Text(
				text = stringResource(profileName),
				style = MaterialTheme.typography.displayMedium,
				modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
			)
			Spacer(modifier = Modifier.padding(10.dp))
			Button(onClick = { /*TODO*/ },
				border = BorderStroke(5.dp, color = Color.White)
			) {
					Icon(imageVector = Icons.Filled.Add, contentDescription = "connect")
				Text(
					text = "Invite",
					style = MaterialTheme.typography.bodyLarge
				)
			}
		}
		Spacer(modifier = Modifier.padding(5.dp))
		Row {
			Text(
				text = stringResource(R.string.years_old, profileAge),
				style = MaterialTheme.typography.bodyLarge,
			)
			Text(
				text = stringResource(profileLocation),
				style = MaterialTheme.typography.bodyLarge,
			)
			Text(
				text = stringResource(profileProfession),
				style = MaterialTheme.typography.bodyLarge,
			)
		}
		Spacer(modifier = Modifier.padding(10.dp))
		Row {
			Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "")
			Text(text = "Dating  |")
			Spacer(modifier = Modifier.padding(8.dp))
			Icon(imageVector = Icons.Outlined.Face, contentDescription = "")
			Text(text = "Meetup  |")
			Spacer(modifier = Modifier.padding(8.dp))
			Icon(imageVector = Icons.Outlined.LocationOn, contentDescription = "")
			Text(text = "Trip")
		}
	}
}

@Preview(showSystemUi = false)
@Composable
fun ProfileItemPreview(){
	ProfileItem(
		Profile(R.drawable.android, R.string.profile_name1, 21, R.string.profile_description1, R.string.profile_location1, R.string.profile_profession1)
	)
}