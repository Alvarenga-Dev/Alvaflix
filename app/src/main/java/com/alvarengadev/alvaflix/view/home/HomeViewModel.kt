package com.alvarengadev.alvaflix.view.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepositoryImpl
import kotlinx.coroutines.launch

class HomeViewModel(
    private val moviesApiRepositoryImpl: MoviesApiRepositoryImpl
) : ViewModel() {

    val listMoviePopularData = MutableLiveData<ArrayList<Movie>>()
    val listMovieRecommendData = MutableLiveData<ArrayList<Movie>>()

    fun getListMoviePopular() {
        viewModelScope.launch {
            listMoviePopularData.value = moviesApiRepositoryImpl.getMoviesPopular()
        }
    }

    fun getListMovieRecommend() {
        viewModelScope.launch {
            listMovieRecommendData.value = moviesApiRepositoryImpl.getMoviesRecommend()
        }
    }

}