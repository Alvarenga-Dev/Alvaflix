package com.alvarengadev.alvaflix

import android.app.Application
import com.alvarengadev.alvaflix.di.databaseModule
import com.alvarengadev.alvaflix.di.detailsModule
import com.alvarengadev.alvaflix.di.homeModule
import com.alvarengadev.alvaflix.di.myListModule
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
                databaseModule,
                homeModule,
                myListModule,
                detailsModule
            )
        }
    }
}