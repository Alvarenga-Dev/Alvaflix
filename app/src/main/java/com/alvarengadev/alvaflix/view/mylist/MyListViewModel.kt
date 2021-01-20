package com.alvarengadev.alvaflix.view.mylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.database.MovieDaoRepositoryImpl
import kotlinx.coroutines.launch

class MyListViewModel(
    private val movieDaoRepositoryImpl: MovieDaoRepositoryImpl
) : ViewModel() {

    val listMovieFavorites = MutableLiveData<ArrayList<Movie>>()

    fun getAllMovieFavorites() {
        viewModelScope.launch {
            listMovieFavorites.value = movieDaoRepositoryImpl.getAllMovieFavorites()
        }
    }
}