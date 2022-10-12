package com.example.sweatlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class CoreActivity : AppCompatActivity() {
    private lateinit var returnButton: Button
    private lateinit var favoriteCrunches: Button
    private lateinit var favoritePlanks: Button
    private lateinit var favoriteLegRaises: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_core)
        returnButton = findViewById(R.id.return_Button)
        favoriteCrunches = findViewById(R.id.favoriteCrunches)
        favoritePlanks = findViewById(R.id.favoritePlanks)
        favoriteLegRaises = findViewById(R.id.favoriteLegRaises)
        returnButton.setOnClickListener {
            finish()
        }

        favoriteCrunches.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@CoreActivity, MainActivity::class.java)
            intent.putExtra("data", "Crunches")
            startActivity(intent)
        }

        favoritePlanks.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@CoreActivity, MainActivity::class.java)
            intent.putExtra("data", "Planks")
            startActivity(intent)
        }

        favoriteLegRaises.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@CoreActivity, MainActivity::class.java)
            intent.putExtra("data", "Leg Raises")
            startActivity(intent)
        }


    }
}