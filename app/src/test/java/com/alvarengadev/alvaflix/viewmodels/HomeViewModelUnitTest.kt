package com.alvarengadev.alvaflix.viewmodels

import com.alvarengadev.alvaflix.couroutine.MainCoroutineRule
import com.alvarengadev.alvaflix.data.MoviesDataSourceFake
import com.alvarengadev.alvaflix.data.api.network.MoviesApi
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepositoryImpl
import com.alvarengadev.alvaflix.view.home.HomeViewModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

class HomeViewModelUnitTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val moviesApi = mockkClass(MoviesApi::class)
    private val repository = MoviesApiRepositoryImpl(moviesApi)
    private val listMockKMovies = mockk<ArrayList<Movie>>()
    private val homeViewModel = HomeViewModel(repository, mainCoroutineRule.dispatcher)

    @Before
    fun before() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `when view model getListMoviePopular get fail then sets listMoviePopularData`() {
        val mockGetResponse = null
        coEvery { repository.getMoviesPopular() } returns mockGetResponse
        coVerify { repository.getMoviesPopular() }

        coEvery { repository.getMoviesRecommend() } returns mockGetResponse
        coVerify { repository.getMoviesRecommend() }

        assertNull(homeViewModel.listMoviePopularData.value)
        assertNull(homeViewModel.listMovieRecommendData.value)
    }

    @Test
    fun `when view model getListMoviePopular get success then sets listMoviePopularData`() {
        val mockGetResponse = MoviesDataSourceFake().getListDataFakes(listMockKMovies)
        coEvery { repository.getMoviesPopular() } returns mockGetResponse

        coEvery { repository.getMoviesRecommend() } returns mockGetResponse

        assertNotNull(homeViewModel.listMoviePopularData.value)
        assertNotNull(homeViewModel.listMovieRecommendData.value)
    }
}