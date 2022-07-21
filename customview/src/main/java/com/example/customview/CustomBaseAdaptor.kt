package com.example.customview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomBaseAdaptor(
    context: Context,
    var fruitList: MutableList<String>,
    var images: MutableList<Int>
) : BaseAdapter() {

    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return fruitList.size

    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }


    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val convertView = inflater.inflate(R.id.customListview, null) as TextView
        val textView = convertView.findViewById<TextView>(R.id.textview)
        val imageView = convertView.findViewById<ImageView>(R.id.imageicon)
        textView.text = fruitList[p0]
        imageView.setImageResource(images[p0])
        return convertView

    }
}