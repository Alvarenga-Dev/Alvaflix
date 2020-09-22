package com.alvarengadev.alvaflix.data.domain

data class MoviePopular (
    val id: Int,
    val title: String,
    val poster: String,
    val posterDetails: String,
    val description: String,
    val rating: Double,
    val date: String
)