package com.example.data.repository

import com.example.data.datasource.MoviesAPI
import com.example.domain.repository.MoviesPopularRepository

class MoviesPopularRepositoryImpl(
    private val api: MoviesAPI
) : MoviesPopularRepository {
    override fun getPopularMovies(apiKey: String) = api.getPopularMovies(apiKey)
}