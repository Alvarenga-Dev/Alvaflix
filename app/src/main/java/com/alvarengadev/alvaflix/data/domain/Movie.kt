package com.alvarengadev.alvaflix.data.domain

import com.alvarengadev.alvaflix.data.database.entity.MovieEntity
import java.io.Serializable

data class Movie(
    val id: Int,
    val title: String,
    val poster: String,
    val posterDetails: String?,
    val description: String,
    val rating: String,
    val date: String
) : Serializable

fun toEntity(movie: Movie): MovieEntity {
    return MovieEntity(
        id = movie.id,
        title = movie.title,
        poster = movie.poster,
        posterDetails = movie.posterDetails,
        description = movie.description,
        rating = movie.rating,
        date = movie.date
    )
}
