package com.example.twonumcalculator.presentation

import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.twonumcalculator.presentation.constants.Constants

class CalculatorViewModel: ViewModel() {

    val numOne = mutableIntStateOf(0)
    val numTwo = mutableIntStateOf(0)
    private val _result = mutableIntStateOf(0)
    val result = _result.asIntState()

    fun makeCalculation() {
        fun makeCalculation(operator: Constants) {
            _result.intValue = when(operator) {
                Constants.SUM -> numOne.intValue + numTwo.intValue
                Constants.REST -> numOne.intValue - numTwo.intValue
                Constants.MULTIPLICATION -> numOne.intValue * numTwo.intValue
                Constants.DIVISION -> numOne.intValue / numTwo.intValue
            }
        }
    }
}