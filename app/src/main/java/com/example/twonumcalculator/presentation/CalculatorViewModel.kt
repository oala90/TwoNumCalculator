package com.example.twonumcalculator.presentation

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.twonumcalculator.presentation.constants.Constants

class CalculatorViewModel: ViewModel() {

    val numOne = mutableIntStateOf(0)
    val numTwo = mutableIntStateOf(0)
    private val _results = mutableStateListOf<ResultCache?>(null)
    val results: List<ResultCache?> = _results

    fun makeCalculation(operator: Constants) {
        val result = when(operator) {
            Constants.SUM -> ResultCache(numOne.intValue + numTwo.intValue)
            Constants.REST -> ResultCache(numOne.intValue - numTwo.intValue)
            Constants.MULTIPLICATION -> ResultCache(numOne.intValue * numTwo.intValue)
            Constants.DIVISION -> {
                if(numTwo.intValue != 0) {
                    ResultCache(numOne.intValue / numTwo.intValue)
                } else {
                    ResultCache(0)
                }
            }
        }

        _results.add(result)
    }
}