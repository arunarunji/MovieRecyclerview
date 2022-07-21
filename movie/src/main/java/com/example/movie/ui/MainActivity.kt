package com.example.movie.ui

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.adaptor.Adaptor
import com.example.movie.db.DataBase
import com.example.movie.model.Movie
import com.example.movie.util.IntentKeys


class MainActivity : AppCompatActivity() {
    private lateinit var adaptor: Adaptor

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val displayList = DataBase.movieList
        adaptor = Adaptor(displayList, movieSelectedListener)
        recyclerView = findViewById(R.id.recyclerview)

        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = GridLayoutManager(this, 1)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
        recyclerView.adapter = adaptor
    }


    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    )
    { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let {
                adaptor.updateData(

                    it.getIntExtra(IntentKeys.ID, 0),
                    it.getIntExtra(IntentKeys.LIKE_COUNT, 0),
                    it.getIntExtra(IntentKeys.DISLIKE_COUNT, 0)

                )

            }
        }

    }


    private val movieSelectedListener: (Movie) -> Unit = { it ->
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra(IntentKeys.TITLE,it.title)
        intent.putExtra(IntentKeys.DESCRIPTION, it.des)
        intent.putExtra(IntentKeys.IMAGE, it.imageURL)
        intent.putExtra(IntentKeys.LIKE, it.like)
        intent.putExtra(IntentKeys.DISLIKE, it.dislike)
        intent.putExtra(IntentKeys.ID, it.id)
        intent.putExtra(IntentKeys.GENRE, it.genres)
        intent.putExtra(IntentKeys.PERCENTAGE, it.percent)
        resultLauncher.launch(intent)
    }


}



