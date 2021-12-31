package com.example.project_clean_paging3_dsl_2022.presentation.ui.viewmodel

import androidx.paging.PagingData
import io.reactivex.Flowable
import com.example.data.remote.Result

class MoviesPopularPageUseCaseImpl(
    private val repository: MoviePopularPageRepository
): MoviesPopularPageUseCase
{
    override fun invoke(): Flowable<PagingData<Result>>  = repository.getPopularMoviesPage()
}
