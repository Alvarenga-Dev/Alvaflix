package com.alvarengadev.alvaflix.view.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.ApiDataSourceRepository

class HomeViewModel : ViewModel() {

    val listMoviePopularData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

    fun getListMoviePopular() {
        val apiDataSourceRepository = ApiDataSourceRepository()
        apiDataSourceRepository.callRetrofitApi(listMoviePopularData)
    }

}