package com.example.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.example.data.datasource.MoviesPopularSource
import com.example.data.remote.Result
import io.reactivex.Flowable

class MoviePopularPageRepositoryImpl(
    private val datasource: MoviesPopularSource
): MoviePopularPageRepository {

    override fun getPopularMoviesPage(): Flowable<PagingData<Result>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 40
            ),
            pagingSourceFactory = {
                datasource
            }
        ).flowable
    }
}