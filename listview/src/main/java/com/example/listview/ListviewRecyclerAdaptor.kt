package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListviewRecyclerAdaptor(
    private val people: MutableList<Person>,
    private val context: Context
) :
    RecyclerView.Adapter<PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
       val view:View=LayoutInflater.from(context).inflate(R.layout.customlayoutperson,parent,false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person: Person = people[position]
        holder.textViewName.text = person.name
        holder.textViewLastName.text = person.lastName
        holder.textViewGender.text = person.gender.toString()
        holder.textViewNationality.text = person.nationality
    }

    override fun getItemCount(): Int {
        return people.size
    }

}


class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    var textViewLastName: TextView = itemView.findViewById(R.id.textViewName)
    var textViewGender: TextView = itemView.findViewById(R.id.textViewGender)
    var textViewNationality: TextView = itemView.findViewById(R.id.textViewNationality)

}
