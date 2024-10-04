package com.giantnovadevs.mycalc.ui.uievents

import com.giantnovadevs.mycalc.data.CalculatorOperation

sealed class CalculatorUIEvents {
	data class Number(val number: Int): CalculatorUIEvents()
	object Clear: CalculatorUIEvents()
	object Delete: CalculatorUIEvents()
	object Decimal: CalculatorUIEvents()
	object Calculate: CalculatorUIEvents()
	data class Operation(val operation: CalculatorOperation): CalculatorUIEvents()
}