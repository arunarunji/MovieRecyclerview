package com.example.movie.model

data class Movie(val id:Int, val percent:Int, val title:String, val time:String, val genres:String, val lang:String, val des:String, val imageURL:String,
                 var like:Int=10, var dislike:Int=10,) {
}

