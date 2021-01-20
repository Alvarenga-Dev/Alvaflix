package com.alvarengadev.alvaflix.di

import androidx.room.Room
import com.alvarengadev.alvaflix.data.api.network.MoviesApi
import com.alvarengadev.alvaflix.data.database.AlvaflixDatabase
import com.alvarengadev.alvaflix.data.repository.database.DatabaseDataSourceRepository
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepositoryImpl
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepository
import com.alvarengadev.alvaflix.utils.Constants
import com.alvarengadev.alvaflix.view.details.DetailsViewModel
import com.alvarengadev.alvaflix.view.home.HomeViewModel
import com.alvarengadev.alvaflix.view.mylist.MyListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AlvaflixDatabase::class.java,
            Constants.NAME_DATABASE
        ).build()
    }
    single { get<AlvaflixDatabase>().movieFavoritesDao }
}

val homeModule = module {
    viewModel {
        HomeViewModel(
            MoviesApiRepositoryImpl(
                moviesApi = get()
            )
        )
    }
}

val myListModule = module {
    viewModel {
        MyListViewModel(
            DatabaseDataSourceRepository(
                movieFavoritesDao = get()
            )
        )
    }
}

val detailsModule = module {
    viewModel {
        DetailsViewModel(
            DatabaseDataSourceRepository(
                movieFavoritesDao = get()
            ),
            MoviesApiRepositoryImpl(
                moviesApi = get()
            )
        )
    }
}

val apiModules = module {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    single { MoviesApi(retrofit = retrofit) }

    fun provideMoviesApiRepository(moviesApi: MoviesApi): MoviesApiRepository {
        return MoviesApiRepositoryImpl(moviesApi)
    }

    single { provideMoviesApiRepository(get()) }
}