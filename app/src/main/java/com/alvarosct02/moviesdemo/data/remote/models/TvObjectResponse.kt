package com.alvarosct02.moviesdemo.data.remote.models

data class TvObjectResponse(
    val posterPath: String?,
    val popularity: Double?,
    val id: Int?,
    val backdropPath: String?,
    val voteAverage: Double?,
    val overview: String?,
    val firstAirDate: String?,
//    originCountry: Array<String>?,
//    genreIds: Array<Int>?,
    val originalLanguage: String?,
    val voteCount: Int?,
    val name: String?,
    val originalName: String?,
)