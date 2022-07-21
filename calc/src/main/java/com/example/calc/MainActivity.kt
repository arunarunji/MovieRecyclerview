package com.example.calc

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {


    private lateinit var resultTextView: TextView
    val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    )
    { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let {
                Log.i("arun", it.getIntExtra("result", 0).toString())

                resultTextView.text = it.getIntExtra("result", 0).toString()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById<TextView>(R.id.result)
        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        findViewById<Button>(R.id.button).setOnClickListener {
            if (num1.text.toString() == " " || num2.text.toString() == " ")
                Toast.makeText(this, "Please Enter the Number ", Toast.LENGTH_SHORT).show()
            else {
                Intent(this, MainActivity2::class.java).also {

                    it.putExtra("Number1", num1.text.toString().toInt())
                    it.putExtra("Number2", num2.text.toString().toInt())

                    resultLauncher.launch(it)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("result", resultTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        resultTextView.text = savedInstanceState.getString("result", "Hello")

    }


}