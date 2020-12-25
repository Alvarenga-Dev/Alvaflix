package com.alvarengadev.alvaflix.view.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.ApiDataSourceRepository
import com.alvarengadev.alvaflix.data.repository.DatabaseDataSourceRepository
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val databaseDataSourceRepository: DatabaseDataSourceRepository
) : ViewModel() {

    val listMovieSimilarData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

    fun insertMovieFavorite(movie: Movie) {
        viewModelScope.launch {
            databaseDataSourceRepository.insert(movie)
        }
    }

    fun getListMovieSimilar(movieId: Int) {
        ApiDataSourceRepository.callMoviesSimilar(listMovieSimilarData, movieId)
    }
}