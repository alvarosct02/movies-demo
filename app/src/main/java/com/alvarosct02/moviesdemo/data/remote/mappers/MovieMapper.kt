package com.alvarosct02.moviesdemo.data.remote.mappers

import com.alvarosct02.moviesdemo.data.local.entities.MovieEntity
import com.alvarosct02.moviesdemo.data.remote.models.MovieObjectResponse
import com.alvarosct02.moviesdemo.models.Movie

object MovieMapper {

    fun fromResponse(movieObjectResponse: MovieObjectResponse) = movieObjectResponse.let {
        Movie(
            posterPath = it.posterPath,
            adult = it.adult,
            overview = it.overview,
            releaseDate = it.releaseDate,
            id = it.id,
            originalTitle = it.originalTitle,
            originalLanguage = it.originalLanguage,
            title = it.title,
            backdropPath = it.backdropPath,
            popularity = it.popularity,
            voteCount = it.voteCount,
            video = it.video,
            voteAverage = it.voteAverage,
        )
    }

    fun fromResponseToEntity(movieObjectResponse: MovieObjectResponse) = movieObjectResponse.let {
        MovieEntity(
            posterPath = it.posterPath,
            adult = it.adult,
            overview = it.overview,
            releaseDate = it.releaseDate,
            id = it.id,
            originalTitle = it.originalTitle,
            originalLanguage = it.originalLanguage,
            title = it.title,
            backdropPath = it.backdropPath,
            popularity = it.popularity,
            voteCount = it.voteCount,
            video = it.video,
            voteAverage = it.voteAverage,
        )
    }
}