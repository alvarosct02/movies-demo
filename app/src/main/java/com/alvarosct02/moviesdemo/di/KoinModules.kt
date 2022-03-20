package com.alvarosct02.moviesdemo.di

import com.alvarosct02.moviesdemo.data.remote.MovieServiceV3
import com.alvarosct02.moviesdemo.data.remote.RetrofitFactory
import org.koin.dsl.module

val repositoriesModule = module {
    single<MovieServiceV3> { RetrofitFactory().getApiService() }
}
