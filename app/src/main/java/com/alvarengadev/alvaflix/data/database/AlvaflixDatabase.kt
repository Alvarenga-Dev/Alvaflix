package com.alvarengadev.alvaflix.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alvarengadev.alvaflix.data.database.dao.MovieFavoritesDao
import com.alvarengadev.alvaflix.data.database.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class AlvaflixDatabase : RoomDatabase() {
    abstract val movieFavoritesDao: MovieFavoritesDao
}