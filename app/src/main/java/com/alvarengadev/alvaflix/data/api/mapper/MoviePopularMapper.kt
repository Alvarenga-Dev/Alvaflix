package com.alvarengadev.alvaflix.data.api.mapper

import android.util.Log
import com.alvarengadev.alvaflix.data.api.network.popular.reponse.MoviePopularResponseBody
import com.alvarengadev.alvaflix.data.domain.MoviePopular

class MoviePopularMapper {
    companion object {
        fun responseToDomain(listResponseBody: List<MoviePopularResponseBody>) : ArrayList<MoviePopular> {
            val listMoviePopular = ArrayList<MoviePopular>()
            for (moviePopularResponse in listResponseBody) {
                val moviePopular = MoviePopular(
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