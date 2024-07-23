package com.example.question3

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FirstActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.first_activity)

        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString("key")

        // declare immutable variables
        val name: EditText = findViewById(R.id.EdtName)
        val btnCheck: Button = findViewById(R.id.button)
        val result: TextView = findViewById(R.id.txtResult)
        val resultNumer: TextView = findViewById(R.id.txtResultNumber)

        // declare mutable variables
        var print_name = name.text.toString()
        var province: String = "Ontario"
        val spnProvince: Spinner = findViewById(R.id.spn)
        var ls_province = arrayOf("Ontario", "Prince Edward Island", "Alberta", "Manitoba", "New Brunswick", "Newfoundland" , "Nova Scotia", "British Columbia", "Quebec", "Saskatchewan" , "Other")

        // set spinner list
        spnProvince.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ls_province)

        btnCheck.setOnClickListener {
            if (name.text.toString() == ""){
                result.text = "Hello!"
            } else {
                result.text = "Hello " + name.text.toString()
            }
            when (province) {
                "Ontario" -> resultNumer.text = "Tax rate in your area is 13%"
                "Prince Edward Island" -> resultNumer.text = "Tax rate in your area is 15%"
                "Alberta" -> resultNumer.text = "Tax rate in your area is 10%"
                "Manitoba" -> resultNumer.text = "Tax rate in your area is 13%"
                "New Brunswick" -> resultNumer.text = "Tax rate in your area is 15%"
                "Newfoundland" -> resultNumer.text = "Tax rate in your area is 15%"
                "Nova Scotia" -> resultNumer.text = "Tax rate in your area is 15%"
                "British Columbia" -> resultNumer.text = "Tax rate in your area is 12%"
                "Quebec" -> resultNumer.text = "Tax rate in your area is 15%"
                "Saskatchewan" -> resultNumer.text = "Tax rate in your area is 11%"
                "Other" -> resultNumer.text = "Sorry. We have no information"
                else -> resultNumer.text = ""
            }
        }

        spnProvince.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                province = ls_province.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}