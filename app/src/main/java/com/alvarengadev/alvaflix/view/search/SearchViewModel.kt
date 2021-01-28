package com.alvarengadev.alvaflix.view.search

import androidx.lifecycle.ViewModel
import com.alvarengadev.alvaflix.data.repository.database.MovieDaoRepositoryImpl

class SearchViewModel(
    private val movieDaoRepositoryImpl: MovieDaoRepositoryImpl
) : ViewModel() {
}