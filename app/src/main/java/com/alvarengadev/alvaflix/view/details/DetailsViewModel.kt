package com.alvarengadev.alvaflix.view.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.database.DatabaseDataSourceRepository
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepositoryImpl
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val databaseDataSourceRepository: DatabaseDataSourceRepository,
    private val moviesApiRepositoryImpl: MoviesApiRepositoryImpl
) : ViewModel() {

    val listMovieSimilarData = MutableLiveData<ArrayList<Movie>>()
    val isMovieFavoriteData = MutableLiveData<Boolean>()

    fun insertMovieFavorite(movie: Movie) {
        viewModelScope.launch {
            databaseDataSourceRepository.insert(movie)
        }
    }

    fun deleteMovieFavorite(movie: Movie) {
        viewModelScope.launch {
            databaseDataSourceRepository.delete(movie)
        }
    }

    fun getListMovieSimilar(movieId: Int) {
        viewModelScope.launch {
            listMovieSimilarData.value = moviesApiRepositoryImpl.getMoviesSimilar(movieId)
        }
    }

    fun isMovieFavorite(movie: Movie) {
        viewModelScope.launch {
            isMovieFavoriteData.value = databaseDataSourceRepository.getAllMovieFavorites().contains(movie)
        }
    }
}