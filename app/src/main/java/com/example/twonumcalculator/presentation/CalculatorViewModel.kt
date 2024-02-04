package com.example.twonumcalculator.presentation

import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.twonumcalculator.presentation.constants.Constants

class CalculatorViewModel: ViewModel() {

    val numOne = mutableStateOf(0)
    val numTwo = mutableStateOf(0)
    private val _results = mutableStateListOf<ResultCache?>(null)
    val results: List<ResultCache?> = _results

    fun makeCalculation(operator: Constants) {
        val result = when(operator) {
            Constants.SUM -> ResultCache(numOne.value + numTwo.value)
            Constants.REST -> ResultCache(numOne.value - numTwo.value)
            Constants.MULTIPLICATION -> ResultCache(numOne.value * numTwo.value)
            Constants.DIVISION -> {
                if(numTwo.value != 0) {
                    ResultCache(numOne.value / numTwo.value)
                } else {
                    ResultCache(0)
                }
            }
        }

        _results.add(result)
    }
}