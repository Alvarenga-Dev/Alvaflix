package com.alvarengadev.alvaflix.viewmodels

import com.alvarengadev.alvaflix.couroutine.MainCoroutineRule
import com.alvarengadev.alvaflix.data.api.network.popular.MoviePopularService
import com.alvarengadev.alvaflix.data.api.network.popular.response.MoviePopularResult
import com.alvarengadev.alvaflix.data.api.network.recommend.MovieRecommendService
import com.alvarengadev.alvaflix.data.api.network.search.MovieSearchService
import com.alvarengadev.alvaflix.data.api.network.similar.MovieSimilarService
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.api.MoviesApiRepositoryImpl
import com.alvarengadev.alvaflix.view.home.HomeViewModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.collections.ArrayList

class HomeViewModelUnitTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val serviceMoviePopular = mockkClass(MoviePopularService::class)
    private val serviceMovieRecommend = mockkClass(MovieRecommendService::class)
    private val serviceMovieSimilar = mockkClass(MovieSimilarService::class)
    private val serviceMovieSearch = mockkClass(MovieSearchService::class)
    private val repository = MoviesApiRepositoryImpl(
        serviceMoviePopular,
        serviceMovieRecommend,
        serviceMovieSimilar,
        serviceMovieSearch
    )
    private val homeViewModel = HomeViewModel(repository, mainCoroutineRule.dispatcher)

    @MockK
    private var listMockKMovies = ArrayList<Movie>()

    @MockK
    private var moviePopularResponseBody: MoviePopularResult? = null

    @Before
    fun before() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `when view model getListMoviePopular get fail then sets listMoviePopularData`() {
        val mockGetResponse = null
        coEvery { repository.getMoviesPopular() } returns mockGetResponse
        coVerify { repository.getMoviesPopular() }
        coVerify { repository.getMoviesRecommend() }

        assertEquals(homeViewModel.listMoviePopularData.value, null)
        assertEquals(homeViewModel.listMovieRecommendData.value, null)
    }

    @Test
    fun `when view model getListMoviePopular get success then sets listMoviePopularData`() {
        listMockKMovies.add(
            Movie(
                10,
                "Title 1",
                "Poster Simple 1",
                "Poster Details 1",
                "Description 1",
                "5.0",
                "05/04/2021"
            )
        )

        coEvery { repository.getMoviesPopular() } returns listMockKMovies
        coEvery { repository.getMoviesRecommend() } returns listMockKMovies
        coVerify { repository.getMoviesPopular() }
        coVerify { repository.getMoviesRecommend() }

        assertEquals(homeViewModel.listMoviePopularData.value, listMockKMovies)
        assertEquals(homeViewModel.listMovieRecommendData.value, listMockKMovies)
    }
}