package com.alvarengadev.alvaflix.data.repository.database

import com.alvarengadev.alvaflix.data.database.dao.MovieFavoritesDao
import com.alvarengadev.alvaflix.data.database.entity.toMovies
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.domain.toEntity

class MovieDaoRepositoryImpl(
    private val movieFavoritesDao: MovieFavoritesDao
) : MovieDaoRepository {
    override suspend fun insert(movie: Movie) {
        movieFavoritesDao.insert(toEntity(movie))
    }

    override suspend fun delete(movie: Movie) {
        movieFavoritesDao.delete(toEntity(movie))
    }

    override suspend fun getAllMovieFavorites(): ArrayList<Movie> {
        return toMovies(movieFavoritesDao.getAll())
    }
}