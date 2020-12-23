package com.alvarengadev.alvaflix.data.api.mapper

import android.util.Log
import com.alvarengadev.alvaflix.data.api.network.popular.response.MoviePopularResponseBody
import com.alvarengadev.alvaflix.data.domain.Movie

class MoviePopularMapper {
    companion object {
        fun responseToDomain(listResponseBody: List<MoviePopularResponseBody>) : ArrayList<Movie> {
            val listMoviePopular = ArrayList<Movie>()
            for (moviePopularResponse in listResponseBody) {
                val moviePopular = Movie(
                    moviePopularResponse.id,
                    moviePopularResponse.title,
                    moviePopularResponse.poster,
                    moviePopularResponse.posterDetails,
                    moviePopularResponse.description,
                    moviePopularResponse.rating.toString(),
                    moviePopularResponse.date
                )
                listMoviePopular.add(moviePopular)
            }
            return listMoviePopular
        }
    }
}