package com.example.twonumcalculator.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CalculatorViews(
    onNumOneChange: (String) -> Unit,
    numOne: String,
    onNumTwoChange: (String) -> Unit,
    numTwo: String,
    resultLabel: String,
    result: () -> Unit
) {
    Column {
        TextField(
            value = numOne,
            onValueChange = {
                onNumOneChange(it)
            },
            label = {
                Text(text = "Enter first number")
            }
        )

        TextField(
            value = numTwo,
            onValueChange = {
                onNumTwoChange(it)
            },
            label = {
                Text(text = "Enter second number")
            }
        )

        Text(text = resultLabel)
        Button(onClick = {
            result()
        }) {}
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorViews({}, "", {}, "", "", {})
}