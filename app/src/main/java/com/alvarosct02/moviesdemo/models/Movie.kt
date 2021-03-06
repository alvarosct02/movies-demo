package com.alvarosct02.moviesdemo.models

data class Movie(
    val posterPath: String?,
    val adult: Boolean?,
    val overview: String?,
    val releaseDate: String?,
//    val genreIds: Array<Int>?,
    val id: Int?,
    val originalTitle: String?,
    val originalLanguage: String?,
    var title: String?,
    val backdropPath: String?,
    val popularity: Double?,
    val voteCount: Int?,
    val video: Boolean?,
    val voteAverage: Double?,
)