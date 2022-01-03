package com.example.domain.usecase

import androidx.paging.PagingData
import io.reactivex.Flowable
import com.example.data.remote.Result
import com.example.domain.repository.MoviePopularPageRepository

class MoviesPopularPageUseCaseImpl(
    private val repository: MoviePopularPageRepository
): MoviesPopularPageUseCase
{
    override fun invoke(): Flowable<PagingData<Result>>  = repository.getPopularMoviesPage()
}
