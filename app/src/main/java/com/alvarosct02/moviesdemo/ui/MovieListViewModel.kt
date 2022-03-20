package com.alvarosct02.moviesdemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarosct02.moviesdemo.data.MovieRepository
import com.alvarosct02.moviesdemo.models.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _categoryPopular = MutableLiveData<List<Movie>>()
    val categoryPopular: LiveData<List<Movie>> = _categoryPopular

    private val _categoryTopRated = MutableLiveData<List<Movie>>()
    val categoryTopRated: LiveData<List<Movie>> = _categoryTopRated


    fun fetchPopular() = viewModelScope.launch {
        val response = movieRepository.getMoviePopular(1)
        _categoryPopular.postValue(response)
    }

    fun fetchTopRated() = viewModelScope.launch {
        val response = movieRepository.getMovieTopRated(1)
        _categoryTopRated.postValue(response)
    }
}

