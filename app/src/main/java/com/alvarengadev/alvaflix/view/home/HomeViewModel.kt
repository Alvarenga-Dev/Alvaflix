package com.alvarengadev.alvaflix.view.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val moviesApiRepositoryImpl: MoviesApiRepositoryImpl,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    val listMoviePopularData = MutableLiveData<ArrayList<Movie>>()
    val listMovieRecommendData = MutableLiveData<ArrayList<Movie>>()

    init {
        getListMoviePopular()
        getListMovieRecommend()
    }

    private fun getListMoviePopular() {
        viewModelScope.launch(defaultDispatcher) {
            listMoviePopularData.value = moviesApiRepositoryImpl.getMoviesPopular()
        }
    }

    private fun getListMovieRecommend() {
        viewModelScope.launch(defaultDispatcher) {
            listMovieRecommendData.value = moviesApiRepositoryImpl.getMoviesRecommend()
        }
    }

}