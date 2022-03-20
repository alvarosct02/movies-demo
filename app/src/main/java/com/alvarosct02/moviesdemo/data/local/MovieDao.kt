package com.alvarosct02.moviesdemo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alvarosct02.moviesdemo.data.local.entities.MovieEntity
import com.alvarosct02.moviesdemo.models.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movieList: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Query("SELECT * FROM MovieEntity WHERE title LIKE '%' || :query || '%' ORDER BY title ASC")
    suspend fun searchMovie(query: String): List<Movie>

    @Query("SELECT * FROM MovieEntity ORDER BY popularity DESC")
    suspend fun getPopularMovies(): List<Movie>

    @Query("SELECT * FROM MovieEntity ORDER BY voteAverage DESC")
    suspend fun getTopRatedMovies(): List<Movie>
}