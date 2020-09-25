package com.alvarengadev.alvaflix.data.api.network.popular.response

import com.squareup.moshi.Json

data class MoviePopularResult (
    @field:Json(name = "results") val results: List<MoviePopularResponseBody>
)