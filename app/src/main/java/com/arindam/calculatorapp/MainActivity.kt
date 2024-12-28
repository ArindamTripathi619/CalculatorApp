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

//        val buttonAC = binding.btnAC
//        val screenWidth = resources.displayMetrics.widthPixels
//        val buttonWidth = (screenWidth * 0.2).toInt()
//        buttonAC.layoutParams.width = buttonWidth

        binding.btn0.setOnClickListener {
            binding.eTInput.text?.append("0")
        }

        binding.btn1.setOnClickListener {
            binding.eTInput.text?.append("1")
        }

        binding.btn2.setOnClickListener {
            binding.eTInput.text?.append("2")
        }

        binding.btn3.setOnClickListener {
            binding.eTInput.text?.append("3")
        }

        binding.btn4.setOnClickListener {
            binding.eTInput.text?.append("4")
        }

        binding.btn5.setOnClickListener {
            binding.eTInput.text?.append("5")
        }

        binding.btn6.setOnClickListener {
            binding.eTInput.text?.append("6")
        }

        binding.btn7.setOnClickListener {
            binding.eTInput.text?.append("7")
        }

        binding.btn8.setOnClickListener {
            binding.eTInput.text?.append("8")
        }

        binding.btn9.setOnClickListener {
            binding.eTInput.text?.append("9")
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

        binding.btnDivide.setOnClickListener {
            binding.eTInput.text?.append("/")
        }

        binding.btnMultiply.setOnClickListener {
            binding.eTInput.text?.append("×")
        }

        binding.btnMinus.setOnClickListener {
            binding.eTInput.text?.append("-")
        }

        binding.btnPlus.setOnClickListener {
            binding.eTInput.text?.append("+")
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

    }
}