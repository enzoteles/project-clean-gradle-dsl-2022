package com.example.domain.usecase

import androidx.paging.PagingData
import io.reactivex.Flowable
import com.example.data.remote.Result

interface MoviesPopularPageUseCase
{
    operator fun invoke() : Flowable<PagingData<Result>>
}
