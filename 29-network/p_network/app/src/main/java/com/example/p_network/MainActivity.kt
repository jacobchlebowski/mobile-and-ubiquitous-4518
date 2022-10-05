package com.example.p_network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.example.p_network.R
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject
import com.android.volley.VolleyError

class MainActivity : AppCompatActivity() {
    private lateinit var postButton: Button
    private lateinit var getButton: Button
    private lateinit var putButton: Button
    private lateinit var deleteButton: Button
    private lateinit var serverText: TextView
    private lateinit var postID: EditText
    private lateinit var postValue: EditText
    private lateinit var putID: EditText
    private lateinit var putValue: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        serverText = findViewById(R.id.display)
        getButton = findViewById(R.id.getButton)
        postButton = findViewById(R.id.postButton)
        putButton = findViewById(R.id.putButton)
        deleteButton = findViewById(R.id.deleteButton)
        postID = findViewById(R.id.postID)
        postValue = findViewById(R.id.postValue)
        putID = findViewById(R.id.putID)
        putValue = findViewById(R.id.putValue)

        val url = "http://10.0.2.2:8888/sjson"
        val requestQueue = Volley.newRequestQueue(this)
        getButton.setOnClickListener {
            val objectRequest = JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                { response -> Log.e("Rest Response", response.toString());
                    serverText.text = response.toString() }
            ) { error -> Log.e("Rest Response", error.toString())}
            requestQueue.add(objectRequest)


        }

        postButton.setOnClickListener() {
            val myPost = JSONObject("""{ "${postID.text.toString().trim()}" : "${postValue.text.toString().trim()}" } """)
            val objectPost = JsonObjectRequest(
                Request.Method.POST,
                url,
                myPost,
                { response -> Log.e("Rest Post", response.toString()) }
                ) { error -> Log.e("Rest Post", error.toString()) }
            requestQueue.add(objectPost)
        }

        putButton.setOnClickListener {
            val myPost = JSONObject("""{ "${putID.text.toString().trim()}" : "${putValue.text.toString().trim()}" } """)
            val objectPost = JsonObjectRequest(
                Request.Method.PUT,
                url,
                myPost,
                { response -> Log.e("Rest Put", response.toString()) }
            ) { error -> Log.e("Rest Put", error.toString()) }
            requestQueue.add(objectPost)
        }

        deleteButton.setOnClickListener() {
            val myPost = JSONObject("""{ "color" : "Hello Professor Guo" }""")
            val objectPost = JsonObjectRequest(
                Request.Method.DELETE,
                url,
                myPost,
                { response -> Log.e("Rest DELETE", response.toString()) }
            ) { error -> Log.e("Rest DELETE", error.toString()) }
            requestQueue.add(objectPost)
        }

    }
}