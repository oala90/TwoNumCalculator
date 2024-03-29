package com.example.twonumcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.twonumcalculator.presentation.CalculatorViewModel
import com.example.twonumcalculator.presentation.CalculatorViews
import com.example.twonumcalculator.presentation.ui.theme.TwoNumCalculatorTheme

class MainActivity : ComponentActivity() {
    private val myViewModel: CalculatorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwoNumCalculatorTheme {
                val numOne = myViewModel.numOne.intValue
                val numTwo = myViewModel.numTwo.intValue
                val result = myViewModel.results
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorViews(
                        onNumOneChange = {
                            myViewModel.numOne.intValue = it.toInt()
                        },
                        numOne = numOne.toString(),
                        onNumTwoChange = {
                            myViewModel.numTwo.intValue = it.toInt()
                        },
                        numTwo = numTwo.toString(),
                        resultLabel = result,
                        result = { operator ->
                            myViewModel.makeCalculation(operator)
                        }
                    )
                }
            }
        }
    }
}
