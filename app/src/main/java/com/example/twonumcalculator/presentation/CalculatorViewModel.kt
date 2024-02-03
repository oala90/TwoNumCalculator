package com.example.twonumcalculator.presentation

import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.twonumcalculator.presentation.constants.Constants

class CalculatorViewModel: ViewModel() {

    val numOne = mutableStateOf(0)
    val numTwo = mutableStateOf(0)
    private val _result = mutableStateOf(0)
    val result = _result.asIntState()

    fun makeCalculation(operator: Constants) {
        _result.value = when(operator) {
            Constants.SUM -> numOne.value + numTwo.value
            Constants.REST -> numOne.value - numTwo.value
            Constants.MULTIPLICATION -> numOne.value * numTwo.value
            Constants.DIVISION -> numOne.value / numTwo.value
        }
    }
}