package com.alvarengadev.alvaflix.data.database.dao

import androidx.room.*
import com.alvarengadev.alvaflix.data.database.entity.MovieEntity

@Dao
interface MovieFavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieEntity: MovieEntity)

    @Delete
    suspend fun delete(movieEntity: MovieEntity)

    @Query("SELECT * FROM movies")
    suspend fun getAll(): List<MovieEntity>
}