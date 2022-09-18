package com.example.sweatlife

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ThirdActivity : AppCompatActivity() {
    companion object {
        var datesList = ArrayList<String>()
        var firstTime = 0
    }

    private lateinit var returnButton: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        recyclerView = findViewById(R.id.recycleView)

        setUserInfo()
        setAdapter()

        returnButton = findViewById(R.id.return_Button)

        returnButton.setOnClickListener {
            finish()
        }

        val dateIntent = intent
        val dateValue = dateIntent.getStringExtra("date")
        if (dateValue != null) {
            datesList.add(dateValue.toString())
        }
    }

    private fun setAdapter(){
        val adapter = RecyclerAdapter(datesList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
    }
    private fun setUserInfo(){
        if (firstTime == 0) {
            datesList.add("9/1/22")
            datesList.add("9/2/22")
            datesList.add("9/3/22")
            datesList.add("9/4/22")
            datesList.add("9/5/22")
            datesList.add("9/6/22")
            datesList.add("9/7/22")
            datesList.add("9/8/22")
            datesList.add("9/9/22")
            datesList.add("9/10/22")
            datesList.add("9/11/22")
            datesList.add("9/12/22")
            datesList.add("9/13/22")
            datesList.add("9/14/22")
            datesList.add("9/15/22")
            datesList.add("9/16/22")
            datesList.add("9/17/22")
            datesList.add("9/18/22")
            datesList.add("9/19/22")
            datesList.add("9/20/22")
            firstTime = 1
        }
    }

}