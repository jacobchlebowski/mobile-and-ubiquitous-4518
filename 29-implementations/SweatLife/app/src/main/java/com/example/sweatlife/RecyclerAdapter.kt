package com.example.sweatlife


import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.sweatlife.RecyclerAdapter.MyViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.util.ArrayList


class RecyclerAdapter(private val datesList: ArrayList<String>) :
    RecyclerView.Adapter<MyViewHolder>() {



    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateTxt: TextView
        val deleteDateButton: Button
        init {
            dateTxt = view.findViewById(R.id.textView2)
            deleteDateButton = view.findViewById(R.id.deleteDateButton)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val date = datesList[position]
        holder.dateTxt.text = date
        holder.deleteDateButton.setOnClickListener {
            val url = "http://10.0.2.2:8888/sjson"
            val requestQueue = Volley.newRequestQueue(holder.itemView.context)
            val myDelete = JSONObject("""{ "Workout" : "$date" } """)
            val objectPost = JsonObjectRequest(
                Request.Method.PUT,
                url,
                myDelete,
                { response -> Log.e("Rest Delete", response.toString()) }
            ) { error -> Log.e("Rest Delete", error.toString()) }
            requestQueue.add(objectPost)

            datesList.remove(datesList[position])
            notifyItemRemoved(position);
            notifyItemRangeChanged(position,datesList.size)
        }
    }

    override fun getItemCount(): Int {
        return datesList.size
    }
}