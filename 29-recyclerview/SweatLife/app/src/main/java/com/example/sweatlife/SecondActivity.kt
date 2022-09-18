package com.example.sweatlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private lateinit var returnButton: Button
    private lateinit var favoriteBenchPress: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        returnButton = findViewById(R.id.return_Button)
        favoriteBenchPress = findViewById(R.id.favoriteBenchPress)

        returnButton.setOnClickListener {
            finish()
        }

        favoriteBenchPress.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("data", "Bench Press")
            startActivity(intent)
        }
    }
}