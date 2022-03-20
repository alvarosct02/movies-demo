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
    val popularLoading = MutableLiveData(false)

    private val _categoryTopRated = MutableLiveData<List<Movie>>()
    val categoryTopRated: LiveData<List<Movie>> = _categoryTopRated
    val topRatedLoading = MutableLiveData(false)

    fun fetchPopular(loadMore: Boolean = false) = viewModelScope.launch {
        val response = movieRepository.getMoviePopular(loadMore)
        _categoryPopular.value = response
        popularLoading.postValue(false)
    }

    fun fetchTopRated(loadMore: Boolean = false) = viewModelScope.launch {
        val response = movieRepository.getMovieTopRated(loadMore)
        _categoryTopRated.postValue(response)
    }
}

fun LiveData<Boolean>.checkAndEnable(): Boolean {
    val boolValue = this.value
    if (boolValue == true) (this as? MutableLiveData<Boolean>)?.value = true
    return boolValue ?: false
}

