package com.example.sweatlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class LowerActivity : AppCompatActivity() {
    private lateinit var returnButton: Button
    private lateinit var favoriteLegPress: Button
    private lateinit var favoriteSquats: Button
    private lateinit var favoriteCalfRaises: Button
    private lateinit var favoriteLegCurls: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lower)
        returnButton = findViewById(R.id.return_Button)
        favoriteLegPress = findViewById(R.id.favoriteLegPress)
        favoriteSquats = findViewById(R.id.favoriteSquats)
        favoriteCalfRaises = findViewById(R.id.favoriteCalfRaises)
        favoriteLegCurls = findViewById(R.id.favoriteLegCurls)

        returnButton.setOnClickListener {
            finish()
        }

        favoriteLegPress.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@LowerActivity, MainActivity::class.java)
            intent.putExtra("data", "Leg Press")
            startActivity(intent)
        }

        favoriteSquats.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@LowerActivity, MainActivity::class.java)
            intent.putExtra("data", "Squats")
            startActivity(intent)
        }

        favoriteCalfRaises.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@LowerActivity, MainActivity::class.java)
            intent.putExtra("data", "Calf Raises")
            startActivity(intent)
        }

        favoriteLegCurls.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@LowerActivity, MainActivity::class.java)
            intent.putExtra("data", "Leg Curls")
            startActivity(intent)
        }
    }
}