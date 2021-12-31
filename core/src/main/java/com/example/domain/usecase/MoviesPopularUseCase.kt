package com.example.domain.usecase

import com.example.data.remote.MoviesPopularResponse
import io.reactivex.Observable

interface MoviesPopularUseCase
{
    operator fun invoke(key: String) : Observable<MoviesPopularResponse>
}
