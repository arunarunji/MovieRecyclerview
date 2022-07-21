package com.example.listview

import android.content.Context
import android.os.Build
import android.util.ArraySet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
class CustomBaseAdaptor(private val context: Context, private val people: MutableList<Person>) :
    BaseAdapter() {
    private val viewset: MutableSet<View>


    init {
        viewset = ArraySet<View>()
    }

    override fun getCount(): Int {
        return people.size
    }

    override fun getItem(p0: Int): Any {
        return people[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, view: View?, p2: ViewGroup?): View? {
        lateinit var personViewHolder: PersonViewHolder
        val inflater = LayoutInflater.from(context)
        val person: Person = people[p0]
        var currentView: View? = null
        if (view == null) {
            currentView = inflater.inflate(R.layout.customlayoutperson, null).also {

                personViewHolder = PersonViewHolder()
                personViewHolder.textViewName = it.findViewById(R.id.textViewName)
                personViewHolder.textViewLastName = it.findViewById(R.id.textViewLastName)
                personViewHolder.textViewGender = it.findViewById(R.id.textViewGender)
                personViewHolder.textViewNationality = it.findViewById(R.id.textViewNationality)
                it.tag = personViewHolder
            }

        } else {
            personViewHolder = view.tag as PersonViewHolder
        }

        personViewHolder.also {
            it.textViewName.text = person.name
            it.textViewLastName.text = person.lastName
            it.textViewGender.text = person.gender.toString()
            it.textViewNationality.text = person.nationality


        }



        if (currentView != null) {
            viewset.add(currentView)
        }


        Log.i("arun", "Index : $p0 : $currentView   Size : ${viewset.size}")
        return currentView
    }

    private class PersonViewHolder {
        lateinit var textViewName: TextView
        lateinit var textViewLastName: TextView
        lateinit var textViewGender: TextView
        lateinit var textViewNationality: TextView
    }
}