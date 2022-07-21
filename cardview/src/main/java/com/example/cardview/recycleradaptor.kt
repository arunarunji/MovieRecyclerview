package com.example.cardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class recycleradaptor(val countryList: MutableList<String>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val v =LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       holder.itemView.findViewById<TextView>(R.id.im1).text=countryList[position]
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
 var itemImageView: ImageView
 var itemtitle:TextView

init {
    itemImageView=itemView.findViewById(R.id.im1)
    itemtitle=itemView.findViewById(R.id.tv1)
    itemView.setOnClickListener()
    {
        val position:Int= adapterPosition
        Toast.makeText(itemView.context,"You have clicked the ${countryList[position]}",Toast.LENGTH_SHORT).show()

    }
}

    }
}