package com.alvarengadev.alvaflix.data.api.mapper

import android.util.Log
import com.alvarengadev.alvaflix.data.api.network.popular.reponse.MoviePopularResponseBody
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
                    moviePopularResponse.rating,
                    moviePopularResponse.date
                )
                listMoviePopular.add(moviePopular)
                Log.i("AAAAAAAA", moviePopular.description)
            }
            return listMoviePopular
        }
    }
}