package com.alvarengadev.alvaflix.data.api.network

import com.alvarengadev.alvaflix.data.api.network.popular.MoviePopularService
import com.alvarengadev.alvaflix.data.api.network.recommend.MovieRecommendService
import com.alvarengadev.alvaflix.data.api.network.search.MovieSearchService
import com.alvarengadev.alvaflix.data.api.network.similar.MovieSimilarService
import retrofit2.Retrofit

class MoviesApi(
    private val retrofit: Retrofit
) {
    fun moviePopularService() : MoviePopularService = retrofit.create(MoviePopularService::class.java)
    fun movieRecommendService() : MovieRecommendService = retrofit.create(MovieRecommendService::class.java)
    fun movieSimilarService() : MovieSimilarService = retrofit.create(MovieSimilarService::class.java)
    fun movieSearchService() : MovieSearchService = retrofit.create(MovieSearchService::class.java)
}