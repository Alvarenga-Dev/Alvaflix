package com.alvarengadev.alvaflix.view.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepositoryImpl
import kotlinx.coroutines.launch

class SearchViewModel(
    private val moviesApiRepositoryImpl: MoviesApiRepositoryImpl
) : ViewModel() {

    val listSearch = MutableLiveData<ArrayList<Movie>?>()

    fun search(titleMovie: String) {
        viewModelScope.launch {
            listSearch.value = moviesApiRepositoryImpl.getMoviesSearch(titleMovie)
        }
    }

}