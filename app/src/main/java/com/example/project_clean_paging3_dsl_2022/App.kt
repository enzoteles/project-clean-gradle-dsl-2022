package com.example.project_clean_paging3_dsl_2022

import android.app.Application
import com.example.data.di.apiModule
import com.example.data.di.moviesPopularModule
import com.example.data.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(
                retrofitModule,
                apiModule,
                moviesPopularModule
            )
        }
    }
}