package com.rio.roombasic


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread {
            val daoAccess = MovieDatabase.getInstance(applicationContext).daoAccess()
            val movie = Movies()

            movie.movieId = "2"
            movie.movieName = "Aquaman"

            daoAccess.insertOnlySingleMovie(movie)
            Log.d("RoomTest", daoAccess.fetchOneMoviesbyMovieId(2).movieName)
        }
    }
}
