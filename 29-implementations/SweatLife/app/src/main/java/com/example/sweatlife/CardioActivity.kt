package com.example.sweatlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class CardioActivity : AppCompatActivity() {
    private lateinit var returnButton: Button
    private lateinit var favoriteTreadmill: Button
    private lateinit var favoriteElliptical: Button
    private lateinit var favoriteBike: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio)
        returnButton = findViewById(R.id.return_Button)
        favoriteTreadmill = findViewById(R.id.favoriteTreadmill)
        favoriteElliptical = findViewById(R.id.favoriteElliptical)
        favoriteBike = findViewById(R.id.favoriteBike)


        returnButton.setOnClickListener {
            finish()
        }

        favoriteTreadmill.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@CardioActivity, MainActivity::class.java)
            intent.putExtra("data", "Treadmill")
            startActivity(intent)
        }

        favoriteElliptical.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@CardioActivity, MainActivity::class.java)
            intent.putExtra("data", "Elliptical")
            startActivity(intent)
        }

        favoriteBike.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@CardioActivity, MainActivity::class.java)
            intent.putExtra("data", "Bike")
            startActivity(intent)
        }

    }
}