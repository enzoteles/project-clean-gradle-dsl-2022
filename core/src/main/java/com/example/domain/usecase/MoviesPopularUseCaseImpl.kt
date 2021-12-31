package com.example.domain.usecase

import com.example.domain.repository.MoviesPopularRepository


class MoviesPopularUseCaseImpl(
    private val repository: MoviesPopularRepository
): MoviesPopularUseCase {
    override fun invoke(key: String) = repository.getPopularMovies(key)
}
