package com.alvarengadev.alvaflix.viewmodels

import com.alvarengadev.alvaflix.couroutine.MainCoroutineRule
import com.alvarengadev.alvaflix.di.apiModules
import com.alvarengadev.alvaflix.di.homeModule
import com.alvarengadev.alvaflix.view.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class HomeViewModelUnitTest : KoinTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val homeViewModel by inject<HomeViewModel>()

    @Test
    fun `when view model getListMoviePopular get fail then sets listMoviePopularData`() {
        startKoin {
            androidLogger()
            modules(apiModules, homeModule)
        }

        Assert.assertTrue(homeViewModel.listMoviePopularData.value == null)
    }
}