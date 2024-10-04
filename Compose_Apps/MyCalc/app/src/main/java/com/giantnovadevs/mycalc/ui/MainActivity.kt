package com.giantnovadevs.mycalc.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.giantnovadevs.mycalc.application.CalculatorApp
import com.giantnovadevs.mycalc.ui.theme.MediumGray
import com.giantnovadevs.mycalc.ui.theme.MyCalcTheme
import com.giantnovadevs.mycalc.ui.viewModel.CalculatorViewModel

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			
			val viewModel = viewModel<CalculatorViewModel>()
			val state = viewModel.state
			val buttonSpacing = 8.dp
			CalculatorApp(
				state = state,
				onAction = viewModel::onAction,
				buttonSpacing = buttonSpacing,
				modifier = Modifier
					.fillMaxSize()
					.background(MediumGray)
					.padding(16.dp)
			)
		}
	}
}

