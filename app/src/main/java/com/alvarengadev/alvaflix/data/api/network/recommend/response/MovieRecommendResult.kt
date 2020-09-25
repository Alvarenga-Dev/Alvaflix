package com.alvarengadev.alvaflix.data.api.network.recommend.response

import com.squareup.moshi.Json

data class MovieRecommendResult(
    @field:Json(name = "results") val results: List<MovieRecommendResponseBody>
)