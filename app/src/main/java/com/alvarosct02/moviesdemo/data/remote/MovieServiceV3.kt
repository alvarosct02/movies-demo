package com.alvarosct02.moviesdemo.data.remote

import com.alvarosct02.moviesdemo.data.remote.models.MovieObjectResponse
import com.alvarosct02.moviesdemo.data.remote.models.PagedResponse
import com.alvarosct02.moviesdemo.data.remote.models.TvObjectResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServiceV3 {

    @GET("search/tv")
    suspend fun searchTv(
        @Query("query") query: String,
    ): PagedResponse<TvObjectResponse>

    @GET("tv/popular")
    suspend fun getTvPopular(
        @Query("page") page: Int,
    ): PagedResponse<TvObjectResponse>

    @GET("tv/top_rated")
    suspend fun getTvTopRated(
        @Query("page") page: Int,
    ): PagedResponse<TvObjectResponse>

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
    ): PagedResponse<MovieObjectResponse>

    @GET("movie/popular")
    suspend fun getMoviePopular(
        @Query("page") page: Int,
    ): PagedResponse<MovieObjectResponse>

    @GET("movie/top_rated")
    suspend fun getMovieTopRated(
        @Query("page") page: Int,
    ): PagedResponse<MovieObjectResponse>

}


