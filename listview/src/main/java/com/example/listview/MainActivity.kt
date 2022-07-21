package com.example.listview

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var appData: AppData

    //    private lateinit var nameAdaptor:CustomBaseAdaptor
    lateinit var listviewRecyclerAdaptor: ListviewRecyclerAdaptor
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        listView = findViewById(R.id.listview)
        appData = AppData.getAppData(resources)
//        nameAdaptor = CustomBaseAdaptor(this, appData.people)
//        listView.adapter = nameAdaptor

        recyclerView = findViewById(R.id.recyclerview)
        listviewRecyclerAdaptor = ListviewRecyclerAdaptor(appData.people, this)
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true)
        val gridLayoutManager=GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false)
       gridLayoutManager.spanSizeLookup
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = listviewRecyclerAdaptor


    }
}