package com.example.sweatlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    private lateinit var returnButton: Button
    private lateinit var dateDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        returnButton = findViewById(R.id.return_Button)
        dateDisplay = findViewById(R.id.dateDisplay)

        returnButton.setOnClickListener {
            finish()
        }

        val dateIntent = intent
        val dateValue = dateIntent.getStringExtra("date")
        dateDisplay.text = dateValue
    }

}