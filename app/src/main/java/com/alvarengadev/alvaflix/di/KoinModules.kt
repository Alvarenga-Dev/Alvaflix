package com.alvarengadev.alvaflix.di

import androidx.room.Room
import com.alvarengadev.alvaflix.data.database.AlvaflixDatabase
import com.alvarengadev.alvaflix.data.repository.DatabaseDataSourceRepository
import com.alvarengadev.alvaflix.utils.Constants
import com.alvarengadev.alvaflix.view.details.DetailsViewModel
import com.alvarengadev.alvaflix.view.home.HomeViewModel
import com.alvarengadev.alvaflix.view.mylist.MyListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

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
        HomeViewModel()
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
            )
        )
    }
}