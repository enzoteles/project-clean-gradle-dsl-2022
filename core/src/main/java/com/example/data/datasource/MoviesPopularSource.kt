package com.example.data.datasource

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.example.core.BuildConfig
import com.example.data.datasource.MoviesAPI
import com.example.data.remote.Result
import com.example.data.remote.MoviesPopularResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MoviesPopularSource(
    private val api: MoviesAPI
) : RxPagingSource<Int, Result>(){


    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Result>> {
        var nextPageNumber = params.key
        if(nextPageNumber == null){
            nextPageNumber = 1
        }

        return api.getPopularMoviesPage(BuildConfig.API_KEY, nextPageNumber)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it, nextPageNumber) }
            .onErrorReturn { LoadResult.Error(it) }

    }

    private fun toLoadResult(data: MoviesPopularResponse, nextPageNumber: Int): LoadResult<Int, Result>{

        return LoadResult.Page(
            data = data.results,
            prevKey = if(nextPageNumber == 1) null else nextPageNumber - 1,
            nextKey = if(nextPageNumber == data.total_pages) null else nextPageNumber + 1,
            LoadResult.Page.COUNT_UNDEFINED,
            LoadResult.Page.COUNT_UNDEFINED
        )

    }




}