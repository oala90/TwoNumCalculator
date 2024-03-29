package com.example.twonumcalculator.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.twonumcalculator.presentation.constants.Constants

@Composable
fun CalculatorViews(
    onNumOneChange: (String) -> Unit,
    numOne: String,
    onNumTwoChange: (String) -> Unit,
    numTwo: String,
    resultLabel: List<ResultCache?>,
    result: (Constants) -> Unit
) {
    Row {

        Column (
            modifier = Modifier
                .padding(20.dp)
        ) {
            TextField(
                value = numOne,
                onValueChange = {
                    if(it.isBlank()) {
                        onNumOneChange("0")
                    } else {
                        if(it.isDigitsOnly()) {
                            onNumOneChange(it)
                        }
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                maxLines = 10,
                label = {
                    Text(text = "Enter first number")
                }
            )

            TextField(
                value = numTwo,
                onValueChange = {
                    if(it.isBlank()) {
                        onNumTwoChange("0")
                    } else {
                        if(it.isDigitsOnly()) {
                            onNumTwoChange(it)
                        }
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                maxLines = 10,
                label = {
                    Text(text = "Enter second number")
                }
            )

            resultLabel.forEachIndexed { index, resultCache ->
                Text(
                    text =
                    if(resultCache !=  null) {
                        "Result $index: ${resultCache.result}"
                    }
                    else { "" },
                    color = Color.Black
                )
            }

        }

        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Button(onClick = {
                result(Constants.SUM)
            }) {
                Text(text = "+")
            }
            Button(onClick = {
                result(Constants.REST)
            }) {
                Text(text = "-")
            }
            Button(onClick = {
                result(Constants.MULTIPLICATION)
            }) {
                Text(text = "*")
            }
            Button(onClick = {
                result(Constants.DIVISION)
            }) {
                Text(text = "/")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorViews({}, "", {}, "", emptyList(), {})
}