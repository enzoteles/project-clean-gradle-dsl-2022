package com.example.data.datasource

import com.example.core.BuildConfig
import com.example.data.remote.MoviesPopularResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {

    @GET("/3/movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ) : Observable<MoviesPopularResponse>

    @GET("/3/movie/popular")
    fun getPopularMoviesPage(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = PAGE
    ) : Single<MoviesPopularResponse>

    companion object {
        val PAGE = 1
    }
}