package com.example.module10_hiddencalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var calculatorBTN: Button
    private lateinit var outputTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculatorBTN = findViewById(R.id.calculatorBTN)
        outputTV = findViewById(R.id.outputTV)

        calculatorBTN.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            launchCalculatorActivity.launch(intent)
        }
    }

    private val launchCalculatorActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val output = result.data!!.getDoubleExtra("result", 0.0)
            outputTV.text = String.format("Результат: $output")

        }
    }
}