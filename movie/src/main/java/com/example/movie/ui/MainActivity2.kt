package com.example.movie.ui

import android.os.Bundle
import android.util.Log

import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.movie.R
import com.example.movie.util.IntentKeys


class MainActivity2 : AppCompatActivity() {

    private var dislike: Int = 0
    private var like: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val mTitle: TextView = findViewById(R.id.a_title)
        val mDescription: TextView = findViewById(R.id.a_des)
        val mImage: ImageView = findViewById(R.id.a_image)
        val mTextlike: TextView = findViewById(R.id.textlike)
        val mTextdislike: TextView = findViewById(R.id.textdislike)
        val mLikeImage: ImageView = findViewById(R.id.a_like)
        val mDislikeImage: ImageView = findViewById(R.id.a_dislike)
        title = intent.getStringExtra(IntentKeys.TITLE)
        val des = intent.getStringExtra(IntentKeys.DESCRIPTION)
        val image = intent.getStringExtra(IntentKeys.IMAGE)
        val genre: TextView = findViewById(R.id.genre)
        val percent: TextView = findViewById(R.id.percent)
        mTitle.text = title
        mDescription.text = des
        mImage.load(image)
        if (savedInstanceState != null) {
            like = savedInstanceState.getInt(IntentKeys.LIKE_COUNT)
            dislike = savedInstanceState.getInt(IntentKeys.DISLIKE_COUNT)

        } else {
            like = intent.getIntExtra(IntentKeys.LIKE, 0)
            dislike = intent.getIntExtra(IntentKeys.DISLIKE, 0)
        }
        mTextlike.text = like.toString()
        mTextdislike.text = dislike.toString()


        genre.text = intent.getStringExtra(IntentKeys.GENRE)
        percent.text = intent.getIntExtra(IntentKeys.PERCENTAGE, 0).toString()

        like = mTextlike.text.toString().toInt()
        dislike = mTextdislike.text.toString().toInt()
        mLikeImage.setOnClickListener {
            like += 1
            mTextlike.text = like.toString()
            Log.i("like", "like ${mTextlike.text}")
            Toast.makeText(this, "Liked the Movie", Toast.LENGTH_SHORT).show()

        }
        mDislikeImage.setOnClickListener {
            dislike += 1
            mTextdislike.text = dislike.toString()
            Log.i("like", "dislike ${mTextdislike.text}")
            Toast.makeText(this, "Disliked the Movie", Toast.LENGTH_SHORT).show()

        }

    }





    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }


    override fun onBackPressed() {
        intent.putExtra(IntentKeys.LIKE_COUNT, like)
        intent.putExtra(IntentKeys.DISLIKE_COUNT, dislike)
        intent.putExtra(IntentKeys.ID, intent.getIntExtra(IntentKeys.ID, 0))
        setResult(RESULT_OK, intent)
        super.onBackPressed()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(IntentKeys.LIKE_COUNT, like)
        outState.putInt(IntentKeys.DISLIKE_COUNT, dislike)
        super.onSaveInstanceState(outState)
    }


}