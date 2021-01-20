package com.alvarengadev.alvaflix.data.repository.database

import com.alvarengadev.alvaflix.data.domain.Movie

interface MovieDaoRepository {
    suspend fun insert(movie: Movie)
    suspend fun delete(movie: Movie)
    suspend fun getAllMovieFavorites(): ArrayList<Movie>
}