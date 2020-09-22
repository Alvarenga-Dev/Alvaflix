package com.alvarengadev.alvaflix.data.api.network.popular

import com.alvarengadev.alvaflix.data.api.network.popular.reponse.MoviePopularResult
import com.alvarengadev.alvaflix.utils.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviePopularService {
    @GET("movie/popular")
    fun list(
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<MoviePopularResult>
}