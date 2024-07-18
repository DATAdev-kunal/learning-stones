package com.giantnovadevs.mycalc.application

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.giantnovadevs.mycalc.components.CalculatorButton
import com.giantnovadevs.mycalc.data.CalculatorOperation
import com.giantnovadevs.mycalc.ui.states.CalculatorState
import com.giantnovadevs.mycalc.ui.theme.LightGray
import com.giantnovadevs.mycalc.ui.theme.MediumGray
import com.giantnovadevs.mycalc.ui.theme.MyCalcTheme
import com.giantnovadevs.mycalc.ui.theme.Orange
import com.giantnovadevs.mycalc.ui.uievents.CalculatorUIEvents
import com.giantnovadevs.mycalc.ui.viewModel.CalculatorViewModel


@Composable
fun CalculatorApp(
		state: CalculatorState,
		modifier: Modifier = Modifier,
		onAction: (CalculatorUIEvents) -> Unit,
		buttonSpacing: Dp = 8.dp
) {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(MediumGray)
			.padding(16.dp)
		
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.align(Alignment.BottomCenter),
			verticalArrangement = Arrangement.spacedBy(buttonSpacing)
		) {
			Text(
				text = state.number1 + (state.operation?.symbol?: "") + state.number2,
				textAlign = TextAlign.End,
				color = Color.White,
				modifier = Modifier
					.fillMaxWidth()
					.padding(32.dp),
				fontWeight = FontWeight.Light,
				fontSize = 80.sp,
				maxLines = 2
			)
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
			) {
				CalculatorButton(
					symbol = "AC",
					onclick = {
							  onAction(CalculatorUIEvents.Clear)
					},
					modifier = Modifier
						.background(LightGray)
						.aspectRatio(2f)
						.weight(2f)
				)
				CalculatorButton(
					symbol = "del",
					onclick = {
						onAction(CalculatorUIEvents.Delete)
					},
					modifier = Modifier
						.background(LightGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "/",
					onclick = {
						onAction(CalculatorUIEvents.Operation(CalculatorOperation.Divide))
					},
					modifier = Modifier
						.background(Orange)
						.aspectRatio(1f)
						.weight(1f)
				)
			}
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
			) {
				CalculatorButton(
					symbol = "7",
					onclick = {
						onAction(CalculatorUIEvents.Number(7))
					},
					modifier = Modifier
						.background(Color.DarkGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "8",
					onclick = {
						onAction(CalculatorUIEvents.Number(8))
					},
					modifier = Modifier
						.background(Color.DarkGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "9",
					onclick = {
						onAction(CalculatorUIEvents.Number(9))
					},
					modifier = Modifier
						.background(Color.DarkGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "x",
					onclick = {
						onAction(CalculatorUIEvents.Operation(CalculatorOperation.Multiply))
					},
					modifier = Modifier
						.background(Orange)
						.aspectRatio(1f)
						.weight(1f)
				)
			}
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
			) {
				CalculatorButton(
					symbol = "4",
					onclick = {
						onAction(CalculatorUIEvents.Number(4))
					},
					modifier = Modifier
						.background(Color.DarkGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "5",
					onclick = {
						onAction(CalculatorUIEvents.Number(5))
					},
					modifier = Modifier
						.background(Color.DarkGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "6",
					onclick = {
						onAction(CalculatorUIEvents.Number(6))
					},
					modifier = Modifier
						.background(Color.DarkGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "-",
					onclick = {
						onAction(CalculatorUIEvents.Operation(CalculatorOperation.Subtract))
					},
					modifier = Modifier
						.background(Orange)
						.aspectRatio(1f)
						.weight(1f)
				)
			}
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
			) {
				CalculatorButton(
					symbol = "1",
					onclick = {
						onAction(CalculatorUIEvents.Number(1))
					},
					modifier = Modifier
						.background(Color.DarkGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "2",
					onclick = {
						onAction(CalculatorUIEvents.Number(2))
					},
					modifier = Modifier
						.background(Color.DarkGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "3",
					onclick = {
						onAction(CalculatorUIEvents.Number(3))
					},
					modifier = Modifier
						.background(Color.DarkGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "+",
					onclick = {
						onAction(CalculatorUIEvents.Operation(CalculatorOperation.Add))
					},
					modifier = Modifier
						.background(Orange)
						.aspectRatio(1f)
						.weight(1f)
				)
			}
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
			) {
				CalculatorButton(
					symbol = "0",
					onclick = {
						onAction(CalculatorUIEvents.Number(0))
					},
					modifier = Modifier
						.background(LightGray)
						.aspectRatio(2f)
						.weight(2f)
				)
				CalculatorButton(
					symbol = ".",
					onclick = {
						onAction(CalculatorUIEvents.Decimal)
					},
					modifier = Modifier
						.background(LightGray)
						.aspectRatio(1f)
						.weight(1f)
				)
				CalculatorButton(
					symbol = "=",
					onclick = {
						onAction(CalculatorUIEvents.Calculate)
					},
					modifier = Modifier
						.background(Orange)
						.aspectRatio(1f)
						.weight(1f)
				)
			}
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculatorAppPreview() {
	CalculatorApp(state = CalculatorState(), onAction = {})
}