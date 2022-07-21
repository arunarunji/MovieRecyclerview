package com.example.androidbasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnApply).setOnClickListener {
            val name= findViewById<EditText>(R.id.etName).text.toString()
            val age =findViewById<EditText>(R.id.etAge).text.toString().toInt()
            val country =findViewById<EditText>(R.id.etCountry).text.toString()
            Intent(this,MainActivity2::class.java).also {
                it.putExtra("Name",name)
                it.putExtra("Age",age)
                it.putExtra("Country",country)
                startActivity(it) }


        }
    }
}