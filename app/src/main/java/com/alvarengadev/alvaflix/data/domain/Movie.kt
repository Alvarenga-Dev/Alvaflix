package com.alvarengadev.alvaflix.data.domain

import java.io.Serializable

data class Movie (
    val id: Int,
    val title: String,
    val poster: String,
    val posterDetails: String?,
    val description: String,
    val rating: String,
    val date: String
) : Serializable