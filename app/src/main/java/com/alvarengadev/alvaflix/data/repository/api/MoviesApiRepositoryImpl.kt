package com.alvarengadev.alvaflix.data.repository.api

import com.alvarengadev.alvaflix.data.api.mapper.MoviePopularMapper
import com.alvarengadev.alvaflix.data.api.mapper.MovieRecommendMapper
import com.alvarengadev.alvaflix.data.api.mapper.MovieSearchMapper
import com.alvarengadev.alvaflix.data.api.mapper.MovieSimilarMapper
import com.alvarengadev.alvaflix.data.api.network.MoviesApi
import com.alvarengadev.alvaflix.data.domain.Movie
import retrofit2.awaitResponse

class MoviesApiRepositoryImpl(
    private val moviesApi: MoviesApi
) : MoviesApiRepository {
    override suspend fun getMoviesPopular(): ArrayList<Movie>? {
        val service = moviesApi.moviePopularService().list().awaitResponse()
        val body = service.body()
        return if (service.isSuccessful && body != null) {
            MoviePopularMapper.responseToDomain(body.results)
        } else {
            null
        }
    }

    override suspend fun getMoviesRecommend(): ArrayList<Movie>? {
        val service = moviesApi.movieRecommendService().list().awaitResponse()
        val body = service.body()
        return if (service.isSuccessful && body != null) {
            MovieRecommendMapper.responseToDomain(body.results)
        } else {
            null
        }
    }

    override suspend fun getMoviesSimilar(movieId: Int): ArrayList<Movie>? {
        val service = moviesApi.movieSimilarService().list(movieId).awaitResponse()
        val body = service.body()
        return if (service.isSuccessful && body != null) {
            MovieSimilarMapper.responseToDomain(body.results)
        } else {
            null
        }
    }

    override suspend fun getMoviesSearch(movieName: String): ArrayList<Movie>? {
        val service = moviesApi.movieSearchService().search(movieName).awaitResponse()
        val body = service.body()
        return if (service.isSuccessful && body != null) {
            MovieSearchMapper.responseToDomain(body.results)
        } else {
            null
        }
    }
}