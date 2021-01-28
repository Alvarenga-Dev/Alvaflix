package com.alvarengadev.alvaflix.data.api.network.search.response

import com.squareup.moshi.Json

data class MovieSearchResponseBody(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "original_title") val title: String,
    @field:Json(name = "poster_path") val poster: String?,
    @field:Json(name = "backdrop_path") val posterDetails: String?,
    @field:Json(name = "overview") val description: String,
    @field:Json(name = "vote_average") val rating: Double,
    @field:Json(name = "release_date") val date: String
)