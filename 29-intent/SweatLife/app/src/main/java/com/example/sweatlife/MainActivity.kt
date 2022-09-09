package com.example.sweatlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var upperBodyButton: Button
    private lateinit var favoriteText: TextView
    private lateinit var dateSubmit: Button
    private lateinit var dateInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        upperBodyButton = findViewById(R.id.upperBodyButton)
        favoriteText = findViewById(R.id.favoriteText)
        dateSubmit = findViewById(R.id.dateSubmit)
        dateInput = findViewById(R.id.date_input)

        upperBodyButton.setOnClickListener {
            val newIntent = Intent(this, SecondActivity::class.java)
            startActivity(newIntent)
        }

        dateSubmit.setOnClickListener {
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, ThirdActivity::class.java)
            intent.putExtra("date", dateInput.text.toString().trim())
            startActivity(intent)
        }



        val intent = intent
        val favorite = intent.getStringExtra("data")
        favoriteText.text = favorite


    }
}