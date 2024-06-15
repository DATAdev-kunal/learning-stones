package com.example.mycalc.data

sealed class CalculatorUIEvents {
	data class Number(val number: Int): CalculatorUIEvents()
	object Clear: CalculatorUIEvents()
	object Delete: CalculatorUIEvents()
	object Decimal: CalculatorUIEvents()
	object Calculate: CalculatorUIEvents()
	data class Operation(val operation: CalculatorOperation): CalculatorUIEvents()
}