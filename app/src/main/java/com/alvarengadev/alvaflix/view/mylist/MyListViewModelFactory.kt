package com.alvarengadev.alvaflix.view.mylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alvarengadev.alvaflix.data.repository.DatabaseDataSourceRepository

@Suppress("UNCHECKED_CAST")
class MyListViewModelFactory (
    private val databaseDataSourceRepository: DatabaseDataSourceRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyListViewModel(databaseDataSourceRepository) as T
    }
}