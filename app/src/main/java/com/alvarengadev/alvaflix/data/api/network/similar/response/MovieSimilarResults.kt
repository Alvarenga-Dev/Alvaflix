package com.alvarengadev.alvaflix.data.api.network.similar.response

import com.squareup.moshi.Json

data class MovieSimilarResults (
    @field:Json(name = "results") val results: List<MovieSimilarResponseBody>
)