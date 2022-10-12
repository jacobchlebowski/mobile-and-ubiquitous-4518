package com.example.sweatlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import java.text.DateFormat
import java.util.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var upperBodyButton: Button
    private lateinit var lowerBodyButton: Button
    private lateinit var coreButton: Button
    private lateinit var cardioButton: Button
    private lateinit var favoriteText: TextView
    private lateinit var dateSubmit: Button
    private lateinit var dateInput: CalendarView
    private lateinit var dateNavButton: Button
    private lateinit var timerNavButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = Calendar.getInstance()
        val url = "http://10.0.2.2:8888/sjson"
        val requestQueue = Volley.newRequestQueue(this)

        upperBodyButton = findViewById(R.id.upperBodyButton)
        lowerBodyButton = findViewById(R.id.lowerBodyButton)
        coreButton = findViewById(R.id.coreButton)
        cardioButton = findViewById(R.id.cardioButton)
        favoriteText = findViewById(R.id.favoriteText)
        dateSubmit = findViewById(R.id.dateSubmit)
        dateInput = findViewById(R.id.date_input)
        dateNavButton = findViewById(R.id.dateNavButton)
        timerNavButton = findViewById(R.id.timerNavButton)

        dateInput.setOnDateChangeListener {
            view, year, month, dayOfMonth ->
            calendar.set(year,month,dayOfMonth)

            dateInput.date = calendar.timeInMillis
        }


        upperBodyButton.setOnClickListener {
            val newIntent = Intent(this, SecondActivity::class.java)
            startActivity(newIntent)
        }
        lowerBodyButton.setOnClickListener {
            val newIntent = Intent(this, LowerActivity::class.java)
            startActivity(newIntent)
        }
        coreButton.setOnClickListener {
            val newIntent = Intent(this, CoreActivity::class.java)
            startActivity(newIntent)
        }
        cardioButton.setOnClickListener {
            val newIntent = Intent(this, CardioActivity::class.java)
            startActivity(newIntent)
        }
        timerNavButton.setOnClickListener {
            val newIntent = Intent(this, TimerActivity::class.java)
            startActivity(newIntent)
        }

        dateSubmit.setOnClickListener {
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
            val selectedDate:Long = dateInput.date
            calendar.timeInMillis = selectedDate
            val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)

            val myPost = JSONObject("""{ "Workout" : "${dateFormatter.format(calendar.time)}" } """)
            val objectPost = JsonObjectRequest(
                Request.Method.POST,
                url,
                myPost,
                { response -> Log.e("Rest Post", response.toString()) }
            ) { error -> Log.e("Rest Post", error.toString()) }
            requestQueue.add(objectPost)

            val intent = Intent(this@MainActivity, ThirdActivity::class.java)
            startActivity(intent)
        }
        dateNavButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ThirdActivity::class.java)
            startActivity(intent)
        }



        val intent = intent
        val favorite = intent.getStringExtra("data")
        favoriteText.text = favorite


    }
}