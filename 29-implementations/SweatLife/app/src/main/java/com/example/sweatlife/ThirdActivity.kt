package com.example.sweatlife

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


class ThirdActivity : AppCompatActivity() {
    companion object {
        var datesList = ArrayList<String>()
    }

    private lateinit var returnButton: Button
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        recyclerView = findViewById(R.id.recycleView)
        datesList.clear()
        setUserInfo()
        setAdapter()

        returnButton = findViewById(R.id.return_Button)

        returnButton.setOnClickListener {
            finish()
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
        datesList.add("Click this to load your data in")
        val url = "http://10.0.2.2:8888/sjson"
        val requestQueue = Volley.newRequestQueue(this)
        val objectPost = JsonArrayRequest(Request.Method.GET, url, null, {
                response ->
                Log.e("Rest Get", response.toString())
            for (i in 0 until response.length()) {
                val dateNeeded = response.getJSONObject(i)
                datesList.add(dateNeeded.getString("Workout").toString())
                Log.e("this is inside", datesList.toString())
                }
            }
        ) { error -> Log.e("Rest Get", error.toString()) }


        requestQueue.add(objectPost)
        Log.e("datesList", datesList.toString())
    }
}