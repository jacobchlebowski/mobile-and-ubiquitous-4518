package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var oneButton: Button
    private lateinit var twoButton: Button
    private lateinit var threeButton: Button
    private lateinit var fourButton: Button
    private lateinit var fiveButton: Button
    private lateinit var sixButton: Button
    private lateinit var sevenButton: Button
    private lateinit var eightButton: Button
    private lateinit var nineButton: Button
    private lateinit var zeroButton: Button
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var equalsButton: Button
    private lateinit var clearButton: Button
    private lateinit var answer: TextView
    private lateinit var equation: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize widgets
        oneButton = findViewById(R.id.buttonOne)
        twoButton = findViewById(R.id.buttonTwo)
        threeButton = findViewById(R.id.buttonThree)
        fourButton = findViewById(R.id.buttonFour)
        fiveButton = findViewById(R.id.buttonFive)
        sixButton = findViewById(R.id.buttonSix)
        sevenButton = findViewById(R.id.buttonSeven)
        eightButton = findViewById(R.id.buttonEight)
        nineButton = findViewById(R.id.buttonNine)
        zeroButton = findViewById(R.id.buttonZero)
        addButton = findViewById(R.id.buttonAdd)
        subtractButton = findViewById(R.id.buttonSubtract)
        equalsButton = findViewById(R.id.buttonEquals)
        clearButton = findViewById(R.id.buttonClear)
        answer = findViewById(R.id.answer)
        equation = findViewById(R.id.equation)

        oneButton.setOnClickListener { evaluateExpression("1", clear = false) }
        twoButton.setOnClickListener { evaluateExpression("2", clear = false) }
        threeButton.setOnClickListener { evaluateExpression("3", clear = false) }
        fourButton.setOnClickListener { evaluateExpression("4", clear = false) }
        fiveButton.setOnClickListener { evaluateExpression("5", clear = false) }
        sixButton.setOnClickListener { evaluateExpression("6", clear = false) }
        sevenButton.setOnClickListener { evaluateExpression("7", clear = false) }
        eightButton.setOnClickListener { evaluateExpression("8", clear = false) }
        nineButton.setOnClickListener { evaluateExpression("9", clear = false) }
        zeroButton.setOnClickListener { evaluateExpression("0", clear = false) }
        addButton.setOnClickListener { evaluateExpression("+", clear = false) }
        subtractButton.setOnClickListener { evaluateExpression("-", clear = false) }

        clearButton.setOnClickListener {
            equation.text = ""
            answer.text = ""
        }
        equalsButton.setOnClickListener {
            val text = equation.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                answer.text = longResult.toString()
            } else {
                answer.text = result.toString()
            }
        }
    }


    /*Function to calculate the expressions using expression builder library*/
    private fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
            answer.text = ""
            equation.append(string)
        } else {
            equation.append(answer.text)
            equation.append(string)
            answer.text = ""
        }
    }


}