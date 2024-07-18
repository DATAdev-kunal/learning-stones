package com.giantnovadevs.bankappui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.widget.ConstraintLayout

@Composable
fun Dashboard(){
	Column(
		Modifier
			.fillMaxHeight()
			.fillMaxWidth()
			.background(
				color = Color(android.graphics.Color.parseColor("#f8eeec"))
			),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		
	}
}

@Preview(showSystemUi = true)
@Composable
fun DashBoardPreview(){
	Dashboard()
}
