package com.example.sweatlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private lateinit var returnButton: Button
    private lateinit var favoriteBenchPress: Button
    private lateinit var favoriteHammerCurls: Button
    private lateinit var favoriteOverheadPress: Button
    private lateinit var favoriteInclinePress: Button
    private lateinit var favoriteFacePulls: Button
    private lateinit var favoriteLateralRaises: Button
    private lateinit var favoriteDeclinePress: Button
    private lateinit var favoriteBarbellRows: Button
    private lateinit var favoritePushUps: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        returnButton = findViewById(R.id.return_Button)
        favoriteBenchPress = findViewById(R.id.favoriteBenchPress)
        favoriteHammerCurls = findViewById(R.id.favoriteHammerCurls)
        favoriteOverheadPress = findViewById(R.id.favoriteOverheadPress)
        favoriteInclinePress = findViewById(R.id.favoriteInclinePress)
        favoriteFacePulls = findViewById(R.id.favoriteFacePulls)
        favoriteLateralRaises = findViewById(R.id.favoriteLateralRaises)
        favoriteDeclinePress = findViewById(R.id.favoriteDeclinePress)
        favoriteBarbellRows = findViewById(R.id.favoriteBarbellRows)
        favoritePushUps = findViewById(R.id.favoritePushUps)
        returnButton.setOnClickListener {
            finish()
        }

        favoriteBenchPress.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("data", "Bench Press")
            startActivity(intent)
        }

        favoriteHammerCurls.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("data", "Hammer Curls")
            startActivity(intent)
        }

        favoriteOverheadPress.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("data", "Overhead Press")
            startActivity(intent)
        }

        favoriteInclinePress.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("data", "Incline Press")
            startActivity(intent)
        }

        favoriteFacePulls.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("data", "Face Pulls")
            startActivity(intent)
        }

        favoriteLateralRaises.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("data", "Lateral Raises")
            startActivity(intent)
        }

        favoriteDeclinePress.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("data", "Decline Press")
            startActivity(intent)
        }

        favoriteBarbellRows.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("data", "Barbell Rows")
            startActivity(intent)
        }

        favoritePushUps.setOnClickListener {
            Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("data", "Push Ups")
            startActivity(intent)
        }
    }
}