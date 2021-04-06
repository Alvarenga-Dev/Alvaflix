package com.alvarengadev.alvaflix.view.mylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.database.MovieDaoRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyListViewModel(
    private val movieDaoRepositoryImpl: MovieDaoRepositoryImpl,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    val listMovieFavorites = MutableLiveData<ArrayList<Movie>?>()

    init {
        getAllMovieFavorites()
    }

    private fun getAllMovieFavorites() {
        viewModelScope.launch(defaultDispatcher) {
            listMovieFavorites.value = movieDaoRepositoryImpl.getAllMovieFavorites()
        }
    }
}