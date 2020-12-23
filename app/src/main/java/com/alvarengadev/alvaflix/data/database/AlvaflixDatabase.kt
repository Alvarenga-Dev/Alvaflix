package com.alvarengadev.alvaflix.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alvarengadev.alvaflix.data.database.dao.MovieFavoritesDao
import com.alvarengadev.alvaflix.data.database.entity.MovieEntity
import com.alvarengadev.alvaflix.utils.Constants

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class AlvaflixDatabase : RoomDatabase() {
    abstract val MovieFavoritesDao: MovieFavoritesDao

    companion object {
        @Volatile
        private var INSTANCE: AlvaflixDatabase? = null

        fun getInstance(context: Context): AlvaflixDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AlvaflixDatabase::class.java,
                    Constants.NAME_DATABASE
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}