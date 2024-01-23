package com.example.twonumcalculator.presentation

import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    val numOne = mutableStateOf(0)
//    val numOne = _numOne.asIntState()
    val numTwo = mutableStateOf(0)
//    val numTwo = _numTwo.asIntState()
    private val _result = mutableStateOf(0)
    val result = _result.asIntState()

    fun makeCalculation() {
        _result.value = numOne.value + numTwo.value
    }
}