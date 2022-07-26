package com.example.cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recycleradaptor: recycleradaptor

    private var countryList = mutableListOf<String>("ksdjfi","kasdghfi","kdshff","kdfhv","jhdfvfjhvdfh","dfgvfdg","kdjfhgvkjfd","kadufgvlfd","kdfgvfb")
    private var displayList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayList.addAll(countryList)
        recyclerView=findViewById(R.id.recyclerview)
        recycleradaptor=recycleradaptor(displayList)
        recyclerView.adapter=recycleradaptor
    }
}