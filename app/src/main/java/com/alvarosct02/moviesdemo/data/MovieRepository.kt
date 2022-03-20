package com.alvarosct02.moviesdemo.data

import com.alvarosct02.moviesdemo.data.local.MovieDao
import com.alvarosct02.moviesdemo.data.remote.MovieServiceV3
import com.alvarosct02.moviesdemo.data.remote.mappers.MovieMapper
import com.alvarosct02.moviesdemo.data.remote.models.MovieObjectResponse
import com.alvarosct02.moviesdemo.models.Movie
import java.util.concurrent.atomic.AtomicInteger

interface MovieRepository {

    suspend fun searchMovie(
        query: String,
        loadMore: Boolean,
    ): List<Movie>

    suspend fun getMoviePopular(loadMore: Boolean): List<Movie>

    suspend fun getMovieTopRated(loadMore: Boolean): List<Movie>

}

class DefaultMovieRepository(
    private val apiService: MovieServiceV3,
    private val movieDao: MovieDao,
) : MovieRepository {

    private var searchList: List<Movie> = emptyList()
    private var searchPage = AtomicInteger(1)
    override suspend fun searchMovie(query: String, loadMore: Boolean): List<Movie> {
        searchList = makeApiCall(
            apiCall = { apiService.searchMovie(query, popularPage.get()).results },
            fallbackDbCall = { movieDao.searchMovie(query) },
            currentList = searchList,
            page = searchPage,
            loadMore = loadMore,
        )
        return searchList
    }

    private var popularList: List<Movie> = emptyList()
    private var popularPage = AtomicInteger(1)
    override suspend fun getMoviePopular(loadMore: Boolean): List<Movie> {
        popularList = makeApiCall(
            apiCall = { apiService.getMoviePopular(popularPage.get()).results },
            fallbackDbCall = { movieDao.getPopularMovies() },
            currentList = popularList,
            page = popularPage,
            loadMore = loadMore,
        )
        return popularList
    }

    private var topRatedList: List<Movie> = emptyList()
    private var topRatedPage = AtomicInteger(1)
    override suspend fun getMovieTopRated(loadMore: Boolean): List<Movie> {
        topRatedList = makeApiCall(
            apiCall = { apiService.getMovieTopRated(topRatedPage.get()).results },
            fallbackDbCall = { movieDao.getTopRatedMovies() },
            currentList = topRatedList,
            page = topRatedPage,
            loadMore = loadMore,
        )
        return topRatedList
    }

    private suspend fun makeApiCall(
        apiCall: suspend () -> List<MovieObjectResponse>,
        fallbackDbCall: suspend () -> List<Movie>,
        currentList: List<Movie>,
        page: AtomicInteger,
        loadMore: Boolean
    ): List<Movie> {
        if (!loadMore) page.set(1)
        val tempList = if (page.get() == 1) emptyList() else currentList

        return try {
            val results = apiCall()
            movieDao.insertMovies(results.map(MovieMapper::fromResponseToEntity))
            page.addAndGet(1)
            tempList + results.map(MovieMapper::fromResponse)
        } catch (e: Exception) {
            fallbackDbCall()
        }
    }

}