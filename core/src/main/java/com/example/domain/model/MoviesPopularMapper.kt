package com.example.domain.model

data class MoviesPopularMapper(
    val page: Int,
    val results: List<ResultMapper>,
    val total_pages: Int,
)