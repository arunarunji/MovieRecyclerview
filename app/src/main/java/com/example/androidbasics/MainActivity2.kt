package com.example.androidbasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val name=intent.getStringExtra("Name")
        val age=intent.getIntExtra("Age",0)
        val country=intent.getStringExtra("Country")

        val person="$name is $age years old and living in $country"
        findViewById<TextView>(R.id.tvperson).text=person

    }
}