package com.example.module10_hiddencalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity(), OnClickListener {

    private lateinit var sendDataBTN: Button

    private lateinit var firstInputET: EditText
    private lateinit var secondInputET: EditText

    private lateinit var additionBTN: Button
    private lateinit var subtractionBTN: Button
    private lateinit var timesBTN: Button
    private lateinit var divisionBTN: Button

    private val intent = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        sendDataBTN = findViewById(R.id.sendDataBTN)

        firstInputET = findViewById(R.id.firstInputET)
        secondInputET = findViewById(R.id.secondInputET)

        additionBTN = findViewById(R.id.additionBTN)
        subtractionBTN = findViewById(R.id.subtractionBTN)
        timesBTN = findViewById(R.id.timesBTN)
        divisionBTN = findViewById(R.id.divisionBTN)

        additionBTN.setOnClickListener(this)
        subtractionBTN.setOnClickListener(this)
        timesBTN.setOnClickListener(this)
        divisionBTN.setOnClickListener(this)

        sendDataBTN.setOnClickListener {
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    override fun onClick(view: View) {

        val first = if (firstInputET.text.isNotEmpty()) {
            firstInputET.text.toString().toDouble()
        } else 0.0

        val second = if (secondInputET.text.isNotEmpty()) {
            secondInputET.text.toString().toDouble()
        } else 0.0

        when (view.id) {
            R.id.additionBTN -> intent.putExtra("result", first + second)
            R.id.subtractionBTN -> intent.putExtra("result", first - second)
            R.id.timesBTN -> intent.putExtra("result", first * second)
            R.id.divisionBTN -> intent.putExtra("result", first / second)
        }
    }
}