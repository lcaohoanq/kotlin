package com.lcaohoanq.calculator

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.allClear
import kotlinx.android.synthetic.main.activity_main.btnBackspace
import kotlinx.android.synthetic.main.activity_main.btnDivide
import kotlinx.android.synthetic.main.activity_main.btnDot
import kotlinx.android.synthetic.main.activity_main.btnEight
import kotlinx.android.synthetic.main.activity_main.btnEqual
import kotlinx.android.synthetic.main.activity_main.btnFive
import kotlinx.android.synthetic.main.activity_main.btnFour
import kotlinx.android.synthetic.main.activity_main.btnMinus
import kotlinx.android.synthetic.main.activity_main.btnMultiply
import kotlinx.android.synthetic.main.activity_main.btnNine
import kotlinx.android.synthetic.main.activity_main.btnOne
import kotlinx.android.synthetic.main.activity_main.btnPLus
import kotlinx.android.synthetic.main.activity_main.btnSeven
import kotlinx.android.synthetic.main.activity_main.btnSix
import kotlinx.android.synthetic.main.activity_main.btnThree
import kotlinx.android.synthetic.main.activity_main.btnTwo
import kotlinx.android.synthetic.main.activity_main.btnZero
import kotlinx.android.synthetic.main.activity_main.clear
import kotlinx.android.synthetic.main.activity_main.tvCurrentOperand
import kotlinx.android.synthetic.main.activity_main.tvInput
import kotlinx.android.synthetic.main.activity_main.tvOldInput
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppBase() {
    private val calculator = CalculatorModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listOf(
            btnOne to "1", btnTwo to "2", btnThree to "3", btnFour to "4", btnFive to "5",
            btnSix to "6", btnSeven to "7", btnEight to "8", btnNine to "9", btnZero to "0", btnDot to "."
        ).forEach { (button, number) -> button.setOnClickListener { appendNumber(number) } }

        mapOf(
            btnPLus to Operator.ADD, btnMinus to Operator.SUBTRACT,
            btnMultiply to Operator.MULTIPLY, btnDivide to Operator.DIVIDE
        ).forEach { (button, operator) -> button.setOnClickListener { setOperator(operator) } }

        btnEqual.setOnClickListener { calculateResult() }
        clear.setOnClickListener { clearInput() }
        allClear.setOnClickListener { allClearInput() }
        btnBackspace.setOnClickListener { handleBackspace() }
    }

    private fun appendNumber(number: String) {
        calculator.currentInput.append(number)
        tvInput.updateDisplay(calculator)
    }

    private fun handleBackspace() {
        with(calculator.currentInput) {
            if (isNotEmpty()) {
                deleteCharAt(length - 1)
                tvInput.updateDisplay(calculator)
            }
        }
    }

    private fun setOperator(operator: Operator) {
        calculator.operand1 = calculator.operand1 ?: calculator.currentInput.toString().toBigDecimalOrNull()
        calculator.currentInput.clear()
        tvOldInput.text = calculator.operand1.toString()
        tvCurrentOperand.text = operator.symbol
        calculator.currentOperator = operator
    }

    private fun calculateResult() {
        val operand2 = calculator.currentInput.toString().toBigDecimalOrNull() ?: return
        val result = when (calculator.currentOperator) {
            Operator.ADD -> calculator.operand1?.add(operand2)
            Operator.SUBTRACT -> calculator.operand1?.subtract(operand2)
            Operator.MULTIPLY -> calculator.operand1?.multiply(operand2)
            Operator.DIVIDE -> calculator.operand1?.takeIf { operand2 != BigDecimal.ZERO }
                ?.divide(operand2, 10, RoundingMode.HALF_EVEN)
            Operator.NONE -> operand2
        }

        result?.let {
            tvOldInput.text = "${calculator.operand1}${calculator.currentOperator.symbol}$operand2"
            tvInput.text = it.toString()
            calculator.operand1 = it
        }
    }

    private fun allClearInput() {
        with(calculator) {
            currentInput.clear()
            operand1 = null
            currentOperator = Operator.NONE
        }
        tvOldInput.text = ""
        tvInput.text = "0"
        tvCurrentOperand.text = ""
    }

    private fun clearInput() {
        calculator.currentInput.clear()
        calculator.currentOperator = Operator.NONE
        tvInput.text = "0"
    }
}