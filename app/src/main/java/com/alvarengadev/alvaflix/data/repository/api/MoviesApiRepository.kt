package com.alvarengadev.alvaflix.data.repository.api

import com.alvarengadev.alvaflix.data.domain.Movie

interface MoviesApiRepository {
    suspend fun getMoviesPopular(): ArrayList<Movie>?
    suspend fun getMoviesRecommend(): ArrayList<Movie>?
    suspend fun getMoviesSimilar(movieId: Int): ArrayList<Movie>?
}