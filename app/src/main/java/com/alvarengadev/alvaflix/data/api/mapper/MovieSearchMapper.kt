package com.alvarengadev.alvaflix.data.api.mapper

import com.alvarengadev.alvaflix.data.api.network.search.response.MovieSearchResponseBody
import com.alvarengadev.alvaflix.data.domain.Movie

class MovieSearchMapper {
    companion object {
        fun responseToDomain(listResponseBody: List<MovieSearchResponseBody>) : ArrayList<Movie> {
            val listMovieSearch = ArrayList<Movie>()
            for (movieSearchResponse in listResponseBody) {
                if (movieSearchResponse.poster != null && movieSearchResponse.posterDetails != null) {
                    val movieSearch = Movie(
                        movieSearchResponse.id,
                        movieSearchResponse.title,
                        movieSearchResponse.poster,
                        movieSearchResponse.posterDetails,
                        movieSearchResponse.description,
                        movieSearchResponse.rating.toString(),
                        movieSearchResponse.date
                    )
                    listMovieSearch.add(movieSearch)
                }
            }
            return listMovieSearch
        }
    }
}