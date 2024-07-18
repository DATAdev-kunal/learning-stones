package com.giantnovadevs.mycalc.ui.states

import com.giantnovadevs.mycalc.data.CalculatorOperation

data class CalculatorState (
	val number1: String = "",
	val number2: String = "",
	val operation: CalculatorOperation? = null
)