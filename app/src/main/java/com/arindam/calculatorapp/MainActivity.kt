package com.arindam.calculatorapp

import com.arindam.calculatorapp.javaCalculator.PostfixStackEvaluator
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.arindam.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val obj = PostfixStackEvaluator()

        // Number buttons
        val numberButtons = listOf(binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9)

        for (i in 0..9) {
            numberButtons[i].setOnClickListener {
                binding.eTInput.text?.append(i.toString())
            }
        }

        binding.btnPoint.setOnClickListener {
            binding.eTInput.text?.append(".")
        }

        binding.btnAC.setOnClickListener {
            binding.eTInput.text?.clear()
            binding.tVResult.text = ""
        }

        binding.btnBracket.setOnClickListener {
            if(!binding.eTInput.text.toString().contains("("))
                binding.eTInput.text?.append("(")
            else
                binding.eTInput.text?.append(")")
        }

        // Operator buttons
        val operatorButtons = mapOf(
            binding.btnDivide to "/", binding.btnMultiply to "×",
            binding.btnMinus to "-", binding.btnPlus to "+"
        )
        operatorButtons.forEach { (button, operator) ->
            button.setOnClickListener { binding.eTInput.text?.append(operator) }
        }

        binding.btnDel.setOnClickListener {
            val length = binding.eTInput.text.toString().length
            binding.eTInput.text?.delete(length-1, length)
        }

        binding.btnEqual.setOnClickListener {
            val input = binding.eTInput.text.toString()
            val result = obj.evaluate(input)
            binding.tVResult.text = result.toString()
        }

        binding.btnAns.setOnClickListener {
            binding.eTInput.text?.clear()
            binding.eTInput.text?.append(binding.tVResult.text.toString())
        }

        // Theme toggle functionality
        binding.btnChangeMode.setOnClickListener {
            val isDarkMode = binding.btnChangeMode.text.toString() == "🌙"
            toggleTheme(isDarkMode, binding)
        }

    }

    private fun toggleTheme(isDarkMode: Boolean, binding: ActivityMainBinding) {
        val backgroundColor = if (isDarkMode) R.color.white else R.color.black
        val textColor = if (isDarkMode) R.color.black else R.color.white
        val buttonBackgroundColor = if (isDarkMode) R.color.lavender else R.color.orange
        val themeIcon = if (isDarkMode) "\uD83C\uDF1E" else "🌙"

        binding.main.setBackgroundResource(backgroundColor)
        binding.eTInput.setTextColor(getColor(textColor))
        binding.tVResult.setTextColor(getColor(textColor))

        // List of all buttons
        val allButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9,
            binding.btnPoint, binding.btnAC, binding.btnBracket, binding.btnDivide,
            binding.btnMultiply, binding.btnMinus, binding.btnPlus, binding.btnDel,
            binding.btnEqual, binding.btnAns, binding.btnChangeMode
        )

        allButtons.forEach { button ->
            button.setTextColor(getColor(textColor))
            button.setBackgroundColor(getColor(buttonBackgroundColor))
        }

        binding.btnChangeMode.text = themeIcon
    }

}