package com.alvarengadev.alvaflix.view.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.ApiDataSourceRepository

class DetailsViewModel : ViewModel() {

    private val apiDataSourceRepository = ApiDataSourceRepository()
    val listMovieSimilarData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

    fun getListMovieSimilar(movieId: Int) {
        apiDataSourceRepository.callMoviesSimilar(listMovieSimilarData, movieId)
    }
}