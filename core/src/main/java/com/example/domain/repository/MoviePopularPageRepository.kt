package com.example.domain.repository

import androidx.paging.PagingData
import io.reactivex.Flowable
import com.example.data.remote.Result

interface MoviePopularPageRepository {
    fun getPopularMoviesPage(): Flowable<PagingData<Result>>
}