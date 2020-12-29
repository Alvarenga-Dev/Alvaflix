package com.alvarengadev.alvaflix.data.repository

import com.alvarengadev.alvaflix.data.database.dao.MovieFavoritesDao
import com.alvarengadev.alvaflix.data.database.entity.toMovies
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.domain.toEntity

class DatabaseDataSourceRepository(private val movieFavoritesDao: MovieFavoritesDao) {
    suspend fun insert(movie: Movie) {
        movieFavoritesDao.insert(toEntity(movie))
    }

    suspend fun delete(movie: Movie) {
        movieFavoritesDao.delete(toEntity(movie))
    }

    suspend fun getAllMovieFavorites(): ArrayList<Movie> {
        return toMovies(movieFavoritesDao.getAll())
    }
}