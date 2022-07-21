package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private val fruitList: MutableList<String> =
        mutableListOf("Apple", "Mango", "Banana", "Grapes", "Lemon")
    private val ImageList: MutableList<Int> = mutableListOf(
        R.drawable.apple,
        R.drawable.mango,
        R.drawable.banana,
        R.drawable.grapes,
        R.drawable.lemon
    )
private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.customListview)
        val adaptor:CustomBaseAdaptor=CustomBaseAdaptor(applicationContext,fruitList,ImageList)
        listView.adapter=adaptor
    }
}