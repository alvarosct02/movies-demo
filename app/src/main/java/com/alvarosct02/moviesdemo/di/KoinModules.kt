package com.alvarosct02.moviesdemo.di

import com.alvarosct02.moviesdemo.data.DefaultMovieRepository
import com.alvarosct02.moviesdemo.data.MovieRepository
import com.alvarosct02.moviesdemo.data.remote.MovieServiceV3
import com.alvarosct02.moviesdemo.data.remote.RetrofitFactory
import com.alvarosct02.moviesdemo.ui.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoriesModule = module {
    single<MovieServiceV3> { RetrofitFactory().getApiService() }
    single<MovieRepository> { DefaultMovieRepository(get()) }
}

val viewModelsModule = module {
    viewModel { MovieListViewModel(get()) }
}