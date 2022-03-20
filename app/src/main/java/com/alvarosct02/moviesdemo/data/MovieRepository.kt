package com.alvarosct02.moviesdemo.data

import com.alvarosct02.moviesdemo.data.remote.MovieServiceV3
import com.alvarosct02.moviesdemo.data.remote.mappers.MovieMapper
import com.alvarosct02.moviesdemo.models.Movie

interface MovieRepository {

    suspend fun searchMovie(
        query: String,
    ): List<Movie>

    suspend fun getMoviePopular(
        page: Int,
    ): List<Movie>

    suspend fun getMovieTopRated(
        page: Int,
    ): List<Movie>

}

class DefaultMovieRepository(
    private val apiService: MovieServiceV3
) : MovieRepository {
    override suspend fun searchMovie(query: String): List<Movie> {
        return apiService.searchMovie(query).results.map {
            MovieMapper.fromResponse(it)
        }
    }

    override suspend fun getMoviePopular(page: Int): List<Movie> {
        return apiService.getMoviePopular(page).results.map {
            MovieMapper.fromResponse(it)
        }
    }

    override suspend fun getMovieTopRated(page: Int): List<Movie> {
        return apiService.getMovieTopRated(page).results.map {
            MovieMapper.fromResponse(it)
        }
    }

}