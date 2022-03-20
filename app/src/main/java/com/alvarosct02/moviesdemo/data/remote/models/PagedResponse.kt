package com.alvarosct02.moviesdemo.data.remote.models

data class PagedResponse<T>(
    val page: Int,
    val results: List<T>,
    val totalResults: Int,
    val totalPages: Int,
)