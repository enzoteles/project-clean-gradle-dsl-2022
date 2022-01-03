package com.example.data.di

import com.example.core.BuildConfig
import com.example.data.datasource.MoviesAPI
import com.example.data.repository.MoviesPopularRepositoryImpl
import com.example.domain.repository.MoviePopularPageRepository
import com.example.domain.repository.MoviePopularPageRepositoryImpl
import com.example.domain.repository.MoviesPopularRepository
import com.example.domain.usecase.MoviesPopularPageUseCase
import com.example.domain.usecase.MoviesPopularPageUseCaseImpl
import com.example.domain.usecase.MoviesPopularUseCase
import com.example.domain.usecase.MoviesPopularUseCaseImpl
import com.example.data.datasource.MoviesPopularSource
import com.example.project_clean_paging3_dsl_2022.presentation.ui.viewmodel.*
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofitModule = module {
    factory<Interceptor> {
        HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger.DEFAULT
        ).setLevel(
            HttpLoggingInterceptor.Level.BODY
        )
    }

    factory {
        OkHttpClient.Builder().addInterceptor(
            interceptor = get()
        ).build()
    }
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BuildConfig.MOVIE_RICK_AND_MORT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}

val apiModule = module {
    single(createdAtStart = false) {
        get<Retrofit>().create(MoviesAPI::class.java)
    }
}

val moviesPopularModule = module {

    //inject repository
    single<MoviesPopularRepository>{
        MoviesPopularRepositoryImpl(
            api = get()
        )
    }

    // datasource page
    factory {
        MoviesPopularSource(api = get())
    }

    //inject repository page
    single<MoviePopularPageRepository>{
        MoviePopularPageRepositoryImpl(
            datasource = get()
        )
    }

    //inject useCase
    single<MoviesPopularUseCase>{
        MoviesPopularUseCaseImpl(
            repository = get()
        )
    }

    single<MoviesPopularPageUseCase>{
        MoviesPopularPageUseCaseImpl(
            repository = get()
        )
    }


    viewModel {
        DefaultViewModel()
    }

    viewModel {
        MoviePopularPageViewModel(
            useCase = get()
        )
    }


}



