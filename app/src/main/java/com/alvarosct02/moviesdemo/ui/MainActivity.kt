package com.alvarosct02.moviesdemo.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alvarosct02.moviesdemo.R
import com.alvarosct02.moviesdemo.data.remote.MovieServiceV3
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val movieService by inject<MovieServiceV3>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        TODO: Pending Repositories
        GlobalScope.launch {
            Log.e("ASCT", "Movies Page 1: ${movieService.getMoviePopular(1).results.size}")

            Log.e("ASCT", "Friends Result: ${movieService.searchTv("friends").results.size}")
        }
    }
}