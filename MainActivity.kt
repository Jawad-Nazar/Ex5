package com.example.counterapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup each counter using the <include> container
        setupCounter(findViewById(R.id.counter1))
        setupCounter(findViewById(R.id.counter2))
        setupCounter(findViewById(R.id.counter3))
    }

    private fun setupCounter(container: View) {
        val btnMinus = container.findViewById<Button>(R.id.btnMinus)
        val btnPlus = container.findViewById<Button>(R.id.btnPlus)
        val etCount = container.findViewById<EditText>(R.id.etCount)

        btnPlus.setOnClickListener {
            val current = etCount.text.toString().toIntOrNull() ?: 0
            etCount.setText((current + 1).toString())
            etCount.setSelection(etCount.text.length)
        }

        btnMinus.setOnClickListener {
            val current = etCount.text.toString().toIntOrNull() ?: 0
            etCount.setText((current - 1).toString())
            etCount.setSelection(etCount.text.length)
        }

        etCount.addTextChangedListener { text ->
            if (text.toString().isNotEmpty() && text.toString().toIntOrNull() == null) {
                etCount.setText("0")
                etCount.setSelection(etCount.text.length)
            }
        }
    }
}