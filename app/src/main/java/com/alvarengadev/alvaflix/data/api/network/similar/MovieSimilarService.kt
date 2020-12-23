package com.alvarengadev.alvaflix.data.api.network.similar

import com.alvarengadev.alvaflix.data.api.network.similar.response.MovieSimilarResults
import com.alvarengadev.alvaflix.utils.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieSimilarService {
    @GET("movie/{movie_id}/similar")
    fun list(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<MovieSimilarResults>
}