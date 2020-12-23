package com.alvarengadev.alvaflix.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @field:PrimaryKey val id: Int,
    @field:ColumnInfo(name = "title") val title: String,
    @field:ColumnInfo(name = "poster") val poster: String,
    @field:ColumnInfo(name = "posterDetails") val posterDetails: String?,
    @field:ColumnInfo(name = "description") val description: String,
    @field:ColumnInfo(name = "rating") val rating: String,
    @field:ColumnInfo(name = "date") val date: String
)
