package com.alvarengadev.alvaflix.data.api.mapper

import com.alvarengadev.alvaflix.data.api.network.similar.response.MovieSimilarResponseBody
import com.alvarengadev.alvaflix.data.domain.Movie

class MovieSimilarMapper {
    companion object {
        fun responseToDomain(listResponseBody: List<MovieSimilarResponseBody>) : ArrayList<Movie> {
            val listMovieSimilar = ArrayList<Movie>()
            for (movieSimilarResponse in listResponseBody) {
                if (movieSimilarResponse.poster != null && movieSimilarResponse.posterDetails != null && movieSimilarResponse.date != null) {
                    val movieSimilar = Movie(
                        movieSimilarResponse.id,
                        movieSimilarResponse.title,
                        movieSimilarResponse.poster,
                        movieSimilarResponse.posterDetails,
                        movieSimilarResponse.description,
                        movieSimilarResponse.rating.toString(),
                        movieSimilarResponse.date
                    )
                    listMovieSimilar.add(movieSimilar)
                }
            }
            return listMovieSimilar
        }
    }
}