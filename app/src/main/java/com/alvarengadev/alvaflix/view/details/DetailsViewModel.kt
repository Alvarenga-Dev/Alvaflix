package com.alvarengadev.alvaflix.view.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.database.MovieDaoRepositoryImpl
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val movieDaoRepositoryImpl: MovieDaoRepositoryImpl,
    private val moviesApiRepositoryImpl: MoviesApiRepositoryImpl,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    val listMovieSimilarData = MutableLiveData<ArrayList<Movie>>()
    val isMovieFavoriteData = MutableLiveData<Boolean>()

    fun insertMovieFavorite(movie: Movie) {
        viewModelScope.launch(defaultDispatcher) {
            movieDaoRepositoryImpl.insert(movie)
        }
    }

    fun deleteMovieFavorite(movie: Movie) {
        viewModelScope.launch(defaultDispatcher) {
            movieDaoRepositoryImpl.delete(movie)
        }
    }

    fun getListMovieSimilar(movieId: Int) {
        viewModelScope.launch(defaultDispatcher) {
            listMovieSimilarData.value = moviesApiRepositoryImpl.getMoviesSimilar(movieId)
        }
    }

    fun isMovieFavorite(movie: Movie) {
        viewModelScope.launch(defaultDispatcher) {
            isMovieFavoriteData.value = movieDaoRepositoryImpl.getAllMovieFavorites().contains(movie)
        }
    }
}