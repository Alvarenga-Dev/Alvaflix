package com.alvarengadev.alvaflix.data.api.network.search.response

import com.squareup.moshi.Json

data class MovieSearchResult(
    @field:Json(name = "results") val results: List<MovieSearchResponseBody>
)