package com.example.project_clean_paging3_dsl_2022.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.example.components.ApiResponse
import com.example.components.SinglePagingLiveEvent
import com.example.convertErrorApi
import com.example.domain.model.ResultMapper
import com.example.domain.usecase.MoviesPopularPageUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

class MoviePopularPageViewModel(
    private val useCase: MoviesPopularPageUseCase
) : ViewModel() {

    private val _popularMovies = SinglePagingLiveEvent<ApiResponse<PagingData<ResultMapper>>>()
    val popularMovies: LiveData<ApiResponse<PagingData<ResultMapper>>> get() = _popularMovies

    var disposable = CompositeDisposable()

    @ExperimentalCoroutinesApi
    fun getPopularMoviesPage() = viewModelScope.launch {
             useCase
                .invoke()
                .observeOn(AndroidSchedulers.mainThread())
                 .doOnSubscribe {
                     _popularMovies.value = ApiResponse.Loading
                 }
                .subscribe({ response ->
                    _popularMovies.value = ApiResponse.Success(
                        data = response.map { it.toResultMapper() }
                    )
                },{ err ->
                    _popularMovies.value = ApiResponse.Failure(
                         errorMessage = convertErrorApi(err)
                    )
                }).addTo(disposable)
        }

    fun start() {
        if (disposable.isDisposed) {
            disposable = CompositeDisposable()
        }
    }

    fun destroy() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

}





