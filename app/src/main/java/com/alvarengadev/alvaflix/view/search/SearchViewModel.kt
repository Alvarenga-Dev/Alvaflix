package com.alvarengadev.alvaflix.view.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(
    private val moviesApiRepositoryImpl: MoviesApiRepositoryImpl,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    val listSearch = MutableLiveData<ArrayList<Movie>?>()

    fun search(titleMovie: String) {
        viewModelScope.launch(defaultDispatcher) {
            listSearch.value = moviesApiRepositoryImpl.getMoviesSearch(titleMovie)
        }
    }

}