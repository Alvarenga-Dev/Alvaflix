package com.alvarengadev.alvaflix.di

import androidx.room.Room
import com.alvarengadev.alvaflix.data.api.network.popular.MoviePopularService
import com.alvarengadev.alvaflix.data.api.network.recommend.MovieRecommendService
import com.alvarengadev.alvaflix.data.api.network.search.MovieSearchService
import com.alvarengadev.alvaflix.data.api.network.similar.MovieSimilarService
import com.alvarengadev.alvaflix.data.database.AlvaflixDatabase
import com.alvarengadev.alvaflix.data.repository.database.MovieDaoRepositoryImpl
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepositoryImpl
import com.alvarengadev.alvaflix.utils.Constants
import com.alvarengadev.alvaflix.view.details.DetailsViewModel
import com.alvarengadev.alvaflix.view.home.HomeViewModel
import com.alvarengadev.alvaflix.view.mylist.MyListViewModel
import com.alvarengadev.alvaflix.view.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val apiModules = module {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    factory { retrofit.create(MoviePopularService::class.java) }
    factory { retrofit.create(MovieRecommendService::class.java) }
    factory { retrofit.create(MovieSimilarService::class.java) }
    factory { retrofit.create(MovieSearchService::class.java) }
}

val repositoryModule = module {
    single {
        MoviesApiRepositoryImpl(
            moviePopularService = get(),
            movieRecommendService = get(),
            movieSearchService = get(),
            movieSimilarService = get()
        )
    }
}

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
            moviesApiRepositoryImpl = get()
        )
    }
}

val myListModule = module {
    viewModel {
        MyListViewModel(
            MovieDaoRepositoryImpl(
                movieFavoritesDao = get()
            )
        )
    }
}

val detailsModule = module {
    viewModel {
        DetailsViewModel(
            MovieDaoRepositoryImpl(
                movieFavoritesDao = get()
            ),
            moviesApiRepositoryImpl = get()
        )
    }
}

val searchModule = module {
    viewModel {
        SearchViewModel(
            moviesApiRepositoryImpl = get()
        )
    }
}
