package com.lcaohoanq.calculator

import android.widget.TextView

fun operatorToString(operator: Operator): String = when (operator) {
    Operator.ADD -> "+"
    Operator.SUBTRACT -> "-"
    Operator.MULTIPLY -> "×"
    Operator.DIVIDE -> "÷"
    Operator.NONE -> ""
}

fun TextView.updateDisplay(calculator: CalculatorModel) {
    text = calculator.currentInput.toString()
}