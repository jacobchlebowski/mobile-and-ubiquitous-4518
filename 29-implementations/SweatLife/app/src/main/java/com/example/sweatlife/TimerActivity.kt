package com.example.sweatlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView

class TimerActivity : AppCompatActivity() {
    private lateinit var returnButton: Button
    private lateinit var startButton: Button
    private lateinit var resetButton: Button
    private lateinit var timerText: TextView
    private lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        returnButton = findViewById(R.id.return_Button)
        timerText = findViewById(R.id.timerText)

        timer = object : CountDownTimer(60_000,50) {
            override fun onTick(remaining: Long) {
                timerText.text = remaining.toString()
            }

            override fun onFinish() {
                timerText.text = "Times up!"
            }

        }

        returnButton.setOnClickListener {
            finish()
        }


    }

    override fun onStart() {
        startButton = findViewById(R.id.startButton)
        resetButton = findViewById(R.id.resetButton)
        super.onStart()
        startButton.setOnClickListener() {
            timer.start()
        }
        resetButton.setOnClickListener() {
            timer.cancel()
        }
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("timer_text",timerText.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val timeLeft = savedInstanceState.getString("timer_text")
//        timerText.text = savedInstanceState.getString("timer_text")
        timer = object : CountDownTimer(java.lang.Long.valueOf(timeLeft),50) {
            override fun onTick(remaining: Long) {
                timerText.text = remaining.toString()
            }

            override fun onFinish() {
                timerText.text = "Times up!"
            }

        }
        timer.start()
    }

}