package com.example.sweatlife


import androidx.recyclerview.widget.RecyclerView
import com.example.sweatlife.RecyclerAdapter.MyViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
            val text = "Insert Delete Implementation Here"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(holder.deleteDateButton.context, text, duration)
            toast.show()
        }
    }

    override fun getItemCount(): Int {
        return datesList.size
    }
}