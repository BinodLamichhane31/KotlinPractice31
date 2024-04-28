package com.example.theapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
   lateinit var textView: TextView
    lateinit var radioButton1: RadioButton
    lateinit var radioButton2:RadioButton
    lateinit var imageView: ImageView
    lateinit var spinner: Spinner
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.myEditText);
        textView = findViewById(R.id.textView);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        button = findViewById(R.id.button);

        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            arrayOf("Football", "Basketball", "Cricket")
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(spinnerAdapter)

        val autoCompleteAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            arrayOf("Apple", "Banana", "Orange", "Mango")
        )
        autoCompleteTextView.setAdapter(autoCompleteAdapter)

        button.setOnClickListener { v -> // Displaying EditText content in TextView
            textView.text = editText.getText().toString()

            // Displaying selected RadioButton
            if (radioButton1.isChecked) {
                textView.append("\nRadio Button 1 Selected")
            } else if (radioButton2.isChecked) {
                textView.append("\nRadio Button 2 Selected")
            }

            // Displaying selected Spinner item
            textView.append(
                """
                    
                    Spinner Item Selected: ${spinner.getSelectedItem()}
                    """.trimIndent()
            )

            // Displaying selected AutoCompleteTextView item
            textView.append(
                """
                    
                    AutoCompleteTextView Item Selected: ${autoCompleteTextView.getText()}
                    """.trimIndent()
            )

            // Showing a Toast
            Toast.makeText(this@MainActivity, "Button Clicked", Toast.LENGTH_SHORT).show()

            // Showing an AlertDialog
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Alert Dialog")
                .setMessage("This is an AlertDialog")
                .setPositiveButton("OK", null)
                .show()

            // Showing a Snackbar
            Snackbar.make(v, "This is a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

    }
}