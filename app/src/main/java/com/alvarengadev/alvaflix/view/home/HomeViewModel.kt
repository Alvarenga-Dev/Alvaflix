package com.alvarengadev.alvaflix.view.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarengadev.alvaflix.data.domain.MoviePopular
import com.alvarengadev.alvaflix.data.repository.ApiDataSourceRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val listMoviePopularData: MutableLiveData<ArrayList<MoviePopular>> = MutableLiveData()

    fun getListMoviePopular() {
        val apiDataSourceRepository = ApiDataSourceRepository(listMoviePopularData)
        apiDataSourceRepository.callRetrofitApi()
    }

}