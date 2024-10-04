package com.giantnovadevs.mycalc.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.giantnovadevs.mycalc.data.CalculatorOperation
import com.giantnovadevs.mycalc.ui.states.CalculatorState
import com.giantnovadevs.mycalc.ui.uievents.CalculatorUIEvents

class CalculatorViewModel: ViewModel(){
	fun onAction(action: CalculatorUIEvents) {
		when(action) {
			is CalculatorUIEvents.Number -> enterNumber(action.number)
			CalculatorUIEvents.Decimal -> enterDecimal()
			CalculatorUIEvents.Clear -> state = CalculatorState()
			is CalculatorUIEvents.Operation -> enterOperation(action.operation)
			CalculatorUIEvents.Calculate -> performCalculation()
			CalculatorUIEvents.Delete -> performDeletion()
		}
	}
	
	private fun performDeletion() {
		when{
			state.number2.isNotBlank() -> state = state.copy(
				number2 = state.number2.dropLast(1)
			)
			state.operation != null -> state = state.copy(
				operation = null
			)
			state.number1.isNotBlank() -> state = state.copy(
				number1 = state.number1.dropLast(1)
			)
		}
	}
	
	private fun performCalculation() {
		val number1 = state.number1.toDoubleOrNull()
		val number2 = state.number2.toDoubleOrNull()
		if(number1 != null && number2 != null){
			val result = when(state.operation){
				CalculatorOperation.Add -> number1 + number2
				CalculatorOperation.Divide -> number1 / number2
				CalculatorOperation.Multiply -> number1  * number2
				CalculatorOperation.Subtract -> number1 - number2
				null -> return
			}
			state = state.copy(
				number1 = result.toString().take(15),
				number2 = "",
				operation = null
			)
		}
	}
	
	private fun enterOperation(operation: CalculatorOperation) {
		if(state.number1.isNotBlank()) {
			state = state.copy(
				operation = operation
			)
		}
	}
	
	private fun enterDecimal() {
		if(state.operation == null && !state.number1.contains(".")
			&& state.number1.isNotBlank()
		){
			state = state.copy(
				number1 = state.number1 + "."
			)
			return
		}
		if(!state.number2.contains(".")
			&& state.number2.isNotBlank()
		){
			state = state.copy(
				number2 = state.number2 + "."
			)
			return
		}
	}
	
	private fun enterNumber(number: Int) {
		if(state.operation == null) {
			if(state.number1.length >= MAX_NUM_LENGTH){
				return
			}
			state = state.copy(
				number1 = state.number1 + number
			)
			return
		}
		if(state.number2.length >= MAX_NUM_LENGTH) {
			return
		}
		state = state.copy(
			number2 = state.number2 + number
		)
	}
	
	companion object {
		private const val MAX_NUM_LENGTH = 8
	}
	var state by mutableStateOf(CalculatorState())
}