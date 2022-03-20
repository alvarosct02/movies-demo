package com.alvarosct02.moviesdemo.data.remote

import com.alvarosct02.moviesdemo.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import java.util.concurrent.TimeUnit
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitFactory {

    fun getApiService(): MovieServiceV3 {
        val connectionPool = ConnectionPool()
        val client = OkHttpClient.Builder()
            .connectionPool(connectionPool)
            .retryOnConnectionFailure(false)
            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor {
                val request = it.request().newBuilder()
                    .addHeader(AUTHORIZATION_HEADER, AUTHORIZATION_BEARER + BuildConfig.API_TOKEN)
                    .build()
                it.proceed(request)
            }
            .addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(MovieServiceV3::class.java)
    }

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
        private const val AUTHORIZATION_BEARER = "Bearer "
        private const val TIMEOUT_SECONDS = 10L
    }
}
