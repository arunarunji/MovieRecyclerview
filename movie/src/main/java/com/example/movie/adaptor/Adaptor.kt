package com.example.movie.adaptor

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movie.R
import com.example.movie.model.Movie

class Adaptor(
    private val movieList: MutableList<Movie>,
    val movieSelectedListener: (movie: Movie) -> Unit
) :
    RecyclerView.Adapter<Adaptor.ViewHolder>() {
    companion object
    {
        var onCreate:Int=0
        var onBind:Int=0
        var onViewHolder:Int=0
        var getItem:Int=0
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(movie: Movie) {
            itemView.findViewById<TextView>(R.id.title1).text = movie.title
            itemView.findViewById<TextView>(R.id.description).text = movie.genres
            itemView.findViewById<ImageView>(R.id.image).load(movie.imageURL)
            itemView.findViewById<TextView>(R.id.textlike).text = movie.like.toString()
            itemView.findViewById<TextView>(R.id.textdislike).text = movie.dislike.toString()
            itemView.findViewById<TextView>(R.id.time).text=movie.time
            itemView.findViewById<TextView>(R.id.percent).text=movie.percent.toString()
            Log.i("arun","onBindItems  ${++onViewHolder}")

        }
        init {
            Log.i("arun","inside the init $onCreate")
        }
    }

    fun updateData(id: Int, like: Int, dislike: Int) {
        Log.i("like","$like")
        Log.i("dislike","$dislike")
        var selectedIndex: Int = -1
        for ((index, movie) in movieList.withIndex()) {
            if (movie.id == id) {
                movie.like = like
                movie.dislike = dislike
                selectedIndex = index
                break
            }
        }
        if (selectedIndex != -1)
            notifyItemChanged(selectedIndex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        Log.i("arun","onCreateViewHolder   ${++onCreate}")
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(movieList[position])
        holder.itemView.setOnClickListener {
            val movie = movieList[position]
            movieSelectedListener(movie)
        }
        Log.i("arun","onBindViewHolder   ${++onBind}")
    }

    override fun getItemCount(): Int {
       Log.i("arun","getItem   ${++getItem}")
        return movieList.size
    }


}

