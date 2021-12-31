package com.example.domain.repository

import com.example.core.BuildConfig
import com.example.data.remote.MoviesPopularResponse
import io.reactivex.Observable

interface MoviesPopularRepository {

    fun getPopularMovies(
        apiKey: String = BuildConfig.API_KEY
    ) : Observable<MoviesPopularResponse>
}