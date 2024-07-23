package com.example.question3

import android.content.Intent
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

        val btnApp1: Button = findViewById(R.id.btnApp1)
        val btnApp2: Button = findViewById(R.id.btnApp1)

        btnApp1.setOnClickListener{
            val app1_message:String = "App 1 Message"
            val app1_intent = Intent(this, FirstActivity::class.java)
            app1_intent.putExtra("key", app1_message)
            startActivity(app1_intent)
        }

        btnApp2.setOnClickListener{
            val app2_message:String = "App 2 Message"
            val app2_intent = Intent(this, SecondActivity::class.java)
            app2_intent.putExtra("key", app2_message)
            startActivity(app2_intent)
        }
    }
}
