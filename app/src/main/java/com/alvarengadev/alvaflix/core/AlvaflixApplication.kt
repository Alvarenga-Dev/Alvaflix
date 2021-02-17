package com.alvarengadev.alvaflix.core

import android.app.Application
import com.alvarengadev.alvaflix.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AlvaflixApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AlvaflixApplication)

            modules(
                apiModules,
                databaseModule,
                homeModule,
                myListModule,
                detailsModule,
                searchModule
            )
        }
    }
}