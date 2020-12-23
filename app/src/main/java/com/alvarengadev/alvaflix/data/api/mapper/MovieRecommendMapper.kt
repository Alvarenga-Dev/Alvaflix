package com.alvarengadev.alvaflix.data.api.mapper

import com.alvarengadev.alvaflix.data.api.network.recommend.response.MovieRecommendResponseBody
import com.alvarengadev.alvaflix.data.domain.Movie

class MovieRecommendMapper {
    companion object {
        fun responseToDomain(listResponseBody: List<MovieRecommendResponseBody>) : ArrayList<Movie> {
            val listMovieRecommend = ArrayList<Movie>()
            for (movieRecommendResponse in listResponseBody) {
                val movieRecommend = Movie(
                    movieRecommendResponse.id,
                    movieRecommendResponse.title,
                    movieRecommendResponse.poster,
                    movieRecommendResponse.posterDetails,
                    movieRecommendResponse.description,
                    movieRecommendResponse.rating.toString(),
                    movieRecommendResponse.date
                )
                listMovieRecommend.add(movieRecommend)
            }
            return listMovieRecommend
        }
    }
}