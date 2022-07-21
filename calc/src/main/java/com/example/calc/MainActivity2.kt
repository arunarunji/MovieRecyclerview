package com.example.calc


import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private var num1 = 0
    private var num2 = 0
    private var res = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)
        num1 = intent.getIntExtra("Number1", 0)
        num2 = intent.getIntExtra("Number2", 0)



        findViewById<TextView>(R.id.number).text = "Numbers :  $num1  ,$num2"
        findViewById<Button>(R.id.add).setOnClickListener(this)
        findViewById<Button>(R.id.sub).setOnClickListener(this)
        findViewById<Button>(R.id.multiply).setOnClickListener(this)
        findViewById<Button>(R.id.divide).setOnClickListener(this)




    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            Toast.makeText(applicationContext, "Portrait Mode", Toast.LENGTH_LONG).show()
        else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Toast.makeText(applicationContext, "Landscape Mode", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View) {
        Log.i("arun", num1.toString())
        Log.i("arun", num2.toString())
        res=when (view.id) {
            R.id.add ->  num1 + num2
            R.id.sub -> num1 - num2
            R.id.divide -> num1 / num2
            R.id.multiply ->  num1 * num2
            else -> 0
        }
        Log.i("arun", res.toString())
        Intent().also {
            it.putExtra("result", res)
            setResult(Activity.RESULT_OK, it)
            finish()

        }


    }
}