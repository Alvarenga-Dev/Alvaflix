package com.alvarengadev.alvaflix.view.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.ApiDataSourceRepository

class HomeViewModel : ViewModel() {

    private val apiDataSourceRepository = ApiDataSourceRepository()
    val listMoviePopularData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    val listMovieRecommendData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

    fun getListMoviePopular() {
        apiDataSourceRepository.callRetrofitApi(listMoviePopularData)
    }

    fun getListMovieRecommend() {
        apiDataSourceRepository.callMoviesRecommends(listMovieRecommendData)
    }

}