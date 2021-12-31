package com.example.domain.model

data class ResultMapper(
    val id: Int,
    val title: String,
    val overview: String,
    val release_date: String,
    val original_language: String,
    val vote_average: String,
    val poster_path: String,
    val backdrop_path: String
)