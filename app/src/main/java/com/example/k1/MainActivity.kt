package com.example.k1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var conversionTypeSpinner: Spinner
    private lateinit var convertButton: Button
    private lateinit var outputEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.inputEditText)
        conversionTypeSpinner = findViewById(R.id.conversionTypeSpinner)
        convertButton = findViewById(R.id.convertButton)
        outputEditText = findViewById(R.id.outputEditText)

        val conversionTypes = resources.getStringArray(R.array.conversion_types)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionTypes)
        conversionTypeSpinner.adapter = adapter

        convertButton.setOnClickListener {
            performConversion()
        }
    }

    private fun performConversion() {
        val input = inputEditText.text.toString().toDoubleOrNull()
        if (input != null) {
            val conversionType = conversionTypeSpinner.selectedItem.toString()
            val output = when (conversionType) {
                "km to mi" -> input * 0.621371
                "mi to km" -> input * 1.60934
                "cm to in" -> input * 0.393701
                "in to cm" -> input * 2.54
                "kg to lb" -> input * 2.20462
                "lb to kg" -> input * 0.453592
                else -> 0.0
            }
            outputEditText.setText(output.toString())
        } else {
            outputEditText.setText("")
        }
    }
}


