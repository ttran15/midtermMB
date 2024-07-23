package com.example.question1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // declare immutable variables
        val Edtxt1: EditText = findViewById(R.id.Edtxt1)
        val Edtxt2: EditText = findViewById(R.id.Edtxt2)
        val btnResult: Button = findViewById(R.id.btnResult)
        val result: TextView = findViewById(R.id.textResult)

        // declare mutable variables
        var operation: String = "addition"
        val spnOperation: Spinner = findViewById(R.id.spn)
        var ls_operation = arrayOf("addition", "subtraction", "multiply", "division")

        // set spinner list
        spnOperation.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ls_operation)

        btnResult.setOnClickListener {
            var x: Int = Edtxt1.text.toString().toInt()
            var y: Int = Edtxt2.text.toString().toInt()
            when (operation) {
                "addition" -> result.text = add(x, y)
                "subtraction" -> result.text = minus(x, y)
                "multiply" -> result.text = multiply(x, y)
                "division" -> result.text = division(x, y)
                else -> result.text = ""
            }
        }

        spnOperation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                operation = ls_operation.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
fun add(a: Int, b: Int): String {
    return (a+b).toString()
}
fun multiply(a: Int, b: Int): String {
    return (a * b).toString()
}
fun minus(a: Int, b: Int): String {
    return (a - b).toString()
}
fun division(a: Int, b: Int): String {
    if (b == 0){
        return "Can not divide 0"
    } else {
        var a_d = a.toDouble()
        var b_d = b.toDouble()
        return (a_d/b_d).toString()
    }
}
