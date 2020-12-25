package com.alvarengadev.alvaflix.view.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alvarengadev.alvaflix.data.repository.DatabaseDataSourceRepository

@Suppress("UNCHECKED_CAST")
class DetailsViewModelFactory(
    private val databaseDataSourceRepository: DatabaseDataSourceRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailsViewModel(databaseDataSourceRepository) as T
    }
}